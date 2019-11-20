package interactorUnitTest;

import excepciones.ClienteIncompletoException;
import excepciones.EmpleadoIncompletoException;
import excepciones.TurnoIncompletoException;
import excepciones.VehiculoIncompletoException;
import interactor.ObtenerVehiculoMasLavadoEntreFechaUseCase;
import mockito.MockitoExtension;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Turno;
import modelo.Vehiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IObtenerVehiculoMasLavadoEntreFechaRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerVehiculoMasLavadoEntreFechaUnitTest {

    @Mock
    IObtenerVehiculoMasLavadoEntreFechaRepo obtenerVehiculoMasLavadoEntreFechaRepo;

    private Vehiculo factoryVehiculo(){
        try{
            List<Turno> turnoList = new ArrayList<>();
            Cliente clienteNuevo = Cliente.factoryCliente(1,"Pepe","Porahi 333", "Los guapos","32458305");
            Cliente clienteNuevo2 = Cliente.factoryCliente(2,"Pipo","Porahi 222", "Los guapos","0303654");
            Cliente clienteNuevo3 = Cliente.factoryCliente(3,"pepi","Porahi 333", "Los guapos","32458398");
            Cliente clienteNuevo4 = Cliente.factoryCliente(4,"popo","Porahi 222", "Los guapos","03036129");
            Vehiculo vehiculo = Vehiculo.factoryVehiculo(1,"IXI056","Toyota","2019", clienteNuevo);
            Vehiculo vehiculo2 = Vehiculo.factoryVehiculo(2,"LXI280","Peugeot","2015", clienteNuevo2);
            Vehiculo vehiculo3 = Vehiculo.factoryVehiculo(2,"LXI390","ford","2016", clienteNuevo3);
            Vehiculo vehiculo4 = Vehiculo.factoryVehiculo(2,"SDI210","Peugeot","2017", clienteNuevo4);

            Turno turno1=Turno.factoryTurno(1, vehiculo, LocalDate.of(2019, 11, 25), Empleado.factoryEmpleado(1,"Luis",234),100);
            Turno turno2=Turno.factoryTurno(2, vehiculo2, LocalDate.of(2019, 12, 9), Empleado.factoryEmpleado(2,"Juan",235),150);
            Turno turno3=Turno.factoryTurno(3, vehiculo3, LocalDate.of(2019, 9, 9), Empleado.factoryEmpleado(1,"Luis",234),100);
            Turno turno4=Turno.factoryTurno(4, vehiculo4, LocalDate.of(2019, 8, 9), Empleado.factoryEmpleado(2,"Juan",235),150);
            Turno turno5=Turno.factoryTurno(5, vehiculo, LocalDate.of(2019, 12, 1), Empleado.factoryEmpleado(1,"Luis",234),100);
            Turno turno6=Turno.factoryTurno(6, vehiculo2, LocalDate.of(2019, 12, 20), Empleado.factoryEmpleado(2,"Juan",235),150);
            Turno turno7=Turno.factoryTurno(7, vehiculo3, LocalDate.of(2019, 9, 9), Empleado.factoryEmpleado(1,"Luis",234),100);
            Turno turno8=Turno.factoryTurno(8, vehiculo, LocalDate.of(2019, 12, 20), Empleado.factoryEmpleado(2,"Juan",235),150);

            turnoList.add(turno1);
            turnoList.add(turno2);
            turnoList.add(turno3);
            turnoList.add(turno4);
            turnoList.add(turno5);
            turnoList.add(turno6);
            turnoList.add(turno7);
            turnoList.add(turno8);

            return vehiculo;
        }catch (EmpleadoIncompletoException | VehiculoIncompletoException | TurnoIncompletoException | ClienteIncompletoException e) {
            e.printStackTrace();
            return null;

        }
    }

    @Test
    public void ObtenerVehiculoMasLavadoEntreFecha_ExisteVehiculo_DevuelveVehiculo() throws VehiculoIncompletoException, ClienteIncompletoException {
        Cliente clienteNuevo = Cliente.factoryCliente(1,"Pepe","Porahi 333", "Los guapos","32458305");
        Vehiculo vehiculo1 = Vehiculo.factoryVehiculo(1,"IXI056","Toyota","2019", clienteNuevo);
        when(obtenerVehiculoMasLavadoEntreFechaRepo.obtenerVehiculoMasLavadoEntreFecha(LocalDate.of(2019, 11, 20),LocalDate.of(2019, 12, 20))).thenReturn(factoryVehiculo());
        ObtenerVehiculoMasLavadoEntreFechaUseCase obtenerVehiculoMasLavadoEntreFechaUseCase = new ObtenerVehiculoMasLavadoEntreFechaUseCase(obtenerVehiculoMasLavadoEntreFechaRepo);
        Vehiculo resultado = obtenerVehiculoMasLavadoEntreFechaUseCase.obtenerVehiculoMasLavadoEntreFecha(LocalDate.of(2019, 11, 20),LocalDate.of(2019, 12, 20));
        Assertions.assertEquals(vehiculo1.getIdVehiculo(),resultado.getIdVehiculo());
    }
}
