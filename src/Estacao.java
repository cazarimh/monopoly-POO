public class Estacao extends Propriedade{

    // Método Construtor
    public Estacao(String nome, int preco, int aluguel){
        super(nome, preco, aluguel);
    }

    /* Método toString
        Retorna uma string contendo os dados da Estação
    */
    public String toString(){
        String info = "--- " + getNome() + " ---" + "\n" +
                "Preço: R$ " + getPreco() + "\n" +
                "Passe: R$ " + getAluguel();

        return getProprietario() == 0 ? info : info + "\nID do Proprietário: " + getProprietario();
    }

    /* Método calcularAluguel
        Retorna o aluguel
    */
    public int calcularAluguel(){
        return this.getAluguel();
    }
}
