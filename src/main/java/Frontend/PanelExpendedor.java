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

            else {
                System.err.println("Error al obtener imagen dinero...");
            }
        }

        catch(Exception e) {
            System.err.println("Error al obtener imagen dinero..." + e.getMessage());
        }


        try {
            imagenMaquina = new ImageIcon(getClass().getResource("/Exp_Frontal.png")).getImage();
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen Exp_Frontal.png");
        }
    }

    public void paintComponent(Graphics g) {
        if (imagenMaquina != null) {
            g.drawImage(imagenMaquina, 50, 20, 420, 620, null);
        } else {
            g.setColor(new Color(90, 92, 92));
            g.fillRect(50, 50, 400, 550);
        }


        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        if(imagenDinero != null){
            g.drawImage(imagenDinero, 770, 35, 30, 30, null);
        }

        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.setColor(new Color(30, 28, 28));

        g.drawString("Saldo: $4000", 810, 56);

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
            // TODO: Crear un método en Expendedor.java que rellene los depósitos vacíos y llamarlo aquí:
            // expLogico.rellenarDepositos();
        }
    }
}