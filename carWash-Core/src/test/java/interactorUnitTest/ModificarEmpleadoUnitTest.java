package interactorUnitTest;

import excepciones.EmpleadoExisteException;
import excepciones.EmpleadoIncompletoException;
import interactor.ModificarEmpleadoUseCase;
import mockito.MockitoExtension;
import modelo.Empleado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IModificarEmpleadoRepo;

import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ModificarEmpleadoUnitTest {

    @Mock
    IModificarEmpleadoRepo modificarEmpleadoRepo;

    @Test
    public void modificarEmpleado_EmpleadoExistente_GuardaCorrectamente() throws EmpleadoIncompletoException, EmpleadoExisteException {
        Empleado empleadoNuevo = Empleado.factoryEmpleado(1, "javier", 12345678);
        when(modificarEmpleadoRepo.findByLegajo(12345678)).thenReturn(null);
        when(modificarEmpleadoRepo.modificarEmpleado(empleadoNuevo)).thenReturn(true);
        ModificarEmpleadoUseCase modificarEmpleadoUseCase = new ModificarEmpleadoUseCase(modificarEmpleadoRepo);
        boolean resultado = modificarEmpleadoUseCase.modificarEmpleado(empleadoNuevo);
        Assertions.assertTrue(resultado);

    }

    @Test
    public void modificarEmpleado_ConflictoEnId_EmpleadoExistente() throws EmpleadoIncompletoException {
        Empleado empleadoNuevo = Empleado.factoryEmpleado(1, "javier", 12345678);
        when(modificarEmpleadoRepo.findByLegajo(12345678)).thenReturn(Empleado.factoryEmpleado(2, "javier", 12345678));
        ModificarEmpleadoUseCase modificarEmpleadoUseCase = new ModificarEmpleadoUseCase(modificarEmpleadoRepo);
        Assertions.assertThrows(EmpleadoExisteException.class, () -> modificarEmpleadoUseCase.modificarEmpleado(empleadoNuevo));

    }

    @Test
    public void modificarEmpleado_ConflictoConEmpleadoExistentePeroEsElMismo_GuardaCorrectamente() throws EmpleadoIncompletoException, EmpleadoExisteException {

        Empleado empleadoNuevo = Empleado.factoryEmpleado(1, "javier", 12345678);
        when(modificarEmpleadoRepo.findByLegajo(12345678)).thenReturn(Empleado.factoryEmpleado(1, "Pedro", 12345013));
        when(modificarEmpleadoRepo.modificarEmpleado(empleadoNuevo)).thenReturn(true);
        ModificarEmpleadoUseCase modificarEmpleadoUseCase = new ModificarEmpleadoUseCase(modificarEmpleadoRepo);
        boolean resultado = modificarEmpleadoUseCase.modificarEmpleado(empleadoNuevo);
        Assertions.assertTrue(resultado);

    }

}
