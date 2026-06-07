package Backend;

/**
 * Representa una bebida de tipo Sprite en la máquina.
 */
class Sprite extends Bebida {

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
