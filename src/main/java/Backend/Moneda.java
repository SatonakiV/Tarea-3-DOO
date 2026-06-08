package Backend;

/**
 * Representa una moneda genérica que el comprador usa para intentar pagar en la máquina,
 * sirve para agrupar a cualquier moneda de cualquier valor, nos permite
 * compararlas u ordenarlas de menor a mayor valor gracias a comparable.
 */

public abstract class Moneda implements Comparable<Moneda> {
    private int serie;

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

    /**
     * Obtiene un identificador único para la moneda
     * como en la vida real cada moneda es distinta, usamos su espacio en la memoria (ToString)
     * para simular que hay un número de serie.
     *
     * @return Un String que representa la serie de la moneda.
     */

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