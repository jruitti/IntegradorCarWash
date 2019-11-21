package interactorUnitTest;

import excepciones.ClienteIncompletoException;
import excepciones.EmpleadoIncompletoException;
import excepciones.TurnoIncompletoException;
import excepciones.VehiculoIncompletoException;
import interactor.ObtenerTop3EmpleadosPorTurnoUseCase;
import mockito.MockitoExtension;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Turno;
import modelo.Vehiculo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import repositorio.IObtenerTop3EmpleadosPorTurnosRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerTop3EmpleadosPorTurnosUnitTestUseCase {

    @Mock
    IObtenerTop3EmpleadosPorTurnosRepo iObtenerTop3EmpleadosPorTurnosRepo;


    @Spy
    List<Empleado> losEmpleados = new ArrayList<>();

    @Test
    public void obtenerTop3EmpleadosConMasTurnos_devuelveBien() throws EmpleadoIncompletoException, ClienteIncompletoException, VehiculoIncompletoException, TurnoIncompletoException {

        Empleado emp1 = Empleado.factoryEmpleado(1, "javier", 12345678);
        Empleado emp2 = Empleado.factoryEmpleado(2, "Juan", 12345465);
        Empleado emp3 = Empleado.factoryEmpleado(3, "Pedro", 12345987);
        losEmpleados.add(emp1);
        losEmpleados.add(emp2);
        losEmpleados.add(emp3);

        when(iObtenerTop3EmpleadosPorTurnosRepo.obtenerTop3EmpleadosPorTurno()).thenReturn(losEmpleados);
        ObtenerTop3EmpleadosPorTurnoUseCase obtenerTop3EmpleadosPorTurnoUseCase = new ObtenerTop3EmpleadosPorTurnoUseCase(iObtenerTop3EmpleadosPorTurnosRepo);
        List<Empleado> top3Empleados = obtenerTop3EmpleadosPorTurnoUseCase.obtenerTop3EmpleadosPorTurno();
        assertEquals(3,top3Empleados.size());
    }

}
