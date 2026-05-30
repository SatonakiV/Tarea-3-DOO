package Backend;

/**
 * Guarda los precios fijos de las cosas que vende la máquina.
 * Usamos un enum para no tener que andar escribiendo los números a mano en el código
 * y tener todos los valores ordenados en un solo lugar.
 */
public enum Precios {

    CocaCola(1000),
    Fanta(1000),
    Sprite(1000),
    Pepsi(1000),
    Kem(1000),
    Snickers(800),
    Super8(300),
    Kitkat(800),
    Chicle(200),
    Chocman(600);

    private final int precio;
    /**
     * Le da el valor en pesos a cada producto de la lista.
     *
     * @param precio El costo del producto.
     */
    Precios(int precio) {
        this.precio = precio;
/**
 * Sirve para ver cuánto cuesta el producto que elegimos.
 *
 * @return El precio del producto en números enteros.
 */
    }
    public int getPrecio() {
        return precio;
    }
}
