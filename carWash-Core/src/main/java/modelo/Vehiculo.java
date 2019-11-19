package modelo;

import excepciones.VehiculoIncompletoException;

public class Vehiculo {
    private Integer idVehiculo;
    private String matricula;
    private String marca;
    private String modelo;
    private Cliente cliente;

    private Vehiculo(int idVehiculo, String matricula, String marca, String modelo, Cliente cliente) {
        this.idVehiculo = idVehiculo;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cliente = cliente;
    }

    public static Vehiculo factoryVehiculo(Integer idVehiculo, String matricula, String marca, String modelo, Cliente cliente)throws VehiculoIncompletoException {
        if(matricula==null||marca==null||modelo==null){
            throw new VehiculoIncompletoException("No puede faltar ningun campo obligatorio");
        }else return new Vehiculo(idVehiculo,matricula,marca,modelo,cliente);
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
