package Frontend;

import javax.swing.*;

public class Ventana extends JFrame {
    public Ventana() {
        super("Expendedora");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);

        this.setResizable(false);

        this.add(new PanelPrincipal());
        this.setVisible(true);
    }
}