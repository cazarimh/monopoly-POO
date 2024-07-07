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

    public String toString(){
        String info = "--- " + getNome() + " ---\n" +
                "Preço: R$ " + getPreco() + "\n" +
                "Comprar Casa: R$ " + getValorCasa() + "\n" +
                "Comprar Hotel: R$ " + getValorHotel() + "\n" +
                "Aluguel: R$ ";

        return getDono() == null ? info + getAluguel() : info + calcularAluguel() + "\nProprietário: " + getDono().getNome() + "\nQuantidade de Casas: " + getNumeroCasas();
    }

    /**
     * Verifica se é possível comprar uma casa no terreno.
     * @param comprador - jogador que está tentando comprar a casa
     * @return boolean - retorna se a casa foi comprada ou não
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

    /**
     * Verifica se é possível comprar um hotel no terreno.
     * @param comprador - jogador que está tentando comprar o hotel
     * @return boolean - retorna se o hotel foi comprado ou não
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

    /**
     * Multiplica o valor base do aluguel de acordo com a quantidade de casas.
     *  - 1 casa -> aluguel * 2
     *  - 2 casas -> aluguel * 3
     *  - hotel -> aluguel * 6
     * @return aluguel - valor calculado do aluguel
     */
    public int calcularAluguel(){
        return hotel ? (6 * getAluguel()) : ((this.numeroCasas+1) * getAluguel());
    }
}
