package Avance;

import javax.swing.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        var crucigrama = new Crucigrama();
        var casa = crucigrama.sacarCasillas();
        var matrizResuelta = crucigrama.obtenerMatriz(casa);

        var vacia = crucigrama.obtenerMatriz2(casa);
        print2D(matrizResuelta);
        // print2D(vacia);
        System.out.println("");
        var pistaCrucigrama = new Crucigrama();
        var idk = pistaCrucigrama.sacarPistas();
        //var matrizPistas = pistaCrucigrama.obtenerPistas(idk);

        System.out.println(idk);
    }


    public static void print2D(String mat[][]) {
        for (String[] row : mat)
            System.out.println(Arrays.toString(row));
    }
}
