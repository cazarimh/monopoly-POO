import java.util.ArrayList;
import java.util.Arrays;

public class Tabuleiro {
    private static ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
    private static ArrayList<Propriedade> propriedades = new ArrayList<Propriedade>();

    // Métodos Getters
    public static ArrayList<Jogador> getJogadores(){
        return jogadores;
    }

    public static ArrayList<Propriedade> getPropriedades(){
        return propriedades;
    }

    public static int getQuantidadeJogadores() {
        return jogadores.size();
    }

    public static int getQuantidadePropriedades() {
        return propriedades.size();
    }

    /* Método infos
        Retorna informações da partida:
            Todos os jogadores no tabuleiro
            Todas as propriedades no tabuleiro
    */
    public static String infos(){
        String infos = "--- JOGADORES ---\n";
        for (Jogador jogador : jogadores){
            infos += jogador + "\n";
        }

        infos += "--- PROPRIEDADES ---\n";
        for (Propriedade propriedade : propriedades){
            infos += propriedade + "\n";
        }

        return infos;
    }

    /* Método addJogador
        Retorna true se há menos de 6 jogadores na partida e se o jogador a ser adicionado nao foi adicionado ainda
        Caso contrário, retorna false
    */
    public static boolean addJogador(Jogador jogador){
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
        return jogadores.remove(jogador);
    }

    /* Método addPropriedade
        Retorna true se há menos de 28 propriedades na partida e se a propriedade a ser adicionado nao foi adicionada ainda
        Caso contrário, retorna false
    */
    public static boolean addPropriedade(Propriedade propriedade){
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
    public static boolean removePropriedade(Propriedade propriedade){
        return propriedades.remove(propriedade);
    }
}
