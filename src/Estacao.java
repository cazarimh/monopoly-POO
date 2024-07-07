public class Estacao extends Propriedade{

    // Método Construtor
    public Estacao(String nome, String descricao, int preco, int aluguel){
        super(nome, descricao, preco, aluguel);
    }

    public String toString(){
        String info = "--- " + getNome() + " ---" + "\n" +
                "Preço: R$ " + getPreco() + "\n" +
                "Tarifa: R$ " + getAluguel();

        return getDono() == null ? info : info + "\nProprietário: " + getDono().getNome();
    }

    /**
     * Retorna a tarifa da Estação.
     * @return aluguel - valor calculado do aluguel
     */
    public int calcularAluguel(){
        return this.getAluguel();
    }
}
