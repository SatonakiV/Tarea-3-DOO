package Frontend;

import Backend.Expendedor;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class PanelExpendedor {
    private Expendedor expLogico;
    private Image imagenMaquina;
    private Image imagenDinero;

    public PanelExpendedor(Expendedor exp) {
        this.expLogico = exp;

        try{
            java.net.URL urlDinero = getClass().getResource("/dinero.png");
            if(urlDinero != null) {
                imagenDinero = ImageIO.read(urlDinero);
            }
        } catch(Exception e) {
            System.err.println("Error al obtener imagen dinero..." + e.getMessage());
        }

        try {
            imagenMaquina = new ImageIcon(getClass().getResource("/Exp_Frontal.png")).getImage();
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen Exp_Frontal.png");
        }
    }

    public void paintComponent(Graphics g) {
        // 1. Fondo
        if (imagenMaquina != null) {
            g.drawImage(imagenMaquina, 50, 20, 420, 620, null);
        } else {
            g.setColor(new Color(90, 92, 92));
            g.fillRect(50, 50, 400, 550);
        }

        // 2. Dibujar Estantes
        dibujarDeposito(g, expLogico.getDepositoCoca(), 90, 100);
        dibujarDeposito(g, expLogico.getDepositoPepsi(), 170, 100);
        dibujarDeposito(g, expLogico.getDepositoSprite(), 250, 100);
        dibujarDeposito(g, expLogico.getDepositoFanta(), 330, 100);

        dibujarDeposito(g, expLogico.getDepositoKem(), 90, 250);
        dibujarDeposito(g, expLogico.getDepositoSnickers(), 170, 250);
        dibujarDeposito(g, expLogico.getDepositoKitkat(), 250, 250);
        dibujarDeposito(g, expLogico.getDepositoSuper8(), 330, 250);

        dibujarDeposito(g, expLogico.getDepositoChocman(), 90, 400);
        dibujarDeposito(g, expLogico.getDepositoChicle(), 170, 400);

        // 3. Dibujar Producto en el Cajón de Salida (Compuerta inferior)
        Backend.Producto pSalida = expLogico.verProductoEnCajon();
        if (pSalida != null) {
            pSalida.setXY(220, 520); // Coordenadas centradas en el cajón de tu imagen
            pSalida.paintComponent(g);
        }

        // 4. Dibujar Monedas en la ranura de Vuelto (Derecha inferior)
        Backend.Deposito<Backend.Moneda> depVuelto = expLogico.getDepositoVuelto();
        if (depVuelto != null && depVuelto.getSize() > 0) {
            if (imagenDinero != null) {
                g.drawImage(imagenDinero, 400, 510, 40, 40, null);
            } else {
                g.setColor(new Color(255, 215, 0)); // Dorado genérico
                g.fillOval(400, 510, 30, 30);
            }
            // Indicador numérico de cuántas monedas hay acumuladas
            g.setColor(new Color(255, 50, 50));
            g.fillOval(425, 500, 20, 20);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 10));
            g.drawString(String.valueOf(depVuelto.getSize()), 432, 514);
        }
    }

    private void dibujarDeposito(Graphics g, Backend.Deposito<Backend.Producto> dep, int startX, int startY) {
        if (dep == null || dep.getSize() == 0) return;

        Backend.Producto pFrontal = dep.getItem(0);

        if (dep.getSize() > 1) {
            g.setColor(new Color(40, 40, 40, 150));
            g.fillRoundRect(startX + 4, startY + 4, 35, 50, 8, 8);
        }
        if (dep.getSize() > 2) {
            g.setColor(new Color(40, 40, 40, 150));
            g.fillRoundRect(startX + 2, startY + 2, 35, 50, 8, 8);
        }

        pFrontal.setXY(startX, startY);
        pFrontal.paintComponent(g);

        g.setColor(new Color(255, 50, 50));
        g.fillOval(startX + 25, startY - 5, 20, 20);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 10));
        
        g.drawString(String.valueOf(dep.getSize()), startX + 31, startY + 9);
    }

    public boolean actualizarHover(int x, int y) {
        return false;
    }

    /**
     * Detecta si el usuario posicionó el mouse sobre el producto o moneda de vuelto
     * para mostrar su número de serie en un ToolTip.
     */
    public String obtenerToolTip(int x, int y) {
        // Verificar si el mouse está sobre el producto en el cajón de salida
        Backend.Producto pSalida = expLogico.verProductoEnCajon();
        if (pSalida != null && x >= 220 && x <= 280 && y >= 520 && y <= 610) {
            return "Producto: " + pSalida.getClass().getSimpleName() + " | Serie: " + pSalida.getSerie();
        }

        // Verificar si el mouse está sobre la moneda en la bandeja de vuelto
        Backend.Deposito<Backend.Moneda> depVuelto = expLogico.getDepositoVuelto();
        if (depVuelto != null && depVuelto.getSize() > 0 && x >= 400 && x <= 440 && y >= 510 && y <= 550) {
            return "Moneda devuelta | Serie: " + depVuelto.getItem(0).getSerie();
        }

        return null;
    }

    public void procesarClic(int x, int y) {
        // Evitamos la zona del cajón inferior para no sobreponer clics
        if(x >= 50 && x <= 470 && y >= 20 && y <= 490) {
            expLogico.rellenarDepositos();
            System.out.println("¡Máquina Expendedora rellenada con éxito!");
        }
    }
}