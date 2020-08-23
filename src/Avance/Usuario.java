package Avance;

public class Usuario {

    private String usario;

    public Usuario(String usario) {
        this.usario = usario;
    }

    public Usuario() {

    }

    public String getUsario() {
        return usario;
    }

    public void setUsario(String usario) {
        this.usario = usario;
    }

    @Override
    public String toString() {

        return "Usario: " + usario;
    }
}
