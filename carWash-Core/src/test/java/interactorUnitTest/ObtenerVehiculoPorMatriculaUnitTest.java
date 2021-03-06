package interactorUnitTest;

import excepciones.ClienteIncompletoException;
import excepciones.VehiculoIncompletoException;
import interactor.ObtenerVehiculoPorMatriculaUseCase;
import mockito.MockitoExtension;
import modelo.Cliente;
import modelo.Vehiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import repositorio.IObtenerVehiculoPorMatriculaRepo;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerVehiculoPorMatriculaUnitTest {
    @Mock
    IObtenerVehiculoPorMatriculaRepo obtenerVehiculoPorMatriculaRepo;

    @Spy
    List<Vehiculo> vehiculos = factoryListVehiculos();

    private List<Vehiculo> factoryListVehiculos() {
        try {
            List<Vehiculo> losVehiculos = new ArrayList<>();
            Cliente clienteNuevo = Cliente.factoryCliente(1,"Pepe","Porahi 333", "Los guapos","0303456");
            Vehiculo vehiculoNuevo1 =  Vehiculo.factoryVehiculo(1,"IXI056","Toyota","2019", clienteNuevo);
            Vehiculo vehiculoNuevo2 =  Vehiculo.factoryVehiculo(2,"ADF987","ford","2019", clienteNuevo);
            losVehiculos.add(vehiculoNuevo1);
            losVehiculos.add(vehiculoNuevo2);
            return losVehiculos;
        } catch (VehiculoIncompletoException | ClienteIncompletoException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Test
    public void buscarClientePorNombre_ExistenClientes_devuelveLista() throws VehiculoIncompletoException {

        when(obtenerVehiculoPorMatriculaRepo.buscarVehiculoPorMatricula("IXI056")).thenReturn(vehiculos);
        ObtenerVehiculoPorMatriculaUseCase obtenerVehiculoPorMatriculaUseCase=new  ObtenerVehiculoPorMatriculaUseCase(obtenerVehiculoPorMatriculaRepo);
        List<Vehiculo> resultado= obtenerVehiculoPorMatriculaUseCase.buscarVehiculoPorMatricula("IXI056");
        Assertions.assertEquals(2,resultado.size());


    }
}