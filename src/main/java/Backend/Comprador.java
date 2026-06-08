package Backend;

import java.util.ArrayList;

/**
 * Representa a un cliente que interactúa con la máquina expendedora.
 * El comprador intenta realizar una compra ingresando una moneda y seleccionando un producto.
 * Se encarga de almacenar el sonido (o sabor) del producto consumido y calcular el vuelto recolectado.
 */
public class Comprador {
    private String sonido;
    private int vuelto;
    private ArrayList<Moneda> billetera;

    /**
     * Construye un nuevo comprador con una billetera inicializada con 5 monedas de 1000 pesos.
     * El comprador comienza sin haber consumido ningún producto.
     */
    public Comprador(){
        this.sonido = null;
        this.billetera = new ArrayList<>();

        int contador = 0;

        for(int i = 0; i <= 4; i++){
            billetera.add(new Moneda1000(contador++ + i));
        }
    }

    /**
     * Inicia el proceso de compra de un producto en la máquina expendedora.
     * Extrae una moneda de la billetera, intenta comprar el producto seleccionado
     * y recolecta el vuelto devuelto por la máquina.
     *
     * @param p   El tipo de producto que se desea comprar (del enum Precios).
     * @param exp La máquina expendedora donde se realizará la compra.
     */
    public void iniciarCompra(Precios p, Expendedor exp){
        if(billetera.isEmpty()){
            System.out.println("Te quedaste sin dinero..");
            return;
        }

        Moneda m = billetera.removeFirst();

        try{
            exp.comprarProducto(m, p);
            Producto prod = exp.getProducto();
            this.sonido = prod.Consumir();

        }
        catch(NoHayProductoException | PagoInsuficienteException | PagoIncorrectoException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println("Un error inesperado ocurrio...");
        }

        Moneda vuelto = exp.getVuelto();

        while(vuelto != null){
            billetera.add(vuelto);
            vuelto = exp.getVuelto();
        }


    }

    /**
     * Calcula el total de dinero disponible actualmente en la billetera del comprador.
     * Suma el valor de todas las monedas que posee.
     *
     * @return El monto total de dinero en la billetera, en pesos.
     */
    public int cuantoVuelto() {
        int dinero = 0;
        for(int i = 0; i < billetera.size(); i++){
            Moneda mon = billetera.get(i);
            dinero += mon.getValor();
        }

        return dinero;
    }
    /**
     * Obtiene el sonido, sabor o tipo del producto que el comprador logró consumir.
     *
     * @return Un String que representa lo que se consumió (por ejemplo, "cocacola").
     *         Si no se logró realizar la compra, retornará null o vacío.
     */
    // Retorna el sonido/sabor del producto consumido
    public String queConsumiste() {
        return this.sonido;
    }
}