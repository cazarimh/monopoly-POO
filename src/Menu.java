import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static ArrayList<Jogador> jogadoresCriados = new ArrayList<Jogador>();
    private static ArrayList<Propriedade> propriedadesCriadas = new ArrayList<Propriedade>();

    /**
     * Menu inicial de configurações da partida.
     *  - Cria, adiciona e remove jogadores
     *  - Cria, adiciona e remove propriedades
     *  - Cria e exclui cartas de sorte
     * @throws IOException
     */
    public static void menuInicial() throws IOException {

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
            int numeroCartasSorte = Tabuleiro.getQuantidadeCartasSorte();

            String opcaoMenu1 = input.nextLine().trim();
            switch (opcaoMenu1) {
                case "1":
                    if (numeroJogadores >= 2 && numeroPropriedades == 3 && numeroCartasSorte == 2) {
                        Menu.iniciarJogo();
                        opcaoMenu1 = "0";
                    } else {
                        System.out.println("Quantidade insuficiente de jogadores e/ou cartas.\n");
                    }
                    break;

                case "2":
                    while (true) {
                        System.out.println("--- EDITAR JOGADORES ---\n" +
                                numeroJogadores + "/6 jogador(es) no tabuleiro\n\n" +
                                "[1] Criar novo jogador\n" +
                                "[2] Adicionar jogador ao tabuleiro\n" +
                                "[3] Remover jogador do tabuleiro\n" +
                                "[0] Voltar\n\n");

                        String opcaoMenu2 = input.nextLine().trim();
                        switch (opcaoMenu2) {
                            case "1":
                                Jogador novoJogador = Menu.criarJogador();
                                if (novoJogador != null) {
                                    jogadoresCriados.add(novoJogador);
                                } else {
                                    System.out.println("Informações inválidas. Não foi possível criar o novo jogador\n");
                                }
                                break;

                            case "2":
                                System.out.println("--- ADICIONAR JOGADORES ---\n");
                                int i;
                                for (i = 0; i < jogadoresCriados.size(); i++) {
                                    System.out.println("[" + (i+1) + "] " + jogadoresCriados.get(i).getNome());
                                }
                                System.out.println("[0] Voltar\n\n");

                                int jogAdd = Integer.parseInt(Validacao.receberEntrada("", "int"));
                                if (jogAdd > 0 && jogAdd <= i) {
                                    Tabuleiro.addJogador(jogadoresCriados.get(jogAdd-1));
                                    jogadoresCriados.remove(jogadoresCriados.get(jogAdd-1));
                                } else if (jogAdd > i){
                                    System.err.println("Entrada inválida, tente novamente.");
                                }
                                break;

                            case "3":
                                System.out.println("--- REMOVER JOGADORES ---\n");
                                ArrayList<Jogador> jogadoresAdicinados = Tabuleiro.getJogadores();
                                int j;
                                for (j = 0; j < jogadoresAdicinados.size(); j++){
                                    System.out.println("[" + (j+1) + "] " + jogadoresAdicinados.get(j).getNome());
                                }
                                System.out.println("[0] Voltar\n\n");

                                int jogRem = Integer.parseInt(Validacao.receberEntrada("", "int"));
                                if (jogRem > 0 && jogRem <= j){
                                    jogadoresCriados.add(jogadoresAdicinados.get(jogRem-1));
                                    Tabuleiro.removeJogador(jogadoresAdicinados.get(jogRem-1));
                                } else if (jogRem > j) {
                                    System.err.println("Entrada inválida, tente novamente.");
                                }
                                break;

                            case "0":
                                break;

                            default:
                                System.err.println("Entrada inválida, tente novamente.");
                                break;

                        }
                        if (opcaoMenu2.equals("0")) {
                            break;
                        }
                    }
                    break;

                case "3":
                    while (true) {
                        System.out.println("--- EDITAR CARTAS ---\n" +
                                numeroPropriedades + "/28 propriedade(s) no tabuleiro\n" +
                                numeroCartasSorte + "/30  carta(s) criadas\n\n" +
                                "[1] Criar nova propriedade\n" +
                                "[2] Adicionar propriedade ao tabuleiro\n" +
                                "[3] Remover propriedade do tabuleiro\n" +
                                "[4] Criar carta de sorte\n" +
                                "[5] Excluir carta de sorte\n" +
                                "[0] Voltar\n\n");

                        String opcaoMenu3 = input.nextLine().trim();
                        switch (opcaoMenu3) {
                            case "1":
                                System.out.println("""
                                        Criar qual tipo de propriedade?

                                        [1] Serviço Público
                                        [2] Estação
                                        [3] Terreno
                                        [0] Cancelar

                                        """);

                                String opcaoMenu4 = input.nextLine().trim();
                                switch (opcaoMenu4) {
                                    case "1":
                                        ServicoPublico novoServico = Menu.criarServico();
                                        propriedadesCriadas.add(novoServico);
                                        break;

                                    case "2":
                                        Estacao novaEstacao = Menu.criarEstacao();
                                        propriedadesCriadas.add(novaEstacao);
                                        break;

                                    case "3":
                                        Terreno novoTerreno = Menu.criarTerreno();
                                        propriedadesCriadas.add(novoTerreno);
                                        break;

                                    case "0":
                                        break;

                                    default:
                                        System.err.println("Entrada inválida, tente novamente.");
                                        break;
                                }

                                break;

                            case "2":
                                System.out.println("--- ADICIONAR PROPRIEDADES ---\n");
                                int i;
                                for (i = 0; i < propriedadesCriadas.size(); i++) {
                                    System.out.println("[" + (i+1) + "] " + propriedadesCriadas.get(i).getNome());
                                }
                                System.out.println("[0] Voltar\n\n");

                                int propAdd = Integer.parseInt(Validacao.receberEntrada("", "int"));
                                if (propAdd > 0 && propAdd <= i) {
                                    Tabuleiro.addPropriedade(propriedadesCriadas.get(propAdd-1));
                                    propriedadesCriadas.remove(propriedadesCriadas.get(propAdd-1));
                                } else if (propAdd > i){
                                    System.err.println("Entrada inválida, tente novamente.");
                                }
                                break;

                            case "3":
                                System.out.println("--- REMOVER PROPRIEDADES ---\n");
                                ArrayList<Propriedade> propriedadesAdicionadas = Tabuleiro.getPropriedades();
                                int j;
                                for (j = 0; j < propriedadesAdicionadas.size(); j++){
                                    System.out.println("[" + (j+1) + "] " + propriedadesAdicionadas.get(j).getNome());
                                }
                                System.out.println("[0] Voltar\n\n");

                                int propRem = Integer.parseInt(Validacao.receberEntrada("", "int"));
                                if (propRem > 0 && propRem <= j){
                                    propriedadesCriadas.add(propriedadesAdicionadas.get(propRem-1));
                                    Tabuleiro.removePropriedade(propriedadesAdicionadas.get(propRem-1));
                                } else if (propRem > j) {
                                    System.err.println("Entrada inválida, tente novamente.");
                                }
                                break;

                            case "4":
                                if (numeroCartasSorte < 30) {
                                    CartaSorte novaCartaSorte = Menu.criarCartaSorte();
                                    Tabuleiro.addCartaSorte(novaCartaSorte);
                                } else {
                                    System.out.println("Há cartas demais, tente excluir algumas antes de criar novas\n");
                                }
                                break;

                            case "5":
                                System.out.println("--- EXCLUIR CARTAS DE SORTE ---\n");
                                ArrayList<CartaSorte> cartasSorteAdicionadas = Tabuleiro.getCartasSorte();
                                int k;
                                for (k = 0; k < cartasSorteAdicionadas.size(); k++) {
                                    System.out.println("[" + (k+1) + "] " + cartasSorteAdicionadas.get(k).getDescricao());
                                }
                                System.out.println("[0] Voltar\n\n");

                                int cartaRem = Integer.parseInt(Validacao.receberEntrada("", "int"));
                                if (cartaRem > 0 && cartaRem <= k) {
                                    cartasSorteAdicionadas.remove(cartasSorteAdicionadas.get(cartaRem-1));
                                } else if (cartaRem > k){
                                    System.err.println("Entrada inválida, tente novamente.");
                                }
                                break;

                            case "0":
                                break;

                            default:
                                System.err.println("Entrada inválida, tente novamente.");
                                break;

                        }
                        if (opcaoMenu3.equals("0")) {
                            break;
                        }
                    }
                    break;

                case "0":
                    break;

                default:
                    System.err.println("Entrada inválida, tente novamente.");
                    break;
            }

            if (opcaoMenu1.equals("0")){
                break;
            }
        }
    }

    /**
     * Chama o construtor de um Jogador e atribui seus valores iniciais.
     * @return jogador - jogador criado
     */
    public static Jogador criarJogador() {

        Scanner input = new Scanner(System.in);

        System.out.print("\nInsira o nome do jogador: \n");
        String nome = input.nextLine();

        System.out.print("\nInsira o cpf do jogador: \n");
        String cpf = input.nextLine();

        System.out.print("\nInsira o email do jogador: \n");
        String email = input.nextLine();

        System.out.print("\nInsira a foto do jogador: \n");
        String foto = input.nextLine();

        return Validacao.validarCPF(cpf) && Validacao.validarEmail(email) ? new Jogador(nome, cpf, email, foto) : null;
    }

    /**
     * Chama o construtor de um ServicoPublico e atribui seus valores iniciais.
     * @return servicoPublico - servicoPublico criado
     */
    public static ServicoPublico criarServico() {

        Scanner input = new Scanner(System.in);

        System.out.print("\nInsira o nome do serviço público: \n");
        String nome = input.nextLine();

        System.out.print("\nInsira a descrição do serviço público: \n");
        String descricao = input.nextLine();

        int preco = Integer.parseInt(Validacao.receberEntrada("\nInsira o preço de compra do serviço público: \n", "int"));

        int aluguel = Integer.parseInt(Validacao.receberEntrada("\nInsira o valor do aluguel base do serviço público: \n", "int"));

        return new ServicoPublico(nome, descricao, preco, aluguel);
    }

    /**
     * Chama o construtor de uma Estacao e atribui seus valores iniciais.
     * @return estacao - estacao criada
     */
    public static Estacao criarEstacao() {

        Scanner input = new Scanner(System.in);

        System.out.print("\nInsira o nome da estação: \n");
        String nome = input.nextLine();

        System.out.print("\nInsira a descrição da estação: \n");
        String descricao = input.nextLine();

        int preco = Integer.parseInt(Validacao.receberEntrada("\nInsira o preço de compra da estação: \n", "int"));

        int aluguel = Integer.parseInt(Validacao.receberEntrada("\nInsira o valor do passe da estação: \n", "int"));

        return new Estacao(nome, descricao, preco, aluguel);
    }

    /**
     * Chama o construtor de um Terreno e atribui seus valores iniciais.
     * @return terreno - terreno criado
     */
    public static Terreno criarTerreno() {

        Scanner input = new Scanner(System.in);

        System.out.print("\nInsira o nome do terreno: \n");
        String nome = input.nextLine();

        System.out.print("\nInsira a descrição do terreno: \n");
        String descricao = input.nextLine();

        int preco = Integer.parseInt(Validacao.receberEntrada("\nInsira o preço de compra do terreno: \n", "int"));

        int aluguel = Integer.parseInt(Validacao.receberEntrada("\nInsira o valor do aluguel base do terreno: \n", "int"));

        int valorCasa = Integer.parseInt(Validacao.receberEntrada("\nInsira o valor para construir uma casa no terreno: \n", "int"));

        int valorHotel = Integer.parseInt(Validacao.receberEntrada("\nInsira o valor para contruir um hotel no terreno: \n", "int"));

        return new Terreno(nome, descricao, preco, aluguel, valorCasa, valorHotel);
    }

    /**
     * Chama o construtor de uma CartaSorte e atribui seus valores iniciais.
     * @return cartaSorte - cartaSorte criada
     */
    public static CartaSorte criarCartaSorte() {

        Scanner input = new Scanner(System.in);

        System.out.print("\nInsira a descrição da carta:\n");
        String descricao = input.nextLine();

        System.out.print("\nCaso exista, insira a ação da carta:\n");
        String acao = input.nextLine();

        System.out.print("\nCaso exista, insira a restrição do uso da carta:\n");
        String restricao = input.nextLine();

        System.out.println("""
                Caso exista, insira o código do movimento da carta:
                - 0 -> sem movimento
                - 1 -> cadeia
                - 2 -> férias
                - 3 -> ponto de partida
                """);
        int movimento = Integer.parseInt(Validacao.receberEntrada("", "int"));

        System.out.println("""
                Caso exista, insira o valor da carta:
                - > 0 se for recebimento
                - 0 se não houver valor
                - < 0 se for pagamento
                """);
        int valor = Integer.parseInt(Validacao.receberEntrada("", "int"));

        System.out.println("""
                Caso exista, insira o tempo de utilização da carta:
                - -1 se não houver
                - 0 para uso imediato
                - > 0 para uso posterior
                """);
        int tempo = Integer.parseInt(Validacao.receberEntrada("", "int"));

        System.out.println("""
                Insira o tipo da carta:
                - -1 -> Revés
                - 1 -> Sorte
                """);
        int escolhaTipo = Integer.parseInt(Validacao.receberEntrada("", "int"));
        TipoCarta tipo = (escolhaTipo == 1 ? TipoCarta.SORTE : TipoCarta.REVES);

        return new CartaSorte(descricao, movimento, valor, acao, tempo, restricao, tipo);
    }

    /**
     * Chama o construtor de uma Peca e atribui seus valores iniciais.
     * @return peca - peca criada
     */
    public static Peca criarPeca() {

        Scanner input = new Scanner(System.in);

        System.out.println("insira a cor desejada:\n");
        String cor = input.nextLine();

        return new Peca(cor);
    }

    /**
     * Inicia o jogo e implementa todas as lógicas para o funcionamento do mesmo.
     * @throws IOException
     */
    public static void iniciarJogo() throws IOException {

        Scanner input = new Scanner(System.in);

        System.out.println("--- SELEÇÃO DE CORES ---");
        for (Jogador jogador : Tabuleiro.getJogadores()) {
            System.out.print(jogador.getNome() + ", ");
            jogador.setPeca(criarPeca());
        }

        Tabuleiro.defineOrdem();
        Tabuleiro.montarCasas();
        ArrayList<Carta> casasTabuleiro = Tabuleiro.getCasasTabuleiro();

        ArrayList<Jogador> jogadores = Tabuleiro.getOrdem();
        ArrayList<Propriedade> propriedades = Tabuleiro.getPropriedades();
        int tamanhoTabuleiro = Tabuleiro.getQuantidadeCasas();

        while (true) {
            Jogador jogadorAtual = Tabuleiro.jogadorAtual();

            System.out.println("--- ORDEM DOS JOGADORES ---");
            for(Jogador jogador : Tabuleiro.getOrdem()) {
                if (jogador == Tabuleiro.jogadorAtual()) {
                    System.out.println("-> " + jogador.getNome());
                } else {
                    System.out.println(jogador.getNome());
                }
            }
            System.out.println("""
                    --- OPÇÕES ---
                    [1] Ver informações dos jogadores
                    [2] Ver propriedades do banco
                    [3] Rolar dados
                    [0] Desistir do jogo
                    """);

            String opcao1 = input.nextLine().trim();
            switch (opcao1) {
                case "1":
                    System.out.println("--- JOGADORES ---\n");
                    System.out.println("[1] Geral");
                    int i;
                    for (i = 0; i < jogadores.size(); i++) {
                        System.out.println("[" + (i+2) + "] " + jogadores.get(i).getNome());
                    }
                    System.out.println("[0] Voltar\n\n");

                    int jogInfos = Integer.parseInt(Validacao.receberEntrada("", "int"));
                    if (jogInfos == 1) {
                        System.out.println(Tabuleiro.infos());
                    } else if (jogInfos > 1 && jogInfos <= i+1) {
                        System.out.println(jogadores.get(jogInfos-2) + "\n");

                        if (!jogadores.get(jogInfos-2).getCartas().isEmpty()) {
                            System.out.println("--- PROPRIEDADES ---");
                            for (Carta propJogInfos : jogadores.get(jogInfos - 2).getCartas()) {
                                if (propJogInfos.getClass() != CartaSorte.class) {
                                    System.out.println(propJogInfos + "\n");
                                }
                            }
                        }
                    } else if (jogInfos > i+1){
                        System.err.println("Entrada inválida, tente novamente.");
                    }
                    break;

                case "2":
                    for (Propriedade prop : propriedades){
                        if (prop.getDono() == null) {
                            System.out.println(prop + "\n");
                        }
                    }
                    break;

                case "3":
                    int dados = Dados.rolarDados();

                    if (jogadorAtual.getRodadasSemJogar() == 0) {

                        int posicao = jogadorAtual.getPeca().getPosicao() + dados;
                        if (posicao >= tamanhoTabuleiro) {
                            System.out.println(jogadorAtual.getNome() + " passou pelo início e ganhou R$ 100");
                            jogadorAtual.aumentarSaldo(100);
                        }
                        posicao %= tamanhoTabuleiro;

                        jogadorAtual.getPeca().setPosicao(posicao);

                        Carta casaAtual = casasTabuleiro.get(posicao);

                        if (Validacao.isPropriedade(casaAtual)) {
                            Propriedade propriedadeAtual = (Propriedade) casaAtual;

                            if (propriedadeAtual.getDono() == null) {
                                System.out.print(jogadorAtual.getNome() + " caiu em " + propriedadeAtual.getNome() + "\n" +
                                        propriedadeAtual + "\n" +
                                        "\nDeseja comprar?\n" +
                                        "[0] Não\n" +
                                        "[1] Sim\n\n");

                                int escolha = Integer.parseInt(Validacao.receberEntrada("", "int"));
                                if (escolha == 1) {
                                    if (jogadorAtual.comprarPropriedade(propriedadeAtual)) {
                                        System.out.println(propriedadeAtual + "\n");
                                    } else {
                                        System.out.println("Saldo insuficiente.");
                                    }
                                }

                            } else if (propriedadeAtual.getDono() == jogadorAtual) {
                                System.out.println(jogadorAtual.getNome() + " caiu em " + propriedadeAtual.getNome() + "\n" +
                                        propriedadeAtual);
                                if (Validacao.isTerreno(propriedadeAtual)) {
                                    Terreno terrenoAtual = (Terreno) propriedadeAtual;
                                    System.out.print("""

                                            [0] Passar a vez
                                            [1] Comprar casa
                                            [2] Comprar hotel

                                            """);

                                    int escolha = Integer.parseInt(Validacao.receberEntrada("", "int"));
                                    switch (escolha) {
                                        case 1:
                                            if (terrenoAtual.comprarCasa(jogadorAtual)) {
                                                System.out.println("Casa comprada com sucesso.");
                                            } else {
                                                System.out.println("Não foi possível comprar a casa.");
                                            }
                                            break;

                                        case 2:
                                            if (terrenoAtual.comprarHotel(jogadorAtual)) {
                                                System.out.println("Hotel comprado com sucesso.");
                                            } else {
                                                System.out.println("Não foi possível comprar o hotel.");
                                            }
                                            break;

                                        case 0:

                                        default:
                                            break;
                                    }
                                }

                            } else if (propriedadeAtual.getDono() != jogadorAtual) {
                                System.out.print(jogadorAtual.getNome() + " caiu em " + propriedadeAtual.getNome() + "\n" +
                                        propriedadeAtual + "\n" +
                                        "\n[1] Tentar comprar\n" +
                                        "[2] Pagar aluguel\n\n");

                                int escolha = Integer.parseInt(Validacao.receberEntrada("", "int"));
                                switch (escolha) {
                                    case 1:
                                        Jogador dono = propriedadeAtual.getDono();
                                        System.out.println(dono.getNome() + " deseja vender?" + "\n" +
                                                "\n[0] Não\n" +
                                                "[1] Sim\n\n");

                                        int decisao = Integer.parseInt(Validacao.receberEntrada("", "int"));
                                        if (decisao == 1) {
                                            int preco = Integer.parseInt(Validacao.receberEntrada("Por qual preço deseja vender?\n", "int"));
                                            if (jogadorAtual.diminuirSaldo(preco)) {
                                                dono.aumentarSaldo(preco);
                                                dono.getCartas().remove(propriedadeAtual);
                                                propriedadeAtual.setDono(jogadorAtual);
                                                jogadorAtual.getCartas().add(propriedadeAtual);
                                                System.out.println(propriedadeAtual + "\n");
                                            } else {
                                                System.out.println("Saldo insuficiente.");
                                                if (jogadorAtual.pagarAluguel(propriedadeAtual)) {
                                                    System.out.println("Aluguel de R$ " + propriedadeAtual.calcularAluguel() + " pago a " + propriedadeAtual.getDono().getNome());
                                                } else {
                                                    System.out.println(jogadorAtual.getNome() + " não possui dinheiro suficiente e faliu.");
                                                    Tabuleiro.falirJogador(jogadorAtual, propriedadeAtual);
                                                }
                                            }
                                        } else {
                                            if (jogadorAtual.pagarAluguel(propriedadeAtual)) {
                                                System.out.println("Aluguel de R$ " + propriedadeAtual.calcularAluguel() + " pago a " + propriedadeAtual.getDono().getNome());
                                            } else {
                                                System.out.println(jogadorAtual.getNome() + " não possui dinheiro suficiente e faliu.");
                                                Tabuleiro.falirJogador(jogadorAtual, propriedadeAtual);
                                            }
                                        }
                                        break;

                                    case 2:

                                    default:
                                        if (jogadorAtual.pagarAluguel(propriedadeAtual)) {
                                            System.out.println("Aluguel de R$ " + propriedadeAtual.calcularAluguel() + " pago a " + propriedadeAtual.getDono().getNome());
                                        } else {
                                            System.out.println(jogadorAtual.getNome() + " não possui dinheiro suficiente e faliu.");
                                            Tabuleiro.falirJogador(jogadorAtual, propriedadeAtual);
                                        }
                                        break;
                                }
                            }
                        } else if (casaAtual.equals(Tabuleiro.ferias)) {
                            System.out.println(jogadorAtual.getNome() + " tirou férias.");
                            jogadorAtual.setRodadasSemJogar(2);
                        } else if (casaAtual.equals(Tabuleiro.sorteReves)) {
                            System.out.println(jogadorAtual.getNome() + " vai testar a sorte.");
                            CartaSorte carta = Tabuleiro.distribuirCartas();

                            System.out.println(jogadorAtual.getNome() + " tirou a carta:\n" +
                                    carta.getDescricao());

                            carta.executaAcao(jogadorAtual);
                            Tabuleiro.addCartaSorte(carta);
                        }
                    } else {
                        System.out.println("Se o valor dos dados for igual, você joga de novo." +
                                "\nDado 1: " + Dados.getValorDado1() +
                                "\nDado 2: " + Dados.getValorDado2());
                        jogadorAtual.setRodadasSemJogar(jogadorAtual.getRodadasSemJogar()-1);
                        if (Dados.getValorDado1() == Dados.getValorDado2()) {
                            jogadorAtual.setRodadasSemJogar(0);
                            break;
                        }
                    }
                    Tabuleiro.proxJogador();
                    break;

                case "0":
                    System.out.println("""
                            Tem certeza que deseja abandonar a partida?
                            [0] Não
                            [1] Sim
                            """);

                    int confirmacao = Integer.parseInt(Validacao.receberEntrada("", "int"));
                    if (confirmacao == 1) {
                        Tabuleiro.removeJogador(Tabuleiro.jogadorAtual());
                    }
                    break;

                default:
                    System.err.println("Entrada inválida, tente novamente.");
                    break;
            }

            if (Tabuleiro.verificaVencedor() != null){
                Jogador vencedor = Tabuleiro.verificaVencedor();
                System.out.println("Parabéns " + vencedor.getNome() + " você venceu!");
                Tabuleiro.salvaLog("log.txt", vencedor);
                break;
            }
        }
    }
}
