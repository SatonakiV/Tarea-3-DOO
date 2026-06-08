package Backend;

/**
 * Representa una bebida de tipo Kem en la máquina.
 */
class Kem extends Bebida {

    /**
     * Construye una nueva instancia de Kem con un número de serie único.
     *
     * @param serie El número de serie que identifica a esta Kem.
     */
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
