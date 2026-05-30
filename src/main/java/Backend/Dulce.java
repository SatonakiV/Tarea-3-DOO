package Backend;

/**
 * Clase abstracta que representa la categoría de dulces dentro de la máquina expendedora.
 * Hereda de la clase Producto y sirve como base para los distintos tipos de golosinas disponibles.
 */
abstract class Dulce extends Producto {
    public Dulce(int serie) {
        super(serie);
    }

    /**
     * Simula la acción de comer el dulce.
     *
     * @return El nombre del dulce consumido.
     */
    public abstract String Consumir();
}

/**
 * Representa un dulce de tipo Snickers en la máquina.
 */
class Snickers  extends Dulce {

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
/**
 * Representa un dulce de tipo Super8 en la máquina.
 */
class Super8 extends Dulce {

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

