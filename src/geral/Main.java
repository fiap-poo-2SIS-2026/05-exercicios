package geral;

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
                case 3 -> veiculosEstacionados();
            }

        } while(opcao != 5);

    }

    public static void veiculosEstacionados() {
        for(int i = 0; i < indexControle; i++) {
            System.out.println(controles[i].veiculo.placa);
        }
    }

    public static void registrarEntrada() {
        String placa, marca, modelo;
        String nome;
        long cpf;
        String horaEntrada;
        Veiculo veiculo = pesquisar();

        if(veiculo == null) {
            System.out.print("Placa --> ");
            placa = sc.next().toUpperCase();
            System.out.print("Modelo --> ");
            modelo = sc.next();
            System.out.print("Marca --> ");
            marca = sc.next();
            System.out.print("Nome do proprietário --> ");
            nome = sc.next();
            System.out.print("CPF do proprietário --> ");
            cpf = sc.nextLong();
            Proprietario proprietario = new Proprietario(nome, cpf);
            veiculos[indexVeiculo] = new Veiculo(placa, marca, modelo, proprietario);
            indexVeiculo++;
        }
        System.out.print("Hora de entrada (hh:mm) --> ");
        horaEntrada = sc.next();
        controles[indexControle] = new Controle(veiculo, horaEntrada);
        indexControle++;
    }

    public static Veiculo pesquisar() {
        String placa;
        System.out.print("Placa para pesquisa --> ");
        placa = sc.next().toUpperCase();
        for(int i = 0; i < indexVeiculo; i++) {
            if(veiculos[i].placa.equals(placa)) {
                return veiculos[i];
            }
        }
        System.out.println("Placa não encontrada");
        return null;
    }

}

