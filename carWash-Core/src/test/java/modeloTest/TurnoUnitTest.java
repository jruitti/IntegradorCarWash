package modeloTest;

import excepciones.ClienteIncompletoException;
import excepciones.EmpleadoIncompletoException;
import excepciones.TurnoIncompletoException;
import excepciones.VehiculoIncompletoException;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Turno;
import modelo.Vehiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TurnoUnitTest {

        @Test
        public void instanciarTurno_TurnoCompleto_instanciaCorrecta() throws TurnoIncompletoException, VehiculoIncompletoException, EmpleadoIncompletoException, ClienteIncompletoException {
            Cliente clienteNuevo = Cliente.factoryCliente(1,"Pepe","Porahi 333", "Los guapos","0303456");
            Turno unTurno=Turno.factoryTurno(1, Vehiculo.factoryVehiculo(1,"IXI056","Toyota","2019", clienteNuevo), LocalDate.of(2019, 11, 9), Empleado.factoryEmpleado(1,"Luis",234),100);
            assertNotNull(unTurno);
        }


        @Test
        void instanciarTurno_FaltaAlgunAtrubuto_TurnoIncompletoException() throws TurnoIncompletoException, ClienteIncompletoException {
            Cliente clienteNuevo = Cliente.factoryCliente(1,"Pepe","Porahi 333", "Los guapos","0303456");
            Assertions.assertThrows(TurnoIncompletoException.class, ()-> Turno.factoryTurno(1, Vehiculo.factoryVehiculo(1,"IXI056","Toyota","2019", clienteNuevo), null, null,0));
        }

    }