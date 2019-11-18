package ar.edu.undec.Service.ModeloService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmpleadoDTO {

    @JsonProperty("idEmpleado")
    private Integer idEmpleado;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("legajo")
    private Integer legajo;

    public EmpleadoDTO( @JsonProperty("idEmpleado") Integer idEmpleado,@JsonProperty("nombre") String nombre,@JsonProperty("legajo") Integer legajo) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.legajo = legajo;
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
