package solid.lsp.correcto;

public class Nino extends Persona{
    private PersonaTutor tutorEncargado;

    public Nino(String nombre, String apellidos) {
        super(null, nombre, apellidos, null);
        this.tutorEncargado = tutorEncargado;
    }
    public void pagar() {
        tutorEncargado.pagarPorNinio(this);
    }
}
