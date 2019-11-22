package ar.edu.undec.Service.Controller;

import excepciones.FechaIncorrectaException;
import input.IObtenerMontoIngresadoPorTurnoEntreFechasInpu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RequestMapping("/")
@RestController
public class ObtenerMontoIngresadoPorTurnoEntreFechasController {

    @Autowired
    private IObtenerMontoIngresadoPorTurnoEntreFechasInpu obtenerMontoIngresadoPorTurnoEntreFechasInpu;

    public ObtenerMontoIngresadoPorTurnoEntreFechasController(IObtenerMontoIngresadoPorTurnoEntreFechasInpu obtenerMontoIngresadoPorTurnoEntreFechasInpu) {
        this.obtenerMontoIngresadoPorTurnoEntreFechasInpu=obtenerMontoIngresadoPorTurnoEntreFechasInpu;
    }
    @RequestMapping(value = "turno/fechaInicio/{inicio}/fechaFin/{fin}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody

    public ResponseEntity<?> obtenerMonto(@PathVariable("inicio") String fechaInicio, @PathVariable("fin") String fechaFin) {
        try {
            LocalDate inicio = LocalDate.parse(fechaInicio, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate fin = LocalDate.parse(fechaFin, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Double monto=obtenerMontoIngresadoPorTurnoEntreFechasInpu.montoObtenidoEntreFechas(inicio, fin);

           if(inicio.isBefore(fin)) {
               return new ResponseEntity<>((HttpStatus.INTERNAL_SERVER_ERROR));
           }
           if (inicio==null||fin==null){
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
            if(monto<0){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else return ResponseEntity.status(HttpStatus.OK).body(monto);

        } catch (FechaIncorrectaException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
}
