public class Peca {
    private String cor;
    private int posicao;

    // Método Construtor
    public Peca(String cor, int posicao){
        this.cor = cor;
        this.posicao = posicao;
    }

    // Métodos Getters e Setters
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
}
