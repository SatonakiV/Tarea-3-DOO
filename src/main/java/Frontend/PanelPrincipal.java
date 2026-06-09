package Frontend;

import Backend.Expendedor;
import Backend.Comprador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Panel principal que contiene la maquina expendedora y el panel de seleccion.
 */
public class PanelPrincipal extends JPanel implements MouseListener, MouseMotionListener {
    private Expendedor expLogico;
    private Comprador clienteLogico;
    private PanelExpendedor exp;
    private PanelComprador com;
    /**
     * Inicializa todo el panel con un color de fondo
     * crea las partes logicas de la maquina y el cliente
     * y activa el detector de clics y de movimiento del mouse para los tooltips.
     */
    public PanelPrincipal() {
        this.setBackground(new Color(237, 240, 240));

        // Inicializaciones lógicas
        expLogico = new Expendedor(5);
        clienteLogico = new Comprador();

        // Paneles visuales
        exp = new PanelExpendedor(expLogico);
        com = new PanelComprador(expLogico, clienteLogico);

        // Listeners
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        // Activamos la capacidad del panel para mostrar ToolTips
        ToolTipManager.sharedInstance().setInitialDelay(100); // Aparece casi al instante
        this.setToolTipText("");
    }

    /**
     * Sobrescribe el método nativo de JPanel para devolver los tooltips
     * basados en las coordenadas del mouse dentro de nuestros componentes dibujados.
     */
    @Override
    public String getToolTipText(MouseEvent e) {
        String textoExp = exp.obtenerToolTip(e.getX(), e.getY());
        if (textoExp != null) return textoExp;

        String textoCom = com.obtenerToolTip(e.getX(), e.getY());
        if (textoCom != null) return textoCom;

        return super.getToolTipText(e);
    }
    /**
     * Dibuja el fondo y le avisa a los paneles del expendedor y comprador que se dibujen.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        exp.paintComponent(g);
        com.paintComponent(g);
    }
    /**
     * Detecta donde hiciste clic en la pantalla
     * si le da al cajon saca el producto o el vuelto
     * sino le pasa el clic a los menus para que hagan lo suyo.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        // Clic en Cajón de Salida (Producto)
        if (x >= 150 && x <= 350 && y >= 500 && y <= 600) {
            clienteLogico.recogerProducto(expLogico);
            if(clienteLogico.queConsumiste() != null) {
                System.out.println("Sabor consumido: " + clienteLogico.queConsumiste());
            }
        }
        // Clic en Vuelto (Monedas)
        else if (x >= 390 && x <= 460 && y >= 500 && y <= 580) {
            clienteLogico.recogerVuelto(expLogico);
        }
        // Procesar clic normal en paneles
        else {
            com.procesarClic(x, y);
            exp.procesarClic(x, y);
        }

        this.repaint();
    }
    /**
     * ve si el mouse se esta moviendo por encima de los botones
     * sirve para el efecto de hover y repinta la pantalla si es necesario.
     */
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