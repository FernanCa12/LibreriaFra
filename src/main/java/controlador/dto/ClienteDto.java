package controlador.dto;

public class ClienteDto {
    private Integer idCliente;
    private String nombre;
    private String genero;
    private Integer cedula;

    public ClienteDto() {
    }

    public ClienteDto(Integer idCliente, String nombre, String genero, Integer cedula) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.genero = genero;
        this.cedula = cedula;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "ClienteDto{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", cedula=" + cedula +
                '}';
    }
}
