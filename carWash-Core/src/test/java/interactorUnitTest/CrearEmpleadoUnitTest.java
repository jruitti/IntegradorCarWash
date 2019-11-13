package interactorUnitTest;

import excepciones.EmpleadoExisteException;
import excepciones.EmpleadoIncompletoException;
import interactor.CrearEmpleadoUseCase;
import mockito.MockitoExtension;
import modelo.Empleado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IRepositorioCrearEmpleado;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearEmpleadoUnitTest {

    @Mock
    IRepositorioCrearEmpleado crearEmpleadoRepo;

    @Test
    public void crearEmpleado_EmpleadoNoExiste_GuardaCorrectamente() throws EmpleadoIncompletoException, EmpleadoExisteException {
        Empleado empleadoNuevo = Empleado.factoryEmpleado(1, "javier", 12345678);
        when(crearEmpleadoRepo.guardarEmpleado(empleadoNuevo)).thenReturn(true);
        CrearEmpleadoUseCase crearEmpleadoUseCase = new CrearEmpleadoUseCase(crearEmpleadoRepo);
        boolean resultado= crearEmpleadoUseCase.crearEmpleado(empleadoNuevo);
        Assertions.assertTrue(resultado);

    }

    @Test
    public void crearEmpleado_EmpleadoExiste_EmpleadoExisteException() throws EmpleadoIncompletoException {
        Empleado empleadoNuevo = Empleado.factoryEmpleado(1, "javier", 12345678);
        when(crearEmpleadoRepo.findByLegajo(12345678)).thenReturn(Empleado.factoryEmpleado(1, "Pedro", 12345678));
        CrearEmpleadoUseCase crearEmpleadoUseCase = new CrearEmpleadoUseCase(crearEmpleadoRepo);
        Assertions.assertThrows(EmpleadoExisteException.class, () -> crearEmpleadoUseCase.crearEmpleado(empleadoNuevo));

    }

}
