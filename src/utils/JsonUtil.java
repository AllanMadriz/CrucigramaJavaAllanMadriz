package utils;

import java.io.FileReader;

import org.json.simple.parser.JSONParser;

public class JsonUtil {

    //Metodo que maneja la lectura del Archivo JSON
    public static Object leerJsonSimple(String nombreArchivo) throws Exception {

        FileReader lector = new FileReader(nombreArchivo);
        JSONParser parsearJson = new JSONParser();
        return parsearJson.parse(lector);
    }
}

