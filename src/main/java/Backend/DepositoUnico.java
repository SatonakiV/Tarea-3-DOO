package Backend;

/**
 * Depósito especial que almacena un único producto a la vez.
 * Se utiliza como bandeja de salida de la máquina expendedora,
 * donde se coloca el producto comprado para que el comprador lo retire.
 *
 * @param <T> El tipo de elemento que almacenará el depósito.
 */
public class DepositoUnico<T> {
    private T producto;

    /**
     * Construye un depósito único vacío, sin ningún producto almacenado.
     */
    public DepositoUnico() {
        this.producto = null;
    }

    /**
     * Almacena un producto en el depósito único, reemplazando cualquier producto anterior.
     *
     * @param producto El producto a almacenar en el depósito.
     */
    public void setProducto(T producto) {
        this.producto = producto;
    }

    /**
     * Extrae el producto almacenado en el depósito y lo deja vacío.
     * Una vez retirado, el depósito queda en null hasta que se almacene otro producto.
     *
     * @return El producto almacenado, o null si el depósito está vacío.
     */
    public T getProducto() {
        T aux = producto;
        producto = null;
        return aux;
    }
}
