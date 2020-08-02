package Avance;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Crucigrama {
    private static String FILE_NAME = "Casillas.json";
    private static String PISTAS_NAME = "Pistas.json";

    public List<Casilla> sacarCasillas() throws Exception {
        List<JSONObject> jsonObjects = (List<JSONObject>) JsonUtil.leerJsonSimple(FILE_NAME);
        List<Casilla> listCrucigrama = new ArrayList<>();

        jsonObjects.forEach(it -> listCrucigrama.add(
                new Casilla(
                        Integer.valueOf(it.get("fila").toString()),
                        Integer.valueOf(it.get("columna").toString()),
                        Boolean.valueOf(it.get("activada").toString()),
                        String.valueOf(it.get("letra").toString())))
        );

        return listCrucigrama;
    }

    public String[][] obtenerMatriz(List<Casilla> casillas) {
        final String[][][] matriz = {new String[7][7]};
        casillas.forEach(casilla ->
                matriz[0] = llenarCasilla(matriz[0], casilla)
        );
        return matriz[0];
    }

    private String[][] llenarCasilla(String[][] matriz, Casilla casilla) {
        if (casilla.getActivada()) {
            matriz[casilla.getFila()][casilla.getColumna()] = casilla.getLetra();
        } else {
            matriz[casilla.getFila()][casilla.getColumna()] = "*";
        }
        return matriz;
    }

    public String[][] obtenerMatriz2(List<Casilla> casillas) {
        final String[][][] matriz = {new String[7][7]};
        casillas.forEach(casilla ->
                matriz[0] = matrizVacia(matriz[0], casilla)
        );
        return matriz[0];
    }

    private static String[][] matrizVacia(String[][] matriz, Casilla casilla) {
        if (casilla.getActivada()) {
            matriz[casilla.getFila()][casilla.getColumna()] = " ";
        } else {
            matriz[casilla.getFila()][casilla.getColumna()] = "*";
        }

        return matriz;
    }

    public List<Pista> sacarPistas() throws Exception {
        List<JSONObject> jsonObjects = (List<JSONObject>) JsonUtil.leerJsonSimple(PISTAS_NAME);
        List<Pista> listPistas = new ArrayList<>();

        jsonObjects.forEach(it -> listPistas.add(
                new Pista(
                        String.valueOf(it.get("text").toString()),
                        String.valueOf(it.get("orientacion").toString()),
                        Integer.valueOf(it.get("numPalabra").toString())))
        );

        return listPistas;
    }

}
