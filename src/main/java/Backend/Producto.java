package Backend;

import java.awt.*;

/**
 * Clase abstracta que representa un producto genérico dentro de la máquina expendedora.
 * Sirve como la plantilla base para todos los dulces y bebidas específicos
 * (como CocaCola, Snickers, etc.) que se pueden comprar.
 */
public abstract class Producto {
    private int serie;

    // NUEVAS PROPIEDADES PARA LA TAREA 3
    protected int x;
    protected int y;

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

    // Método para actualizar la posición en la interfaz gráfica
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Método para que el producto se dibuje a sí mismo
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Identifica quién es y elige su color corporativo
        Color colorPrimario;
        String nombre = this.getClass().getSimpleName();

        switch(nombre) {
            case "Cocacola": colorPrimario = new Color(200, 0, 0); break;     // Rojo
            case "Pepsi": colorPrimario = new Color(0, 80, 200); break;       // Azul oscuro
            case "Sprite": colorPrimario = new Color(0, 150, 50); break;      // Verde
            case "Fanta": colorPrimario = new Color(255, 100, 0); break;      // Naranja
            case "Kem": colorPrimario = new Color(255, 200, 0); break;        // Amarillo
            case "Snickers": colorPrimario = new Color(100, 50, 0); break;    // Café oscuro
            case "Super8": colorPrimario = new Color(180, 20, 20); break;     // Rojo oscuro
            case "Kitkat": colorPrimario = new Color(220, 20, 30); break;     // Rojo vivo
            case "Chocman": colorPrimario = new Color(130, 70, 20); break;    // Café claro
            case "Chicle": colorPrimario = new Color(255, 105, 180); break;   // Rosado
            default: colorPrimario = new Color(85, 170, 210);
        }

        // Sombra y Borde del empaque
        g2d.setColor(colorPrimario.darker().darker());
        g2d.fillRoundRect(x, y, 35, 50, 8, 8);

        // Color principal del empaque
        g2d.setColor(colorPrimario);
        g2d.fillRoundRect(x + 2, y + 2, 31, 46, 6, 6);

        // Franja negra elegante en el centro
        g2d.setColor(new Color(0, 0, 0, 120));
        g2d.fillRect(x + 2, y + 18, 31, 14);

        // Número de Serie centrado dinámicamente
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 10));
        String texto = "#" + getSerie();
        FontMetrics fm = g2d.getFontMetrics();
        int textoX = x + (35 - fm.stringWidth(texto)) / 2;

        g2d.drawString(texto, textoX, y + 29);
    }
    /**
     * Simula la acción de consumir el producto.
     * Cada producto específico debe implementar este método
     * para devolver su propio sonido o sabor característico.
     *
     * @return Un String que representa el sonido, nombre o sabor del producto al ser consumido.
     */
    public abstract String Consumir();
}