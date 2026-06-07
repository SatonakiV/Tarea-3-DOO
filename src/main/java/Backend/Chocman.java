package Backend;

/**
 * Representa un dulce de tipo Chocman en la máquina.
 */
class Chocman extends Dulce {

    public Chocman(int serie) {
        super(serie);
    }

    /**
     * Simula la acción de comer el Chocman.
     *
     * @return El nombre del dulce consumido ("Chocman").
     */
    @Override
    public String Consumir() {
        return "Chocman";
    }
}
