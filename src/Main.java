import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//      Instanciação de objeto da classe Jogador

        Scanner input = new Scanner(System.in);

        String nome = input.nextLine();
        String cpf = input.nextLine();
        String foto = input.nextLine();
        String email = input.nextLine();

        Jogador player1;
        player1 = new Jogador(nome, cpf, foto, email);

        Tabuleiro.addJogador(player1.getId());
        Tabuleiro.removeJogador(player1.getId()); // apenas para teste
        Tabuleiro.addJogador(player1.getId());

        if (Validacao.validarCPF(player1.getCpf()) && Validacao.validarEmail(player1.getEmail())){
            System.out.println("CPF e Email válidos.\n");
        } else {
            System.out.println("CPF e/ou Email cadastrado(s) inválido(s).\n");
        }

        System.out.println(player1 + "\n");

//      -------------------------------------------------------------------------------------------
//      Instanciação de objetos das classes Terreno, ServicoPublico e Estacao

        Terreno saoPaulo, rioDeJaneiro;
        saoPaulo = new Terreno("São Paulo", 300, 40, 18, 26);
        rioDeJaneiro = new Terreno("Rio de Janeiro", 250, 36, 15, 30);

        Tabuleiro.addPropriedade(saoPaulo.getId());
        Tabuleiro.addPropriedade(rioDeJaneiro.getId());

        ServicoPublico ciaDeAgua, ciaDeLuz;
        ciaDeAgua = new ServicoPublico("Companhia de Água", 150, 15);
        ciaDeLuz = new ServicoPublico("Companhia de Luz", 120, 10);

        Tabuleiro.addPropriedade(ciaDeAgua.getId());
        Tabuleiro.addPropriedade(ciaDeLuz.getId());

        Estacao estLuz, estItaquera;
        estLuz = new Estacao("Estação da Luz", 200, 25);
        estItaquera = new Estacao("Estação Corinthians-Itaquera", 200, 25);

        Tabuleiro.addPropriedade(estLuz.getId());
        Tabuleiro.addPropriedade(estItaquera.getId());

        Tabuleiro.removePropriedade(rioDeJaneiro.getId());
        Tabuleiro.removePropriedade(ciaDeAgua.getId());

//      -------------------------------------------------------------------------------------------

        if (Tabuleiro.estaNoTabuleiro(player1) && Tabuleiro.estaNoTabuleiro(saoPaulo)){

            // comprando terreno
            if (player1.getDinheiro() >= saoPaulo.getPreco()){
                int saldo = player1.getDinheiro() - saoPaulo.getPreco();
                player1.setDinheiro(saldo);
                saoPaulo.setProprietario(player1.getId());
            }

            // comprando casas e hotel
            if (player1.getId() == saoPaulo.getProprietario()) {
                if (player1.getDinheiro() >= (4 * saoPaulo.getValorCasa() + saoPaulo.getValorHotel())) {
                    int saldo = player1.getDinheiro() - (4 * saoPaulo.getValorCasa() + saoPaulo.getValorHotel());
                    player1.setDinheiro(saldo);
                    saoPaulo.comprarCasa();
                    saoPaulo.setNumeroCasas(4);
                    saoPaulo.comprarHotel();
                }
            }
        }

        // Testando os métodos toString
        System.out.println(saoPaulo + "\n");
        System.out.println(rioDeJaneiro + "\n");

        if (player1.getDinheiro() >= ciaDeLuz.getPreco()) {
            ciaDeLuz.setProprietario(player1.getId());
        }
        System.out.println(ciaDeLuz + "\n");
        System.out.println(ciaDeAgua + "\n");

        if (player1.getDinheiro() >= estItaquera.getPreco()) {
            estItaquera.setProprietario(player1.getId());
        }
        System.out.println(estItaquera + "\n");
        System.out.println(estLuz + "\n");

        System.out.println(Tabuleiro.infos());

//      -------------------------------------------------------------------------------------------
//      Instanciação de objetos das classes Peca e CartaSorte

        Peca peca1;
        peca1 = new Peca("Preto", 0);

        CartaSorte carta1;
        carta1 = new CartaSorte(1, "Incêndio", 0,
                -1, 35000, "", 0, "");
    }
}
