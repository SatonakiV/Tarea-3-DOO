package Backend;

/**
 * Representa un dulce de tipo Chocman en la máquina.
 */
class Chocman extends Dulce {

    /**
     * Construye una nueva instancia de Chocman con un número de serie único.
     *
     * @param serie El número de serie que identifica a este Chocman.
     */
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
