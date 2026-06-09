package Backend;

/**
 * Representa la máquina expendedora de productos.
 * Gestiona el almacenamiento interno de bebidas y dulces en sus respectivos depósitos,
 * así como el depósito para almacenar y entregar el vuelto de las transacciones.
 */
public class Expendedor {
    private DepositoUnico<Producto> deposito;
    private Deposito<Moneda> monedas;

    //Inicializa cada uno de los depositos de cada tipo de producto para evitar problemas
    private Deposito<Producto> depositoCoca;
    private Deposito<Producto> depositoSprite;
    private Deposito<Producto> depositoPepsi;
    private Deposito<Producto> depositoKem;
    private Deposito<Producto> depositoFanta;
    private Deposito<Producto> depositoSuper8;
    private Deposito<Producto> depositoKitkat;
    private Deposito<Producto> depositoSnickers;
    private Deposito<Producto> depositoChicle;
    private Deposito<Producto> depositoChocman;
    private Deposito<Moneda> depositoVuelto;

    /**
     * Constructor que inicializa todos los depósitos de la máquina expendedora
     * y los llena con una cantidad específica inicial de cada producto.
     *
     * @param cantidad La cantidad de unidades de cada producto con la que se rellenará la máquina.
     */
    public Expendedor(int cantidad) {
        this.depositoCoca = new Deposito<>();
        this.depositoSprite = new Deposito<>();
        this.depositoPepsi = new Deposito<>();
        this.depositoKem = new Deposito<>();
        this.depositoFanta = new Deposito<>();
        this.depositoSuper8 = new Deposito<>();
        this.depositoKitkat = new Deposito<>();
        this.depositoSnickers = new Deposito<>();
        this.depositoChicle = new Deposito<>();
        this.depositoChocman = new Deposito<>();
        this.depositoVuelto = new Deposito<>();
        this.monedas = new Deposito<>();
        this.deposito = new DepositoUnico<>();

        // Llenamos la máquina asignando series únicas por "Lote" a cada producto
        for(int i = 0; i < cantidad; i++) {
            depositoCoca.addElemento(new Cocacola(100 + i));
            depositoPepsi.addElemento(new Pepsi(200 + i));
            depositoSprite.addElemento(new Sprite(300 + i));
            depositoFanta.addElemento(new Fanta(400 + i));
            depositoKem.addElemento(new Kem(500 + i));

            depositoSuper8.addElemento(new Super8(600 + i));
            depositoSnickers.addElemento(new Snickers(700 + i));
            depositoKitkat.addElemento(new Kitkat(800 + i));
            depositoChocman.addElemento(new Chocman(900 + i));
            depositoChicle.addElemento(new Chicle(1000 + i));
        }
    }
    /**
     * Intenta realizar la compra de un producto en la máquina expendedora.
     * Verifica que la moneda sea válida, que el pago sea suficiente y que exista stock.
     * Si la compra es exitosa, calcula el vuelto en monedas de 100 y lo almacena en el depósito de vuelto.
     *
     * @param m            La moneda ingresada por el comprador para pagar.
     * @param tipoProducto El producto específico que se desea comprar (del enum Precios).
     * @return El objeto Producto que fue extraído exitosamente del depósito correspondiente.
     * @throws PagoIncorrectoException Si la moneda ingresada es nula.
     * @throws PagoInsuficienteException Si el valor de la moneda es menor al precio del producto solicitado.
     * @throws NoHayProductoException Si el depósito del producto solicitado está vacío o el producto no existe.
     */
    public void comprarProducto(Moneda m, Precios tipoProducto) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException{
        Producto p = null; //Variable para comprobar si el producto es válido luego


        //Verificamos si la moneda existe
        if(m == null){
            throw new PagoIncorrectoException("Moneda no puede ser nula");
        }

        //Verificamos que el valor de lo ingresado sea mayor al precio del producto
        if(m.getValor() < tipoProducto.getPrecio()){
            depositoVuelto.addElemento(m); //Guardamos la moneda si no es suficiente para luego devolverla
            throw new PagoInsuficienteException("Ingresar el pago suficiente");
        }

        //Switch para verificar que el producto este, y de serlo saca el objeto del deposito respectivo
        switch (tipoProducto){
            case CocaCola -> p = depositoCoca.getElemento();
            case Sprite -> p = depositoSprite.getElemento();
            case Pepsi -> p = depositoPepsi.getElemento();
            case Fanta -> p = depositoFanta.getElemento();
            case Kem -> p = depositoKem.getElemento();
            case Chicle -> p = depositoChicle.getElemento();
            case Chocman -> p = depositoChocman.getElemento();
            case Super8 -> p = depositoSuper8.getElemento();
            case Kitkat -> p = depositoKitkat.getElemento();
            case Snickers -> p = depositoSnickers.getElemento();
        }

        //Si el producto no existe o no hay stock guarda la moneda para devolverla y lanza exception
        if(p == null){
            depositoVuelto.addElemento(m);
            throw new NoHayProductoException("No existe este producto o no hay stock de el");
        }

        monedas.addElemento(m);

        //Si todo funciona, entonces devolvemos el producto a la vez que el vuelto en monedas variadas respectivamente hasta que el vuelto sea completado
        int contador = 0;
        int getVuelto = m.getValor() -  tipoProducto.getPrecio();
        while(getVuelto >= 1000){
            depositoVuelto.addElemento(new Moneda1000(contador++));
            getVuelto -= 1000;
        }

        while(getVuelto >=500){
            depositoVuelto.addElemento(new Moneda500(contador++));
            getVuelto -= 500;
        }

        while(getVuelto >= 100){
            depositoVuelto.addElemento(new Moneda100(contador++));
            getVuelto -= 100;
        }



        deposito.setProducto(p);

    }

    /**
     * Obtiene el producto comprado que fue almacenado en el depósito único de salida.
     * Al extraerlo, el depósito queda vacío nuevamente.
     *
     * @return El producto comprado, o null si no hay ningún producto disponible.
     */
    public Producto getProducto() {
        return deposito.getProducto();
    }


    /**
     * Extrae una moneda del depósito de vuelto de la máquina.
     * Este método debe llamarse repetidamente por el comprador para retirar todo su dinero acumulado.
     *
     * @return Una instancia de Moneda (ya sea una moneda de vuelto o la moneda original rechazada),
     *         o null si el depósito de vuelto ya se encuentra vacío.
     */
    public Moneda getVuelto() {
        return depositoVuelto.getElemento();
    }


    // Getters para que la interfaz gráfica pueda "mirar" los depósitos
    public Deposito<Producto> getDepositoCoca() { return depositoCoca; }
    public Deposito<Producto> getDepositoSprite() { return depositoSprite; }
    public Deposito<Producto> getDepositoPepsi() { return depositoPepsi; }
    public Deposito<Producto> getDepositoKem() { return depositoKem; }
    public Deposito<Producto> getDepositoFanta() { return depositoFanta; }
    public Deposito<Producto> getDepositoSuper8() { return depositoSuper8; }
    public Deposito<Producto> getDepositoKitkat() { return depositoKitkat; }
    public Deposito<Producto> getDepositoSnickers() { return depositoSnickers; }
    public Deposito<Producto> getDepositoChicle() { return depositoChicle; }
    public Deposito<Producto> getDepositoChocman() { return depositoChocman; }
    public Deposito<Moneda> getDepositoVuelto() { return depositoVuelto; }
}
