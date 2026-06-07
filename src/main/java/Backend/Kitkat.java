package Backend;

/**
 * Representa un dulce de tipo Kitkat en la máquina.
 */
class Kitkat extends Dulce {

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
