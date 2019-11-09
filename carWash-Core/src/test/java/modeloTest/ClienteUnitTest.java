package modeloTest;

import excepciones.ClienteIncompletoException;
import modelo.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ClienteUnitTest {
    @Test
   public void instanciarCliente_ClienteCompleto_instanciaCorrecta() throws ClienteIncompletoException {
        Cliente elCliente=Cliente.factoryCliente(1,"Bautista", "Davila San roman 124","B° El Asfalto","32458305");
        assertNotNull(elCliente);
    }

    @Test
    public void instanciarCliente_FaltaAlgunAtributo_ClienteIncompletoException() throws ClienteIncompletoException {
        Assertions.assertThrows(ClienteIncompletoException.class, ()-> Cliente.factoryCliente(1,"Bautista", null,"B° El Asfalto",null));
    }

}
