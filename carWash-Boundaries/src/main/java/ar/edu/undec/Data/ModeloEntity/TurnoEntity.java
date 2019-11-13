package ar.edu.undec.Data.ModeloEntity;

import modelo.Empleado;
import modelo.Vehiculo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name="turnos")
@SequenceGenerator(name="seq_turno", sequenceName = "seq_turno",initialValue = 1, allocationSize = 1)



public class TurnoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_turno")
    private Integer idPedido;
    private LocalDate fecha;
    private float precio;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "empleado_id")
    private EmpleadoEntity encargado;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "vehiculo_id")
    private VehiculoEntity vehiculo;

    public TurnoEntity(){}

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public VehiculoEntity getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoEntity vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public EmpleadoEntity getEncargado() {
        return encargado;
    }

    public void setEncargado(EmpleadoEntity encargado) {
        this.encargado = encargado;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
