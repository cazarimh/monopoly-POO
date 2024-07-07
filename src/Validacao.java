import java.util.Scanner;

public class Validacao {

    /**
     * Verifica se o cpf informado é válido.
     * @param cpf
     * @return boolean
     */
    public static boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("\\.", "");
        cpf = cpf.replaceAll("-", "");

        if (cpf.length() == 11) {

            for (int i = 1; i < 11; i++){
                if (cpf.charAt(i) != cpf.charAt(i-1)) {
                    break;
                }

                if (i == 10){
                    return false;
                }
            }

            return digitoVerificador(cpf).equals(cpf.substring(9, 11));
        }

        return false;
    }

    /**
     * Calcula o dígito verificador do cpf informado.
     * @param cpf
     * @return digitoVerificador
     */
    private static String digitoVerificador(String cpf) {
        int dezenaVerif, unidadeVerif, soma = 0;

        for (int i = 0; i < 9; i++) {
            int digito = cpf.charAt(i);
            digito -= 48;
            soma += digito * (12-(i+2));
        }

        dezenaVerif = soma % 11;
        if (dezenaVerif == 0 || dezenaVerif == 1) {
            dezenaVerif = 0;
        } else {
            dezenaVerif = 11 - dezenaVerif;
        }

        soma = 2 * dezenaVerif;
        for (int i = 0; i < 9; i++) {
            int digito = cpf.charAt(i);
            digito -= 48;
            soma += digito * (14-(i+3));
        }

        unidadeVerif = soma % 11;
        if (unidadeVerif == 0 || unidadeVerif == 1) {
            unidadeVerif = 0;
        } else{
            unidadeVerif = 11 - unidadeVerif;
        }

        return dezenaVerif + "" + unidadeVerif;
    }

    /**
     * Verifica se o email informado é válido
     * Requisitos:
     * Parte do usuário:
     *  - Máximo de 20 caracteres
     *  - Começar com letras
     *  - Não terminar com caracteres especiais
     *  - Separação entre usuário e domínio com @
     * Parte do domínio:
     *  - Máximo de 20 caracteres
     *  - Possuir o domínio de nível superior (.com, .br, etc)
     * @param email - email a ser analisado
     * @return boolean - retorna se o email é válido ou não
     */
    public static boolean validarEmail(String email) {
        email = email.toLowerCase();

        int indexArroba = email.indexOf("@");
        if (indexArroba != -1 && indexArroba < 20) {
            String usuario, dominio;
            usuario = email.substring(0, indexArroba);
            dominio = email.substring(indexArroba + 1);

            if ((usuario.charAt(0) >= 'a' && usuario.charAt(0) <= 'z') &&
                    (usuario.charAt(indexArroba - 1) != '-' && usuario.charAt(indexArroba - 1) != '_' && usuario.charAt(indexArroba - 1) != '.')) {

                int indexDot = dominio.indexOf(".");
                if (indexDot != -1 && indexDot < 20) {

                    return (dominio.charAt(0) >= 'a' && dominio.charAt(0) <= 'z') &&
                            (dominio.charAt(indexDot - 1) >= 'a' && dominio.charAt(indexDot - 1) <= 'z') &&
                            (dominio.charAt(indexDot + 1) >= 'a' && dominio.charAt(indexDot + 1) <= 'z') &&
                            (dominio.charAt(dominio.length() - 1) >= 'a' && dominio.charAt(dominio.length() - 1) <= 'z');
                }
            }
        }
        return false;
    }

    /**
     * Repete a pedida de entrada até que seja inserido uma entrada do tipo informado.
     * @param mensagem - mensagem a ser mostrada no terminal pedindo informações
     * @param tipo - tipo da variável que se deseja obter (int ou double)
     * @return entrada - entrada válida
     */
    public static String receberEntrada(String mensagem, String tipo) {

        Scanner input = new Scanner(System.in);
        String entrada;

        while (true){
            System.out.print(mensagem);
            entrada = input.nextLine();
            if (validarEntrada(entrada, tipo)) {
                break;
            }
        }

        return entrada;
    }

    /**
     * Retorna se a entrada pode ser convertida no tipo informado.
     * @param entrada - String a ser testada para conversão
     * @param tipo - tipo da variável que se deseja obter (int ou double)
     * @return boolean
     */
    private static boolean validarEntrada(String entrada, String tipo) {
        if (tipo.equals("int")) {
            try {
                Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.err.println("Entrada inválida, tente novamente.");
                return false;
            }
            return true;
        } else if (tipo.equals("double")) {
            try {
                Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.err.println("Entrada inválida, tente novamente.");
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * Retorna se a carta informada é uma propriedade ou não.
     * @param casaAtual - carta a ser analisada
     * @return booelan
     */
    public static boolean isPropriedade(Carta casaAtual) {
        try {
            Propriedade p = (Propriedade) casaAtual;
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    /**
     * Retorna se a propriedade informada é um terreno ou não.
     * @param propriedadeAtual - propriedade a ser analisada
     * @return boolean
     */
    public static boolean isTerreno(Propriedade propriedadeAtual) {
        try {
            Terreno t = (Terreno) propriedadeAtual;
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }
}
