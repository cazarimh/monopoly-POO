import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Tabuleiro {
    private static Random gerador = new Random();

    public static final Carta inicio = new Carta("Início");
    public static final Carta ferias = new Carta("Férias");
    public static final Carta sorteReves = new Carta("Sorte ou Revés");

    private static ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
    private static ArrayList<Propriedade> propriedades = new ArrayList<Propriedade>();
    private static ArrayList<CartaSorte> cartasSorte = new ArrayList<CartaSorte>();
    private static ArrayList<Carta> casasTabuleiro = new ArrayList<Carta>();

    /* CASAS DO TABULEIRO
    *
    *     inicio   -     prop1      -   ferias
    *       |                             |
    *     prop3    -   sorte/azar   -   prop2
    *
    *
    */

    private static ArrayList<Jogador> ordem = new ArrayList<Jogador>();
    private static int indiceAtual = 0;

    // Métodos Getters
    public static ArrayList<Jogador> getJogadores(){
        return jogadores;
    }

    public static ArrayList<Propriedade> getPropriedades(){
        return propriedades;
    }

    public static ArrayList<CartaSorte> getCartasSorte() {
        return cartasSorte;
    }

    public static ArrayList<Carta> getCasasTabuleiro(){
        return casasTabuleiro;
    }

    public static int getQuantidadeJogadores() {
        return jogadores.size();
    }

    public static int getQuantidadePropriedades() {
        return propriedades.size();
    }

    public static int getQuantidadeCartasSorte() {
        return cartasSorte.size();
    }

    public static int getQuantidadeCasas() {
        return casasTabuleiro.size();
    }

    public static int getValorDados(){
        return Dados.getUltimaSomaDados();
    }

    public static ArrayList<Jogador> getOrdem(){
        return ordem;
    }

    /* Método infos
        Retorna informações da partida:
            Todos os jogadores no tabuleiro
            Todas as propriedades no tabuleiro
    */
    public static String infos(){
        String infos = "--- JOGADORES ---\n";
        for (Jogador jogador : jogadores){
            infos += jogador + "\n\n";
        }

        infos += "--- PROPRIEDADES ---\n";
        for (Propriedade propriedade : propriedades){
            infos += propriedade + "\n\n";
        }

        return infos;
    }

    /* Método addJogador
        Retorna true se há menos de 6 jogadores na partida e se o jogador a ser adicionado nao foi adicionado ainda
        Caso contrário, retorna false
    */
    public static boolean addJogador(Jogador jogador) {
        if (jogadores.size() < 6 && !jogadores.contains(jogador)) {
            jogadores.add(jogador);
            return true;
        }
        return false;
    }

    /* Método removeJogador
        Retorna true se o jogador a ser removido estiver na partida
        Caso contrário, retorna false
    */
    public static boolean removeJogador(Jogador jogador){
        return ordem.remove(jogador);
    }

    /* Método addPropriedade
        Retorna true se há menos de 28 propriedades na partida e se a propriedade a ser adicionado nao foi adicionada ainda
        Caso contrário, retorna false
    */
    public static boolean addPropriedade(Propriedade propriedade) {
        if (propriedades.size() < 28 && !propriedades.contains(propriedade)) {
            propriedades.add(propriedade);
            return true;
        }
        return false;
    }

    /* Método removePropriedade
        Retorna true se a propriedade a ser removida estiver na partida
        Caso contrário, retorna false
    */
    public static boolean removePropriedade(Propriedade propriedade) {
        return propriedades.remove(propriedade);
    }

    /* Método addCartaSorte
        Retorna true se há menos de 30 cartas de sorte na partida e se a carta a ser adicionado nao foi adicionada ainda
        Caso contrário, retorna false
    */
    public static boolean addCartaSorte(CartaSorte carta) {
        if (cartasSorte.size() < 30 && !cartasSorte.contains(carta)) {
            cartasSorte.add(carta);
            return true;
        }
        return false;
    }

    /* Método removeCartaSorte
        Retorna true se a carta a ser removida estiver na partida
        Caso contrário, retorna false
    */
    public static boolean removeCartaSorte(CartaSorte carta) {
        return cartasSorte.remove(carta);
    }

    public static void montarCasas() {
        casasTabuleiro.add(inicio);

        ArrayList<Propriedade> listaAux = new ArrayList<>(propriedades);
        int propriedadesParaSortear = listaAux.size();
        while (propriedadesParaSortear != 0) {
            int indice = gerador.nextInt(0, propriedadesParaSortear);
            Propriedade prop = listaAux.get(indice);
            casasTabuleiro.add(prop);
            listaAux.remove(prop);
            casasTabuleiro.add(sorteReves);
            propriedadesParaSortear--;
        }

        casasTabuleiro.add(casasTabuleiro.size()/2, ferias);
    }

    public static void defineOrdem() {
        ArrayList<Jogador> listaAux = new ArrayList<>(jogadores);
        int jogadoresParaSortear = listaAux.size();
        while (jogadoresParaSortear != 0) {
            int indice = gerador.nextInt(0, jogadoresParaSortear);
            Jogador jogadorSorteado = listaAux.get(indice);
            ordem.add(jogadorSorteado);
            listaAux.remove(jogadorSorteado);
            jogadoresParaSortear--;
        }
    }

    public static Jogador jogadorAtual() {
        return ordem.get(indiceAtual);
    }

    public static Jogador proxJogador() {
        int quantidadeJogadores = ordem.size();
        int indiceMax = quantidadeJogadores - 1;
        if (indiceAtual == indiceMax){
            indiceAtual = 0;
            return ordem.get(indiceAtual);
        }
        return ordem.get(++indiceAtual);
    }

    public static CartaSorte distribuirCartas() {
        ArrayList<CartaSorte> listaAux = new ArrayList<>(cartasSorte);
        ArrayList<CartaSorte> cartasEmbaralhadas = new ArrayList<CartaSorte>();
        int cartasParaEmbaralhar = listaAux.size();
        while (cartasParaEmbaralhar != 0) {
            int indice = gerador.nextInt(0, cartasParaEmbaralhar);
            CartaSorte carta = listaAux.get(indice);
            cartasEmbaralhadas.add(carta);
            listaAux.remove(carta);
            cartasParaEmbaralhar--;
        }
        removeCartaSorte(cartasEmbaralhadas.getFirst());
        return cartasEmbaralhadas.getFirst();
    }

    public static void falirJogador(Jogador jogador, Propriedade propriedade) {
        int saldo = jogador.getDinheiro();
        ArrayList<Carta> cartas = jogador.getCartas();

        for(Carta carta : cartas) {
            if (Validacao.isPropriedade(carta)) {
                Propriedade propriedadeAtual = (Propriedade) carta;
                propriedadeAtual.setDono(null);
            } else {
                CartaSorte cartaSorteAtual = (CartaSorte) carta;
                cartaSorteAtual.setDono(null);
                Tabuleiro.addCartaSorte(cartaSorteAtual);
            }
            jogador.removeCarta(carta);
        }

        propriedade.getDono().aumentarSaldo(saldo);
    }

    public static Jogador verificaVencedor() {
        if (ordem.size() == 1) {
            return ordem.getFirst();
        } else {
            Jogador jogador = propriedades.getFirst().getDono();
            for (Propriedade propriedade : propriedades) {
                if (jogador!= null && !jogador.equals(propriedade.getDono())) {
                    return null;
                }
            }
            return jogador;
        }
    }

    public static void salvaLog(String arquivo, Jogador vencedor) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            writer.write(Tabuleiro.infos());
            writer.write("Vencedor: " + vencedor.getNome());
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
