package ar.edu.undec.Service.Controller;

import excepciones.FechaIncorrectaException;
import input.IObtenerMontoIngresadoPorTurnoEntreFechasInpu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.time.LocalDate;

@RequestMapping("/")
@RestController
public class ObtenerMontoIngresadoPorTurnoEntreFechasController {

    @Autowired
    private IObtenerMontoIngresadoPorTurnoEntreFechasInpu obtenerMontoIngresadoPorTurnoEntreFechasInpu;

    public ObtenerMontoIngresadoPorTurnoEntreFechasController(IObtenerMontoIngresadoPorTurnoEntreFechasInpu obtenerMontoIngresadoPorTurnoEntreFechasInpu) {
        this.obtenerMontoIngresadoPorTurnoEntreFechasInpu=obtenerMontoIngresadoPorTurnoEntreFechasInpu;
    }
    @RequestMapping(value = "fechaInicio/fechaFin/{monto}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody

    public ResponseEntity<?> obtenerMonto(@RequestBody LocalDate fechaInicio, @RequestBody LocalDate fechaFin) {
        try {
            Double monto=obtenerMontoIngresadoPorTurnoEntreFechasInpu.montoObtenidoEntreFechas(fechaInicio,fechaFin);
            if(monto<0){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }else return ResponseEntity.status(HttpStatus.OK).body(monto);
        } catch (FechaIncorrectaException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(0);
        }
    }
}
