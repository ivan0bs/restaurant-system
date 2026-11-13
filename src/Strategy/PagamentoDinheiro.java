package Strategy;

public class PagamentoDinheiro implements EstrategiaPagamento{
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento realizado em dinheiro!");
        System.out.println("Valor: R$ " + valor+"\n");
    }
}
