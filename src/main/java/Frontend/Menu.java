package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana principal de bienvenida de la aplicación de la máquina expendedora.
 * Muestra una imagen decorativa de la expendedora, el título de la simulación
 * y un botón para iniciar la aplicación. Al presionar el botón, esta ventana
 * se cierra y se abre la ventana principal de la simulación.
 */
public class Menu extends JFrame implements ActionListener{

    /** Botón que inicia la simulación y abre la ventana principal. */
    JButton inicio;


    /**
     * Construye y configura el menú principal de la aplicación.
     * Inicializa todos los componentes visuales de la ventana:
     * la imagen de la expendedora, el ícono de la ventana, el título,
     * el botón de inicio con su imagen y fuente personalizada,
     * y el label con el título de la simulación.
     */
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

            /**
             * Cambia el color de fondo del botón a un tono más claro cuando
             * el cursor entra en su área, dando retroalimentación visual al usuario.
             *
             * @param evt El evento de mouse generado al entrar el cursor.
             */
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inicio.setBackground(new Color(70, 70, 70));
            }

            /**
             * Restaura el color de fondo original del botón cuando
             * el cursor sale de su área.
             *
             * @param evt El evento de mouse generado al salir el cursor.
             */
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


    /**
     * Maneja los eventos de acción generados por los componentes de esta ventana.
     * Al presionar el botón inicio, cierra el menú y abre la ventana principal
     * de la simulación.
     *
     * @param e El evento de acción generado por el componente que fue activado.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == inicio){
            this.dispose();
            new Ventana();

        }


    }
}
