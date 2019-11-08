package modelo;

import excepciones.EmpleadoIncompletoException;

public class Empleado {

    private Integer idEmpleado;
    private String nombre;
    private Integer legajo;

    private Empleado(Integer idEmpleado, String nombre, Integer legajo) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.legajo = legajo;
    }

    public static Empleado factoryEmpleado(Integer idEmpleado, String nombre, Integer legajo) throws EmpleadoIncompletoException {
        if(idEmpleado == null || nombre == null || legajo == null){
            throw new EmpleadoIncompletoException();
        }
        else {
            return new Empleado(idEmpleado, nombre, legajo);
        }
    }
}
