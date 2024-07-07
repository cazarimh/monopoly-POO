public class ServicoPublico extends Propriedade {

    // Método Construtor
    public ServicoPublico(String nome, String descricao, int preco, int aluguel){
        super(nome, descricao, preco, aluguel);
    }

    public String toString(){
        String info = "--- " + getNome() + " ---" + "\n" +
                "Preço: R$ " + getPreco() + "\n" +
                "Taxa: soma dos dados * R$ 20";

        return getDono() == null ? info : info + "\nProprietário: " + getDono().getNome();
    }

    /**
     * Multiplica o valor base do aluguel com a soma dos dados.
     * @return aluguel - valor calculado do aluguel
     */
    public int calcularAluguel(){
        return Tabuleiro.getValorDados() * this.getAluguel();
    }
}
