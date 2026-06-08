package Backend;

/**
 * Representa una bebida de tipo Pepsi en la máquina.
 */
class Pepsi extends Bebida {

    /**
     * Construye una nueva instancia de Pepsi con un número de serie único.
     *
     * @param serie El número de serie que identifica a esta Pepsi.
     */
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
