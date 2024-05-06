public class Peca {
    private String cor;
    private int posicao = 0;

    // Método Construtor
    public Peca(String cor){
        this.cor = cor;
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
