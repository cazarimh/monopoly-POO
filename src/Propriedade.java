public class Propriedade {
    private int id;
    private static int numeroPropriedades = 0;
    private String nome;
    private int proprietario = 0;
    private int preco;
    private int aluguel;

    // Método Construtor
    public Propriedade(String nome, int preco, int aluguel){
        this.id = ++numeroPropriedades;
        this.nome = nome;
        this.preco = preco;
        this.aluguel = aluguel;
    }

    // Métodos Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getProprietario() {
        return proprietario;
    }

    public void setProprietario(int idProprietario) {
        this.proprietario = idProprietario;
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

    /* Método calcularAluguel
        Retorna o aluguel
    */
    public int calcularAluguel(){
        return aluguel;
    }
}
