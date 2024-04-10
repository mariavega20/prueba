package solid.lsp.correcto;

import java.util.List;

public class PersonaTutor extends Persona{
    private Nino ninos;

    public PersonaTutor(String nombre, String apellidos, String tarjeta) {
        super(null, nombre, apellidos, tarjeta);
    }
    public void pagarPorNinio(Nino nino) {
        System.out.println("Mi documento de identificación  es " + getDni() + " y pago con la tarjeta " + getTarjeta() + " por " + nino.getNombre() + getApellido());
    }
}
