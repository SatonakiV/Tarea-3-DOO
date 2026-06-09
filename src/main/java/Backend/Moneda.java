package Backend;

import java.awt.*;

/**
 * Representa una moneda genérica que el comprador usa para intentar pagar en la máquina,
 * sirve para agrupar a cualquier moneda de cualquier valor, nos permite
 * compararlas u ordenarlas de menor a mayor valor gracias a comparable.
 */
public abstract class Moneda implements Comparable<Moneda> {
    private int serie;

    // NUEVAS PROPIEDADES PARA LA TAREA 3
    protected int x;
    protected int y;

    /**
     * Construye una nueva moneda como base.
     *
     * @param serie El número de serie que identifica a la moneda.
     */
    public Moneda(int serie) {
        this.serie = serie;
    }

    /**
     * Obtiene el número de serie de esta moneda.
     *
     * @return El número de serie de la moneda.
     */
    public int getSeries(){
        return serie;
    }

    /**
     * Obtiene el valor numérico de esta moneda.
     *
     * @return El valor de la moneda en formato entero.
     */
    public abstract int getValor();

    // Método para actualizar la posición en la interfaz gráfica
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Método para que la moneda se dibuje a sí misma (Tarea 3)
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Define el color dependiendo del valor (Oro, Plata, Bronce)
        Color colorMoneda;
        if (getValor() == 1000) colorMoneda = new Color(255, 215, 0);
        else if (getValor() == 500) colorMoneda = new Color(192, 192, 192);
        else colorMoneda = new Color(205, 127, 50);

        // Sombra y Borde
        g2d.setColor(colorMoneda.darker().darker());
        g2d.fillOval(x, y, 32, 32);

        // Brillo interior
        g2d.setColor(colorMoneda);
        g2d.fillOval(x + 2, y + 2, 28, 28);

        // Valor de la moneda en el centro
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 10));
        g2d.drawString(String.valueOf(getValor()), x + 5, y + 20);
    }

    /**
     * Compara el valor de esta moneda con el de otra que le pasemos.
     * Así la máquina o el comprador puede saber fácilmente cuál vale más.
     *
     * @param m la moneda con la que queremos comparar.
     * @return Un numero negativo si esta vale menos, 0 si valen lo mismo, o positivo si vale más.
     */
    @Override
    public int compareTo(Moneda m) {
        return Integer.compare(this.getValor(), m.getValor());
    }
}