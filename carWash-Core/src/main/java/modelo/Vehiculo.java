package modelo;

import excepciones.ClienteIncompletoException;
import excepciones.VehiculoIncompletoException;

public class Vehiculo {
    private Integer idVehiculo;
    private String matricula;
    private String marca;
    private String modelo;

    private Vehiculo(int idVehiculo, String matricula, String marca, String modelo) {
        this.idVehiculo = idVehiculo;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    public static Vehiculo factoryVehiculo(Integer idVehiculo, String matricula, String marca, String modelo)throws VehiculoIncompletoException {
        if(matricula==null||marca==null||modelo==null){
            throw new VehiculoIncompletoException("No puede faltar ningun campo obligatorio");
        }else return new Vehiculo(idVehiculo,matricula,marca,modelo);
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
}
