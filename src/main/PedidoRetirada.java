package main;

public class PedidoRetirada extends Pedido {
    public PedidoRetirada(int numero) {
        super(numero);
    }
    @Override
    public String getTipo() {
        return "Retirada";
    }
}
