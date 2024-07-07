public class CartaSorte extends Carta{
    private int movimento;
//    private int efeito; PARAMETRO SUBSTITUIDO PELO TIPO DA CARTA
    private int valor;
    private String acao;
    private int tempo;
    private String restricao;
    private TipoCarta tipo;

    // Método Construtor
    public CartaSorte(String descricao, int movimento,/* int efeito,*/ int valor, String acao, int tempo, String restricao, TipoCarta tipo){
        super(descricao);
        this.movimento = movimento;
        /*this.efeito = efeito;*/
        this.valor = valor;
        this.acao = acao;
        this.tempo = tempo;
        this.restricao = restricao;
        this.tipo = tipo;
    }

    // Métodos Getters e Setters
    public int getMovimento() {
        return movimento;
    }

    public void setMovimento(int movimento) {
        this.movimento = movimento;
    }

    /*public int getEfeito() {
        return efeito;
    }

    public void setEfeito(int efeito) {
        this.efeito = efeito;
    }*/

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public String getRestricao() {
        return restricao;
    }

    public void setRestricao(String restricao) {
        this.restricao = restricao;
    }

    public void setTipo(TipoCarta tipo) {
        this.tipo = tipo;
    }

    public TipoCarta getTipo() {
        return tipo;
    }

    public void executaAcao(Jogador jogador) {
        if (movimento == 0) {
            if (tipo == TipoCarta.SORTE) {
                jogador.aumentarSaldo(valor);
            } else {
                jogador.diminuirSaldo(valor);
            }
        } else if (movimento == 2) {
            jogador.getPeca().setPosicao(Tabuleiro.getCasasTabuleiro().indexOf(Tabuleiro.ferias));
            jogador.setRodadasSemJogar(2);
        }
    }
}
