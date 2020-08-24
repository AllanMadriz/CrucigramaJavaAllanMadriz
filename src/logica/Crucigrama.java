package logica;

import utils.JsonUtil;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Crucigrama {

    private static String FILE_NAME = "Casillas.json";
    private static String PISTAS_NAME = "Pistas.json";

    public List<Casilla> sacarCasillas() throws Exception {

        List<JSONObject> jsonObjects = (List<JSONObject>) JsonUtil.leerJsonSimple(FILE_NAME);
        List<Casilla> listCrucigrama = new ArrayList<>();

        jsonObjects.forEach(jsonObj -> listCrucigrama.add(
                new Casilla(
                        Integer.valueOf(jsonObj.get("fila").toString()),
                        Integer.valueOf(jsonObj.get("columna").toString()),
                        Boolean.valueOf(jsonObj.get("activada").toString()),
                        String.valueOf(jsonObj.get("letra").toString())))
        );

        return listCrucigrama;
    }

    private String[][] llenarCasilla(String[][] matriz, Casilla casilla) {

        if (casilla.getActivada()) {
            matriz[casilla.getFila()][casilla.getColumna()] = casilla.getLetra();
        } else {
            matriz[casilla.getFila()][casilla.getColumna()] = "*";
        }
        return matriz;
    }

    public String[][] obtenerMatriz(List<Casilla> casillas) {

        final String[][][] matriz = {new String[7][7]};
        casillas.forEach(casilla ->
                matriz[0] = llenarCasilla(matriz[0], casilla)
        );
        return matriz[0];

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
