package Strategy;

public class PagamentoPix implements EstrategiaPagamento{
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento realizado via Pix!");
        System.out.println("Valor: R$ " + valor+"\n");
    }
}
