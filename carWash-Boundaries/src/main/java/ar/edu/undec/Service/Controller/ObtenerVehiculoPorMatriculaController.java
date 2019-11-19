package ar.edu.undec.Service.Controller;

import ar.edu.undec.Service.ModeloService.VehiculoDTO;
import ar.edu.undec.Service.ServiceMapper.VehiculoDTOMapper;
import input.IObtenerVehiculoPorMatriculaImput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@RestController
public class ObtenerVehiculoPorMatriculaController {

    @Autowired
    private IObtenerVehiculoPorMatriculaImput obtenerVehiculoPorMatriculaImput;

    public ObtenerVehiculoPorMatriculaController(IObtenerVehiculoPorMatriculaImput obtenerVehiculoPorMatriculaImput){
        this.obtenerVehiculoPorMatriculaImput = obtenerVehiculoPorMatriculaImput;
    }

    @RequestMapping(value = "vehiculo/matricula{matricula}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> consultarVehiculoPorMatricula(@PathVariable("matricula") String matricula) {
        try{
            List<VehiculoDTO> vehiculos = new ArrayList<>();
            this.obtenerVehiculoPorMatriculaImput.buscarVehiculoPorMatricula(matricula).forEach(tp -> vehiculos.add(new VehiculoDTOMapper().mapeoCoreDTO(tp)));
            if (vehiculos.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(vehiculos);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
