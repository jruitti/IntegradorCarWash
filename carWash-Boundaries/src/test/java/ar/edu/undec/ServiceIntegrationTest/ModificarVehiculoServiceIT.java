package ar.edu.undec.ServiceIntegrationTest;

import static junit.framework.TestCase.assertEquals;
import ar.edu.undec.Service.Controller.ModificarVehiculoController;
import ar.edu.undec.Service.ModeloService.ClienteDTO;
import ar.edu.undec.Service.ModeloService.VehiculoDTO;
import excepciones.VehiculoExisteException;
import input.IModificarVehiculoInput;
import modelo.Vehiculo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModificarVehiculoServiceIT {

    @Mock
    IModificarVehiculoInput iModificarVehiculoInput;

    @Test
    public void modificarVehiculo_VehiculoModificado_DevuelveTrue() throws VehiculoExisteException {
        ClienteDTO elClienteDTO = new ClienteDTO(1, "Matías de la Fuente","La Mejicana 56","Cable Carril","34724669");
        VehiculoDTO vehiculoAModificar = new VehiculoDTO(1, "NRP374","Toyota Etios","2018", elClienteDTO);
        when(iModificarVehiculoInput.modificarVehiculo(any(Vehiculo.class))).thenReturn(true);
        ModificarVehiculoController modificarVehiculoController = new ModificarVehiculoController(iModificarVehiculoInput);
        assertEquals(modificarVehiculoController.modificarVehiculo(vehiculoAModificar).getStatusCodeValue(), org.apache.http.HttpStatus.SC_OK);
    }

    @Test
    public void modificarVehiculo_VehiculoExiste_DevuelveFalse() throws VehiculoExisteException {
        ClienteDTO elClienteDTO = new ClienteDTO(1, "Matías de la Fuente","La Mejicana 56","Cable Carril","34724669");
        VehiculoDTO vehiculoAModificar = new VehiculoDTO(1, "NRP374","Toyota Etios","2018", elClienteDTO);
        when(iModificarVehiculoInput.modificarVehiculo(any(Vehiculo.class))).thenThrow(new VehiculoExisteException("Vehiculo existe"));
        ModificarVehiculoController modificarVehiculoController = new ModificarVehiculoController(iModificarVehiculoInput);
        assertEquals(modificarVehiculoController.modificarVehiculo(vehiculoAModificar).getStatusCodeValue(), org.apache.http.HttpStatus.SC_PRECONDITION_FAILED);
    }

}
