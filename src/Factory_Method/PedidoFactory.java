package Factory_Method;

import main.Pedido;

public abstract class PedidoFactory {
    public abstract Pedido criarPedido(int numero);
}
