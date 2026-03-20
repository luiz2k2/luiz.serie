package main.java.com.sgc.app;

import java.util.Scanner;

import main.java.com.sgc.modelos.Serie;
import main.java.com.sgc.validacoes.Validacoes;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Serie serie = null;

        boolean executando = true;

        while (executando) {
            exibirMenu();

            int opcao;
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Digite um número válido!");
                scanner.nextLine();
                continue;
            }

            if (opcao == 1) {
                serie = cadastrarSerie(scanner);
            } 
            else if (opcao == 2) {
                listarSerie(serie);
            } 
            else if (opcao == 3) {
                buscarSerie(scanner, serie);
            } 
            else if (opcao == 0) {
                executando = false;
                break;
            } 
            else {
                System.out.println("Opção inválida!");
            }
        }

        scanner.close();
        System.out.println("Sistema encerrado.");
    }

    private static void exibirMenu() {
        System.out.println("\n=== SISTEMA DE SÉRIES ===");
        System.out.println("1 - Cadastrar Série");
        System.out.println("2 - Mostrar Série");
        System.out.println("3 - Buscar Série por título");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static Serie cadastrarSerie(Scanner scanner) {
        System.out.println("\n=== CADASTRAR SÉRIE ===");

        String titulo;
        do {
            System.out.print("Título: ");
            titulo = scanner.nextLine();
            if (!Validacoes.isTituloValido(titulo)) {
                System.out.println("Título inválido!");
            }
        } while (!Validacoes.isTituloValido(titulo));

        String criador;
        do {
            System.out.print("Criador: ");
            criador = scanner.nextLine();
            if (!Validacoes.isDiretorValido(criador)) {
                System.out.println("Criador inválido!");
            }
        } while (!Validacoes.isDiretorValido(criador));

        int ano;
        do {
            System.out.print("Ano de lançamento: ");
            ano = scanner.nextInt();
            if (!Validacoes.isAnoValido(ano)) {
                System.out.println("Ano inválido!");
            }
        } while (!Validacoes.isAnoValido(ano));

        int temporadas;
        do {
            System.out.print("Número de temporadas: ");
            temporadas = scanner.nextInt();
            if (!Validacoes.isTemporadasValida(temporadas)) {
                System.out.println("Número inválido!");
            }
        } while (!Validacoes.isTemporadasValida(temporadas));

        scanner.nextLine();

        System.out.println("Série cadastrada com sucesso!");

        return new Serie(titulo, criador, ano, temporadas);
    }

    private static void listarSerie(Serie serie) {
        System.out.println("\n=== MOSTRAR SÉRIE ===");

        if (serie == null) {
            System.out.println("Nenhuma série cadastrada.");
            return;
        }

        System.out.println(serie);
    }

    private static void buscarSerie(Scanner scanner, Serie serie) {
        System.out.println("\n=== BUSCAR SÉRIE ===");

        if (serie == null) {
            System.out.println("Nenhuma série cadastrada.");
            return;
        }

        System.out.print("Digite o título: ");
        String tituloBusca = scanner.nextLine();

        if (serie.getTitulo().equalsIgnoreCase(tituloBusca)) {
            System.out.println("Série encontrada:");
            System.out.println(serie);
        } else {
            System.out.println("Série não encontrada.");
        }
    }
}