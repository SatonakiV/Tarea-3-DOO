package Backend;

/**
 * Representa un dulce de tipo Snickers en la máquina.
 */
class Snickers extends Dulce {

    public Snickers(int serie) {
        super(serie);
    }

    /**
     * Simula la acción de comer el Snickers.
     *
     * @return El nombre del dulce consumido ("Snickers").
     */
    @Override
    public String Consumir() {
        return "Snickers";
    }
}
