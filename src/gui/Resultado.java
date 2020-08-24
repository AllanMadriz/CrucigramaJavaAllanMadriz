package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Resultado {
    private JPanel panelResultado;
    private JLabel lblJugador;
    private JLabel lblRecord;
    private JLabel lblTiempo;
    private JLabel lblUsuarioRegistrado;
    private JLabel lblTiempoObtenido;
    private JLabel lblPuntaje;
    private JLabel lblMalo;
    private JLabel lblRegular;
    private JLabel lblBueno;
    private JLabel lblExcellente;
    private JButton btnTerminar;


    public Resultado() {

        //Configuraciones del frame
        JFrame frame = new JFrame("Resultado");
        frame.setContentPane(panelResultado);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        panelResultado.setLayout(null);

        //Configuraciones de los labels
        lblJugador.setBounds(75, 115, 200, 100);
        lblRecord.setBounds(60, 205, 200, 100);
        lblTiempo.setBounds(75, 315, 200, 100);

        lblUsuarioRegistrado.setBounds(225, 115, 200, 100);
        lblUsuarioRegistrado.setText(Registro.NOMBRE);

        lblTiempoObtenido.setBounds(225, 315, 200, 100);
        lblTiempoObtenido.setText(Presentacion.TIEMPO);

        lblPuntaje.setBounds(245, 205, 200, 100);
        lblPuntaje.setText(String.valueOf(Presentacion.PUNTAJE));

        lblMalo.setBounds(140, 25, 300, 100);
        lblRegular.setBounds(125, 25, 300, 100);
        lblBueno.setBounds(140, 25, 300, 100);
        lblExcellente.setBounds(140, 25, 300, 100);

        lblMalo.setVisible(false);
        lblRegular.setVisible(false);
        lblBueno.setVisible(false);
        lblExcellente.setVisible(false);

        //Configuraciones del boton
        btnTerminar.setBounds(175, 450, 150, 50);

        //Series de if para determinar frase a mostrar
        if (Presentacion.PUNTAJE < 9) {
            lblMalo.setVisible(true);
        } else if (Presentacion.PUNTAJE < 18 && Presentacion.PUNTAJE > 9) {
            lblRegular.setVisible(true);
        } else if (Presentacion.PUNTAJE < 27 && Presentacion.PUNTAJE > 18) {
            lblBueno.setVisible(true);
        } else {
            lblExcellente.setVisible(true);
        }

        //Acciones a realizar en el boton terminar
        btnTerminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Integer salir = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (salir == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Hasta luego!!");
                    System.exit(0);
                }
            }
        });
    }

}
