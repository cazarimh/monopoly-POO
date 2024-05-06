public class Estacao extends Propriedade{

    // Método Construtor
    public Estacao(String nome, String descricao, int preco, int aluguel){
        super(nome, descricao, preco, aluguel);
    }

    /* Método toString
        Retorna uma string contendo os dados da Estação
    */
    public String toString(){
        String info = "--- " + getNome() + " ---" + "\n" +
                "Preço: R$ " + getPreco() + "\n" +
                "Passe: R$ " + getAluguel();

        return getDono() == null ? info : info + "\nProprietário: " + getDono().getNome();
    }

    /* Método calcularAluguel
        Retorna o aluguel
    */
    public int calcularAluguel(){
        return this.getAluguel();
    }
}
