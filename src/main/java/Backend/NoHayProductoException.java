package Backend;

/**
 * Excepción lanzada cuando el comprador intenta adquirir un producto
 * cuyo depósito se encuentra vacío (sin stock) o no existe en la máquina.
 */
public class NoHayProductoException extends Exception {
    public NoHayProductoException(String mensaje) {
        super(mensaje);
    }
}