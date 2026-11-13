package Repository;

import java.util.ArrayList;
import main.Produtos;

public class ProdutosRepository {
    private static final ArrayList<Produtos> produtos = new ArrayList<>();
    public void CadastrarProdutos(String nome, double Preco){
        int id = produtos.size() + 1;
        produtos.add(new Produtos(id, nome, Preco));
        System.out.println("Produto Cadastrado!");
    }

    public void ListarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nem um produto Cadastrado!");
        }else{
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println((i+1) + " - "+produtos.get(i).getNome()+" - R$ "+produtos.get(i).getPreco());
            }
        }
    }

    public void ExcluirProdutos(int idProcurado) {
        for (int i = 0; i < produtos.size(); i++) {
            Produtos produto = produtos.get(i);
            if (produto != null && produto.getId() == idProcurado) {
                produtos.remove(i);
                System.out.println("Produto com o ID " + idProcurado + " excluído com sucesso!\n");
                return;
            }
        }
        System.out.println("Produto Para Ser Exclusão Não Encontrado.\n");
    }

    public void AlterarNomeProduto(int id,String nome){
        for (int i = 0; produtos.size() >= i; i++) {
            if (produtos.get(i).getId() == id) {
                produtos.get(i).setNome(nome);
                System.out.println("Produto atualizado!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public void AlterarPrecoProduto(int id,double preco){
        for (int i = 0; produtos.size() >= i; i++) {
            if (produtos.get(i).getId() == id) {
                produtos.get(i).setPreco(preco);
                System.out.println("Produto atualizado!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }
    public int getSize(){
        return produtos.size();
    }

    public Produtos BuscarProduto(int id) {
        if (id >= 1 && id <= produtos.size()) {
            return produtos.get(id - 1);
        }

        return null;
    }
}
