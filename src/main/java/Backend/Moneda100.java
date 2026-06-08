package Backend;

/**
 * Representa una moneda física de 100 pesos que el comprador usará para pagar en la maquina.
 */
public class Moneda100 extends Moneda {
    /**
     * Construye una nueva moneda de 100 pesos.
     *
     * @param serie El número de serie que identifica a esta moneda.
     */
    public Moneda100(int serie) {
        super(serie);

    }

    /**
     * Nos entrega el valor de esta moneda.
     *
     * @return siempre devuelve 100.
     */
    @Override
    public int getValor() {
        return 100;
    }
}
