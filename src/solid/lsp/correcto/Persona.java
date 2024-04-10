package solid.lsp.correcto;
public class Persona {
    private String dni;
    private String nombre;
    private String apellido;
    private String tarjeta;

    public Persona(String dni, String nombre, String apellido, String tarjeta) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tarjeta = tarjeta;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
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
    public String getTarjeta() {
        return tarjeta;
    }
    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }


    public void pagar() {

        if (tarjeta != null) {
            System.out.println("Mi documento de identificación es " + getDni() + 
            System.lineSeparator() + "Pago con la tarjeta " + tarjeta + 
            System.lineSeparator() + "A nombre de " + 
            System.lineSeparator() + getNombre() + " " + getApellido());
        } else {
            System.out.println("No se escribio un número de tarjeta");
        }
    }
}
