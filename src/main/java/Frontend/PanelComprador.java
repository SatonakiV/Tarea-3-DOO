package Frontend;

import javax.swing.*;
import java.awt.*;

public class PanelComprador {
    private int menuActual = 0;
    private int hoverBoton = 0;

    private Image imagenBotonMenu;
    private Image imagenCoca, imagenPepsi, imagenSprite, imagenFanta, imagenKem;
    private Image imagenSuper8, imagenSnickers, imagenOrbit, imagenKitkat, imagenChocman;

    public PanelComprador() {
        imagenBotonMenu = new ImageIcon(getClass().getResource("/boton2.png")).getImage();

        imagenCoca = new ImageIcon(getClass().getResource("/cocacola.png")).getImage();
        imagenPepsi = new ImageIcon(getClass().getResource("/pepsi.png")).getImage();
        imagenSprite = new ImageIcon(getClass().getResource("/sprite.png")).getImage();
        imagenFanta = new ImageIcon(getClass().getResource("/fanta.png")).getImage();
        imagenKem = new ImageIcon(getClass().getResource("/kem.png")).getImage();

        imagenSuper8 = new ImageIcon(getClass().getResource("/super8.png")).getImage();
        imagenSnickers = new ImageIcon(getClass().getResource("/snickers.png")).getImage();
        imagenOrbit = new ImageIcon(getClass().getResource("/orbit.png")).getImage();
        imagenKitkat = new ImageIcon(getClass().getResource("/kitkat.png")).getImage();
        imagenChocman = new ImageIcon(getClass().getResource("/chocman.png")).getImage();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; //tipo modo hd, es un suavizado de bordes e imagenes
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

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

        g.drawImage(imagenBotonMenu, 570, 120, 340, 150, null);
        if(hoverBoton == 1) {
            g.setColor(new Color(255, 255, 255, 60));
            g.fillRoundRect(570, 120, 340, 150, 30, 30);
        }

        g.setColor(Color.WHITE);
        g.drawString("Bebestibles", 678, 200);

        g.drawImage(imagenBotonMenu, 570, 290, 340, 150, null);
        if(hoverBoton == 2) {
            g.setColor(new Color(255, 255, 255, 60));
            g.fillRoundRect(570, 290, 340, 150, 30, 30);
        }
        g.setColor(Color.WHITE);
        g.drawString("Dulces", 700, 370);
    }

    private void dibujarMenuBebestibles(Graphics g) {
        dibujarProducto(g, imagenCoca, "CocaCola", "$1500", 570, 120, false, hoverBoton == 1);
        dibujarProducto(g, imagenPepsi, "Pepsi", "$1500", 690, 120, false, hoverBoton == 2);
        dibujarProducto(g, imagenSprite, "Sprite", "$1500", 810, 120, false,  hoverBoton == 3);

        dibujarProducto(g, imagenFanta, "Fanta", "$1500", 630, 280, false, hoverBoton == 4);
        dibujarProducto(g, imagenKem, "Kem", "$1500", 750, 280, false,  hoverBoton == 5);

        dibujarBotonVolver(g);
    }

    private void dibujarMenuDulces(Graphics g) {
        dibujarProducto(g, imagenSuper8, "Super 8", "$600", 570, 120, true,hoverBoton == 1);
        dibujarProducto(g, imagenSnickers, "Snickers", "$1200", 690, 120, true, hoverBoton == 2);
        dibujarProducto(g, imagenOrbit, "Orbit", "$1000", 810, 120, true, hoverBoton == 3);
        dibujarProducto(g, imagenKitkat, "Kitkat", "$1200", 630, 280, true,hoverBoton == 4);
        dibujarProducto(g, imagenChocman, "Chocman", "$600", 750, 280, true, hoverBoton == 5);

        dibujarBotonVolver(g);
    }

    private void dibujarProducto(Graphics g, Image imagen, String nombre, String precio, int x, int y, boolean esDulce, boolean hovered) {

        g.setColor(hovered ? new Color(245, 245, 250) : Color.white);
        g.fillRoundRect(x, y, 80, 140, 15, 15);

        g.setColor(Color.WHITE);
        g.fillRoundRect(x, y, 80, 140, 15, 15);

        g.setColor(Color.LIGHT_GRAY);
        g.drawRoundRect(x, y, 80, 140, 15, 15);

        if (esDulce) {
            g.drawImage(imagen, x + 5, y + 25, 70, 40, null);
        } else {
            g.drawImage(imagen, x + 10, y + 5, 60, 90, null);
        }

        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(Color.BLACK);
        g.drawString(nombre, x + 10, y + 115);

        g.setFont(new Font("Arial", Font.BOLD, 13));
        g.setColor(new Color(0, 100, 0));
        g.drawString(precio, x + 18, y + 135);
    }

    private void dibujarBotonVolver(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 16));

        g.setColor(hoverBoton == 6 ? new Color(130, 130, 130) : Color.DARK_GRAY);
        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(580, 480, 320, 50, 15, 15);
        g.setColor(Color.WHITE);
        g.drawString("<- Volver al menú principal", 630, 510);
    }

    public boolean actualizarHover(int x, int y) {
        hoverBoton = 0;

        if(menuActual == 0) {
            if (x >= 570 && x <= 990 && y >= 120 && y <= 250) {
                hoverBoton = 1;
            } else if (x >= 570 && x <= 990 && y >= 290 && y <= 440) {
                hoverBoton = 2;
            }
        }
        else if(menuActual == 1 || menuActual == 2){
            if(x >= 570  && x <= 650 && y >= 120 && y <= 260){
                hoverBoton = 1;
            }
            else if(x >= 690  && x <= 770 && y >= 120 && y <= 260){
                hoverBoton = 2;
            }
            else if(x >= 810  && x <= 890 && y >= 120 && y <= 260){
                hoverBoton = 3;
            }
            else if(x >= 630  && x <= 710 && y >= 280 && y <= 420){
                hoverBoton = 4;
            }
            else if (x >= 750  && x <= 830 && y >= 280 && y <= 420){
                hoverBoton = 5;
            }

            if(x >= 580  && x <= 900 && y >= 480 && y <= 530){
                hoverBoton = 1;
            }

        }

        return hoverBoton != 0;

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
            if (x >= 570 && x <= 650 && y >= 120 && y <= 260) System.out.println("Elegiste CocaCola");
            if (x >= 690 && x <= 770 && y >= 120 && y <= 260) System.out.println("Elegiste Pepsi");
            if (x >= 810 && x <= 890 && y >= 120 && y <= 260) System.out.println("Elegiste Sprite");
            if (x >= 630 && x <= 710 && y >= 280 && y <= 420) System.out.println("Elegiste Fanta");
            if (x >= 750 && x <= 830 && y >= 280 && y <= 420) System.out.println("Elegiste Kem");

            if (x >= 580 && x <= 900 && y >= 480 && y <= 530) menuActual = 0;
        }
        else if (menuActual == 2) {
            if (x >= 570 && x <= 650 && y >= 120 && y <= 260) System.out.println("Elegiste Super 8");
            if (x >= 690 && x <= 770 && y >= 120 && y <= 260) System.out.println("Elegiste Snickers");
            if (x >= 810 && x <= 890 && y >= 120 && y <= 260) System.out.println("Elegiste Orbit");
            if (x >= 630 && x <= 710 && y >= 280 && y <= 420) System.out.println("Elegiste Kitkat");
            if (x >= 750 && x <= 830 && y >= 280 && y <= 420) System.out.println("Elegiste Chocman");

            if (x >= 580 && x <= 900 && y >= 480 && y <= 530) menuActual = 0;
        }
    }
}