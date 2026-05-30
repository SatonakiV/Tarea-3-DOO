package Backend;

/**
 * Representa una moneda física de 1000 pesos que el comprador usará para pagar en la maquina.
 */
public class Moneda1000 extends Moneda {
    /**
     * Construye una nueva moneda de 1000 pesos.
     */
    public Moneda1000(int serie) {
        super(serie);
    }
    /**
     * Nos entrega el valor de esta moneda.
     *
     * @return siempre devuelve 1000.
     */
    @Override
    public int getValor() {
        return 1000;
    }
}