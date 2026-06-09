 package Frontend;

import Backend.Expendedor;
import Backend.Comprador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Panel principal que contiene la maquina expendedora y el panel de seleccion.
 * Gestiona la interaccion entre la logica del expendedor, el comprador y las interfaces graficas.
 */
public class PanelPrincipal extends JPanel implements MouseListener, MouseMotionListener {
    private Expendedor expLogico;
    private Comprador clienteLogico;
    private PanelExpendedor exp;
    private PanelComprador com;

    /**
     * Construye el panel principal inicializando la lógica del expendedor,
     * el comprador y vinculándolos a sus respectivos paneles visuales.
     */
    public PanelPrincipal() {
        this.setBackground(new Color(237, 240, 240));

        // 1. Inicializamos los componentes lógicos del sistema
        expLogico = new Expendedor(5);
        clienteLogico = new Comprador();

        // 2. Pasamos las referencias correspondientes a los paneles visuales
        exp = new PanelExpendedor(expLogico);
        com = new PanelComprador(expLogico, clienteLogico);

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        exp.paintComponent(g);
        com.paintComponent(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Se procesa el clic en ambos paneles
        com.procesarClic(e.getX(), e.getY());
        exp.procesarClic(e.getX(), e.getY());

        // Forzamos el redibujado de la interfaz para actualizar stocks y billetera
        this.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        boolean cambio = com.actualizarHover(e.getX(), e.getY());
        if (cambio) {
            repaint();
        }
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void mouseDragged(MouseEvent e) {}
}