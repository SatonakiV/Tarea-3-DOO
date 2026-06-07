package Frontend;

import Backend.Expendedor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PanelPrincipal extends JPanel implements MouseListener, MouseMotionListener {
    private PanelExpendedor exp;
    private PanelComprador com;
    private Expendedor expendedorLogico;

    public PanelPrincipal() {
        this.setBackground(new Color(237, 240, 240));

        expendedorLogico = new Expendedor(5);
        exp = new PanelExpendedor(expendedorLogico);
        com = new PanelComprador();

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        com.paintComponent(g);
        exp.paintComponent(g);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        com.procesarClic(x, y);

        this.repaint();
    }

    @Override
    public void mouseMoved (MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        boolean sobreBoton = com.actualizarHover(x, y);

        if(sobreBoton) {
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));

        }
        else {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

        this.repaint();
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseDragged(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}