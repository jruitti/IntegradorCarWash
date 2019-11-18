package ar.edu.undec.ServiceIntegrationTest;

import ar.edu.undec.Service.ModeloService.ClienteDTO;
import ar.edu.undec.Service.ModeloService.VehiculoDTO;
import input.IObtenerVehiculoPorMatriculaImput;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerVehiculoPorMatriculaServiceIT {

    @Mock
    IObtenerVehiculoPorMatriculaImput obtenerVehiculoPorMatriculaImput;

    ClienteDTO elCliente = new ClienteDTO(null,"Baista","Davila San Roman","El Asfalto","32458305");
    VehiculoDTO elVehiculo=new VehiculoDTO(null,"XAD456","Peugeot","2017", elCliente);


}
