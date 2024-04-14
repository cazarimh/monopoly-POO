public class Tabuleiro {
    private static int[] jogadores = {0, 0, 0, 0, 0, 0};
    private static int quantidadeJogadores = 0;
    private static int[] propriedades = new int[28];
    private static int quantidadePropriedades = 0;

    /* Método infos
        Retorna a quantidade de jogadores e propriedades na partida
    */
    public static String infos(){
        return quantidadeJogadores + "/6 jogador(es) cadastrado(s).\n" + quantidadePropriedades + "/28 propriedade(s) cadastrada(s).";
    }

    /* Método addJogador
        Retorna true se há menos de 6 jogadores na partida e se o jogador a ser adicionado nao foi adicionado ainda
        Caso contrário, retorna false
    */
    public static boolean addJogador(int id){
        int indice = buscaId(id, jogadores);
        if (indice == -1) {
            if (quantidadeJogadores < 6) {
                jogadores[quantidadeJogadores] = id;
                quantidadeJogadores++;
                return true;
            }
        }
        return false;
    }

    /* Método removeJogador
        Retorna true se o jogador a ser removido estiver na partida, após isso, organiza a lista para que os espaços vazios fiquem no final
        Caso contrário, retorna false
    */
    public static boolean removeJogador(int id){
        int indice = buscaId(id, jogadores);
        if (indice != -1){
            jogadores[indice] = 0;
            if (indice < 5 && jogadores[indice + 1] != 0){
                Tabuleiro.organizarLista(indice, jogadores);
            }
            quantidadeJogadores--;
            return true;
        }
        return false;
    }

    /* Método addPropriedade
        Retorna true se há menos de 28 propriedades na partida e se a propriedade a ser adicionado nao foi adicionada ainda
        Caso contrário, retorna false
    */
    public static boolean addPropriedade(int id){
        int indice = buscaId(id, propriedades);
        if (indice == -1) {
            if (quantidadePropriedades < 28) {
                propriedades[quantidadePropriedades] = id;
                quantidadePropriedades++;
                return true;
            }
        }
        return false;
    }

    /* Método removePropriedade
        Retorna true se a propriedade a ser removida estiver na partida, após isso, organiza a lista para que os espaços vazios fiquem no final
        Caso contrário, retorna false
    */
    public static boolean removePropriedade(int id){
        int indice = buscaId(id, propriedades);
        if (indice != -1){
            propriedades[indice] = 0;
            if (indice < 27 && propriedades[indice + 1] != 0){
                Tabuleiro.organizarLista(indice, propriedades);
            }
            quantidadePropriedades--;
            return true;
        }
        return false;
    }

    /* Método estaNoTabuleiro
        Retorna true se o jogador a ser buscado estiver na partida
        Caso contrário, retorna false
    */
    public static boolean estaNoTabuleiro(Jogador jogador){
        return buscaId(jogador.getId(), jogadores) != -1;
    }

    /* Método estaNoTabuleiro
        Retorna true se a propriedade a ser buscada estiver na partida
        Caso contrário, retorna false
    */
    public static boolean estaNoTabuleiro(Propriedade propriedade){
        return buscaId(propriedade.getId(), propriedades) != -1;
    }

    /* Método buscaId
        Retorna o indice do id buscado
        Caso não esteja na partida, retorna -1
    */
    private static int buscaId(int id, int...lista){
        for (int i = 0; i < lista.length; i++){
            if (lista[i] == id){
                return i;
            }
            if (lista[i] == 0){
                break;
            }
        }
        return -1;
    }

    /* Método organizarLista
        Método recursivo para organizar a lista a fim de manter os espaços vazios no final
    */
    private static void organizarLista(int indice, int...lista){
        lista[indice] = lista[indice + 1];
        lista[++indice] = 0;
        if (indice < (lista.length - 1) && lista[indice + 1] != 0){
            organizarLista(indice, lista);
        }
    }
}
