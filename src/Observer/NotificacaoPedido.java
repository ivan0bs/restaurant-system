package Observer;

import main.Pedido;

public class NotificacaoPedido implements ObservadorPedido {
    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("NOTIFICAÇÃO: Pedido " + pedido.getId() + " agora está: " + pedido.getStatus());
    }
}
