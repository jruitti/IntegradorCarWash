package ar.edu.undec.Service.ModeloService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteDTO {

    @JsonProperty("idCliente")
    private Integer idCliente;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("domicilio")
    private String domicilio;
    @JsonProperty("barrio")
    private String barrio;
    @JsonProperty("documento")
    private String documento;

    public ClienteDTO(@JsonProperty("idCliente") Integer idCliente, @JsonProperty("nombre") String nombre,@JsonProperty("domicilio") String domicilio,@JsonProperty("barrio") String barrio, @JsonProperty("documento") String documento){
        this.idCliente=idCliente;
        this.nombre=nombre;
        this.domicilio=domicilio;
        this.barrio=barrio;
        this.documento=documento;
    }

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
}
