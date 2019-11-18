package ar.edu.undec.Service.Controller;

import ar.edu.undec.Service.ModeloService.TurnoDTO;
import ar.edu.undec.Service.ServiceMapper.TurnoDTOMapper;
import excepciones.TurnoExisteException;
import input.ICrearTurnoImput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class CrearTurnoController {

    @Autowired
    private ICrearTurnoImput crearTurnoImput;

    public CrearTurnoController(ICrearTurnoImput crearTurnoImput){
        this.crearTurnoImput = crearTurnoImput;
    }

    @RequestMapping(value = "turno", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDTO turnoDTO) {
        try {
            boolean resultado = this.crearTurnoImput.crearTurno(new TurnoDTOMapper().mapeoDTOCore(turnoDTO));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(TurnoExisteException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);
        }
    }
}
