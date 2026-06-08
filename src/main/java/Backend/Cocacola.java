package Backend;

/**
 * Representa una bebida de tipo CocaCola en la máquina.
 */
class Cocacola extends Bebida {

    /**
     * Construye una nueva instancia de CocaCola con un número de serie único.
     *
     * @param serie El número de serie que identifica a esta CocaCola.
     */
    public Cocacola(int serie) {
        super(serie);
    }

    /**
     * Simula la acción de beber la CocaCola.
     *
     * @return El nombre de la bebida consumida ("Cocacola").
     */
    @Override
    public String Consumir() {
        return "Cocacola";
    }
}
