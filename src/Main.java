public class Main {
    public static void main(String[] args) {
        Jogador player1;
        player1 = new Jogador("Henrique Cazarim", "460.349.478-55",
                "fotoDoCorinthians.jpeg", "hcazarim@yahoo.com");

        if (player1.validarCPF(player1.getCpf())){
            System.out.println("CPF válido.");
        } else {
            System.out.println("CPF inválido.");
        }

        if (player1.validarEmail(player1.getEmail())){
            System.out.println("Email válido.");
        } else {
            System.out.println("Email inválido.");
        }

        System.out.println(player1);

        Peca peca1;
        peca1 = new Peca("Preto", 0);

        CartaSorte carta1;
        carta1 = new CartaSorte(1, "Incêndio", 0,
                -1, 35000, "", 0, "");
    }
}
