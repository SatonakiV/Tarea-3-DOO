package Backend;

/**
 * Representa una bebida de tipo Kem en la máquina.
 */
class Kem extends Bebida {

    public Kem(int serie) {
        super(serie);
    }

    /**
     * Simula la acción de beber la Kem.
     *
     * @return El nombre de la bebida consumida ("Kem").
     */
    @Override
    public String Consumir() {
        return "Kem";
    }
}
