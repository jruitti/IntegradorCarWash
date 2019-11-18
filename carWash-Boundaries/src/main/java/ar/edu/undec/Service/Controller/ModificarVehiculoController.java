package ar.edu.undec.Service.Controller;

import ar.edu.undec.Service.ModeloService.VehiculoDTO;
import ar.edu.undec.Service.ServiceMapper.VehiculoDTOMapper;
import excepciones.VehiculoExisteException;
import input.IModificarVehiculoInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class ModificarVehiculoController {

    private IModificarVehiculoInput modificarVehiculoInput;

    public ModificarVehiculoController(IModificarVehiculoInput modificarVehiculoInput) {
        this.modificarVehiculoInput = modificarVehiculoInput;
    }

    @RequestMapping(value = "vehiculo", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> modificarVehiculo(@RequestBody VehiculoDTO vehiculoAModificar) {
        try {
            boolean resultado = this.modificarVehiculoInput.modificarVehiculo(new VehiculoDTOMapper().mapeoDTOCore(vehiculoAModificar));
            if (resultado)
                return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (VehiculoExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);
        }
    }
}