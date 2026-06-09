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
        // 1. Dibuja el fondo y la imagen principal de la máquina
        if (imagenMaquina != null) {
            g.drawImage(imagenMaquina, 50, 20, 420, 620, null);
        } else {
            g.setColor(new Color(90, 92, 92));
            g.fillRect(50, 50, 400, 550);
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // 2. MAGIA: Dibujar el interior de los estantes
        // Estante de arriba (Bebidas)
        dibujarDeposito(g, expLogico.getDepositoCoca(), 85, 100);
        dibujarDeposito(g, expLogico.getDepositoPepsi(), 145, 100);
        dibujarDeposito(g, expLogico.getDepositoSprite(), 205, 100);
        dibujarDeposito(g, expLogico.getDepositoFanta(), 265, 100);
        dibujarDeposito(g, expLogico.getDepositoKem(), 325, 100);

        // Estante de abajo (Dulces)
        dibujarDeposito(g, expLogico.getDepositoSuper8(), 85, 330);
        dibujarDeposito(g, expLogico.getDepositoSnickers(), 145, 330);
        dibujarDeposito(g, expLogico.getDepositoKitkat(), 205, 330);
        dibujarDeposito(g, expLogico.getDepositoChocman(), 265, 330);
        dibujarDeposito(g, expLogico.getDepositoChicle(), 325, 330);


        // 3. Dibujar UI Adicional
        if(imagenDinero != null){
            g.drawImage(imagenDinero, 770, 35, 30, 30, null);
        }

        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.setColor(new Color(30, 28, 28));
        g.drawString("Saldo: $4000", 810, 56);
    }

    /**
     * Helper que dibuja un contenedor de vidrio y apila los productos adentro.
     * Reposiciona cada producto dinámicamente cumpliendo la regla de la Tarea 3.
     */
    private void dibujarDeposito(Graphics g, Backend.Deposito<Backend.Producto> dep, int startX, int startY) {
        if (dep == null) return;

        // Dibuja el fondo de vidrio del carril
        g.setColor(new Color(30, 30, 30, 100)); // Negro semi-transparente
        g.fillRect(startX - 5, startY - 5, 45, 230);

        // Apila los productos desde abajo hacia arriba
        for (int i = 0; i < dep.getSize(); i++) {
            Backend.Producto p = dep.getItem(i);

            // Calculamos la posición relativa (mientras más productos, se apilan más arriba)
            int itemY = startY + 175 - (i * 35);

            // Cumplimos el requisito del PDF: Usar setXY y luego paintComponent
            p.setXY(startX, itemY);
            p.paintComponent(g);
        }
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