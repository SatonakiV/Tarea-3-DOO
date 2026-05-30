package Backend;

public class DepositoUnico<T> {
    private T producto;

    public DepositoUnico() {
        this.producto = null;
    }

    public void setProducto(T producto) {
        this.producto = producto;
    }

    public T getProducto() {
        T aux = producto;
        producto = null;
        return aux;
    }
}
