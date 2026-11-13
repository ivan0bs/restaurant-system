package Factory_Method;

import main.Pedido;
import main.PedidoRetirada;

public class PedidoRetiradaFactory extends PedidoFactory {
    @Override
    public Pedido criarPedido(int numero) {
        return new PedidoRetirada(numero);
    }
}
