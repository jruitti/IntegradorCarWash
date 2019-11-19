package ar.edu.undec.ServiceIntegrationTest;

import ar.edu.undec.Service.Controller.ObtenerVehiculoPorMatriculaController;
import ar.edu.undec.Service.ModeloService.ClienteDTO;
import ar.edu.undec.Service.ModeloService.VehiculoDTO;
import ar.edu.undec.Service.ServiceMapper.ClienteDTOMapper;
import ar.edu.undec.Service.ServiceMapper.VehiculoDTOMapper;
import input.IObtenerVehiculoPorMatriculaImput;
import modelo.Vehiculo;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerVehiculoPorMatriculaServiceIT {

    @Mock
    IObtenerVehiculoPorMatriculaImput obtenerVehiculoPorMatriculaImput;

    @Test
    public void obtenerVehiculoPorMatricula_vehiculoExiste_Devuelve_200() {
        List<Vehiculo> losCarros = new ArrayList<>();
        ClienteDTO elCliente = new ClienteDTO(1,"Fred","El sapo 201","El pantano","31001200");
        VehiculoDTO elVehiculo=new VehiculoDTO(1,"VJR222","Ford","1992", elCliente);
        losCarros.add(new VehiculoDTOMapper().mapeoDTOCore(elVehiculo));
        when(obtenerVehiculoPorMatriculaImput.buscarVehiculoPorMatricula(any(String.class))).thenReturn(losCarros);
        ObtenerVehiculoPorMatriculaController obtenerVehiculoPorMatriculaController = new ObtenerVehiculoPorMatriculaController(obtenerVehiculoPorMatriculaImput);
        assertEquals(HttpStatus.SC_OK, obtenerVehiculoPorMatriculaController.consultarVehiculoPorMatricula("VJR222").getStatusCodeValue());
    }

    @Test
    public void obtenerVehiculoPorMatricula_vehiculoNoExiste_Devuelve_204() {
        List<Vehiculo> losCarros;
        losCarros = obtenerVehiculoPorMatriculaImput.buscarVehiculoPorMatricula("BOB303");
        when(obtenerVehiculoPorMatriculaImput.buscarVehiculoPorMatricula(any(String.class))).thenReturn(losCarros);
        ObtenerVehiculoPorMatriculaController obtenerVehiculoPorMatriculaController = new ObtenerVehiculoPorMatriculaController(obtenerVehiculoPorMatriculaImput);
        assertEquals(HttpStatus.SC_NO_CONTENT, obtenerVehiculoPorMatriculaController.consultarVehiculoPorMatricula("BOB303").getStatusCodeValue());
    }

    @Test
    public void obtenerVehiculoPorMatricula_vehiculoNoExiste_Devuelve_500() throws Exception {
        when(obtenerVehiculoPorMatriculaImput.buscarVehiculoPorMatricula(any(String.class))).thenReturn(null);
        ObtenerVehiculoPorMatriculaController obtenerVehiculoPorMatriculaController = new ObtenerVehiculoPorMatriculaController(obtenerVehiculoPorMatriculaImput);
        assertEquals(HttpStatus.SC_INTERNAL_SERVER_ERROR, obtenerVehiculoPorMatriculaController.consultarVehiculoPorMatricula("SSS111").getStatusCodeValue());

    }


}
