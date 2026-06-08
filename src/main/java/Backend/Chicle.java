package Backend;

/**
 * Representa un dulce de tipo Chicle en la máquina.
 */
class Chicle extends Dulce {

    /**
     * Construye una nueva instancia de Chicle con un número de serie único.
     *
     * @param serie El número de serie que identifica a este Chicle.
     */
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
