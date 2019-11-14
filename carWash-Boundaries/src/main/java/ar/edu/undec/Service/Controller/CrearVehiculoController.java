package ar.edu.undec.Service.Controller;
/*
import ar.edu.undec.Service.ModeloService.VehiculoDTO;
import ar.edu.undec.Service.ServiceMapper.VehiculoDTOMapper;
import excepciones.VehiculoExisteException;
import input.ICrearVehiculoInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class CrearVehiculoController {

    @Autowired
    private ICrearVehiculoInput crearVehiculoInput;

    public CrearVehiculoController(ICrearVehiculoInput crearVehiculoInput){
        this.crearVehiculoInput = crearVehiculoInput;
    }

    @RequestMapping(value = "vehiculo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> crearVehiculo(@RequestBody VehiculoDTO vehiculoDTO) {
        try {
            boolean resultado = this.crearVehiculoInput.crearVehiculo(new VehiculoDTOMapper().mapeoDTOCore(vehiculoDTO));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (VehiculoExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);
        }
    }
}*/
