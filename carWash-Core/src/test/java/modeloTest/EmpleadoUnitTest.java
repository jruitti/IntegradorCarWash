package modeloTest;

import excepciones.EmpleadoIncompletoException;
import modelo.Empleado;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoUnitTest {

    @Test
    void instanciarEmpleado_EmpleadoCompleto_instanciaCorrecta () throws EmpleadoIncompletoException{
        Empleado empleado = Empleado.factoryEmpleado(1, "Juan", 12345678);
        assertNotNull(empleado);
    }

    @Test
    void instaciarEmpleado_EmpleadoIncompleto_instaciaIncoreccta() throws EmpleadoIncompletoException{
        Assertions.assertThrows(EmpleadoIncompletoException.class, ()-> Empleado.factoryEmpleado(null, null, null));
    }
}
