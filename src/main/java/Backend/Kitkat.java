package Backend;

/**
 * Representa un dulce de tipo Kitkat en la máquina.
 */
class Kitkat extends Dulce {

    /**
     * Construye una nueva instancia de Kitkat con un número de serie único.
     *
     * @param serie El número de serie que identifica a este Kitkat.
     */
    public Kitkat(int serie) {
        super(serie);
    }

    /**
     * Simula la acción de comer el Kitkat.
     *
     * @return El nombre del dulce consumido ("Kitkat").
     */
    @Override
    public String Consumir() {
        return "Kitkat";
    }
}
