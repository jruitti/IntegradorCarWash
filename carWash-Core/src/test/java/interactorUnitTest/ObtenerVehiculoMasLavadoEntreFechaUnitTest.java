package interactorUnitTest;

import excepciones.ClienteIncompletoException;
import excepciones.EmpleadoIncompletoException;
import excepciones.TurnoIncompletoException;
import excepciones.VehiculoIncompletoException;
import mockito.MockitoExtension;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Turno;
import modelo.Vehiculo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IObtenerVehiculoMasLavadoEntreFechaRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerVehiculoMasLavadoEntreFechaUnitTest {

    @Mock
    IObtenerVehiculoMasLavadoEntreFechaRepo obtenerVehiculoMasLavadoEntreFechaRepo;

    private List<Vehiculo> factoryListaVehiculo(){
        try{
            List<Vehiculo> vehiculoList = new ArrayList<>();
            Cliente clienteNuevo = Cliente.factoryCliente(1,"Pepe","Porahi 333", "Los guapos","32458305");
            Cliente clienteNuevo2 = Cliente.factoryCliente(1,"Pipo","Porahi 222", "Los guapos","0303654");
            Turno turno1=Turno.factoryTurno(1, Vehiculo.factoryVehiculo(1,"IXI056","Toyota","2019", clienteNuevo), LocalDate.of(2019, 11, 9), Empleado.factoryEmpleado(1,"Luis",234),100);
            Turno turno2=Turno.factoryTurno(2, Vehiculo.factoryVehiculo(2,"LXI280","Peugeot","2015", clienteNuevo2), LocalDate.of(2019, 12, 9), Empleado.factoryEmpleado(1,"Luis",234),150);
        }catch (EmpleadoIncompletoException | VehiculoIncompletoException | TurnoIncompletoException | ClienteIncompletoException e) {
            e.printStackTrace();
            return new ArrayList();

        }
    }
}
