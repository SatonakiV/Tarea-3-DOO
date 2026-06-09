package Frontend;

import Backend.Expendedor;
import Backend.Comprador;
import Backend.Precios;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Panel encargado de la interfaz de usuario para el comprador.
 * Permite navegar por los productos, visualizar y seleccionar monedas,
 * y realizar la compra interactuando directamente con el objeto Comprador.
 */
public class PanelComprador {
    private int menuActual = 0;
    private int hoverBoton = 0;
    private int indiceMonedaSeleccionada = -1; // -1 significa que no hay ninguna seleccionada

    private Expendedor exp;
    private Comprador cliente;

    private Image imagenBotonMenu;
    private Image imagenCoca, imagenPepsi, imagenSprite, imagenFanta, imagenKem;
    private Image imagenSuper8, imagenSnickers, imagenOrbit, imagenKitkat, imagenChocman;

    public PanelComprador(Expendedor exp, Comprador cliente) {
        this.exp = exp;
        this.cliente = cliente;

        try {
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
        } catch (Exception e) {
            System.err.println("Error al cargar imágenes del panel comprador: " + e.getMessage());
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        // Fondo del panel
        g.setColor(new Color(230, 230, 230));
        g.fillRoundRect(530, 30, 420, 600, 25, 25);

        // Título
        g.setFont(new Font("Arial", Font.BOLD, 22));
        FontMetrics fm = g.getFontMetrics();
        String titulo = "Panel de Selección";
        int xTitulo = 530 + (420 - fm.stringWidth(titulo)) / 2;
        g.setColor(Color.BLACK);
        g.drawString(titulo, xTitulo, 80);

        // Texto de Saldo Total
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.setColor(new Color(0, 102, 51));
        g.drawString("Billetera: $" + cliente.cuantoVuelto(), 570, 105);

        // Renderizado del Menú
        if (menuActual == 0) dibujarMenuPrincipal(g);
        else if (menuActual == 1) dibujarMenuBebestibles(g);
        else if (menuActual == 2) dibujarMenuDulces(g);

        // Dibujar el Monedero en la parte inferior
        dibujarMonedero(g);
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
        dibujarProducto(g, imagenCoca, "CocaCola", "$1000", 570, 120, false, hoverBoton == 1);
        dibujarProducto(g, imagenPepsi, "Pepsi", "$1000", 690, 120, false, hoverBoton == 2);
        dibujarProducto(g, imagenSprite, "Sprite", "$1000", 810, 120, false, hoverBoton == 3);
        dibujarProducto(g, imagenFanta, "Fanta", "$1000", 630, 280, false, hoverBoton == 4);
        dibujarProducto(g, imagenKem, "Kem", "$1000", 750, 280, false, hoverBoton == 5);
        dibujarBotonVolver(g);
    }

    private void dibujarMenuDulces(Graphics g) {
        dibujarProducto(g, imagenSuper8, "Super 8", "$300", 570, 120, true, hoverBoton == 1);
        dibujarProducto(g, imagenSnickers, "Snickers", "$800", 690, 120, true, hoverBoton == 2);
        dibujarProducto(g, imagenOrbit, "Chicle", "$200", 810, 120, true, hoverBoton == 3);
        dibujarProducto(g, imagenKitkat, "Kitkat", "$800", 630, 280, true, hoverBoton == 4);
        dibujarProducto(g, imagenChocman, "Chocman", "$600", 750, 280, true, hoverBoton == 5);
        dibujarBotonVolver(g);
    }

    private void dibujarProducto(Graphics g, Image imagen, String nombre, String precio, int x, int y, boolean esDulce, boolean hovered) {
        g.setColor(hovered ? new Color(245, 245, 250) : Color.white);
        g.fillRoundRect(x, y, 80, 140, 15, 15);
        g.setColor(Color.LIGHT_GRAY);
        g.drawRoundRect(x, y, 80, 140, 15, 15);

        if (esDulce) g.drawImage(imagen, x + 5, y + 25, 70, 40, null);
        else g.drawImage(imagen, x + 10, y + 5, 60, 90, null);

        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(Color.BLACK);
        g.drawString(nombre, x + 10, y + 115);
        g.setFont(new Font("Arial", Font.BOLD, 13));
        g.setColor(new Color(0, 100, 0));
        g.drawString(precio, x + 18, y + 135);
    }

    private void dibujarBotonVolver(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.setColor(hoverBoton == 6 ? new Color(130, 130, 130) : Color.DARK_GRAY);
        g.fillRoundRect(580, 430, 320, 35, 15, 15); // Movido un poco hacia arriba para dar espacio
        g.setColor(Color.WHITE);
        g.drawString("<- Volver al menú principal", 645, 453);
    }

    /**
     * Dibuja las monedas de la billetera en la parte inferior del panel.
     */
    private void dibujarMonedero(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(Color.DARK_GRAY);
        g.drawString("Selecciona una moneda para comprar:", 550, 490);

        ArrayList<Backend.Moneda> bill = cliente.getBilletera();
        int cols = 8; // Máximo de monedas por fila

        for (int i = 0; i < bill.size(); i++) {
            Backend.Moneda m = bill.get(i);
            int col = i % cols;
            int row = i / cols;

            int x = 550 + (col * 45);
            int y = 505 + (row * 45);

            // Resaltado de selección
            if (i == indiceMonedaSeleccionada) {
                g.setColor(new Color(50, 205, 50, 150)); // Verde brillante
                g.fillOval(x - 4, y - 4, 48, 48);
            }

            // Colores por valor
            if (m.getValor() == 1000) g.setColor(new Color(255, 215, 0)); // Dorada
            else if (m.getValor() == 500) g.setColor(new Color(192, 192, 192)); // Plateada
            else g.setColor(new Color(205, 127, 50)); // Bronce (100)

            g.fillOval(x, y, 40, 40);
            g.setColor(Color.BLACK);
            g.drawOval(x, y, 40, 40);

            g.setFont(new Font("Arial", Font.BOLD, 11));
            // Centrar el texto según si tiene 3 o 4 dígitos
            int offsetX = m.getValor() >= 1000 ? 5 : 8;
            g.drawString("$" + m.getValor(), x + offsetX, y + 24);
        }
    }

    public boolean actualizarHover(int x, int y) {
        hoverBoton = 0;
        if(menuActual == 0) {
            if (x >= 570 && x <= 990 && y >= 120 && y <= 250) hoverBoton = 1;
            else if (x >= 570 && x <= 990 && y >= 290 && y <= 440) hoverBoton = 2;
        }
        else if(menuActual == 1 || menuActual == 2){
            if(x >= 570  && x <= 650 && y >= 120 && y <= 260) hoverBoton = 1;
            else if(x >= 690  && x <= 770 && y >= 120 && y <= 260) hoverBoton = 2;
            else if(x >= 810  && x <= 890 && y >= 120 && y <= 260) hoverBoton = 3;
            else if(x >= 630  && x <= 710 && y >= 280 && y <= 420) hoverBoton = 4;
            else if (x >= 750  && x <= 830 && y >= 280 && y <= 420) hoverBoton = 5;

            if(x >= 580  && x <= 900 && y >= 430 && y <= 465) hoverBoton = 6;
        }
        return hoverBoton != 0;
    }

    public void procesarClic(int x, int y) {
        // Verificar si el clic fue en el monedero
        if (y >= 505) {
            ArrayList<Backend.Moneda> bill = cliente.getBilletera();
            int cols = 8;
            for (int i = 0; i < bill.size(); i++) {
                int col = i % cols;
                int row = i / cols;
                int mx = 550 + (col * 45);
                int my = 505 + (row * 45);

                // Si el clic está dentro del rectángulo de la moneda (40x40)
                if (x >= mx && x <= mx + 40 && y >= my && y <= my + 40) {
                    indiceMonedaSeleccionada = i;
                    System.out.println("Moneda seleccionada: $" + bill.get(i).getValor());
                    return; // Terminamos de procesar el clic
                }
            }
        }

        // Si no hizo clic en una moneda, procesamos el menú
        if (menuActual == 0) {
            if (x >= 570 && x <= 910 && y >= 120 && y <= 270) menuActual = 1;
            else if (x >= 570 && x <= 910 && y >= 290 && y <= 440) menuActual = 2;
        }
        else if (menuActual == 1) {
            if (x >= 570 && x <= 650 && y >= 120 && y <= 260) intentarCompra(Precios.CocaCola);
            if (x >= 690 && x <= 770 && y >= 120 && y <= 260) intentarCompra(Precios.Pepsi);
            if (x >= 810 && x <= 890 && y >= 120 && y <= 260) intentarCompra(Precios.Sprite);
            if (x >= 630 && x <= 710 && y >= 280 && y <= 420) intentarCompra(Precios.Fanta);
            if (x >= 750 && x <= 830 && y >= 280 && y <= 420) intentarCompra(Precios.Kem);
            if (x >= 580 && x <= 900 && y >= 430 && y <= 465) menuActual = 0;
        }
        else if (menuActual == 2) {
            if (x >= 570 && x <= 650 && y >= 120 && y <= 260) intentarCompra(Precios.Super8);
            if (x >= 690 && x <= 770 && y >= 120 && y <= 260) intentarCompra(Precios.Snickers);
            if (x >= 810 && x <= 890 && y >= 120 && y <= 260) intentarCompra(Precios.Chicle);
            if (x >= 630 && x <= 710 && y >= 280 && y <= 420) intentarCompra(Precios.Kitkat);
            if (x >= 750 && x <= 830 && y >= 280 && y <= 420) intentarCompra(Precios.Chocman);
            if (x >= 580 && x <= 900 && y >= 430 && y <= 465) menuActual = 0;
        }
    }

    private void intentarCompra(Precios producto) {
        // Validación: Asegurarse de que el usuario seleccionó una moneda antes
        if (indiceMonedaSeleccionada != -1 && indiceMonedaSeleccionada < cliente.getBilletera().size()) {

            // Extraer específicamente la moneda que el usuario seleccionó
            Backend.Moneda monedaUsada = cliente.getBilletera().remove(indiceMonedaSeleccionada);

            // Resetear la selección para obligarlo a seleccionar otra moneda en su próxima compra
            indiceMonedaSeleccionada = -1;

            cliente.pagarProducto(producto, exp, monedaUsada);
        } else {
            System.out.println("ERROR: ¡Debes seleccionar una moneda haciendo clic en ella antes de comprar!");
        }
    }
}