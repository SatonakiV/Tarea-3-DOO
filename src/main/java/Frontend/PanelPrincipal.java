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
        int x = e.getX();
        int y = e.getY();

        // 1. Zona de clic para el Cajón de Salida (Producto)
        if (x >= 150 && x <= 350 && y >= 500 && y <= 600) {
            clienteLogico.recogerProducto(expLogico);
            if(clienteLogico.queConsumiste() != null) {
                System.out.println("Sabor consumido: " + clienteLogico.queConsumiste());
            }
        }
        // 2. Zona de clic para el Vuelto (Monedas)
        else if (x >= 390 && x <= 460 && y >= 500 && y <= 580) {
            clienteLogico.recogerVuelto(expLogico);
        }
        // 3. Cualquier otro clic se envía a los paneles normales
        else {
            com.procesarClic(x, y);
            exp.procesarClic(x, y);
        }

        // Forzamos el redibujado de la interfaz
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