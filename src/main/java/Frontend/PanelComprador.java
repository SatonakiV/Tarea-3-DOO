package Frontend;

import javax.swing.*;
import java.awt.*;

public class PanelComprador {
    private int menuActual = 0;
    private Image imgBotonMenu;

    public PanelComprador() {
        imgBotonMenu = new ImageIcon(getClass().getResource("/boton2.png")).getImage();
    }

    public void paintComponent(Graphics g) {
        g.setColor(new Color(230, 230, 230));
        g.fillRoundRect(530, 30, 420, 600, 25, 25);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 22));
        g.drawString("Panel de Selección", 640, 80);

        if (menuActual == 0) {
            dibujarMenuPrincipal(g);
        } else if (menuActual == 1) {
            dibujarMenuBebestibles(g);
        } else if (menuActual == 2) {
            dibujarMenuDulces(g);
        }
    }

    private void dibujarMenuPrincipal(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 22));

        //BOTÓN 1: BEBESTIBLES
        g.drawImage(imgBotonMenu, 570, 120, 340, 150, null);
        g.setColor(Color.WHITE);
        g.drawString("Bebestibles", 670, 200);

        //BOTÓN 2: DULCES
        g.drawImage(imgBotonMenu, 570, 290, 340, 150, null);
        g.setColor(Color.WHITE);
        g.drawString("Dulces", 695, 370);
    }

    private void dibujarMenuBebestibles(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 14));

        g.setColor(new Color(254, 0, 26));
        g.fillRoundRect(580, 130, 120, 40, 15, 15);
        g.setColor(Color.WHITE); g.drawString("CocaCola", 605, 155);

        g.setColor(new Color(28, 82, 162));
        g.fillRoundRect(580, 190, 120, 40, 15, 15);
        g.setColor(Color.WHITE); g.drawString("Pepsi", 620, 215);

        g.setColor(new Color(0, 139, 71));
        g.fillRoundRect(580, 250, 120, 40, 15, 15);
        g.setColor(Color.WHITE); g.drawString("Sprite", 615, 275);

        g.setColor(new Color(255, 165, 0));
        g.fillRoundRect(740, 130, 120, 40, 15, 15);
        g.setColor(Color.BLACK); g.drawString("Fanta", 780, 155);

        g.setColor(new Color(255, 215, 0));
        g.fillRoundRect(740, 190, 120, 40, 15, 15);
        g.setColor(Color.BLACK); g.drawString("Kem", 785, 215);

        dibujarBotonVolver(g);
    }

    private void dibujarMenuDulces(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 14));

        g.setColor(new Color(255, 200, 0));
        g.fillRoundRect(580, 130, 120, 40, 15, 15);
        g.setColor(Color.BLACK); g.drawString("Super 8", 610, 155);

        g.setColor(new Color(128, 64, 8));
        g.fillRoundRect(580, 190, 120, 40, 15, 15);
        g.setColor(Color.WHITE); g.drawString("Snickers", 610, 215);

        g.setColor(new Color(224, 36, 199));
        g.fillRoundRect(580, 250, 120, 40, 15, 15);
        g.setColor(Color.BLACK); g.drawString("Chicle", 615, 275);

        g.setColor(new Color(210, 20, 30));
        g.fillRoundRect(740, 130, 120, 40, 15, 15);
        g.setColor(Color.WHITE); g.drawString("Kitkat", 780, 155);

        g.setColor(new Color(17, 68, 238));
        g.fillRoundRect(740, 190, 120, 40, 15, 15);
        g.setColor(Color.WHITE); g.drawString("Chocman", 765, 215);

        dibujarBotonVolver(g);
    }

    private void dibujarBotonVolver(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(580, 480, 320, 50, 15, 15);
        g.setColor(Color.WHITE);
        g.drawString("<- Volver al menú principal", 630, 510);
    }

    public void procesarClic(int x, int y) {
        if (menuActual == 0) {
            if (x >= 570 && x <= 910 && y >= 120 && y <= 270) {
                menuActual = 1;
            } else if (x >= 570 && x <= 910 && y >= 290 && y <= 440) {
                menuActual = 2;
            }
        }
        else if (menuActual == 1) {
            if (x >= 580 && x <= 700 && y >= 130 && y <= 170) System.out.println("Elegiste CocaCola");
            if (x >= 580 && x <= 700 && y >= 190 && y <= 230) System.out.println("Elegiste Pepsi");
            if (x >= 580 && x <= 700 && y >= 250 && y <= 290) System.out.println("Elegiste Sprite");
            if (x >= 740 && x <= 860 && y >= 130 && y <= 170) System.out.println("Elegiste Fanta");
            if (x >= 740 && x <= 860 && y >= 190 && y <= 230) System.out.println("Elegiste Kem");

            if (x >= 580 && x <= 900 && y >= 480 && y <= 530) menuActual = 0;
        }
        else if (menuActual == 2) {
            if (x >= 580 && x <= 700 && y >= 130 && y <= 170) System.out.println("Elegiste Super 8");
            if (x >= 580 && x <= 700 && y >= 190 && y <= 230) System.out.println("Elegiste Snickers");
            if (x >= 580 && x <= 700 && y >= 250 && y <= 290) System.out.println("Elegiste Chicle");
            if (x >= 740 && x <= 860 && y >= 130 && y <= 170) System.out.println("Elegiste Kitkat");
            if (x >= 740 && x <= 860 && y >= 190 && y <= 230) System.out.println("Elegiste Chocman");

            if (x >= 580 && x <= 900 && y >= 480 && y <= 530) menuActual = 0;
        }
    }
}