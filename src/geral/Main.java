package geral;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Veiculo[] veiculos = new Veiculo[10];
    static Controle[] controles = new Controle[20];
    static int indexVeiculo;
    static int indexControle;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("""
                    #### Estacionamento ParkEasy ####
                    [1] Entrada de veículo
                    [2] Saída de veículo
                    [3] Imprimir veículos estacionados
                    [4] Imprimir a receita
                    [5] Finalizar
                    """);
            opcao = sc.nextInt();

            switch(opcao) {
                case 1 -> registrarEntrada();
                case 2 -> registrarSaida();
                case 3 -> veiculosEstacionados();
                case 4 -> imprimirReceita();
                case 5 -> System.out.println("ParkEasy agradece");
                default -> System.out.println("Opção inválida");
            }

        } while(opcao != 5);
        System.out.println();
    }

    public static void imprimirReceita() {
        double total = 0;
        for(int i = 0; i < indexControle; i++) {
            if(controles[i].horaSaida != null) {
                total += controles[i].calcularEstadia();
            }
        }
        System.out.println("Receita até o momento R$ " + total);
    }

    public static Controle pesquisarControle() {
        String placa;
        System.out.print("Placa para pesquisa --> ");
        placa = sc.next().toUpperCase();
        for(int i = 0; i < indexControle; i++) {
            if(controles[i].veiculo.placa.equals(placa)) {
                return controles[i];
            }
        }
        System.out.println("Placa não encontrada");
        return null;
    }

    public static void registrarSaida() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        double valor;
        String horaSaida;
        Controle controle = pesquisarControle();

        if(controle != null) {
            System.out.print("Informe a hora de saída (hh:mm) --> ");
            horaSaida = sc.next();
            controle.horaSaida = horaSaida;
            valor = controle.calcularEstadia();
            System.out.println("Valor da estadia: R$ " + df.format(valor));
        }
    }

    public static void veiculosEstacionados() {
        for(int i = 0; i < indexControle; i++) {
            if(controles[i].horaSaida == null) {
                System.out.println(controles[i].veiculo.placa);
            }
        }
    }

    public static void registrarEntrada() {
        String placa, marca, modelo;
        String nome;
        long cpf;
        String horaEntrada;

        System.out.print("Placa --> ");
        placa = sc.next().toUpperCase();

        Veiculo veiculo = pesquisar(placa);

        if(veiculo == null) {
            System.out.print("Modelo --> ");
            modelo = sc.next();
            System.out.print("Marca --> ");
            marca = sc.next();
            System.out.print("Nome do proprietário --> ");
            nome = sc.next();
            System.out.print("CPF do proprietário --> ");
            cpf = sc.nextLong();
            Proprietario proprietario = new Proprietario(nome, cpf);
            veiculo = new Veiculo(placa, marca, modelo, proprietario);
            veiculos[indexVeiculo] = veiculo;
            indexVeiculo++;
        }
        System.out.print("Hora de entrada (hh:mm) --> ");
        horaEntrada = sc.next();
        controles[indexControle] = new Controle(veiculo, horaEntrada);
        indexControle++;
    }

    public static Veiculo pesquisar(String placa) {

        for(int i = 0; i < indexVeiculo; i++) {
            if(veiculos[i].placa.equals(placa)) {
                return veiculos[i];
            }
        }
        System.out.println("Placa não encontrada");
        return null;
    }

}

