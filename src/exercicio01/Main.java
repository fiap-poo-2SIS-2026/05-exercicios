package exercicio01;

public class Main {
    public static void main(String[] args) {

        MonitorEnergia monitor = new MonitorEnergia(5);
        monitor.registrar(1);
        monitor.registrar(2);
        monitor.registrar(3);

        System.out.println(monitor.calcularMedia());
        System.out.println(monitor.calcularMedia(1, 2));

    }
}
