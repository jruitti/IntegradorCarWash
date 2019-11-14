package interactorUnitTest;

import excepciones.ClienteIncompletoException;
import excepciones.EmpleadoIncompletoException;
import excepciones.TurnoIncompletoException;
import excepciones.VehiculoIncompletoException;
import interactor.BuscarClientesPorNombreUseCase;
import interactor.ObtenerTurnoPorNombreYVehiculoUseCase;
import mockito.MockitoExtension;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Turno;
import modelo.Vehiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import repositorio.IBuscarClientePorNombreRepo;
import repositorio.IObtenerTurnoPorClienteYVehiculoRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerTurnoPorClienteYVehiculoUnitTest {
    @Mock
    IObtenerTurnoPorClienteYVehiculoRepo obtenerTurnoPorClienteYVehiculoRepo;
    @Mock
    IBuscarClientePorNombreRepo buscarClientePorNombreRepo;
    @Spy
    List<Turno> turnos = factoryListaTurnos();
    @Spy
    List<Cliente> clientes =factoryListaCliente();

    private List<Cliente> factoryListaCliente() {
        try {
            List<Cliente> clientes=new ArrayList<>();
            Cliente cliente1=Cliente.factoryCliente(1,"Bautista", "Davila San roman 124","B° El Asfalto","32458305");
            Cliente cliente2=Cliente.factoryCliente(2,"Lucas", "Chilecito","B° las Torres","24567890");
            clientes.add(cliente1);
            clientes.add(cliente2);

            return clientes;

        } catch (ClienteIncompletoException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private List<Turno> factoryListaTurnos() {
        try {
            List<Turno> turnos=new ArrayList<>();
            Cliente clienteNuevo = Cliente.factoryCliente(1,"Pepe","Porahi 333", "Los guapos","0303456");
            Cliente clienteNuevo2 = Cliente.factoryCliente(1,"Pipo","Porahi 222", "Los guapos","0303654");
            Turno turno1=Turno.factoryTurno(1, Vehiculo.factoryVehiculo(1,"IXI056","Toyota","2019", clienteNuevo), LocalDate.of(2019, 11, 9), Empleado.factoryEmpleado(1,"Luis",234),100);
            Turno turno2=Turno.factoryTurno(2, Vehiculo.factoryVehiculo(2,"LXI280","Peugeot","2015", clienteNuevo2), LocalDate.of(2019, 12, 9), Empleado.factoryEmpleado(1,"Luis",234),150);
            turnos.add(turno1);
            turnos.add(turno2);
            return turnos;
        } catch (EmpleadoIncompletoException | VehiculoIncompletoException | TurnoIncompletoException | ClienteIncompletoException e) {
            e.printStackTrace();
            return new ArrayList();

        }
    }

    @Test
    public void ObtenerTurnoPorNombreYVehiculo_ExistenTurnos_devuelveLista() throws TurnoIncompletoException {
        when(obtenerTurnoPorClienteYVehiculoRepo.obtenerTurnosPorCLiente("Bautista")).thenReturn(clientes);
        when(obtenerTurnoPorClienteYVehiculoRepo.obtenerTurnosPorVehiculo("IXI056")).thenReturn(turnos);
        ObtenerTurnoPorNombreYVehiculoUseCase obtenerTurnoPorClienteYVehiculoUseCase = new ObtenerTurnoPorNombreYVehiculoUseCase(obtenerTurnoPorClienteYVehiculoRepo);
        BuscarClientesPorNombreUseCase buscarClientesPorNombreUseCase = new BuscarClientesPorNombreUseCase(buscarClientePorNombreRepo);
        List<Cliente> resultado= obtenerTurnoPorClienteYVehiculoUseCase.obtenerTurnoPorCliente("Bautista");
        List<Turno> resultado1= obtenerTurnoPorClienteYVehiculoUseCase.obtenerTurnoPorVehiculo("IXI056");
        //System.out.println(resultado);
        //System.out.println(resultado1);
        Assertions.assertEquals(2,resultado.size());
        Assertions.assertEquals(2,resultado1.size());

    }
}
