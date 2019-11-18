package ar.edu.undec.ServiceIntegrationTest;
import ar.edu.undec.Service.Controller.CrearVehiculoController;
import ar.edu.undec.Service.ModeloService.ClienteDTO;
import ar.edu.undec.Service.ModeloService.VehiculoDTO;
import excepciones.VehiculoExisteException;
import input.ICrearVehiculoInput;
import modelo.Vehiculo;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrearVehiculoServiceIT {

    @Mock
    ICrearVehiculoInput crearVehiculoInput;

    @Test
    public void crearVehiculo_VehiculoNoExiste_Devuelve200() throws Exception {

        ClienteDTO elCliente = new ClienteDTO(null,"Baista","Davila San Roman","El Asfalto","32458305");
        VehiculoDTO elVehiculo=new VehiculoDTO(1,"XAD456","Peugeot","2017", elCliente);
        when(crearVehiculoInput.crearVehiculo(any(Vehiculo.class))).thenReturn(true);
        CrearVehiculoController crearVehiculoController = new CrearVehiculoController(crearVehiculoInput);
        assertEquals(crearVehiculoController.crearVehiculo(elVehiculo).getStatusCodeValue(),HttpStatus.SC_OK);

    }
    @Test
    public void crearVehiculo_VehiculoExiste_Devuelve412() throws VehiculoExisteException {
        ClienteDTO elCliente = new ClienteDTO(null,"Baista","Davila San Roman","El Asfalto","32458305");
        VehiculoDTO elVehiculo=new VehiculoDTO(1,"XAD456","Peugeot","2017", elCliente);
        when(crearVehiculoInput.crearVehiculo(any(Vehiculo.class))).thenThrow(new VehiculoExisteException("El vehiculo ya existe"));
        CrearVehiculoController crearVehiculoController = new CrearVehiculoController(crearVehiculoInput);
        assertEquals(crearVehiculoController.crearVehiculo(elVehiculo).getStatusCodeValue(), HttpStatus.SC_PRECONDITION_FAILED);
    }
}
