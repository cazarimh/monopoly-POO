public class Jogador {
    private int id;
    private static int numeroJogadores = 0;
    private int dinheiro = 2458;
    private String nome;
    private String cpf;
    private String foto;
    private String email;

    // Método Construtor
    public Jogador(String nome, String cpf, String foto, String email){
        this.id = ++numeroJogadores;
        this.nome = nome;
        this.cpf = cpf;
        this.foto = foto;
        this.email = email;
    }

    // Métodos Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /* Método toString
        Retorna uma string contendo os dados do jogador
    */
    public String toString(){
        return "Nome: " + getNome() + "\n" +
                "CPF: " + getCpf() + "\n" +
                "Email: " + getEmail() + "\n" +
                "ID do jogador: " + getId();
    }
}
