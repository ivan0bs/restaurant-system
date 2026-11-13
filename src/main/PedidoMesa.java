package main;

public class PedidoMesa extends Pedido {
    public PedidoMesa(int numero) {
        super(numero);
    }
    @Override
    public String getTipo() {
        return "Mesa";
    }
}
