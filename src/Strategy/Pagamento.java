package Strategy;

public class Pagamento {
    private EstrategiaPagamento estrategia;

    public void setEstrategia(EstrategiaPagamento estrategia) {
        this.estrategia = estrategia;
    }

    public void executarPagamento(double valor) {
        if (estrategia == null) {
            System.out.println("Forma de pagamento não selecionada!");
            return;
        }
        estrategia.pagar(valor);
    }
}
