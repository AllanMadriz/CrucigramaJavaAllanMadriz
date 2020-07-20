package Avance;

import javax.swing.*;
import java.awt.*;


public class Presentacion {
    private JPanel Panel;
    final int tamanio = 7;
    JButton[][] elCrucigrama;

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Presentacion");
        frame.setContentPane(new Presentacion().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public Presentacion() throws Exception {
        Panel.setLayout(null);
        var crucigrama = new Crucigrama();
        var casa = crucigrama.sacarCasillas();
        var matrizResuelta = crucigrama.obtenerMatriz(casa);
        elCrucigrama = new JButton[tamanio][tamanio];

        for (int fila = 0; fila < tamanio; fila++) {
            for (int columna = 0; columna < tamanio; columna++) {

                elCrucigrama[fila][columna] = new JButton();
                elCrucigrama[fila][columna].setBackground(Color.WHITE);

                if (matrizResuelta[fila][columna].equals("*")) {
                    elCrucigrama[fila][columna].setBackground(Color.BLACK);
                }

                int filaBoton = 0;
                int columnaBoton = 0;

                switch (fila) {
                    case 0:
                        columnaBoton = 70;
                        break;
                    case 1:
                        columnaBoton = 120;
                        break;
                    case 2:
                        columnaBoton = 170;
                        break;
                    case 3:
                        columnaBoton = 220;
                        break;
                    case 4:
                        columnaBoton = 270;
                        break;
                    case 5:
                        columnaBoton = 320;
                        break;
                    case 6:
                        columnaBoton = 370;
                        break;

                }
                switch (columna) {
                    case 0:
                        filaBoton = 70;
                        break;
                    case 1:
                        filaBoton = 120;
                        break;
                    case 2:
                        filaBoton = 170;
                        break;
                    case 3:
                        filaBoton = 220;
                        break;
                    case 4:
                        filaBoton = 270;
                        break;
                    case 5:
                        filaBoton = 320;
                        break;
                    case 6:
                        filaBoton = 370;
                        break;
                }
                elCrucigrama[fila][columna].setBorderPainted(true);
                elCrucigrama[fila][columna].setOpaque(true);
                elCrucigrama[fila][columna].setBounds(filaBoton, columnaBoton, 50, 50);
                Panel.add(elCrucigrama[fila][columna]);

            }
        }
    }

}
