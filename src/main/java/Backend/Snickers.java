package Backend;

/**
 * Representa un dulce de tipo Snickers en la máquina.
 */
class Snickers extends Dulce {

    /**
     * Construye una nueva instancia de Snickers con un número de serie único.
     *
     * @param serie El número de serie que identifica a este Snickers.
     */
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
