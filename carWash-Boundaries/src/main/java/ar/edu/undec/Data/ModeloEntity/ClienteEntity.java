package ar.edu.undec.Data.ModeloEntity;

import modelo.Vehiculo;

import javax.persistence.*;
import java.util.Collection;

@Entity(name="clientes")
@SequenceGenerator(name="seq_cliente", sequenceName = "seq_cliente",initialValue = 1, allocationSize = 1)
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
    private Integer idCliente;
    private String nombre;
    private String domicilio;
    private String barrio;
    private String documento;

   // @OneToMany(cascade = CascadeType.MERGE)
    //@JoinColumn(name = "vehiculo_id")
    //private Collection<Vehiculo> vehiculos;

    public ClienteEntity(){}

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

 /*   public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Collection<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }*/
}
