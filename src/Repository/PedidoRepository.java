package Repository;

import java.util.ArrayList;
import main.Pedido;

public class PedidoRepository {
    private final ArrayList<Pedido> pedidos;
    private int contador;

    public PedidoRepository() {
        this.pedidos = new ArrayList<>();
        this.contador = 1;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
        contador++;
    }

    public int gerarNumeroPedido() {
        return contador;
    }

    public Pedido buscarPedido(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    public boolean  listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado!");
            return false;
        }
        System.out.println("----------------------");
        for (Pedido pedido : pedidos) {
            System.out.println("Pedido: " + pedido.getId());
            System.out.println("----------------------");
            System.out.println("Tipo: " + pedido.getTipo());
            System.out.println("Status: " + pedido.getStatus());
            System.out.println("Itens:");
            pedido.listarProdutos();
            System.out.println("\nTotal: R$ " + pedido.calcularTotal());
            System.out.println("----------------------");
        }
        return true;
    }
    
}
