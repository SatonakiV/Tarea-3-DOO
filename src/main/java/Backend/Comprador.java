package Backend;

import java.util.ArrayList;

/**
 * Representa a un cliente que interactúa con la máquina expendedora.
 */
public class Comprador {
    private String sonido;
    private ArrayList<Moneda> billetera;

    public Comprador(){
        this.sonido = null;
        this.billetera = new ArrayList<>();
        int contador = 0;

        // Inicializamos con 5 monedas de 1000
        for(int i = 0; i <= 4; i++){
            billetera.add(new Moneda1000(contador++ + i));
        }
    }

    /**
     * Paso 1: Inserta la moneda y selecciona el producto.
     */
    public void pagarProducto(Precios p, Expendedor exp, Moneda m){
        try{
            exp.comprarProducto(m, p);
        }
        catch(NoHayProductoException | PagoInsuficienteException | PagoIncorrectoException e){
            System.out.println("Máquina rechaza la compra: " + e.getMessage());
            // ¡CORRECCIÓN DEL BUG!
            // Ya no devolvemos la moneda a la billetera aquí.
            // El Expendedor la envió a la bandeja de vuelto, así que el usuario
            // debe hacer clic en el vuelto de la interfaz gráfica para recuperarla.
        }
        catch(Exception e){
            System.out.println("Un error inesperado ocurrió...");
        }
    }

    /**
     * Paso 2: El comprador "mete la mano" al cajón para sacar el producto.
     */
    public void recogerProducto(Expendedor exp){
        Producto prod = exp.getProducto(); // Saca el producto del depósito único
        if (prod != null) {
            this.sonido = prod.Consumir();
        }
    }

    /**
     * Paso 3: El comprador recoge las monedas de la bandeja de vuelto.
     */
    public void recogerVuelto(Expendedor exp){
        Moneda vuelto = exp.getVuelto();
        while(vuelto != null){
            billetera.add(vuelto);
            vuelto = exp.getVuelto();
        }
    }

    // --- Métodos de utilidad para la Interfaz Gráfica ---

    public int cuantoVuelto() {
        int dinero = 0;
        for(int i = 0; i < billetera.size(); i++){
            dinero += billetera.get(i).getValor();
        }
        return dinero;
    }

    public String queConsumiste() {
        return this.sonido;
    }

    /**
     * Permite a la interfaz gráfica acceder a la billetera para dibujar las monedas.
     */
    public ArrayList<Moneda> getBilletera() {
        return billetera;
    }
}