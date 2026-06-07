package Backend;

/**
 * Representa un dulce de tipo Chicle en la máquina.
 */
class Chicle extends Dulce {

    public Chicle(int serie) {
        super(serie);
    }

    /**
     * Simula la acción de comer el Chicle.
     *
     * @return El nombre del dulce consumido ("Chicle").
     */
    @Override
    public String Consumir() {
        return "Chicle";
    }
}
