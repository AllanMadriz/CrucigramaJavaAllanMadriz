package Avance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Presentacion {
    private JPanel Panel;
    private JTextArea Vertical;
    private JButton btnSalir;
    private JButton btnValidar;
    private JButton btnAyuda;
    private JButton btnFinalizar;
    private JButton btnRemover;

    final int tamanio = 7;
    JButton[][] elCrucigrama;

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Presentacion");
        frame.setContentPane(new Presentacion().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public Presentacion() throws Exception {

        Panel.setLayout(null);
        btnSalir.setBounds(650, 475, 100, 50);
        btnValidar.setBounds(650, 400, 100, 50);
        btnAyuda.setBounds(650, 325, 100, 50);
        btnFinalizar.setBounds(650, 250, 100, 50);
        btnRemover.setBounds(650, 175, 100, 50);
        btnRemover.setEnabled(false);

        var crucigrama = new Crucigrama();
        var casa = crucigrama.sacarCasillas();
        var matrizResuelta = crucigrama.obtenerMatriz(casa);
        elCrucigrama = new JButton[tamanio][tamanio];
        var pistaCrucigrama = new Crucigrama();
        var idk = pistaCrucigrama.sacarPistas();


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

                elCrucigrama[fila][columna].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int fila = 0; fila < tamanio; fila++) {
                            for (int columna = 0; columna < tamanio; columna++) {
                                if (e.getSource() == elCrucigrama[fila][columna]) {
                                    if (elCrucigrama[fila][columna].getBackground() == Color.WHITE) {
                                        if (elCrucigrama[fila][columna].getText().trim().equals("")) {
                                            char letra = JOptionPane.showInputDialog("Digite una letra:").toUpperCase().charAt(0);
                                            elCrucigrama[fila][columna].setText(letra + "");
                                        }
                                    } else if (elCrucigrama[fila][columna].getBackground() == Color.GREEN || elCrucigrama[fila][columna].getBackground() == Color.RED) {
                                        elCrucigrama[fila][columna].setText("");
                                        elCrucigrama[fila][columna].setBackground(Color.WHITE);
                                    }
                                }
                            }
                        }
                    }
                });

                Panel.add(elCrucigrama[fila][columna]);
            }
        }
        Vertical.setText(String.valueOf(idk).replaceAll("[-+,^]", ""));
        Vertical.setBackground(Color.LIGHT_GRAY);
        Vertical.setVisible(true);
        Vertical.setOpaque(true);
        Vertical.setBounds(70, 600, 650, 125);

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer salir = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (salir == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Hasta luego!!");
                    System.exit(0);
                }
            }
        });

        btnFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnValidar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int fila = 0; fila < tamanio; fila++) {
                    for (int columna = 0; columna < tamanio; columna++) {
                        if (elCrucigrama[fila][columna].getBackground() == Color.WHITE) {
                            if (elCrucigrama[fila][columna].getText().equals(matrizResuelta[fila][columna])) {
                                elCrucigrama[fila][columna].setBackground(Color.GREEN);
                            } else {
                                elCrucigrama[fila][columna].setBackground(Color.RED);
                            }
                        }
                    }
                }
                btnRemover.setEnabled(true);
            }
        });

        btnAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //int ayudas = 0;
                // JOptionPane.showMessageDialog(null, "Te quedan solo " + ayudas + " ayudas!!");
                Random random = new Random();
                int filaRandom = 0;
                int columnaRandom = 0;
                do {
                     filaRandom = random.nextInt(matrizResuelta.length);
                     columnaRandom = random.nextInt(matrizResuelta.length);
                    System.out.println(filaRandom);
                    System.out.println(columnaRandom);
                    System.out.println(elCrucigrama[filaRandom][columnaRandom].getText().trim().equals(""));
                    System.out.println(elCrucigrama[filaRandom][columnaRandom].getBackground() == Color.WHITE);
                } while (elCrucigrama[filaRandom][columnaRandom].getText().trim().equals("") && (elCrucigrama[filaRandom][columnaRandom].getBackground() == Color.WHITE));
                if (elCrucigrama[filaRandom][columnaRandom].getBackground() == Color.WHITE) {
                    if (elCrucigrama[filaRandom][columnaRandom].getText().trim().equals("")) {
                        System.out.println(filaRandom);
                        System.out.println(columnaRandom);
                        elCrucigrama[filaRandom][columnaRandom].setText(matrizResuelta[filaRandom][columnaRandom]);

                    }
                }
            }

        });

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int fila = 0; fila < tamanio; fila++) {
                    for (int columna = 0; columna < tamanio; columna++) {
                        if (elCrucigrama[fila][columna].getBackground().equals(Color.RED)) {
                            elCrucigrama[fila][columna].setText(null);
                            elCrucigrama[fila][columna].setBackground(Color.WHITE);
                        } else if (elCrucigrama[fila][columna].getBackground().equals(Color.GREEN)) {
                            elCrucigrama[fila][columna].setBackground(Color.WHITE);
                        }
                    }
                }
                btnRemover.setEnabled(false);
            }
        });

    }

}
