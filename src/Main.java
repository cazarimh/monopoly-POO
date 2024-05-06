import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static ArrayList<Jogador> jogadoresCriados = new ArrayList<Jogador>();
    private static ArrayList<Propriedade> propriedadesCriadas = new ArrayList<Propriedade>();
    private static ArrayList<CartaSorte> cartaSortesCriadas = new ArrayList<CartaSorte>();

    public static void main(String[] args) {
        Main.menu();
    }

    /* Método menu
        Método que exibe os menus de escolhas, computa as escolhas e decide o que será feito a partir de cada escolha
    */
    public static void menu() {

        Scanner input = new Scanner(System.in);

        while (true){
            System.out.println("""
                    --- MENU ---
                    [1] Jogar
                    [2] Editar Jogadores
                    [3] Editar Cartas
                    [0] Sair

                    """);

            int numeroJogadores = Tabuleiro.getQuantidadeJogadores();
            int numeroPropriedades = Tabuleiro.getQuantidadePropriedades();
            int numeroCartasSorte = cartaSortesCriadas.size();

            int opcaoMenu1 = input.nextInt();
            switch (opcaoMenu1) {
                case 1:
                    if (numeroJogadores >= 2 && numeroPropriedades == 28 && numeroCartasSorte == 30) {
                        Main.iniciarJogo();
                        opcaoMenu1 = 0;
                    } else {
                        System.out.println("Quantidade insuficiente de jogadores e/ou cartas.\n");
                    }
                    break;

                case 2:
                    while (true) {
                        numeroJogadores = Tabuleiro.getQuantidadeJogadores();
                        System.out.println("--- EDITAR JOGADORES ---\n" +
                                numeroJogadores + "/6 jogador(es) no tabuleiro\n\n" +
                                "[1] Criar novo jogador\n" +
                                "[2] Adicionar jogador ao tabuleiro\n" +
                                "[3] Remover jogador do tabuleiro\n" +
                                "[0] Voltar\n\n");

                        int opcaoMenu2 = input.nextInt();
                        switch (opcaoMenu2) {
                            case 1:
                                Jogador novoJogador = Main.criarJogador();
                                if (novoJogador != null) {
                                    jogadoresCriados.add(novoJogador);
                                } else {
                                    System.out.println("Informações inválidas. Não foi possível criar o novo jogador\n");
                                }
                                break;

                            case 2:
                                System.out.println("--- ADICIONAR JOGADORES ---\n");
                                int i;
                                for (i = 0; i < jogadoresCriados.size(); i++) {
                                    System.out.println("[" + (i+1) + "] " + jogadoresCriados.get(i).getNome());
                                }
                                System.out.println("[0] Voltar\n\n");

                                int jogAdd = input.nextInt();
                                if (jogAdd > 0 && jogAdd <= i) {
                                    Tabuleiro.addJogador(jogadoresCriados.get(jogAdd-1));
                                    jogadoresCriados.remove(jogadoresCriados.get(jogAdd-1));
                                } else if (jogAdd > i){
                                    System.out.println("Entrada inválida.\n");
                                }
                                break;

                            case 3:
                                System.out.println("--- REMOVER JOGADORES ---\n");
                                ArrayList<Jogador> jogadoresAdicinados = Tabuleiro.getJogadores();
                                int j;
                                for (j = 0; j < jogadoresAdicinados.size(); j++){
                                    System.out.println("[" + (j+1) + "] " + jogadoresAdicinados.get(j).getNome());
                                }
                                System.out.println("[0] Voltar\n\n");

                                int jogRem = input.nextInt();
                                if (jogRem > 0 && jogRem <= j){
                                    jogadoresCriados.add(jogadoresAdicinados.get(jogRem-1));
                                    Tabuleiro.removeJogador(jogadoresAdicinados.get(jogRem-1));
                                } else if (jogRem > j) {
                                    System.out.println("Entrada inválida.\n");
                                }
                                break;

                            default:
                                opcaoMenu2 = 0;
                                break;

                        }
                        if (opcaoMenu2 == 0) {
                            break;
                        }
                    }
                    break;

                case 3:
                    while (true) {
                        numeroPropriedades = Tabuleiro.getQuantidadePropriedades();
                        numeroCartasSorte = cartaSortesCriadas.size();

                        System.out.println("--- EDITAR CARTAS ---\n" +
                                numeroPropriedades + "/28 propriedade(s) no tabuleiro\n" +
                                numeroCartasSorte + "/30  carta(s) criadas\n\n" +
                                "[1] Criar nova propriedade\n" +
                                "[2] Adicionar propriedade ao tabuleiro\n" +
                                "[3] Remover propriedade do tabuleiro\n" +
                                "[4] Criar carta de sorte\n" +
                                "[5] Excluir carta de sorte\n" +
                                "[0] Voltar\n\n");

                        int opcaoMenu3 = input.nextInt();
                        switch (opcaoMenu3) {
                            case 1:
                                System.out.println("""
                                        Criar qual tipo de propriedade?

                                        [1] Serviço Público
                                        [2] Estação
                                        [3] Terreno
                                        [0] Cancelar

                                        """);

                                int opcaoMenu4 = input.nextInt();
                                switch (opcaoMenu4) {
                                    case 1:
                                        ServicoPublico novoServico = Main.criarServico();
                                        propriedadesCriadas.add(novoServico);
                                        break;

                                    case 2:
                                        Estacao novaEstacao = Main.criarEstacao();
                                        propriedadesCriadas.add(novaEstacao);
                                        break;

                                    case 3:
                                        Terreno novoTerreno = Main.criarTerreno();
                                        propriedadesCriadas.add(novoTerreno);
                                        break;

                                    default:
                                        break;
                                }

                                break;

                            case 2:
                                System.out.println("--- ADICIONAR PROPRIEDADES ---\n");
                                int i;
                                for (i = 0; i < propriedadesCriadas.size(); i++) {
                                    System.out.println("[" + (i+1) + "] " + propriedadesCriadas.get(i).getNome());
                                }
                                System.out.println("[0] Voltar\n\n");

                                int propAdd = input.nextInt();
                                if (propAdd > 0 && propAdd <= i) {
                                    Tabuleiro.addPropriedade(propriedadesCriadas.get(propAdd-1));
                                    propriedadesCriadas.remove(propriedadesCriadas.get(propAdd-1));
                                } else if (propAdd > i){
                                    System.out.println("Entrada inválida.\n");
                                }
                                break;

                            case 3:
                                System.out.println("--- REMOVER PROPRIEDADES ---\n");
                                ArrayList<Propriedade> propriedadesAdicionadas = Tabuleiro.getPropriedades();
                                int j;
                                for (j = 0; j < propriedadesAdicionadas.size(); j++){
                                    System.out.println("[" + (j+1) + "] " + propriedadesAdicionadas.get(j).getNome());
                                }
                                System.out.println("[0] Voltar\n\n");

                                int propRem = input.nextInt();
                                if (propRem > 0 && propRem <= j){
                                    propriedadesCriadas.add(propriedadesAdicionadas.get(propRem-1));
                                    Tabuleiro.removePropriedade(propriedadesAdicionadas.get(propRem-1));
                                } else if (propRem > j) {
                                    System.out.println("Entrada inválida.\n");
                                }
                                break;

                            case 4:
                                if (cartaSortesCriadas.size() < 30) {
                                    CartaSorte novaCartaSorte = criarCartaSorte();
                                    cartaSortesCriadas.add(novaCartaSorte);
                                } else {
                                    System.out.println("Há cartas demais, tente excluir algumas antes de criar novas\n");
                                }
                                break;

                            case 5:
                                System.out.println("--- EXCLUIR CARTAS DE SORTE ---\n");
                                int k;
                                for (k = 0; k < cartaSortesCriadas.size(); k++) {
                                    System.out.println("[" + (k+1) + "] " + cartaSortesCriadas.get(k).getDescricao());
                                }
                                System.out.println("[0] Voltar\n\n");

                                int cartaRem = input.nextInt();
                                if (cartaRem > 0 && cartaRem <= k) {
                                    cartaSortesCriadas.remove(cartaSortesCriadas.get(cartaRem-1));
                                } else if (cartaRem > k){
                                    System.out.println("Entrada inválida.\n");
                                }
                                break;

                            default:
                                opcaoMenu3 = 0;
                                break;

                        }
                        if (opcaoMenu3 == 0) {
                            break;
                        }
                    }
                    break;

                default:
                    opcaoMenu1 = 0;
                    break;
            }

            if (opcaoMenu1 == 0){
                break;
            }
        }
    }

    /* Método criarJogador
        Chama o construtor de um Jogador e atribui seus valores iniciais
    */
    public static Jogador criarJogador() {

        Scanner input = new Scanner(System.in);

        System.out.println("Insira o nome do jogador: \n");
        String nome = input.nextLine();

        System.out.println("Insira o cpf do jogador: \n");
        String cpf = input.nextLine();

        System.out.println("Insira o email do jogador: \n");
        String email = input.nextLine();

        System.out.println("Insira a foto do jogador: \n");
        String foto = input.nextLine();

        return Validacao.validarCPF(cpf) && Validacao.validarEmail(email) ? new Jogador(nome, cpf, email, foto) : null;
    }

    /* Método criarServico
        Chama o construtor de um Serviço e atribui seus valores iniciais
    */
    public static ServicoPublico criarServico() {

        Scanner input = new Scanner(System.in);

        System.out.println("Insira o nome do serviço público: \n");
        String nome = input.nextLine();

        System.out.println("Insira a descrição do serviço público: \n");
        String descricao = input.nextLine();

        System.out.println("Insira o preço de compra do serviço público: \n");
        int preco = input.nextInt();

        System.out.println("Insira o valor do aluguel base do serviço público: \n");
        int aluguel = input.nextInt();

        return new ServicoPublico(nome, descricao, preco, aluguel);
    }

    /* Método criarEstacao
        Chama o construtor de uma Estação e atribui seus valores iniciais
    */
    public static Estacao criarEstacao() {

        Scanner input = new Scanner(System.in);

        System.out.println("Insira o nome da estação: \n");
        String nome = input.nextLine();

        System.out.println("Insira a descrição da estação: \n");
        String descricao = input.nextLine();

        System.out.println("Insira o preço de compra da estação: \n");
        int preco = input.nextInt();

        System.out.println("Insira o valor do passe da estação: \n");
        int aluguel = input.nextInt();

        return new Estacao(nome, descricao, preco, aluguel);
    }

    /* Método criarTerreno
        Chama o construtor de um Terreno e atribui seus valores iniciais
    */
    public static Terreno criarTerreno() {

        Scanner input = new Scanner(System.in);

        System.out.println("Insira o nome do terreno: \n");
        String nome = input.nextLine();

        System.out.println("Insira a descrição do terreno: \n");
        String descricao = input.nextLine();

        System.out.println("Insira o preço de compra do terreno: \n");
        int preco = input.nextInt();

        System.out.println("Insira o valor do aluguel base do terreno: \n");
        int aluguel = input.nextInt();

        System.out.println("Insira o valor para construir uma casa no terreno: \n");
        int valorCasa = input.nextInt();

        System.out.println("Insira o valor para contruir um hotel no terreno: \n");
        int valorHotel = input.nextInt();

        return new Terreno(nome, descricao, preco, aluguel, valorCasa, valorHotel);
    }

    /* Método criarCartaSorte
        Chama o construtor de uma Carta de Sorte e atribui seus valores iniciais
    */
    public static CartaSorte criarCartaSorte() {

        Scanner input = new Scanner(System.in);

        System.out.println("Insira a descrição da carta:\n");
        String descricao = input.nextLine();

        System.out.println("Caso exista, insira a ação da carta:\n");
        String acao = input.nextLine();

        System.out.println("Caso exista, insira a restrição do uso da carta:\n");
        String restricao = input.nextLine();

        System.out.println("""
                Caso exista, insira o código do movimento da carta:
                - 0 -> sem movimento
                - 1 -> cadeia
                - 2 -> férias
                - 3 -> ponto de partida
                """);
        int movimento = input.nextInt();

        System.out.println("""
                Insira o efeito da carta:
                - -1 -> efeito negativo
                - 0 -> efeito neutro/sem efeito
                - 1 -> efeito positivo
                """);
        int efeito = input.nextInt();

        System.out.println("""
                Caso exista, insira o valor da carta:
                - > 0 se for recebimento
                - 0 se não houver valor
                - < 0 se for pagamento
                """);
        float valor = input.nextFloat();

        System.out.println("""
                Caso exista, insira o tempo de utilização da carta:
                - -1 se não houver
                - 0 para uso imediato
                - > 0 para uso posterior
                """);
        int tempo = input.nextInt();

        return new CartaSorte(descricao, movimento, efeito, valor, acao, tempo, restricao);
    }

    /* Método criarPeca
        Chama o construtor de uma Peça e atribui seus valores iniciais
    */
    public static Peca criarPeca() {

        Scanner input = new Scanner(System.in);

        System.out.println("Insira a cor desejada:\n");
        String cor = input.nextLine();

        return new Peca(cor);
    }

    /* Método iniciarJogo
        Atribui as peças a cada jogador, e inicia o jogo
    */
    public static void iniciarJogo() {

        Scanner input = new Scanner(System.in);

        ArrayList<Jogador> jogadores = Tabuleiro.getJogadores();
        ArrayList<Propriedade> propriedades = Tabuleiro.getPropriedades();

        System.out.println("--- SELEÇÃO DE CORES ---");
        for (Jogador jogador : jogadores) {
            System.out.println(jogador.getNome() + ":");
            jogador.setPeca(criarPeca());
        }

//      Aqui teria a definição da ordem em que os jogadores começam a jogar

        while (true) {
            System.out.println("""
                    --- OPÇÕES ---
                    [1] Ver informações dos jogadores
                    [2] Ver propriedades do banco
                    [3] Rolar dados
                    [0] Desistir do jogo
                    """);

            int opcao1 = input.nextInt();
            switch (opcao1) {
                case 0:
                    System.out.println("""
                            Tem certeza que deseja abandonar a partida?
                            [0] Não
                            [1] Sim
                            """);

                    int confirmacao = input.nextInt();
                    if (confirmacao == 1) {

//                      Aqui retirando um jogador aleatório, mais pra frente será o jogadorAtual
                        Tabuleiro.removeJogador(jogadores.get(0));
                    }
                    break;

                case 1:
                    System.out.println("--- JOGADORES ---\n");
                    int i;
                    for (i = 0; i < jogadores.size(); i++) {
                        System.out.println("[" + (i+1) + "] " + jogadores.get(i).getNome());
                    }
                    System.out.println("[0] Voltar\n\n");

                    int jogInfos = input.nextInt();
                    if (jogInfos > 0 && jogInfos <= i) {
                        System.out.println(jogadores.get(jogInfos-1) + "\n");

                        if (!jogadores.get(jogInfos-1).getCartas().isEmpty()) {
                            System.out.println("--- PROPRIEDADES ---");
                            for (Carta propJogInfos : jogadores.get(jogInfos - 1).getCartas()) {
                                if (propJogInfos.getClass() != CartaSorte.class) {
                                    System.out.println(propJogInfos + "\n");
                                }
                            }
                        }
                    } else if (jogInfos > i){
                        System.out.println("Entrada inválida.\n");
                    }
                    break;

                case 2:
                    for (Propriedade prop : propriedades){
                        if (prop.getDono() == null) {
                            System.out.println(prop + "\n");
                        }
                    }
                    break;

                case 3:
//                  Rolar dados, valor aleatório
                    int dados = 3;
                    int posicao = jogadores.get(0).getPeca().getPosicao() + dados;
                    jogadores.get(0).getPeca().setPosicao(posicao);

                    if (posicao == 3) {

//                      Simulando que o jogador caiu em uma propriedade
                        System.out.println(jogadores.get(0).getNome() + " caiu em " + propriedades.get(0).getNome() + "\n" +
                                propriedades.get(0).toString() + "\n" +
                                "Deseja comprar?\n" +
                                "[0] Não\n" +
                                "[1] Sim \n\n");

                        int escolha = input.nextInt();
                        if (escolha == 1) {

//                      Simulando a compra da propriedade
                            if (jogadores.get(0).getDinheiro() >= propriedades.get(0).getPreco()) {
                                int saldo = jogadores.get(0).getDinheiro() - propriedades.get(0).getPreco();
                                jogadores.get(0).setDinheiro(saldo);
                                propriedades.get(0).setDono(jogadores.get(0));
                                jogadores.get(0).addCarta(propriedades.get(0));
                                System.out.println(propriedades.get(0).toString() + "\n");
                            }
                        }
                    }

                    jogadores.get(1).getPeca().setPosicao(3);

                    if (jogadores.get(1).getPeca().getPosicao() == 3) {

//                      Simulando pagamento de aluguel (posicao do player2 igual a uma propriedade com dono diferente dele)
                        System.out.println(jogadores.get(1).getNome() + " caiu em " + propriedades.get(0).getNome() + "\n" +
                                propriedades.get(0).toString() + "\n");

                        if (propriedades.get(0).getDono() != null) {
                            if (propriedades.get(0).getDono() != jogadores.get(1) && jogadores.get(1).getDinheiro() >= propriedades.get(0).calcularAluguel()) {
                                int aluguel = propriedades.get(0).calcularAluguel();
                                propriedades.get(0).getDono().setDinheiro(propriedades.get(0).getDono().getDinheiro() + aluguel);

                                int saldo = jogadores.get(1).getDinheiro() - aluguel;
                                jogadores.get(1).setDinheiro(saldo);

                                System.out.println(jogadores.get(1).getNome() + " pagou R$" + propriedades.get(0).calcularAluguel() + " para " + propriedades.get(0).getDono().getNome());
                            } else {
                                System.out.println(jogadores.get(1).getNome() + " não tem dinheiro suficiente para pagar aluguel e, portanto, faliu");
                                Tabuleiro.removeJogador(jogadores.get(1));
                            }
                        } else {
                            System.out.println("""
                                    Deseja comprar?
                                    [0] Não
                                    [1] Sim
                                    """);
//                          Vou evitar reescrever o mesmo código aqui, mas seria a opção de compra, mais tarde separarei em outro método
                        }
                    }
                    break;

                default:
                    break;
            }

//          Simulando uma vitória
            if (jogadores.size() == 1){
                System.out.println("Parabéns " + jogadores.get(0).getNome() + " você venceu!");
                break;
            }
        }
    }
}
