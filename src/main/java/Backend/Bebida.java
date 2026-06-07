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

