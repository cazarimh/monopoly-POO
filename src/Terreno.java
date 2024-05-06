public class Terreno extends Propriedade{
    private int numeroCasas = 0;
    private int valorCasa;
    private int valorHotel;
    private boolean hotel = false;

    // Método Construtor
    public Terreno(String nome, String descricao, int preco, int aluguel, int valorCasa, int valorHotel){
        super(nome, descricao, preco, aluguel);
        this.valorCasa = valorCasa;
        this.valorHotel = valorHotel;
    }

    // Métodos Getters e Setters
    public int getNumeroCasas(){
        return numeroCasas;
    }

    public void setNumeroCasas(int numeroCasas){
        this.numeroCasas = numeroCasas;
    }

    public int getValorCasa(){
        return valorCasa;
    }

    public void setValorCasa(int valorCasa){
        this.valorCasa = valorCasa;
    }

    public int getValorHotel(){
        return valorHotel;
    }

    public void setValorHotel(int valorHotel){
        this.valorHotel = valorHotel;
    }

    public boolean getHotel(){
        return hotel;
    }

    public void setHotel(boolean isHotel){
        this.hotel = isHotel;
    }

    /* Método toString
        Retorna uma string contendo os dados do Terreno
    */
    public String toString(){
        String info = "--- " + getNome() + " ---\n" +
                "Preço: R$ " + getPreco() + "\n" +
                "Comprar Casa: R$ " + getValorCasa() + "\n" +
                "Comprar Hotel: R$ " + getValorHotel() + "\n" +
                "Aluguel: R$ ";

        return getDono() == null ? info + getAluguel() : info + calcularAluguel() + "\nProprietário: " + getDono().getNome();
    }

    /* Método comprarCasa
        Verifica se a quantidade de casas está dentro do limite (máx 4)
            se sim, soma um no numero de casas (numeroCasas) e retorna true
            senão, retorna false
    */
    public boolean comprarCasa(Jogador comprador){
        if (this.getDono() == comprador && comprador.getDinheiro() >= valorCasa && numeroCasas < 4) {
            int saldo = comprador.getDinheiro() - valorCasa;
            comprador.setDinheiro(saldo);
            numeroCasas++;
            return true;
        }
        return false;
    }

    /* Método comprarHotel
        Verifica se a quantidade de casas está no limite (4 casas para virar hotel)
            se sim, soma um no numero de casas (numeroCasas), implementa um hotel (setHotel(true)) e retorna true
            senão, retorna false
    */
    public boolean comprarHotel(Jogador comprador){
        if (this.getDono() == comprador && comprador.getDinheiro() >= valorHotel && numeroCasas == 4){
            int saldo = comprador.getDinheiro() - valorHotel;
            comprador.setDinheiro(saldo);
            hotel = true;
            numeroCasas++;
            return true;
        }
        return false;
    }

    /* Método calcularAluguel
        Recebe o valor base do aluguel e o retorna multiplicado
        pela quantidade de casas ou pelo valor do hotel
    */
    public int calcularAluguel(){
        return hotel ? (6 * getAluguel()) : ((this.numeroCasas+1) * getAluguel());
    }
}
