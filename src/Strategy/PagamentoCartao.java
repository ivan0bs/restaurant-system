package Strategy;

public class PagamentoCartao implements EstrategiaPagamento{
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento realizado no cartão!");
        System.out.println("Valor: R$ " + valor+"\n");
    }
}
