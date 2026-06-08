package Backend;

/**
 * Representa una bebida de tipo Sprite en la máquina.
 */
class Sprite extends Bebida {

    /**
     * Construye una nueva instancia de Sprite con un número de serie único.
     *
     * @param serie El número de serie que identifica a esta Sprite.
     */
    public Sprite(int serie) {
        super(serie);
    }

    /**
     * Simula la acción de beber la Sprite.
     *
     * @return El nombre de la bebida consumida ("Sprite").
     */
    @Override
    public String Consumir() {
        return "Sprite";
    }
}
