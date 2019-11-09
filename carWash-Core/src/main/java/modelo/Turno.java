package modelo;

import excepciones.TurnoIncompletoException;

import java.time.LocalDate;

public class Turno {
    private Integer idPedido;
    private Vehiculo vehiculo;
    private LocalDate fecha;
    private Empleado encargado;
    private float precio;

    private Turno(Integer idPedido,Vehiculo vehiculo,LocalDate fecha,Empleado encargado,float precio){
        this.idPedido=idPedido;
        this.vehiculo=vehiculo;
        this.fecha=fecha;
        this.encargado=encargado;
        this.precio=precio;
    }

    public static Turno factoryTurno(Integer idPedido, Vehiculo vehiculo, LocalDate fecha, Empleado encargado, float precio) throws TurnoIncompletoException {
        if(vehiculo==null||fecha==null||encargado==null||precio==0){
                throw new TurnoIncompletoException("no Puede faltar ningun campo, datos obligatorios");
        }else return new Turno(idPedido,vehiculo,fecha,encargado,precio);
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
