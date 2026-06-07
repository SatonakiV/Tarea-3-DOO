package Frontend;

import Backend.Expendedor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelPrincipal extends JPanel implements MouseListener {
    private PanelExpendedor exp;
    private PanelComprador com;
    private Expendedor expendedorLogico;

    public PanelPrincipal() {
        this.setBackground(new Color(237, 240, 240));

        expendedorLogico = new Expendedor(5);
        exp = new PanelExpendedor(expendedorLogico);
        com = new PanelComprador();

        this.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        exp.paintComponent(g);
        com.paintComponent(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        com.procesarClic(x, y);

        this.repaint();
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}