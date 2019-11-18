package ar.edu.undec.Service.Controller;

import ar.edu.undec.Service.ModeloService.VehiculoDTO;
import input.IObtenerVehiculoPorMatriculaImput;
import modelo.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
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
    //@RequestMapping(value = "vehiculo/matricula{matricula}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    //@ResponseBody

    //public ResponseEntity<?> consultarVehiculoPorMatricula(@PathVariable("matricula") String matricula) {
     //   try{
       //     List<VehiculoDTO> vehiculos = new ArrayList<VehiculoDTO>();
        //}
    }




}
