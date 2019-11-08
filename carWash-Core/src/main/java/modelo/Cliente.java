package modelo;

import excepciones.ClienteIncompletoException;

import java.util.ArrayList;
import java.util.Collection;

public class Cliente {
    private Integer idCliente;
    private String nombre;
    private String domicilio;
    private String barrio;
    private String documento;
    private Collection<Vehiculo> vehiculos;

    private Cliente(Integer idCliente,String nombre,String domicilio,String barrio,String documento){
        this.idCliente=idCliente;
        this.nombre=nombre;
        this.domicilio=domicilio;
        this.barrio=barrio;
        this.documento=documento;
        this.vehiculos= new ArrayList<Vehiculo>();

    }

    public static Cliente factoryCliente(Integer idCliente, String nombre, String domicilio, String barrio, String documento)throws ClienteIncompletoException {
        if(nombre==null||domicilio==null||barrio==null||documento==null){
            throw new ClienteIncompletoException("No puede faltar ningun campo obligatorio");
        }else return new Cliente(idCliente,nombre,domicilio,barrio,documento);
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getBarrio() {
        return barrio;
    }

    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public String getDocumento() {
        return documento;
    }
}
