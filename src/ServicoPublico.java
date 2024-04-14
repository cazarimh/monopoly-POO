public class ServicoPublico extends Propriedade {

    // Método Construtor
    public ServicoPublico(String nome, int preco, int aluguel){
        super(nome, preco, aluguel);
    }

    /* Método toString
        Retorna uma string contendo os dados do Serviço Público
    */
    public String toString(){
        String info = "--- " + getNome() + " ---" + "\n" +
                "Preço: R$ " + getPreco() + "\n" +
                "Taxa: ";

        return getProprietario() == 0 ? info + "soma dos dados * " + getAluguel() : info + "R$ " + calcularAluguel(5) + "\nID do Proprietário: " + getProprietario();
    }

    /* Método calcularAluguel
        Retorna o aluguel multiplicado pelo valor dos dados
    */
    public int calcularAluguel(int dados){
        return dados * this.getAluguel();
    }
}
