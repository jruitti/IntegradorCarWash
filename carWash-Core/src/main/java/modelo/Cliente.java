package modelo;

import excepciones.ClienteIncompletoException;

import java.util.ArrayList;

import java.util.List;

public class Cliente {
    private Integer idCliente;
    private String nombre;
    private String domicilio;
    private String barrio;
    private String documento;
    private List<Vehiculo> vehiculos;

    private Cliente(Integer idCliente,String nombre,String domicilio,String barrio,String documento){
        this.idCliente=idCliente;
        this.nombre=nombre;
        this.domicilio=domicilio;
        this.barrio=barrio;
        this.documento=documento;


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

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public String getDocumento() {
        return documento;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }


}
