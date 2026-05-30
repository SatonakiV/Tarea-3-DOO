package Backend;

/**
 * Clase abstracta que representa un producto genérico dentro de la máquina expendedora.
 * Sirve como la plantilla base para todos los dulces y bebidas específicos
 * (como CocaCola, Snickers, etc.) que se pueden comprar.
 */
abstract class Producto {
    private int serie;

    public Producto(int serie){
        this.serie = serie;
    }

    public int getSerie() {
        return serie;
    }


    /**
     * Simula la acción de consumir el producto.
     * Cada producto específico (las clases hijas) debe implementar este método
     * para devolver su propio sonido o sabor característico.
     *
     * @return Un String que representa el sonido, nombre o sabor del producto al ser consumido.
     */
    public abstract String Consumir();

}

