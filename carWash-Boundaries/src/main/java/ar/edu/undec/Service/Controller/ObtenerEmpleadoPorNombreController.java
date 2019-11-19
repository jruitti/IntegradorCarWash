package ar.edu.undec.Service.Controller;

import ar.edu.undec.Service.ModeloService.EmpleadoDTO;
import ar.edu.undec.Service.ServiceMapper.EmpleadoDTOMapper;
import input.IObtenerEmpleadoPorNombreInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@RestController
public class ObtenerEmpleadoPorNombreController {

    @Autowired
    private IObtenerEmpleadoPorNombreInput obtenerEmpleadoPorNombreInput;

    public ObtenerEmpleadoPorNombreController(IObtenerEmpleadoPorNombreInput obtenerEmpleadoPorNombreInput){
        this.obtenerEmpleadoPorNombreInput = obtenerEmpleadoPorNombreInput;
    }

    @RequestMapping(value = "empleado/nombre{nombre}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> consultarEmpleadoPorNombre(@PathVariable("nombre") String nombre){
        try {
            List<EmpleadoDTO> empleadoList = new ArrayList<>();
            this.obtenerEmpleadoPorNombreInput.buscarEmpleadoPorNombre(nombre).forEach(p -> empleadoList.add(new EmpleadoDTOMapper().mapeoCoreDTO(p)));
            if (empleadoList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.status(HttpStatus.OK).body(empleadoList);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
