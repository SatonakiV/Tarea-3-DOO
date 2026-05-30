package Backend;

/**
 * Excepción lanzada cuando se intenta realizar una compra con un pago inválido,
 * específicamente cuando la moneda ingresada es nula.
 */
public class PagoIncorrectoException extends Exception {
    public PagoIncorrectoException(String mensaje) {
        super(mensaje);
    }
}