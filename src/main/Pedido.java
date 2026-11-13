package main;

import Observer.ObservadorPedido;
import State.PedidoAberto;
import State.StatusPedido;
import java.util.ArrayList;

public abstract class Pedido {

    private final int id;
    private final ArrayList<ItemPedido> produtos;
    private ArrayList<ObservadorPedido> observadores;
    private StatusPedido status;

    public Pedido(int id) {
        this.id = id;
        this.produtos = new ArrayList<>();
        this.status = new PedidoAberto();
        this.observadores = new ArrayList<>();
    }

    public void adicionarProduto(Produtos produto, int quantidade) {
        for (ItemPedido item : produtos) {
            if (item.getProduto() == produto) {
                item.aumentarQuantidade(quantidade);
                return;
            }
        }
        produtos.add(new ItemPedido(produto, quantidade));
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto neste pedido!");
            return;
        }
        for (ItemPedido item : produtos) {
            System.out.println(item.getProduto().getNome()+ " | Quantidade: " + item.getQuantidade()+ " | Preço unitario: R$ " + item.getProduto().getPreco()+ " | Subtotal: R$ " + item.calcularSubtotal());
        }
    }

    public void adicionarObservador(ObservadorPedido observador) {
        observadores.add(observador);
    }

    public void removerObservador(ObservadorPedido observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores() {
        for (ObservadorPedido observador : observadores) {
            observador.atualizar(this);
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : produtos) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public void avancarStatus() {
        status.avancar(this);
    }

    public void VoltarStatus() {
        status.Voltar(this);
    }

    public String getStatus() {
        return status.getNome();
    }

    public void setStatus(StatusPedido status){
        this.status = status;
        notificarObservadores();
    }
    
    public int getId() {
        return id;
    }
    
    public int getSize(){
        return produtos.size();
    }

    public abstract String getTipo();

}