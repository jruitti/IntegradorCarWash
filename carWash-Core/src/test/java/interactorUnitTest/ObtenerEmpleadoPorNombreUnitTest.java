package interactorUnitTest;

import excepciones.EmpleadoIncompletoException;
import interactor.ObtenerEmpleadoPorNombreUseCase;
import mockito.MockitoExtension;
import modelo.Empleado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import repositorio.IObtnerEmpleadoPorNombreRepo;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerEmpleadoPorNombreUnitTest {
    @Mock
    IObtnerEmpleadoPorNombreRepo obtnerEmpleadoPorNombreRepo;
    @Spy
    List<Empleado> empleados = factoryListEmpleados();

    private List<Empleado> factoryListEmpleados() {
        try {
            List<Empleado> losEmpleados= new ArrayList<>();
            Empleado empleado1 = Empleado.factoryEmpleado(1, "javier", 12345678);
            Empleado empleado2 = Empleado.factoryEmpleado(2, "Juan", 12345465);
            Empleado empleado3 = Empleado.factoryEmpleado(3, "Pedro", 12345987);
            losEmpleados.add(empleado1);
            losEmpleados.add(empleado2);
            losEmpleados.add(empleado3);
            return losEmpleados;
        } catch (EmpleadoIncompletoException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Test
    public void obtenerEmpleadoPorNombre_ExistenEmpleado_devuelveLista() throws EmpleadoIncompletoException {

        when(obtnerEmpleadoPorNombreRepo.buscarEmpleadoPorNombre("Javier")).thenReturn(empleados);
        ObtenerEmpleadoPorNombreUseCase obtenerEmpleadoPorNombreUseCase = new   ObtenerEmpleadoPorNombreUseCase(obtnerEmpleadoPorNombreRepo);
        List<Empleado> resultado=obtenerEmpleadoPorNombreUseCase.buscarEmpleadoPorNombre("Javier");
        Assertions.assertEquals(3,resultado.size());

    }

}
