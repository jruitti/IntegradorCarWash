package interactorUnitTest;

import excepciones.VehiculoExisteException;
import excepciones.VehiculoIncompletoException;
import interactor.CrearVehiculoUseCase;
import mockito.MockitoExtension;
import modelo.Vehiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IRepositorioCrearVehiculo;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class CrearVehiculoUnitTest {

    @Mock
    IRepositorioCrearVehiculo crearVehiculoGateway;

    @Test
    public void crearVehiculo_VehiculoNoExiste_GuardaCorrectamente() throws VehiculoExisteException, VehiculoIncompletoException {
        Vehiculo vehiculoNuevo = Vehiculo.factoryVehiculo(1, "NRP374","Toyota","Etios");
        when(crearVehiculoGateway.guardar(vehiculoNuevo)).thenReturn(true);
        CrearVehiculoUseCase crearVehiculoUseCase = new CrearVehiculoUseCase(crearVehiculoGateway);
        boolean resultado = crearVehiculoUseCase.crearVehiculo(vehiculoNuevo);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void crearVehiculo_VehiculoExiste_VehiculoExisteExteption() throws VehiculoExisteException, VehiculoIncompletoException {
        Vehiculo vehiculoNuevo = Vehiculo.factoryVehiculo(1, "NRP374","Toyota","Etios");
        when(crearVehiculoGateway.findByMatricula("NRP374")).thenReturn(Vehiculo.factoryVehiculo(1, "NRP374","Toyota","Etios"));
        CrearVehiculoUseCase crearVehiculoUseCase = new CrearVehiculoUseCase(crearVehiculoGateway);
        Assertions.assertThrows(VehiculoExisteException.class,() -> crearVehiculoUseCase.crearVehiculo(vehiculoNuevo));
    }


}