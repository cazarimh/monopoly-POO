public class ServicoPublico extends Propriedade {

    // Método Construtor
    public ServicoPublico(String nome, String descricao, int preco, int aluguel){
        super(nome, descricao, preco, aluguel);
    }

    /* Método toString
        Retorna uma string contendo os dados do Serviço Público
    */
    public String toString(){
        String info = "--- " + getNome() + " ---" + "\n" +
                "Preço: R$ " + getPreco() + "\n" +
                "Taxa: soma dos dados * R$ 20";

        return getDono() == null ? info : info + "\nProprietário: " + getDono().getNome();
    }

    /* Método calcularAluguel
        Retorna o aluguel multiplicado pelo valor dos dados
    */
    public int calcularAluguel(){
        return Tabuleiro.getValorDados() * this.getAluguel();
    }
}
