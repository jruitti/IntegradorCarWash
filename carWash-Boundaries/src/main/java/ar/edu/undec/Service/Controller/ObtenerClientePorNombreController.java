package ar.edu.undec.Service.Controller;

import ar.edu.undec.Service.ModeloService.ClienteDTO;
import ar.edu.undec.Service.ServiceMapper.ClienteDTOMapper;
import input.IBuscarClientePorNombreImput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@RestController
public class ObtenerClientePorNombreController {

    @Autowired
    private IBuscarClientePorNombreImput buscarClientePorNombreImput;

    public ObtenerClientePorNombreController( IBuscarClientePorNombreImput buscarClientePorNombreImput){
        this.buscarClientePorNombreImput=buscarClientePorNombreImput;
    }
    @RequestMapping(value = "cliente/nombre/{nombre}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody

    public ResponseEntity<?> consultarClientePorNombre(@PathVariable("nombre") String nombre){
        try {
            List<ClienteDTO> cliente = new ArrayList<>();
            this.buscarClientePorNombreImput.buscarClientePorNombre(nombre).forEach(tp -> cliente.add(new ClienteDTOMapper().mapeoCoreDTO(tp)));
            if (cliente.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(cliente);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
