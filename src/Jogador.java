import java.util.ArrayList;

public class Jogador {
    private int id;
    private static int numeroJogadores = 0;
    private int dinheiro = 2458;
    private String nome;
    private String cpf;
    private String email;
    private String foto;
    private ArrayList<Carta> cartas = new ArrayList<Carta>();
    private Peca peca = null;
    private int rodadasSemJogar = 0;

    // Método Construtor
    public Jogador(String nome, String cpf, String email, String foto) {
        this.id = numeroJogadores++;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.foto = foto;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public ArrayList<Carta> getCartas(){
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas){
        this.cartas = cartas;
    }

    public Peca getPeca(){
        return peca;
    }

    public void setPeca(Peca peca){
        this.peca = peca;
    }

    public int getRodadasSemJogar() {
        return rodadasSemJogar;
    }

    public void setRodadasSemJogar(int rodadasSemJogar) {
        this.rodadasSemJogar = rodadasSemJogar;
    }

    /* Método addCarta
                    Adiciona uma carta ao array do jogador
                */
    public void addCarta(Carta carta){
        cartas.add(carta);
    }

    /* Método removeCarta
        Remove carta do array do jogador se ela existir
    */
    public boolean removeCarta(Carta carta){
        return cartas.remove(carta);
    }

    public void aumentarSaldo(int valor) {
        setDinheiro(dinheiro + valor);
    }

    public boolean diminuirSaldo(int valor) {
        if (dinheiro >= valor) {
            setDinheiro(dinheiro - valor);
            return true;
        }
        return false;
    }

    public boolean comprarPropriedade(Propriedade propriedade) {
        if (diminuirSaldo(propriedade.getPreco())) {
            propriedade.setDono(this);
            addCarta(propriedade);
            return true;
        }
        return false;
    }

    public boolean pagarAluguel(Propriedade propriedade) {
        if (diminuirSaldo(propriedade.calcularAluguel())) {
            propriedade.getDono().aumentarSaldo(propriedade.calcularAluguel());
            return true;
        }
        return false;
    }

    /* Método toString
        Retorna uma string contendo os dados do jogador
    */
    public String toString() {
        if (peca == null) {
            return "Nome: " + this.nome + "\n" +
                    "CPF: " + this.cpf + "\n" +
                    "Email: " + this.email + "\n" +
                    "ID do jogador: " + this.id;
        } else {
            return  "Nome: " + this.nome + "\n" +
                    "ID do jogador: " + this.id + "\n" +
                    "Cor da peça do jogador: " + this.peca.getCor() + "\n" +
                    "Posição no tabuleiro: " + this.peca.getPosicao() + "\n" +
                    "Saldo do jogador: " + this.getDinheiro();
        }
    }
}
