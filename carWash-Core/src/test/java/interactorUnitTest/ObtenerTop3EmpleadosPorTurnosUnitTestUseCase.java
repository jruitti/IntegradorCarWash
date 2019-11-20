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
import repositorio.IObtenerTop3EmpleadosPorTurnosRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerTop3EmpleadosPorTurnosUnitTestUseCase {

    @Mock
    IObtenerTop3EmpleadosPorTurnosRepo obtenerTop3EmpleadosPorTurnosRepo;

    @Test
    public void obtenerTop3EmpleadosConMasTurnos_devuelveBien() throws ClienteIncompletoException, VehiculoIncompletoException, EmpleadoIncompletoException, TurnoIncompletoException {

        List<Turno> losTurnos= new ArrayList<>();
        List<Empleado> losEmpleados = new ArrayList<>();
        List <Empleado> los3Empleados = new ArrayList<>();

        Cliente pepe = Cliente.factoryCliente(1, "Pepe", "Porahi 333", "Los guapos", "32458305");
        Cliente pipo = Cliente.factoryCliente(1, "Pipo", "Porahi 222", "Los guapos", "0303654");
        Cliente pepi = Cliente.factoryCliente(3, "pepi", "Porahi 342", "Los guapos", "32458398");
        Cliente popo = Cliente.factoryCliente(4, "popo", "Porahi 212", "Los guapos", "03036129");
        Cliente bauta = Cliente.factoryCliente(5, "Bauta", "Chilecito", "Paiman Sur", "20897654");
        Cliente bauto= Cliente.factoryCliente(6,"Bauto", "Cordoba","Leandro Alem","45098345");

        Vehiculo veh = Vehiculo.factoryVehiculo(1,"IXI056","Toyota","2019", pepe);
        Vehiculo veh2 = Vehiculo.factoryVehiculo(2,"LXI280","Peugeot","2015", pepi);
        Vehiculo veh3 = Vehiculo.factoryVehiculo(3,"LXI390","ford","2016", popo);
        Vehiculo veh4 = Vehiculo.factoryVehiculo(5,"SDI210","Peugeot","2017", pipo);
        Vehiculo veh5 = Vehiculo.factoryVehiculo(3,"AAA111","ford","2013", bauta);
        Vehiculo veh6 = Vehiculo.factoryVehiculo(5,"SBB244","Peugeot","2010", bauto);

        Empleado emp1 = Empleado.factoryEmpleado(1, "javier", 12345678);
        Empleado emp2 = Empleado.factoryEmpleado(2, "Juan", 12345465);
        Empleado emp3 = Empleado.factoryEmpleado(3, "Pedro", 12345987);
        Empleado emp4 = Empleado.factoryEmpleado(1, "lucas", 12345678);
        Empleado emp5 = Empleado.factoryEmpleado(2, "judas", 12345656);
        Empleado emp6 = Empleado.factoryEmpleado(3, "mateo", 12345454);

        losEmpleados.add(emp1);
        losEmpleados.add(emp2);
        losEmpleados.add(emp3);
        losEmpleados.add(emp4);
        losEmpleados.add(emp5);
        losEmpleados.add(emp6);

        Turno turno1=Turno.factoryTurno(1, veh, LocalDate.of(2019, 11, 25), emp1,100);
        Turno turno2=Turno.factoryTurno(2, veh2, LocalDate.of(2019, 12, 9), emp2,150);
        Turno turno3=Turno.factoryTurno(3, veh3, LocalDate.of(2019, 9, 9), emp1,100);
        Turno turno4=Turno.factoryTurno(4, veh4, LocalDate.of(2019, 8, 9), emp1,150);
        Turno turno5=Turno.factoryTurno(5, veh5, LocalDate.of(2019, 12, 1), emp1,100);
        Turno turno6=Turno.factoryTurno(6, veh6, LocalDate.of(2019, 12, 20), emp2,150);
        Turno turno7=Turno.factoryTurno(7, veh6, LocalDate.of(2019, 9, 9), emp2,100);
        Turno turno8=Turno.factoryTurno(8, veh2, LocalDate.of(2019, 12, 20), emp3,150);
        Turno turno9=Turno.factoryTurno(9, veh2, LocalDate.of(2019, 12, 20), emp3,300);
        Turno turno10=Turno.factoryTurno(10, veh2, LocalDate.of(2019, 12, 20), emp4,500);

        losTurnos.add(turno1);
        losTurnos.add(turno2);
        losTurnos.add(turno3);
        losTurnos.add(turno4);
        losTurnos.add(turno5);
        losTurnos.add(turno6);
        losTurnos.add(turno7);
        losTurnos.add(turno8);
        losTurnos.add(turno9);
        losTurnos.add(turno10);

        when(obtenerTop3EmpleadosPorTurnosRepo.findByEmpleadoAndTurno(losTurnos, losEmpleados)).thenReturn(los3Empleados);
        ObtenerTop3EmpleadosPorTurnoUseCase obtenerTop3EmpleadosPorTurnoUseCase = new ObtenerTop3EmpleadosPorTurnoUseCase(obtenerTop3EmpleadosPorTurnosRepo);
        assertEquals(3, obtenerTop3EmpleadosPorTurnoUseCase.obtenerTop3EmpleadosPorTurno(losTurnos, losEmpleados).size());
        assertEquals("javier", obtenerTop3EmpleadosPorTurnoUseCase.obtenerTop3EmpleadosPorTurno(losTurnos, losEmpleados).get(0));
        assertEquals("Juan", obtenerTop3EmpleadosPorTurnoUseCase.obtenerTop3EmpleadosPorTurno(losTurnos, losEmpleados).get(0));
        assertEquals("Pedro", obtenerTop3EmpleadosPorTurnoUseCase.obtenerTop3EmpleadosPorTurno(losTurnos, losEmpleados).get(0));

    }

}
