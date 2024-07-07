import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Tabuleiro implements Salvavel{
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

    /**
     * Retorna as informações gerais da partida.
     *  - Jogadores
     *  - Propriedades e seus respectivos donos
     * @return infos - String com as informações da partida
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

    /**
     * Adiciona um jogador ao tabuleiro.
     * @param jogador - jogador a ser adicionado
     * @return boolean - retorna se o jogador foi adicionado ou não
     */
    public static boolean addJogador(Jogador jogador) {
        if (jogadores.size() < 6 && !jogadores.contains(jogador)) {
            jogadores.add(jogador);
            return true;
        }
        return false;
    }

    /**
     * Remove um jogador do tabuleiro.
     * @param jogador - jogador a ser removido
     * @return boolean - retorna se o jogador foi removido ou não
     */
    public static boolean removeJogador(Jogador jogador){
        return ordem.remove(jogador);
    }

    /**
     * Adiciona uma propriedade ao tabuleiro.
     * @param propriedade - propriedade a ser adicionada
     * @return boolean - retorna se a propriedade foi adicionada ou não
     */
    public static boolean addPropriedade(Propriedade propriedade) {
        if (propriedades.size() < 28 && !propriedades.contains(propriedade)) {
            propriedades.add(propriedade);
            return true;
        }
        return false;
    }

    /**
     * Remove uma propriedade do tabuleiro.
     * @param propriedade - propriedade a ser removida
     * @return boolean - retorna se a propriedade foi removida ou não
     */
    public static boolean removePropriedade(Propriedade propriedade) {
        return propriedades.remove(propriedade);
    }

    /**
     * Adiciona uma carta de sorte ao tabuleiro.
     * @param carta - carta a ser adicionada
     * @return boolean - retorna se a carta foi adicionada ou não
     */
    public static boolean addCartaSorte(CartaSorte carta) {
        if (cartasSorte.size() < 30 && !cartasSorte.contains(carta)) {
            cartasSorte.add(carta);
            return true;
        }
        return false;
    }

    /**
     * Remove uma carta de sorte do tabuleiro.
     * @param carta - carta a ser removida
     * @return boolean - retorna se a carta foi removida ou não
     */
    public static boolean removeCartaSorte(CartaSorte carta) {
        return cartasSorte.remove(carta);
    }


    /**
     * Posiciona todas as propriedades no tabuleiro.
     * Para cada propriedade, há umma casa de Sorte ou Revés.
     * Adiciona a casa Início no começo e a casa Férias no meio.
     */
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

    /**
     * Sorteia a ordem dos jogadores.
     */
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

    /**
     * Retorna o jogador atual.
     * @return jogadorAtual - objeto da classe Jogador
     */
    public static Jogador jogadorAtual() {
        return ordem.get(indiceAtual);
    }

    /**
     * Lógica para atualizar o índice atual da ordem.
     */
    public static void proxJogador() {
        int quantidadeJogadores = ordem.size();
        int indiceMax = quantidadeJogadores - 1;
        if (indiceAtual == indiceMax){
            indiceAtual = 0;
            return;
        }
        ++indiceAtual;
    }

    /**
     * Retorna a carta do topo do baralho embaralhado.
     * @return cartaSorteada - objeto da classe CartaSorte
     */
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

    /**
     * Transfere o saldo do jogador falido por completo ao dono da propriedade.
     * Transfere todas suas propriedades de volta ao banco e cartas de sorte de volta ao baralho.
     * @param jogador - jogador que faliu
     * @param propriedade - propriedade em que o jogador caiu antes de falir
     */
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

    /**
     * Verifica se existe só um jogador na partida ou se um jogador possui todas as propriedades.
     * @return vencedor - objeto da classe Jogador
     */
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

    /**
     * Salva as informações da partida em um arquivo de texto log.txt.
     * @param arquivo - caminho do arquivo
     * @param vencedor - jogador que venceu a partida
     * @throws IOException
     */
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
