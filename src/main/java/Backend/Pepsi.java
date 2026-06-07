package Backend;

/**
 * Representa una bebida de tipo Pepsi en la máquina.
 */
class Pepsi extends Bebida {

    public Pepsi(int serie) {
        super(serie);
    }

    /**
     * Simula la acción de beber la Pepsi.
     *
     * @return El nombre de la bebida consumida ("Pepsi").
     */
    @Override
    public String Consumir() {
        return "Pepsi";
    }
}
