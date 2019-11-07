package modeloTest;

import excepciones.VehiculoIncompletoException;
import modelo.Vehiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehiculoUnitTest {

    @Test
    void instanciarVehiculo_VehiculoCompleto_instanciaCorrecta() throws VehiculoIncompletoException {
        Vehiculo elVehiculo= Vehiculo.factoryVehiculo(1,"NRP374", "Toyota","Etios");
        assertNotNull(elVehiculo);
    }

    @Test

    void     instanciarVehiculo_VehiculoSinMatricula_VehiculoINcompletoException() throws VehiculoIncompletoException {
        Assertions.assertThrows(VehiculoIncompletoException.class, ()-> Vehiculo.factoryVehiculo(1,null, "Toyota","Etios"));
    }

}