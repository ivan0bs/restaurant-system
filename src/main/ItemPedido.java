package main;

public class ItemPedido {

    private Produtos produto;
    private int quantidade;

    public ItemPedido(Produtos produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produtos getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double calcularSubtotal() {
        return produto.getPreco() * quantidade;
    }

    public void aumentarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }
}
