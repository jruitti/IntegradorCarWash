package ar.edu.undec.Service.Controller;

import ar.edu.undec.Service.ModeloService.ClienteDTO;
import ar.edu.undec.Service.ServiceMapper.ClienteDTOMapper;
import excepciones.ClienteExisteException;
import input.ICrearClienteInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class CrearClienteController {
     @Autowired
    private ICrearClienteInput crearClienteInput;

    public CrearClienteController(ICrearClienteInput crearClienteInput){
        this.crearClienteInput=crearClienteInput;

    }
    @RequestMapping(value = "cliente", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> crearCliente(@ResponseBody ClienteDTO clienteDTO){
        try {
            boolean resultado= this.crearClienteInput.crearCliente(new ClienteDTOMapper().mapeoDTOCore(clienteDTO));
            if(resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
        } catch (ClienteExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);
        }
    }
}
