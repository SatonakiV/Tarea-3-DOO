package Backend;

/**
 * Representa una moneda física de 500 pesos que el comprador usará para pagar en la maquina.
 */
public class Moneda500 extends Moneda {
    /**
     * Construye una nueva moneda de 500 pesos.
     *
     * @param serie El número de serie que identifica a esta moneda.
     */
    public Moneda500(int serie) {
        super(serie);
    }
    /**
     * Nos entrega el valor de esta moneda.
     *
     * @return siempre devuelve 500.
     */
    @Override
    public int getValor() {
        return 500;
    }
}