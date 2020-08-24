package gui;

import javax.swing.*;

import java.awt.event.*;


public class Registro {

    private JPanel panel;
    private JLabel lblNombre;
    private JTextField txtFieldNombre;
    private JButton btnContinuar;
    private JButton btnSalir;
    private JButton btnRegistrar;
    private JLabel lblImagen;
    public static String NOMBRE = "";

    public Registro() {

        //Configuraciones del frame
        JFrame frame = new JFrame("Registro");
        frame.setContentPane(panel);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        panel.setLayout(null);

        //Configuraciones de los labels
        lblImagen.setBounds(300, 25, 400, 250);
        lblNombre.setBounds(50, 100, 100, 30);
        txtFieldNombre.setBounds(125, 105, 100, 25);

        //Configuraciones de los botones
        btnContinuar.setBounds(25, 300, 150, 50);
        btnSalir.setBounds(200, 300, 150, 50);
        btnRegistrar.setBounds(80, 150, 100, 30);
        btnContinuar.setEnabled(false);
        btnRegistrar.setEnabled(false);

        //Acciones a realizar en el boton continuar
        btnContinuar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    Presentacion presentacion = new Presentacion();
                    frame.dispose();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

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

        //Acciones a realizar en el boton registrar
        btnRegistrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                NOMBRE = txtFieldNombre.getText().trim();
                txtFieldNombre.setText("");
                JOptionPane.showMessageDialog(null, "Usuario registrado");
                btnContinuar.setEnabled(true);
                btnRegistrar.setEnabled(false);

            }
        });

        //Acciones a realizar en el Jtext
        txtFieldNombre.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {

                JTextField jTextField = (JTextField) e.getSource();
                if (!jTextField.getText().trim().equals("")) {

                    btnRegistrar.setEnabled(true);
                } else {

                    btnRegistrar.setEnabled(false);
                }
            }
        });
    }

    //Main de la aplicacion para inicializarlo
    public static void main(String[] args) {

        Registro registro = new Registro();

    }
}
