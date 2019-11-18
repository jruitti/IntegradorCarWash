package ar.edu.undec.Service.Controller;

import ar.edu.undec.Service.ModeloService.EmpleadoDTO;
import ar.edu.undec.Service.ServiceMapper.EmpleadoDTOMapper;
import excepciones.EmpleadoExisteException;
import input.ICrearEmpleadoInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class CrearEmpleadoController {

    @Autowired
    private ICrearEmpleadoInput iCrearEmpleadoInput;

    public CrearEmpleadoController(ICrearEmpleadoInput crearEmpleadoInput){
        this.iCrearEmpleadoInput = crearEmpleadoInput;
    }

    @RequestMapping(value = "empleado", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> crearEmpleado(@RequestBody EmpleadoDTO empleadoDTO){
        try{
            boolean resultado = this.iCrearEmpleadoInput.crearEmpleado(new EmpleadoDTOMapper().mapeoDTOCore(empleadoDTO));
            if(resultado){
                return ResponseEntity.status(HttpStatus.OK).body(true);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (EmpleadoExisteException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);
        }
    }
}
