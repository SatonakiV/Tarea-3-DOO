package Backend;

/**
 * Clase abstracta que representa la categoría de bebidas dentro de la máquina expendedora.
 * Hereda de la clase Producto y sirve como base para los distintos tipos de líquidos disponibles.
 */
abstract class Bebida extends Producto {

    /**
     * Construye una nueva bebida con un número de serie único.
     *
     * @param serie El número de serie que identifica a la bebida.
     */
    public Bebida(int serie) {
        super(serie);
    }
}

