package Backend;

/**
 * Excepción lanzada cuando el valor de la moneda ingresada por el comprador
 * es menor al precio del producto que intenta adquirir.
 */
public class PagoInsuficienteException extends Exception {
    public PagoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}