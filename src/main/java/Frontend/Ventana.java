package Frontend;

import javax.swing.*;
/**
 * Ventana principal de la tarea
 * sirve como base para montar el panel donde estará la maquina.
 */
public class Ventana extends JFrame {
    /**
     * Crea la ventana con el titulo y tamaño fijo
     * la deja centrada en la pantalla para que se vea bien
     * y al final le mete el panel principal.
     */
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