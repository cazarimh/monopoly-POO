public class Carta {
    private int id;
    private static int numeroCartas = 0;
    private String descricao;
    private Jogador dono = null;

    // Método Construtor
    public Carta(String descricao) {
        this.id = numeroCartas++;
        this.descricao = descricao;
    }

    // Métodos Getters e Setters
    public static int getNumeroCartas(){
        return numeroCartas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Jogador getDono() {
        return dono;
    }

    public void setDono(Jogador dono) {
        this.dono = dono;
    }
}
