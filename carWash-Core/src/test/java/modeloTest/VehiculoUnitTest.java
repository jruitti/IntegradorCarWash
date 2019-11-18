package modeloTest;

import excepciones.ClienteIncompletoException;
import excepciones.VehiculoIncompletoException;
import modelo.Cliente;
import modelo.Vehiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehiculoUnitTest {

    @Test
    void instanciarVehiculo_VehiculoCompleto_instanciaCorrecta() throws VehiculoIncompletoException, ClienteIncompletoException {
        Cliente clienteNuevo = Cliente.factoryCliente(1,"Pepe","Porahi 333", "Los guapos","0303456");
        Vehiculo elVehiculo= Vehiculo.factoryVehiculo(1,"NRP374", "Toyota","Etios", clienteNuevo);
        assertNotNull(elVehiculo);
    }

    @Test

    void     instanciarVehiculo_VehiculoSinMatricula_VehiculoINcompletoException() throws VehiculoIncompletoException, ClienteIncompletoException {
        Cliente clienteNuevo = Cliente.factoryCliente(1,"Pepe","Porahi 333", "Los guapos","0303456");
        Assertions.assertThrows(VehiculoIncompletoException.class, ()-> Vehiculo.factoryVehiculo(1,null, "Toyota","Etios", clienteNuevo));
    }

}