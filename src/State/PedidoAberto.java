package State;

import main.Pedido;

public class PedidoAberto implements StatusPedido {

    @Override
    public void avancar(Pedido pedido) {
        pedido.setStatus(new PedidoEmPreparacao());
    }

    @Override
    public void Voltar(Pedido pedido) {
        System.out.println("O pedido Aberto!");
    }

    @Override
    public String getNome() {
        return "Aberto";
    }
}
