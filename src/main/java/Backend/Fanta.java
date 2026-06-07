package Backend;

/**
 * Representa una bebida de tipo Fanta en la máquina.
 */
class Fanta extends Bebida {

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
