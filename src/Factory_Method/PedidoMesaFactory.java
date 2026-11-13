package Factory_Method;

import main.Pedido;
import main.PedidoMesa;

public class PedidoMesaFactory extends PedidoFactory {
    @Override
    public Pedido criarPedido(int numero) {
        return new PedidoMesa(numero);
    }
}
