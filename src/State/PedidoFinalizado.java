package State;

import main.Pedido;

public class PedidoFinalizado implements StatusPedido {

    @Override
    public void avancar(Pedido pedido) {
        System.out.println("O pedido já foi finalizado!");
    }

    @Override
    public void Voltar(Pedido pedido) {
        pedido.setStatus(new PedidoEmPreparacao());
    }

    @Override
    public String getNome() {
        return "Finalizado";
    }
}
