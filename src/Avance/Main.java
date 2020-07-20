package Avance;

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
        var pistas = crucigrama.lasPistas();
        System.out.println(pistas);

    }

    public static void print2D(String mat[][]) {
        for (String[] row : mat)

            System.out.println(Arrays.toString(row));
    }
}
/*Hacer un metodo que me devuelva una matriz sin mostrar las letras(En clase Crucigrama)
 * Hacer una entidad(Clase) que se va llamar pista y va tener los atributos texto y que diga si es horizontal o vertical y el numero de palabra,
 * ejemplo si es la primera vertial o segunda...
 * Se van a leer las pistas desde un Json
 * Luego imprimir la matriz vacia y seguida de las pistas*/