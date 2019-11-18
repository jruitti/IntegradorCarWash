package ar.edu.undec.Service.Controller;

import ar.edu.undec.Service.ModeloService.ClienteDTO;
import ar.edu.undec.Service.ServiceMapper.ClienteDTOMapper;
import excepciones.ClienteExisteException;
import input.IModificarClienteInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class ModificarClienteController {

    @Autowired
    private IModificarClienteInput modificarClienteInput;
    public ModificarClienteController(IModificarClienteInput modificarClienteInput) {
        this.modificarClienteInput=modificarClienteInput;
    }

    @RequestMapping(value = "cliente", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> modificarCliente(@RequestBody ClienteDTO elClienteAModificar) {
        try {
            boolean resultado = this.modificarClienteInput.modificarCliente(new ClienteDTOMapper().mapeoDTOCore(elClienteAModificar));
            if (resultado)  return ResponseEntity.status(HttpStatus.OK).body(true);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (ClienteExisteException e) {
            e.printStackTrace();
               return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);
        }

    }
}
