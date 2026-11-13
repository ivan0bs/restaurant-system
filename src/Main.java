import Factory_Method.PedidoFactory;
import Factory_Method.PedidoMesaFactory;
import Factory_Method.PedidoRetiradaFactory;
import Observer.NotificacaoPedido;
import Repository.PedidoRepository;
import Repository.ProdutosRepository;
import Strategy.EstrategiaPagamento;
import Strategy.Pagamento;
import Strategy.PagamentoCartao;
import Strategy.PagamentoDinheiro;
import Strategy.PagamentoPix;
import java.util.Scanner;
import main.Pedido;
import main.Produtos;

public class Main{
    public static void main(String[] args) throws InterruptedException {
        boolean online = true,online2;
        ProdutosRepository produtoRepository = new ProdutosRepository();
        PedidoRepository pedidoRepository = new PedidoRepository();
        NotificacaoPedido notificacao = new NotificacaoPedido();
        produtoRepository.CadastrarProdutos("Pizza", 35);
        produtoRepository.CadastrarProdutos("Hambúrguer", 20);
        produtoRepository.CadastrarProdutos("Refrigerante", 7);
        int opcao,opcao2,opcao3;
        String nome;
        double preco;
        Scanner scanner = new Scanner(System.in);
        limparTela();
        System.out.println("Bem vido ao Restaurante\n");
        while (online) { 
            System.out.println("Opções:\n1 - Produto\n2 - Pedidos\n\n0 - Sair");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    limparTela();
                    System.out.println("Opções:\n1 - Cadastrar Produto\n2 - Listar Produto\n3 - Excluir Produto\n4 - Alterar Produto\n\n0 - Sair");
                    opcao = scanner.nextInt();
                    switch (opcao) {
                        case 1:
                            limparTela();
                            System.out.println("Nome do Produto:");
                            nome = scanner.next();
                            System.out.println("Preço do Produto:");
                            preco = scanner.nextDouble();
                            scanner.nextLine();
                            produtoRepository.CadastrarProdutos(nome, preco);
                            break;
                        case 2:
                            limparTela();
                            System.out.println("===== CARDÁPIO =====\n");
                            produtoRepository.ListarProdutos();
                            System.out.println("\n0 - Sair\n");
                            String _ = scanner.next();
                            limparTela();
                            break;

                        case 3:
                            limparTela();
                            System.out.println("===== CARDÁPIO =====\n");
                            produtoRepository.ListarProdutos();
                            System.out.print("\n0 - Sair\n\nDigite o numero do Produto que queira Excluir: ");
                            opcao = scanner.nextInt();
                            limparTela();
                            if(opcao == 0){break;}
                            produtoRepository.ExcluirProdutos(opcao);
                            break;
                        case 4:
                            limparTela();
                            System.out.println("===== CARDÁPIO =====\n");
                            produtoRepository.ListarProdutos();
                            System.out.print("\n0 - Sair\n\nDigite o numero do Produto que queira Alterar : ");
                            opcao = scanner.nextInt();
                            limparTela();
                            if(opcao == 0){break;}
                            System.out.println("Opções:\n1 - Alterar nome do Produto\n2 - Alterar Preco do Produto\n\n0 - Sair\"");
                            opcao2 = scanner.nextInt();
                            limparTela();
                            if(opcao2 == 0){break;}
                            switch (opcao2) {
                                case 1 -> {
                                    System.out.println("Nome do Produto:");
                                    nome = scanner.next();
                                    produtoRepository.AlterarNomeProduto(opcao, nome);
                                }
                                case 2 -> {
                                    System.out.println("Preço do Produto:");
                                    preco = scanner.nextDouble();
                                    produtoRepository.AlterarPrecoProduto(opcao, preco);
                                }
                                default -> System.out.println("!Numero Invalido!\nDigitem o numero de uma das Opções!!");
                                }
                            break;
                        case 0:
                            limparTela();
                            break;
                        default:
                            System.out.println("!Numero Invalido!\nDigitem o numero de uma das Opções!!");
                            break;
                    }
                    break;
                case 2:
                    limparTela();
                    System.out.println("Opções:\n1 - Criar Pedido\n2 - Listar Pedidos\n\n0 - Sair");
                    PedidoFactory factory;
                    Pedido pedido;
                    scanner.nextLine();
                    opcao2 = scanner.nextInt();
                    switch (opcao2) {
                        case 1:
                            limparTela();
                            System.out.println("Opções:\n1 - Retirar\n2 - Comer\n\n0 - Sair");
                            scanner.nextLine();
                            opcao3 = scanner.nextInt();
                            factory = new PedidoMesaFactory();
                            if (opcao3 == 1){
                                factory = new PedidoRetiradaFactory();
                            }else if (opcao3 == 0){break;}
                            pedido = factory.criarPedido(pedidoRepository.gerarNumeroPedido());
                            pedido.adicionarObservador(notificacao);
                            pedidoRepository.adicionarPedido(pedido);
                            limparTela();
                            System.out.println("Pedido criado!");
                            System.out.println("Número: " + pedido.getId());
                            System.out.println("Tipo: " + pedido.getTipo()+"\n");
                            online2 = true;
                            while(online2){
                                System.out.println("===== CARDÁPIO =====\n");
                                produtoRepository.ListarProdutos();
                                System.out.print("\n0 - Sair\n\nDigite o numero do Produto: ");
                                opcao2 = scanner.nextInt();
                                scanner.nextLine();
                                if(opcao2 == 0){limparTela();break;}
                                Produtos produto = produtoRepository.BuscarProduto(opcao2);
                                if (produto != null) {
                                    System.out.print("Digite a quantidade: ");
                                    int quantidade = scanner.nextInt();
                                    pedido.adicionarProduto(produto,quantidade);
                                    limparTela();
                                    System.out.println("Produto adicionado ao pedido!");
                                } else if(produto == null&& opcao2 != 0){
                                    System.out.println("ID inválido!");
                                }
                                if (opcao2 == 0){
                                    limparTela();
                                    if (pedido.getSize() == 0){ 
                                        System.out.println("Pedido Cancelado!\nMotivo: Nem um produto Adicionado!");
                                        break;
                                    }
                                    break;
                                }
                            }
                            break;
                        case 2:
                            limparTela();
                            if (pedidoRepository.listarPedidos() == true){
                                System.out.print("\n0 - Sair\nDigite o numero do Pedido: ");
                                int numeroPedido = scanner.nextInt();
                                scanner.nextLine();
                                limparTela();
                                if (numeroPedido == 0){break;}
                                Pedido pedidos = pedidoRepository.buscarPedido(numeroPedido);
                                if (pedidos == null){
                                    System.out.println("\nPedido não encontrado!");
                                    break;
                                }
                                if ("Finalizado".equals(pedidos.getStatus())){
                                    pedidos.avancarStatus();
                                    break;
                                }
                                System.out.println("Opções:\n1 - Adicionar Produto ao Pedido\n2 - Finalizar Pedidos\n\n0 - Sair");
                                opcao = scanner.nextInt();
                                limparTela();
                                if (opcao == 1){
                                    online2 = true;
                                    while(online2){
                                        System.out.println("===== CARDÁPIO =====\n");
                                        produtoRepository.ListarProdutos();
                                        System.out.print("\n0 - Sair\n\nDigite o numero do Produto: ");
                                        opcao = scanner.nextInt();
                                        scanner.nextLine();
                                        if (opcao == 0){
                                            limparTela();
                                            break;
                                        }
                                        Produtos produto = produtoRepository.BuscarProduto(opcao);
                                        if (produto != null) {
                                            System.out.print("Digite a quantidade: ");
                                            int quantidade = scanner.nextInt();
                                            pedidos.adicionarProduto(produto,quantidade);
                                            limparTela();
                                            System.out.println("Produto adicionado ao pedido!");
                                        } else if(produto == null&& opcao2 != 0){
                                            System.out.println("ID inválido!");
                                        }
                                        if (opcao2 == 0){
                                            if (pedidos.getSize() == 0){
                                                limparTela();
                                                System.out.println("Pedido Cancelado!\nMotivo: Nem um produto Adicionado!");
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }else if (opcao == 2){
                                    pedidos.avancarStatus();
                                    java.util.concurrent.TimeUnit.SECONDS.sleep(5);
                                    if ("Mesa".equals(pedidos.getTipo())){
                                        System.out.println("\nPedido Pronto, indo a Mesa!\n");
                                        System.out.println("1 - Finalizar\n\n0 - Sair");
                                        opcao = scanner.nextInt();
                                        if(opcao == 0){break;}
                                    }
                                    pedidos.avancarStatus();
                                    java.util.concurrent.TimeUnit.SECONDS.sleep(5);
                                    limparTela();
                                    if("Retirada".equals(pedidos.getTipo())){
                                        System.out.println(pedidos.getStatus()+" Pronto para Retirada!");
                                    }
                                    limparTela();
                                    System.out.println("\n===== FORMAS DE PAGAMENTO =====\n\n1 - Pix\n2 - Dinheiro\n3 - Cartão\n\n0 - Sair\n");
                                    opcao = scanner.nextInt();
                                    limparTela();
                                    EstrategiaPagamento estrategia = null;
                                    switch (opcao) {
                                        case 1:
                                            estrategia = new PagamentoPix();
                                            break;
                                        case 2:
                                            estrategia = new PagamentoDinheiro();
                                            break;
                                        case 3:
                                            estrategia = new PagamentoCartao();
                                            break;
                                        case 0:
                                            pedidos.VoltarStatus();
                                            pedidos.VoltarStatus();
                                            limparTela();
                                            break;
                                        default:
                                            System.out.println("Opção inválida!");
                                            break;
                                    }
                                    if (estrategia != null) {
                                        Pagamento pagamento = new Pagamento();
                                        pagamento.setEstrategia(estrategia);
                                        pagamento.executarPagamento(pedidos.calcularTotal());
                                    }
                                }
                            }
                            break;
                        case 0:
                            limparTela();
                            break;
                        default:
                            System.out.println("!Numero Invalido!\nDigitem o numero de uma das Opções!!");
                            break;
                    }
                    break;
                case 0:
                    limparTela();
                    online = false;
                    break;
                default:
                    System.out.println("!Numero Invalido!\nDigitem o numero de uma das Opções!!");
                    break;
            }
        }
        scanner.close();
    }
    private static void limparTela() {
        for (int i = 0; i < 50; i++) System.out.println();
        }
}