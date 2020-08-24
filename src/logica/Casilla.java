package logica;


public class Casilla {

   private Integer fila;
   private Integer columna;
   private Boolean activada;
   private String letra;

    public Casilla(Integer fila, Integer columna, Boolean activada, String letra) {

        this.fila = fila;
        this.columna = columna;
        this.activada = activada;
        this.letra = letra;
    }

    public Casilla(Integer fila, Integer columna, Boolean activada) {



    }

    public Integer getFila() {

        return fila;
    }

    public void setFila(Integer fila) {

        this.fila = fila;
    }

    public Integer getColumna() {

        return columna;
    }

    public void setColumna(Integer columna) {

        this.columna = columna;
    }

    public Boolean getActivada() {

        return activada;
    }

    public void setActivada(Boolean activada) {

        this.activada = activada;
    }

    public String getLetra() {

        return letra;
    }

    public void setLetra(String letra) {

        this.letra = letra;
    }

    @Override
    public String toString() {

        return "Casilla: " +
                "fila: " + fila +
                "columna: " + columna +
                "activada: " + activada +
                "letra: " + letra;
    }
}


