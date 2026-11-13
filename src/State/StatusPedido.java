package State;

import main.Pedido;

public interface StatusPedido {
    void avancar(Pedido pedido);
    String getNome();
    void Voltar(Pedido pedido);
}
