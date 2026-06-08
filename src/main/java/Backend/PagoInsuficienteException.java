package Backend;

/**
 * Excepción lanzada cuando el valor de la moneda ingresada por el comprador
 * es menor al precio del producto que intenta adquirir.
 */
public class PagoInsuficienteException extends Exception {
    /**
     * Construye una nueva excepción de pago insuficiente con un mensaje descriptivo.
     *
     * @param mensaje El mensaje que describe la causa de la excepción.
     */
    public PagoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}