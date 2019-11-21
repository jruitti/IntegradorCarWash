package ar.edu.undec.Service.Controller;


import ar.edu.undec.Service.ModeloService.EmpleadoDTO;
import ar.edu.undec.Service.ServiceMapper.EmpleadoDTOMapper;
import input.IObtenerTop3EmpleadosPorTurnoInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@RestController
public class ObtenerTop3EmpleadosPorTurnoController {

    @Autowired
    IObtenerTop3EmpleadosPorTurnoInput iObtenerTop3EmpleadosPorTurnoInput;

    public ObtenerTop3EmpleadosPorTurnoController(IObtenerTop3EmpleadosPorTurnoInput iObtenerTop3EmpleadosPorTurnoInput){
        this.iObtenerTop3EmpleadosPorTurnoInput = iObtenerTop3EmpleadosPorTurnoInput;
    }

    @RequestMapping(value = "empleado/top3", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> ObtenerTop3EmpleadosPorTurno() {
        try{
            List<EmpleadoDTO> losEmpleadosDTO = new ArrayList<>();
            this.iObtenerTop3EmpleadosPorTurnoInput.obtenerTop3EmpleadosPorTurno().forEach(tp -> losEmpleadosDTO.add(new EmpleadoDTOMapper().mapeoCoreDTO(tp)));
            if(losEmpleadosDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(losEmpleadosDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}