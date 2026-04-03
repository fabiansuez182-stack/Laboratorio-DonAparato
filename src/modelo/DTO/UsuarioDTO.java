package modelo.DTO;

/**
 * Data Transfer Object para la entidad Usuario.
 * Transporta datos entre la capa de acceso a datos (DAO) y los controladores.
 */
public class UsuarioDTO {

    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String telefono;
    private String tipo; // A, B, C, o null (Sin afiliación)

    public UsuarioDTO() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}