package ar.edu.undec.Service.Controller;

import ar.edu.undec.Service.ModeloService.TurnoDTO;
import ar.edu.undec.Service.ModeloService.VehiculoDTO;
import ar.edu.undec.Service.ServiceMapper.TurnoDTOMapper;
import input.IObtenerVehiculoMasLavadoEntreFechaInput;
import modelo.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@RestController
public class ObtenerVehiculoMasLavadoEntreFechaController {

    @Autowired
    IObtenerVehiculoMasLavadoEntreFechaInput iObtenerVehiculoMasLavadoEntreFechaInput;

    public ObtenerVehiculoMasLavadoEntreFechaController(IObtenerVehiculoMasLavadoEntreFechaInput obtenerVehiculoMasLavadoEntreFechaInput){
        this.iObtenerVehiculoMasLavadoEntreFechaInput = obtenerVehiculoMasLavadoEntreFechaInput;
    }

    @RequestMapping(value = "vehiculo/fechainicio/{inicio}/fechafin/{fin}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> ObtenerVehiculoMasLavadoEntreFecha(@PathVariable("inicio") String fechaInicio, @PathVariable("fin") String fechaFin){
        try {
            LocalDate inicio = LocalDate.parse(fechaInicio, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate fin = LocalDate.parse(fechaFin, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Vehiculo vehiculo = this.iObtenerVehiculoMasLavadoEntreFechaInput.obtenerVehiculoMasLavadoEntreFecha(inicio, fin);
            if(inicio == null || fin == null){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            if (vehiculo == null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.status(HttpStatus.OK).body(vehiculo);
        }catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
