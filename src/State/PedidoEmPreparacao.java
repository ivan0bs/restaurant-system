package State;

import main.Pedido;

public class PedidoEmPreparacao implements StatusPedido {

    @Override
    public void avancar(Pedido pedido) {
        pedido.setStatus(new PedidoFinalizado());
    }

    @Override
    public void Voltar(Pedido pedido) {
        pedido.setStatus(new PedidoAberto());
    }

    @Override
    public String getNome() {
        return "Em preparação";
    }
}
