package interactorUnitTest;

import excepciones.*;
import interactor.ModificarTurnoUseCase;
import mockito.MockitoExtension;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Turno;
import modelo.Vehiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IModificarTurnoRepo;
import repositorio.IRepositorioCrearVehiculo;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ModificarTurnoUnitTest {

    @Mock
    IModificarTurnoRepo modificarTurnoRepo;
    @Mock
    IRepositorioCrearVehiculo repositorioCrearVehiculo;
    @Test
    public void modificarTurno_TurnoExistente_GuardaCorrectamente() throws VehiculoIncompletoException, EmpleadoIncompletoException, TurnoIncompletoException, TurnoExisteException, ClienteIncompletoException {
        Cliente clienteNuevo = Cliente.factoryCliente(1,"Pepe","Porahi 333", "Los guapos","0303456");
        Vehiculo vehiculoNuevo = Vehiculo.factoryVehiculo(1, "NRP374","Toyota","2000", clienteNuevo);
       // when(repositorioCrearVehiculo.findByMatricula("NRP374")).thenReturn(null);
        Turno turnoDatosNuevo = Turno.factoryTurno(1, vehiculoNuevo, LocalDate.of(2019, 11, 9), Empleado.factoryEmpleado(1, "Luis", 234), 100);
        when(modificarTurnoRepo.findBFecha(LocalDate.of(2019, 11, 9))).thenReturn(null);
        when(modificarTurnoRepo.modificarTurno(turnoDatosNuevo)).thenReturn(true);
        ModificarTurnoUseCase modificarTurnoUseCase= new ModificarTurnoUseCase(modificarTurnoRepo,repositorioCrearVehiculo);
        boolean resultado= modificarTurnoUseCase.modificarTurno(turnoDatosNuevo);
        Assertions.assertTrue(resultado);

    }
    @Test
    public void ModificarTurno_ConflictoEnId_TurnoExistente() throws TurnoIncompletoException, VehiculoIncompletoException, EmpleadoIncompletoException, ClienteIncompletoException {
        Cliente clienteNuevo = Cliente.factoryCliente(1,"Pepe","Porahi 333", "Los guapos","0303456");
        Vehiculo vehiculoNuevo = Vehiculo.factoryVehiculo(1, "NRP374","Toyota","2000", clienteNuevo);
        when(repositorioCrearVehiculo.findByMatricula("NRP374")).thenReturn(Vehiculo.factoryVehiculo(1, "NRP374","Toyota","2000", clienteNuevo));

        Turno turnoDatosNuevo = Turno.factoryTurno(1, vehiculoNuevo, LocalDate.of(2019, 11, 9), Empleado.factoryEmpleado(1, "Luis", 234), 100);
        when(modificarTurnoRepo.findBFecha(LocalDate.of(2019, 11, 9))).thenReturn(Turno.factoryTurno(2, vehiculoNuevo, LocalDate.of(2019, 11, 9), Empleado.factoryEmpleado(1, "Luis", 234), 100));
        ModificarTurnoUseCase modificarTurnoUseCase = new ModificarTurnoUseCase(modificarTurnoRepo,repositorioCrearVehiculo);
        Assertions.assertThrows(TurnoExisteException.class, () -> modificarTurnoUseCase.modificarTurno(turnoDatosNuevo));
    }

    @Test
    public void modificarTurno_ConflictoConTurnoExistentePeroEsElMismo_GuardaCorrectamente() throws VehiculoIncompletoException, EmpleadoIncompletoException, TurnoIncompletoException, TurnoExisteException, ClienteIncompletoException {
        Cliente clienteNuevo = Cliente.factoryCliente(1,"Pepe","Porahi 333", "Los guapos","0303456");
        Vehiculo vehiculoNuevo = Vehiculo.factoryVehiculo(1, "NRP374","Toyota","2000", clienteNuevo);
        when(repositorioCrearVehiculo.findByMatricula("NRP374")).thenReturn(Vehiculo.factoryVehiculo(1, "NRP374","Toyota","2000", clienteNuevo));

        Turno turnoDatosNuevo = Turno.factoryTurno(1, vehiculoNuevo, LocalDate.of(2019, 11, 9), Empleado.factoryEmpleado(1, "Luis", 234), 100);
        when(modificarTurnoRepo.findBFecha(LocalDate.of(2019, 11, 9))).thenReturn(Turno.factoryTurno(1, vehiculoNuevo, LocalDate.of(2019, 11, 9), Empleado.factoryEmpleado(1, "Pedro", 235), 200));
       when(modificarTurnoRepo.modificarTurno(turnoDatosNuevo)).thenReturn(true);
        ModificarTurnoUseCase modificarTurnoUseCase = new ModificarTurnoUseCase(modificarTurnoRepo,repositorioCrearVehiculo);
        boolean resultado=modificarTurnoUseCase.modificarTurno(turnoDatosNuevo);
        Assertions.assertTrue(resultado);



    }

}
