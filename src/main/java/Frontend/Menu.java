package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener{

    JButton inicio;


    public Menu() {
        this.setLayout(null);

        //Imagen expendedora
        java.net.URL imgURL = getClass().getResource("/Expendedora.png");

        if(imgURL != null) {
            ImageIcon img = new ImageIcon(imgURL);

            Image imgEscalada = img.getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);

            ImageIcon imgExp = new ImageIcon(imgEscalada);

            JLabel imgLabel = new JLabel(imgExp);

            imgLabel.setBounds(250, 150, 300, 400);

            this.add(imgLabel);
        }

        else{
            System.out.println("Error al encontrar la imagen de la expendedora...");
        }

        //Imagen expendedora logo

        java.net.URL imgURL1 = getClass().getResource("/Exp_Frontal.png");

        if(imgURL1 != null) {

            ImageIcon imgicono = new ImageIcon(imgURL1);
            this.setIconImage(imgicono.getImage());
        }

        else{
            System.out.println("Error al encontrar la imagen de la expendedora frontal...");
        }




        this.setTitle("Menu Principal");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);

        ImageIcon icon = new ImageIcon("Expendedora.png");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(245, 245, 247));
        this.setLocationRelativeTo(null);


        //Boton
        inicio = new JButton();
        inicio.setBounds(278, 600, 250, 100);
        inicio.addActionListener(this);
        inicio.setText("Iniciar Expendedora");
        inicio.setFocusable(false);
        inicio.setHorizontalAlignment(SwingConstants.CENTER);
        inicio.setVerticalAlignment(SwingConstants.CENTER);
        inicio.setMargin(new Insets(0, 0 ,0 ,0));
        inicio.setBorder(BorderFactory.createEtchedBorder());
        inicio.setForeground(new Color(255, 255, 255));
        inicio.setBackground(new Color(30, 30, 30));
        inicio.setBorderPainted(false);
        inicio.setFocusPainted(false);
        inicio.setCursor(new Cursor(Cursor.HAND_CURSOR));

        inicio.setHorizontalTextPosition(SwingConstants.CENTER);
        inicio.setVerticalTextPosition(SwingConstants.TOP);
        inicio.setIconTextGap(8);


        //Imagen boton play

        java.net.URL img1 = getClass().getResource("/Boton_Play.png");

        if(img1 != null) {

            ImageIcon imgp = new ImageIcon(img1);

            Image img1Escalada = imgp.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

            inicio.setIcon(new ImageIcon(img1Escalada));

        }

        else{
            System.out.println("Error al encontrar la imagen del boton play...");
        }

        //Verificacion del font para el boton del menu

        try{
            java.io.InputStream is = getClass().getResourceAsStream("/Poppins-Bold.ttf");

            if(is != null) {

                Font fontBase = Font.createFont(Font.TRUETYPE_FONT, is);

                Font fontBotonMenu = fontBase.deriveFont(Font.BOLD, 20f);

                inicio.setFont(fontBotonMenu);

            }

            else{
                System.out.println("Error al encontrar el font Poppins-Bold.ttf...");
            }

        }

        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error inesperado intentalo denuevo...");
            inicio.setFont(new Font("Arial", Font.BOLD, 20)); //Font predeterminado en caso de que no encuentre el archivo
        }


        inicio.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inicio.setBackground(new Color(70, 70, 70));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                inicio.setBackground(new Color(30, 30, 30));
            }
        });



        JLabel label = new JLabel();
        label.setText("Simulación Maquina Expendedora");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setForeground(new Color(50, 50, 50));
        label.setFont(new Font("Inter", Font.BOLD, 30));
        label.setBounds(0, 50, 800, 100);
        label.setVisible(true);


        //Agregracion de las cosas al panel
        this.add(inicio);
        this.add(label);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == inicio){
            this.dispose();
            new Ventana();

        }


    }
}
