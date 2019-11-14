package ar.edu.undec.Service.Controller;

import input.ICrearClienteInput;
import org.springframework.beans.factory.annotation.Autowired;
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

    //@ResponseBody
}
