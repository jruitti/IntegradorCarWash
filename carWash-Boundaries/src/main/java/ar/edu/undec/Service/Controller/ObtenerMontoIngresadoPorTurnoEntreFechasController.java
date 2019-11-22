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

@RequestMapping("/")
@RestController
public class ObtenerMontoIngresadoPorTurnoEntreFechasController {

    @ModelAttribute
    LocalDate initLocalDate() {return LocalDate.now();
    }


    @Autowired
    private IObtenerMontoIngresadoPorTurnoEntreFechasInpu obtenerMontoIngresadoPorTurnoEntreFechasInpu;

    public ObtenerMontoIngresadoPorTurnoEntreFechasController(IObtenerMontoIngresadoPorTurnoEntreFechasInpu obtenerMontoIngresadoPorTurnoEntreFechasInpu) {
        this.obtenerMontoIngresadoPorTurnoEntreFechasInpu=obtenerMontoIngresadoPorTurnoEntreFechasInpu;
    }
    @RequestMapping(value = "fechaInicio/{inicio}/fechaFin/{fin}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody

    public ResponseEntity<?> obtenerMonto(@DateTimeFormat(pattern="yyyy-MM-dd")   @ModelAttribute LocalDate fechaInicio,   @ModelAttribute LocalDate fechaFin) {
        try {
            Double monto=obtenerMontoIngresadoPorTurnoEntreFechasInpu.montoObtenidoEntreFechas(fechaInicio,fechaFin);
            if(monto<0){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else return ResponseEntity.status(HttpStatus.OK).body(true);

        } catch (FechaIncorrectaException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
}
