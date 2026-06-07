package Frontend;

import Backend.Expendedor;
import javax.swing.*;
import java.awt.*;

public class PanelExpendedor {
    private Expendedor expLogico;
    private Image imagenMaquina;

    public PanelExpendedor(Expendedor exp) {
        this.expLogico = exp;

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
    }
}
