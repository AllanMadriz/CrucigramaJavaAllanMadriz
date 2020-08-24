package gui;

import logica.Crucigrama;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;


public class Presentacion implements Runnable {

    private JPanel Panel;
    private JTextArea Vertical;
    private JButton btnSalir;
    private JButton btnValidar;
    private JButton btnAyuda;
    private JButton btnFinalizar;
    private JButton btnRemover;
    private JLabel lblCronometro;
    private JButton btnJugar;
    private JLabel lblUser;
    private JLabel lblNick;

    JButton[][] elCrucigrama;
    final int tamanio = 7;

    private static long INICIO = 0;
    private static int CONTADOR_AYUDAS = 0;
    public static String TIEMPO = "";
    public static int PUNTAJE = 0;
    public static int VALIDACIONES = 0;

    public Presentacion() throws Exception {

        //Configuraciones del frame
        JFrame frame = new JFrame("Presentacion");
        frame.setIconImage(new ImageIcon(getClass().getResource("/imagenes/snorlax.png")).getImage());
        frame.setContentPane(Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(750, 750);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Panel.setLayout(null);

        //Configuraciones de los botones
        btnSalir.setBounds(525, 360, 150, 50);
        btnValidar.setBounds(525, 290, 150, 50);
        btnAyuda.setBounds(525, 220, 150, 50);
        btnFinalizar.setBounds(525, 150, 150, 50);
        btnRemover.setBounds(525, 70, 150, 50);
        btnRemover.setEnabled(false);
        btnJugar.setBounds(100, 450, 250, 75);
        btnFinalizar.setEnabled(false);
        btnAyuda.setEnabled(false);
        btnValidar.setEnabled(false);

        //Configuraciones de los labels
        lblCronometro.setBounds(230, 10, 100, 50);
        lblNick.setBackground(Color.LIGHT_GRAY);
        lblNick.setOpaque(true);
        lblNick.setBounds(450, 460, 175, 30);
        lblNick.setHorizontalAlignment(JLabel.CENTER);
        lblUser.setBounds(400, 450, 50, 50);
        lblNick.setText(Registro.NOMBRE);

        //Sacar las casillas para formar el crucigrama
        var crucigrama = new Crucigrama();
        var casa = crucigrama.sacarCasillas();
        var matrizResuelta = crucigrama.obtenerMatriz(casa);
        var pistaCrucigrama = new Crucigrama();
        var pistillas = pistaCrucigrama.sacarPistas();
        elCrucigrama = new JButton[tamanio][tamanio];

        //Creacion de los botones del crucigrama
        for (int fila = 0; fila < tamanio; fila++) {

            for (int columna = 0; columna < tamanio; columna++) {

                elCrucigrama[fila][columna] = new JButton();
                elCrucigrama[fila][columna].setBackground(Color.WHITE);

                if (matrizResuelta[fila][columna].equals("*")) {

                    elCrucigrama[fila][columna].setBackground(Color.BLACK);
                }
                elCrucigrama[fila][columna].setEnabled(false);
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

                                            try {
                                                char letra = JOptionPane.showInputDialog("Digite una letra:").toUpperCase().charAt(0);
                                                elCrucigrama[fila][columna].setText(letra + "");

                                            } catch (Exception exception) {

                                            }

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

        //Creacion de la textArea donde se muestran las pistas
        pistillas.forEach(pista -> Vertical.setText(Vertical.getText() + pista.toString()));
        Vertical.setBackground(Color.LIGHT_GRAY);
        Vertical.setVisible(true);
        Vertical.setOpaque(true);
        Vertical.setBounds(40, 550, 650, 125);

        //Acciones a realizar en el boton salir
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Integer salir = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (salir == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Hasta luego!!");
                    System.exit(0);
                }
            }
        });

        //Acciones a realizar en el boton finalizar
        btnFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < tamanio; i++) {
                    for (int j = 0; j < tamanio; j++) {
                        if (elCrucigrama[i][j].getText().equals(matrizResuelta[i][j])) {
                            PUNTAJE++;
                        }
                    }
                }
                TIEMPO = lblCronometro.getText();
                Resultado resultado = new Resultado();
                frame.dispose();

            }
        });

        //Acciones a realizar en el boton validar
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
                if (VALIDACIONES < 2) {
                    btnValidar.setEnabled(true);
                    VALIDACIONES++;
                } else {
                    btnRemover.setEnabled(false);
                    btnValidar.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "No mas validaciones");
                }

                btnRemover.setEnabled(true);
                VALIDACIONES++;
            }
        });

        //Acciones a realizar en el boton ayuda
        btnAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int filaRandom = 0;
                int columnaRandom = 0;

                filaRandom = (int) (Math.random() * 7);
                columnaRandom = (int) (Math.random() * 7);

                btnAyuda.setEnabled(false);
                while (matrizResuelta[filaRandom][columnaRandom].trim().equals("*") || elCrucigrama[filaRandom][columnaRandom].getText() != "") {

                    filaRandom = (int) (Math.random() * 7);
                    columnaRandom = (int) (Math.random() * 7);
                }
                elCrucigrama[filaRandom][columnaRandom].setText(matrizResuelta[filaRandom][columnaRandom]);


                if (CONTADOR_AYUDAS < 2) {
                    btnAyuda.setEnabled(true);
                    CONTADOR_AYUDAS++;
                } else {
                    JOptionPane.showMessageDialog(null, "Ups intentos acabos!!");
                }
            }
        });

        //Acciones a realizar en el boton remover
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int fila = 0; fila < tamanio; fila++) {
                    for (int columna = 0; columna < tamanio; columna++) {
                        if (elCrucigrama[fila][columna].getBackground().equals(Color.RED)) {
                            elCrucigrama[fila][columna].setText("");
                            elCrucigrama[fila][columna].setBackground(Color.WHITE);
                        }
                    }
                }
                btnRemover.setEnabled(false);

            }
        });

        //Acciones a realizar en el boton jugar
        btnJugar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                btnFinalizar.setEnabled(true);
                btnAyuda.setEnabled(true);
                btnValidar.setEnabled(true);
                for (int i = 0; i < tamanio; i++) {

                    for (int j = 0; j < tamanio; j++) {

                        elCrucigrama[i][j].setEnabled(true);
                    }
                }
                btnJugar.setEnabled(false);
                init();
            }
        });
    }

    public void init() {

        INICIO = System.currentTimeMillis();
        Thread hilo = new Thread(this);
        hilo.start();

    }

    @Override
    public void run() {

        Calendar calendario = Calendar.getInstance();
        while (true) {
            calendario.setTimeInMillis(System.currentTimeMillis() - INICIO);
            lblCronometro.setText(String.format("%02d:%02d", calendario.get(Calendar.MINUTE), calendario.get(Calendar.SECOND)));

        }
    }

}
