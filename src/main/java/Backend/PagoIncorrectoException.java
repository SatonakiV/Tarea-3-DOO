package Backend;

/**
 * Excepción lanzada cuando se intenta realizar una compra con un pago inválido,
 * específicamente cuando la moneda ingresada es nula.
 */
public class PagoIncorrectoException extends Exception {
    /**
     * Construye una nueva excepción de pago incorrecto con un mensaje descriptivo.
     *
     * @param mensaje El mensaje que describe la causa de la excepción.
     */
    public PagoIncorrectoException(String mensaje) {
        super(mensaje);
    }
}