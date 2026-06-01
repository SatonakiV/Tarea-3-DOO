package Frontend;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener{

    JButton inicio;


    public Menu() {
        this.setLayout(null);


        java.net.URL imgURL = Menu.class.getResource("/Expendedora.png");

        if(imgURL != null) {
            ImageIcon img = new ImageIcon(imgURL);
            JLabel imgLabel = new JLabel();
            imgLabel.setIcon(img);
            imgLabel.setBounds(150, 150, 100,50);
            imgLabel.setVisible(true);
        }

        this.setTitle("Menu Principal");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);

        ImageIcon icon = new ImageIcon("Expendedora.png");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setLocationRelativeTo(null);

        inicio = new JButton();
        inicio.setBounds(278, 500, 250, 100);
        inicio.addActionListener(this);
        inicio.setText("Iniciar Expendedora");
        inicio.setFocusable(false);
        inicio.setFont(new Font("Inter", Font.BOLD, 20));
        inicio.setHorizontalAlignment(SwingConstants.CENTER);
        inicio.setVerticalAlignment(SwingConstants.BOTTOM);
        inicio.setBorder(BorderFactory.createEtchedBorder());
        inicio.setForeground(new Color(253, 76, 76));
        inicio.setBackground(new Color(55, 255, 148));
        this.add(inicio);




        JLabel label = new JLabel();
        label.setText("Simulación Maquina Expendedora");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setForeground(new Color(51, 163, 243));
        label.setFont(new Font("Inter", Font.BOLD, 30));
        label.setBounds(0, 50, 800, 100);
        label.setVisible(true);


        this.add(label);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == inicio){
            this.dispose();

        }


    }
}
