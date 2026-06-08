package Backend;

/**
 * Representa un dulce de tipo Super8 en la máquina.
 */
class Super8 extends Dulce {

    /**
     * Construye una nueva instancia de Super8 con un número de serie único.
     *
     * @param serie El número de serie que identifica a este Super8.
     */
    public Super8(int serie) {
        super(serie);
    }

    /**
     * Simula la acción de comer el Super8.
     *
     * @return El nombre del dulce consumido ("Super8").
     */
    @Override
    public String Consumir() {
        return "Super8";
    }
}
