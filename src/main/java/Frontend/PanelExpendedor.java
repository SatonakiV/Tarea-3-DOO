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
            } else {
                System.err.println("Error al obtener imagen dinero...");
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

        // 2. Distribución Centrada 4 - 4 - 2 (Dentro del cristal)
        // He movido el eje X inicial de 70 a 90 para dar margen al borde izquierdo
        // He reducido el espacio entre columnas de 85 a 80 para que el bloque de 4 quepa mejor

        // Fila 1
        dibujarDeposito(g, expLogico.getDepositoCoca(), 90, 100);
        dibujarDeposito(g, expLogico.getDepositoPepsi(), 170, 100);
        dibujarDeposito(g, expLogico.getDepositoSprite(), 250, 100);
        dibujarDeposito(g, expLogico.getDepositoFanta(), 330, 100);

        // Fila 2
        dibujarDeposito(g, expLogico.getDepositoKem(), 90, 250);
        dibujarDeposito(g, expLogico.getDepositoSnickers(), 170, 250);
        dibujarDeposito(g, expLogico.getDepositoKitkat(), 250, 250);
        dibujarDeposito(g, expLogico.getDepositoSuper8(), 330, 250);

        // Fila 3
        dibujarDeposito(g, expLogico.getDepositoChocman(), 90, 400);
        dibujarDeposito(g, expLogico.getDepositoChicle(), 170, 400);

        // 3. UI
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.setColor(new Color(30, 28, 28));
        g.drawString("Saldo: $4000", 810, 56);
    }

    /**
     * Helper que dibuja un contenedor de vidrio y apila los productos adentro.
     * Reposiciona cada producto dinámicamente cumpliendo la regla de la Tarea 3.
     */
    private void dibujarDeposito(Graphics g, Backend.Deposito<Backend.Producto> dep, int startX, int startY) {
        if (dep == null || dep.getSize() == 0) return;

        // Obtenemos el producto para copiar su estilo
        Backend.Producto pFrontal = dep.getItem(0);

        // 1. Dibujamos los "stack" detrás con el mismo color, pero un poco más oscuros
        // para que se note que están detrás (usando Alpha 150)
        if (dep.getSize() > 1) {
            g.setColor(new Color(40, 40, 40, 150));
            g.fillRoundRect(startX + 4, startY + 4, 35, 50, 8, 8);
        }
        if (dep.getSize() > 2) {
            g.setColor(new Color(40, 40, 40, 150));
            g.fillRoundRect(startX + 2, startY + 2, 35, 50, 8, 8);
        }

        // 2. El producto principal al frente (el que tiene todo el color y detalle)
        pFrontal.setXY(startX, startY);
        pFrontal.paintComponent(g);

        // 3. El contador de stock (Badge)
        g.setColor(new Color(255, 50, 50));
        g.fillOval(startX + 25, startY - 5, 20, 20);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 10));
        g.drawString(String.valueOf(dep.getSize()), startX + 31, startY + 9);
    }

    /**
     * Verifica si el mouse está sobre alguna zona interactiva de la máquina.
     * Por ahora la máquina no tiene botones que brillen, así que retorna false.
     */
    public boolean actualizarHover(int x, int y) {
        return false;
    }

    /**
     * Procesa los clics que ocurren sobre el expendedor.
     * Según el PDF: Si se hace click en el expendedor, se rellenan los depósitos.
     */
    public void procesarClic(int x, int y) {
        // Asumiendo que la imagen de la máquina está entre x:50-470 y y:20-640
        if(x >= 50 && x <= 470 && y >= 20 && y <= 640) {
            System.out.println("¡Clic en la máquina! Aquí debemos llamar al método de rellenar productos.");
            // Próximo paso: expLogico.rellenarDepositos();
        }
    }
}