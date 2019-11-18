package ar.edu.undec.Data.ModeloEntity;
import javax.persistence.*;
import java.util.Collection;

@Entity(name = "empleados")
@SequenceGenerator(name = "seq_empleado", sequenceName = "seq_empleado", initialValue = 1, allocationSize = 1)
public class EmpleadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_empleado")
    private Integer idEmpleado;
    private String nombre;
    private Integer legajo;

    public EmpleadoEntity(){

    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getLegajo() {
        return legajo;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

}
