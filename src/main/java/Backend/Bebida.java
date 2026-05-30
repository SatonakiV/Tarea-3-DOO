package Backend;

/**
 * Clase abstracta que representa la categoría de bebidas dentro de la máquina expendedora.
 * Hereda de la clase Producto y sirve como base para los distintos tipos de líquidos disponibles.
 */
abstract class Bebida extends Producto {

    public Bebida(int serie) {
        super(serie);
    }
}

/**
 * Representa una bebida de tipo CocaCola en la máquina.
 */
class Cocacola extends Bebida {

    public Cocacola(int serie) {
        super(serie);
    }

    /**
     * Simula la acción de beber la CocaCola.
     *
     * @return El nombre de la bebida consumida ("Cocacola").
     */
    @Override
    public String Consumir() {
        return "Cocacola";
    }
}

/**
 * Representa una bebida de tipo Sprite en la máquina.
 */
class Sprite extends Bebida {

    public Sprite(int serie) {
        super(serie);
    }

    /**
     * Simula la acción de beber la Sprite.
     *
     * @return El nombre de la bebida consumida ("Sprite").
     */
    @Override
    public String Consumir() {
        return "Sprite";
    }
}

/**
 * Representa una bebida de tipo Fanta en la máquina.
 */
class Fanta extends Bebida {

    public Fanta(int serie) {
        super(serie);
    }

    /**
     * Simula la acción de beber la Fanta.
     *
     * @return El nombre de la bebida consumida ("Fanta").
     */
    @Override
    public String Consumir() {
        return "Fanta";
    }
}

/**
 * Representa una bebida de tipo Pepsi en la máquina.
 */
class Pepsi extends Bebida {

    public Pepsi(int serie) {
        super(serie);
    }

    /**
     * Simula la acción de beber la Pepsi.
     *
     * @return El nombre de la bebida consumida ("Pepsi").
     */
    @Override
    public String Consumir() {
        return "Pepsi";
    }
}

/**
 * Representa una bebida de tipo Kem en la máquina.
 */
class Kem extends Bebida {

    public Kem(int serie) {
        super(serie);
    }

    /**
     * Simula la acción de beber la Kem.
     *
     * @return El nombre de la bebida consumida ("Kem").
     */
    @Override
    public String Consumir() {
        return "Kem";
    }
}
