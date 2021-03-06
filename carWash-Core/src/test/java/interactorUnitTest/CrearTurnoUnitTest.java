package interactorUnitTest;

import excepciones.*;
import interactor.CrearTurnoUseCase;
import mockito.MockitoExtension;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Turno;
import modelo.Vehiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IRepositorioCrearTurno;
import repositorio.IRepositorioCrearVehiculo;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearTurnoUnitTest {
    @Mock
    IRepositorioCrearTurno crearTurnoRepo;


    @Test
    public void crearTurno_TurnoNoExiste_GuardaCorrectamente() throws TurnoIncompletoException, TurnoExisteException, VehiculoIncompletoException, EmpleadoIncompletoException, ClienteIncompletoException {
        Cliente clienteNuevo = Cliente.factoryCliente(1,"Pepe","Porahi 333", "Los guapos","0303456");
        Turno turnoNuevo=Turno.factoryTurno(1, Vehiculo.factoryVehiculo(1,"IXI056","Toyota","2019", clienteNuevo), LocalDate.of(2019, 11, 9), Empleado.factoryEmpleado(1,"Luis",234),100);
        when(crearTurnoRepo.guardar(turnoNuevo)).thenReturn(true);
        CrearTurnoUseCase crearTurnoUseCase = new CrearTurnoUseCase(crearTurnoRepo);
        boolean resultado = crearTurnoUseCase.crearTurno(turnoNuevo);
        Assertions.assertTrue(resultado);

    }
    @Test
    public void crearTurno_TurnoExiste_TurnoExisteException() throws TurnoIncompletoException, VehiculoIncompletoException, EmpleadoIncompletoException, ClienteIncompletoException {
        Cliente clienteNuevo = Cliente.factoryCliente(1,"Pepe","Porahi 333", "Los guapos","0303456");
        Vehiculo vehiculoNuevo = Vehiculo.factoryVehiculo(1, "NRP374","Toyota","2000", clienteNuevo);
        Turno turnoNuevo = Turno.factoryTurno(1, vehiculoNuevo, LocalDate.of(2019, 11, 9), Empleado.factoryEmpleado(1, "Luis", 234), 100);
        when(crearTurnoRepo.findByVehiculoAndFecha(vehiculoNuevo.getMatricula(), LocalDate.of(2019, 11, 9))).thenReturn(Turno.factoryTurno(1, vehiculoNuevo, LocalDate.of(2019, 11, 9), Empleado.factoryEmpleado(1, "pepe", 546), 250));
        CrearTurnoUseCase crearTurnoUseCase = new CrearTurnoUseCase(crearTurnoRepo);
        Assertions.assertThrows(TurnoExisteException.class, () -> crearTurnoUseCase.crearTurno(turnoNuevo));
    }


}
