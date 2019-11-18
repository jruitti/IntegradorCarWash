package ar.edu.undec.Service.ModeloService;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class TurnoDTO {
    @JsonProperty("idPedido")
    private Integer idPedido;
    @JsonProperty("vehiculo")
    private VehiculoDTO vehiculo;
    @JsonProperty("fecha")
    private LocalDate fecha;
    @JsonProperty("encargado")
    private EmpleadoDTO encargado;
    @JsonProperty("precio")
    private float precio;

    public TurnoDTO( @JsonProperty("idPedido") Integer idPedido, @JsonProperty("vehiculo") VehiculoDTO vehiculo,
                     @JsonProperty("fecha") LocalDate fecha, @JsonProperty("encargado") EmpleadoDTO encargado,
                     @JsonProperty("precio") float precio){
        this.idPedido = idPedido;
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.encargado = encargado;
        this.precio = precio;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public EmpleadoDTO getEncargado() {
        return encargado;
    }

    public void setEncargado(EmpleadoDTO encargado) {
        this.encargado = encargado;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
