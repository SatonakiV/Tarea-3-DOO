package Backend;
import java.awt.*;

/**
 * Clase abstracta que representa un producto genérico dentro de la máquina expendedora.
 * Sirve como la plantilla base para todos los dulces y bebidas específicos
 * (como CocaCola, Snickers, etc.) que se pueden comprar.
 */
abstract class Producto {
    private int serie;

    /**
     * Construye un nuevo producto con un número de serie único.
     *
     * @param serie El número de serie que identifica al producto.
     */
    public Producto(int serie){
        this.serie = serie;
    }

    /**
     * Obtiene el número de serie de este producto.
     *
     * @return El número de serie del producto.
     */
    public int getSerie() {
        return serie;
    }


    /**
     * Simula la acción de consumir el producto.
     * Cada producto específico debe implementar este método
     * para devolver su propio sonido o sabor característico.
     *
     * @return Un String que representa el sonido, nombre o sabor del producto al ser consumido.
     */
    public abstract String Consumir();

    protected int x;
    protected int y;

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Diseño del empaque del producto
        g2d.setColor(new Color(40, 40, 40)); // Sombra oscura
        g2d.fillRoundRect(x, y, 35, 50, 8, 8);

        g2d.setColor(new Color(85, 170, 210)); // Tonalidad azul corporativa
        g2d.fillRoundRect(x + 2, y + 2, 31, 46, 6, 6);

        // Imprime el Número de Serie exigido por el PDF
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 11));
        g2d.drawString("#" + getSerie(), x + 4, y + 28);
    }
}

