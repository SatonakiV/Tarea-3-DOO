package Backend;

/**
 * Excepción lanzada cuando el comprador intenta adquirir un producto
 * cuyo depósito se encuentra vacío (sin stock) o no existe en la máquina.
 */
public class NoHayProductoException extends Exception {
    /**
     * Construye una nueva excepción de producto no disponible con un mensaje descriptivo.
     *
     * @param mensaje El mensaje que describe la causa de la excepción.
     */
    public NoHayProductoException(String mensaje) {
        super(mensaje);
    }
}