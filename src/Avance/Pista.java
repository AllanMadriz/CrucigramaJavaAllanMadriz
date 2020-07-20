package Avance;

public class Pista {

private String text;
private String orientacion;
private int numPalabra;

    public Pista(String text, String orientacion, int numPalabra) {
        this.text = text;
        this.orientacion = orientacion;
        this.numPalabra = numPalabra;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public int getNumPalabra() {
        return numPalabra;
    }

    public void setNumPalabra(int numPalabra) {
        this.numPalabra = numPalabra;
    }

    @Override
    public String toString() {
        return  "Pista: " + text +"."+
                " Orientacion: " + orientacion +"."+
                " Numero de palabra: " + numPalabra +"\n";
    }



}
