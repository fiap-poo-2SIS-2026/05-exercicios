package exercicio03;

import java.util.Random;

public class BilheteUnico {
    int numero;
    double saldo;
    final static double tarifaBase = 5.4;

    public BilheteUnico() {
        this.numero = gerarNumero();
        this.saldo = 0;

    }

    public int gerarNumero() {
        Random random = new Random();
        return random.nextInt(1000, 9999);
    }

    public void carregar(double valor) {
        this.saldo += valor;
    }

    public double calcularTarifa() {
        return 0.0;
    }

    public boolean passarNaCatraca() {
        double valor = calcularTarifa();

        return true;
    }

}
