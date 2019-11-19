package ar.edu.undec.Service.Controller;

import ar.edu.undec.Service.ModeloService.TurnoDTO;
import ar.edu.undec.Service.ServiceMapper.TurnoDTOMapper;
import excepciones.TurnoExisteException;
import input.IModificarTurnoInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class ModificarTurnoController {

    private IModificarTurnoInput modificarTurnoInput;

    public ModificarTurnoController(IModificarTurnoInput modificarTurnoInput) {
        this.modificarTurnoInput=modificarTurnoInput;
    }

    @RequestMapping(value = "turno",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoDTO turnoAModificar) {
        try {
            boolean resultado= this.modificarTurnoInput.modificarTurno(new TurnoDTOMapper().mapeoDTOCore(turnoAModificar));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (TurnoExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);
        }
    }
}
