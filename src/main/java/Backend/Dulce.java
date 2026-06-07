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

