package main;

public class Produtos {
    private final int id;
    private String nome;
    private double preco;
    
    public Produtos(int id, String nome, double preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}
