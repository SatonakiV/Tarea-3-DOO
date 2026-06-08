package Backend;

/**
 * Representa una bebida de tipo Fanta en la máquina.
 */
class Fanta extends Bebida {

    /**
     * Construye una nueva instancia de Fanta con un número de serie único.
     *
     * @param serie El número de serie que identifica a esta Fanta.
     */
    public Fanta(int serie) {
        super(serie);
    }

    /**
     * Simula la acción de beber la Fanta.
     *
     * @return El nombre de la bebida consumida ("Fanta").
     */
    @Override
    public String Consumir() {
        return "Fanta";
    }
}
