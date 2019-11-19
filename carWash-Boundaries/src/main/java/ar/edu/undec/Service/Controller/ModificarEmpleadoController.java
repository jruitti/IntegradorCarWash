package ar.edu.undec.Service.Controller;

import ar.edu.undec.Service.ModeloService.EmpleadoDTO;
import ar.edu.undec.Service.ServiceMapper.EmpleadoDTOMapper;
import excepciones.EmpleadoExisteException;
import input.IModificarEmpleadoInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/")
@RestController
public class ModificarEmpleadoController {


    private IModificarEmpleadoInput modificarEmpleadoInput;

    public ModificarEmpleadoController(IModificarEmpleadoInput iModificarEmpleadoInput){
        this.modificarEmpleadoInput = iModificarEmpleadoInput;
    }

    @RequestMapping(value = "empleado", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> modificarEmpleado(@RequestBody EmpleadoDTO empleadoDTO){
        try {
            boolean resultado = this.modificarEmpleadoInput.modificarEmpleado(new EmpleadoDTOMapper().mapeoDTOCore(empleadoDTO));
            if (resultado){
                return ResponseEntity.status(HttpStatus.OK).body(true);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (EmpleadoExisteException e){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);
        }
    }
}
