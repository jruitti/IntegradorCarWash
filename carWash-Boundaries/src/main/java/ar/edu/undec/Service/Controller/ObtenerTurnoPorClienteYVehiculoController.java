package ar.edu.undec.Service.Controller;

import ar.edu.undec.Data.EntityMapper.ClienteEntityMapper;
import ar.edu.undec.Service.ModeloService.ClienteDTO;
import ar.edu.undec.Service.ModeloService.TurnoDTO;
import ar.edu.undec.Service.ModeloService.VehiculoDTO;
import ar.edu.undec.Service.ServiceMapper.ClienteDTOMapper;
import ar.edu.undec.Service.ServiceMapper.TurnoDTOMapper;
import ar.edu.undec.Service.ServiceMapper.VehiculoDTOMapper;
import input.IObtenerTurnoPorClienteYVehiculoInput;
import modelo.Cliente;
import modelo.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@RestController
public class ObtenerTurnoPorClienteYVehiculoController {

    @Autowired
    private IObtenerTurnoPorClienteYVehiculoInput obtenerTurnoPorClienteYVehiculoInput;

    public ObtenerTurnoPorClienteYVehiculoController(IObtenerTurnoPorClienteYVehiculoInput obtenerTurnoPorClienteYVehiculoInput) {
        this.obtenerTurnoPorClienteYVehiculoInput=obtenerTurnoPorClienteYVehiculoInput;
    }

    @RequestMapping(value = "turno/cliente/vehiculo/{turno}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> obtenerTurnos(@RequestBody ClienteDTO elCliente,@RequestBody VehiculoDTO elVehiculo) {
        try {

            List<Turno> turno = this.obtenerTurnoPorClienteYVehiculoInput.obtenerturnoPorClienteYVehiculo(new ClienteDTOMapper().mapeoDTOCore(elCliente),new VehiculoDTOMapper().mapeoDTOCore(elVehiculo));
            if (turno.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(turno);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
