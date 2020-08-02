package Avance;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class JsonUtil {

   /* static void escribirJsonSimple(String nombreArchivo, List<JSONObject> objsJson)throws Exception {
        JSONArray arrayJson = new JSONArray();
        objsJson.forEach(obj -> arrayJson.add(obj));
        Files.write(Paths.get(nombreArchivo), arrayJson.toString().getBytes());
    }*/

    static Object leerJsonSimple(String nombreArchivo) throws Exception {
        FileReader lector = new FileReader(nombreArchivo);
        JSONParser parsearJson = new JSONParser();
        return parsearJson.parse(lector);
    }
}

