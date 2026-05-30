package Backend;

import java.util.ArrayList;
/**
 * Crea un tipo de espacio para guardar cosas dentro de la máquina.
 * Usamos la T para que sea genérico, así nos sirve tanto para guardar los productos
 * que vamos a vender como para guardar las monedas del vuelto, sin tener que crear
 * clases distintas.
 *
 * @param <T> Lo que sea que vayamos a meter en la lista.
 */
public class Deposito<T> {
    private ArrayList<T> lista;
    /**
     * Construye el depósito vacío para que le podamos empezar a meter cosas.
     */
    public Deposito() {
        this.lista = new ArrayList<T>();
    }
    /**
     * Mete un elemento nuevo al depósito.
     *
     * @param t El elemento que queremos guardar.
     */
    public void addElemento(T t) {
        this.lista.add(t);
    }
    /**
     * Saca el primer elemento que esté en la lista y lo devuelve.
     * Es como cuando la máquina te bota el producto o la moneda.
     *
     * @return El elemento que sacamos, o null si el depósito está vacío.
     */
    public T getElemento() {
        if (lista.isEmpty()) {
            return null;
        }
        return lista.remove(0);
    }
}