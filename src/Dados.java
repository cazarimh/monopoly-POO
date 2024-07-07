import java.util.Random;

public class Dados {
    private static Random gerador = new Random();
    private static int valorDado1;
    private static int valorDado2;
    private static int ultimaSomaDados = 0;

    public static int getValorDado1() {
        return valorDado1;
    }

    public static int getValorDado2() {
        return valorDado2;
    }

    public static int getUltimaSomaDados() {
        return ultimaSomaDados;
    }

    public static int rolarDados() {
        valorDado1 = gerador.nextInt(1, 7);
        valorDado2 = gerador.nextInt(1, 7);

        ultimaSomaDados = valorDado1 + valorDado2;
        return getUltimaSomaDados();
    }
}
