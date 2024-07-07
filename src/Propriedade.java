public abstract class Propriedade extends Carta{
    private String nome;
    private int preco;
    private int aluguel;

    // Método Construtor
    public Propriedade(String nome, String descricao, int preco, int aluguel){
        super(descricao);
        this.nome = nome;
        this.preco = preco;
        this.aluguel = aluguel;
    }

    // Métodos Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getAluguel() {
        return aluguel;
    }

    public void setAluguel(int aluguel) {
        this.aluguel = aluguel;
    }

    /**
     * Método abstrato para implementação nas classes herdeiras.
     */
    public abstract int calcularAluguel();
}
