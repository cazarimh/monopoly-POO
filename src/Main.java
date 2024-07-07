import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        /*Instanciação de objetos para testes*/
        Jogador henrique = new Jogador("Henrique", "146.026.894-69", "henrique@email.com", "henrique.png");
        Jogador duda = new Jogador("Maria Eduarda", "123.782.201-70", "duda@email.com", "duda.png");

        ServicoPublico cpfl = new ServicoPublico("CPFL", "Companhia Paulista de Força e Luz", 120, 20);
        Estacao corinthians = new Estacao("Estação Corinthians-Itaquera", "Estação da linha 3 vermelha da zona leste de São Paulo", 150, 15);
        Terreno saoPaulo = new Terreno("São Paulo", "Capital do estado de São  Paulo", 220, 40, 15, 20);

        CartaSorte cartaDeSorte = new CartaSorte("Seu barco afundou! Mas possuía seguro, receba a apólice.", 0, 25, "Receba 25 mil do banco.", 0, "", TipoCarta.SORTE);
        CartaSorte cartaDeAzar = new CartaSorte("Você tirou férias e foi viajar.", 2, 0, "Vá imediatamente para Férias", 0, "", TipoCarta.REVES);

        Tabuleiro.addJogador(henrique);
        Tabuleiro.addJogador(duda);

        Tabuleiro.addPropriedade(cpfl);
        Tabuleiro.addPropriedade(corinthians);
        Tabuleiro.addPropriedade(saoPaulo);

        Tabuleiro.addCartaSorte(cartaDeSorte);
        Tabuleiro.addCartaSorte(cartaDeAzar);

        Menu.menuInicial();
    }
}
