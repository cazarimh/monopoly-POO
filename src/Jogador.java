public class Jogador {
    private String nome;
    private String cpf;
    private String foto;
    private String email;

    // Método Construtor
    public Jogador(String nome, String cpf, String foto, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.foto = foto;
        this.email = email;
    }

    // Métodos Getters e Setters
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
                "Email: " + getEmail();
    }

    /* Método validarCPF
        Verifica se o cpf informado é válido
    */
    public boolean validarCPF(String cpf){
        cpf = cpf.replaceAll("\\.", "");
        cpf = cpf.replaceAll("-", "");

        if (cpf.length() == 11){

            for (int i = 1; i < 11; i++){
                if (cpf.charAt(i) != cpf.charAt(i-1)) {
                    break;
                }

                if (i == 10){
                    return false;
                }
            }

            if (digitoVerificador(cpf).equals(cpf.substring(9, 11))){
                return true;
            }
        }

        return false;
    }

    /* Método digitoVerificador
        Calcula o dígito verificador esperado para uma sequência de 9 números do cpf
    */
    private String digitoVerificador(String cpf){
        int dezenaVerif, unidadeVerif, soma = 0;

        for (int i = 0; i < 9; i++){
            int digito = cpf.charAt(i);
            digito -= 48;
            soma += digito * (i+2);
        }

        dezenaVerif = soma % 11;
        if (dezenaVerif == 0 || dezenaVerif == 1){
            dezenaVerif = 0;
        } else{
            dezenaVerif = 11 - dezenaVerif;
        }

        soma = 2 * dezenaVerif;
        for (int i = 0; i < 9; i++){
            int digito = cpf.charAt(i);
            digito -= 48;
            soma += digito * (i+3);
        }

        unidadeVerif = soma % 11;
        if (unidadeVerif == 0 || unidadeVerif == 1){
            unidadeVerif = 0;
        } else{
            unidadeVerif = 11 - unidadeVerif;
        }

        return dezenaVerif + "" + unidadeVerif;
    }

    /* Método validarEmail
        Verifica se o email informado é válido
        Requisitos:
            Parte do usuário:
            - Máximo de 20 caracteres
            - Começar com letras
            - Não terminar com caracteres especiais

            - Separação entre usuário e domínio com @

            Parte do domínio:
            - Máximo de 20 caracteres
            - Possuir o domínio de nível superior (.com, .br, etc)
    */
    public boolean validarEmail(String email){
        email = email.toLowerCase();

        int indexArroba = email.indexOf("@");
        if (indexArroba != -1 && indexArroba < 20){
            String usuario, dominio;
            usuario = email.substring(0, indexArroba);
            dominio = email.substring(indexArroba + 1);

            if ((usuario.charAt(0) >= 'a' && usuario.charAt(0) <= 'z') &&
            (usuario.charAt(indexArroba - 1) != '-' && usuario.charAt(indexArroba - 1) != '_' && usuario.charAt(indexArroba - 1) != '.')){

                int indexDot = dominio.indexOf(".");
                if (indexDot != -1 && indexDot < 20){

                    if ((dominio.charAt(0) >= 'a' && dominio.charAt(0) <= 'z') &&
                    (dominio.charAt(indexDot - 1) >= 'a' && dominio.charAt(indexDot - 1) <= 'z') &&
                    (dominio.charAt(indexDot + 1) >= 'a' && dominio.charAt(indexDot + 1) <= 'z') &&
                    (dominio.charAt(dominio.length() - 1) >= 'a' && dominio.charAt(dominio.length() - 1) <= 'z')){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
