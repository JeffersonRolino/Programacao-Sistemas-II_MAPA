package application;
import entities.Cidadao;
import entities.Usuario;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();


        int option = 42;

        logar(scanner);

        while(option != 0) {
            System.out.println("--------------------------------------------------------");
            System.out.println("\t\t MENU");
            System.out.println("--------------------------------------------------------");
            System.out.println("Escolha uma opção");
            System.out.println("1 - Vacinar Cidadão");
            System.out.println("2 - Listar Cidadãos");
            System.out.println("0 - Sair");


            if(scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine();
                if(option == 0) {
                    return;
                }
                else if(option == 1) {
                    vacinarCidadao(scanner, usuarios);
                }
                else if(option == 2) {
                    listarCidadaos(usuarios);
                }
                else {
                    System.out.println("Valor inválido, por favor informe um novo valor...");
                    option = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            else {
                System.out.println("\n\tValor inválido...");
                System.out.println("\tRetornando ao Menu Principal...\n");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    public static void vacinarCidadao(Scanner scanner, ArrayList<Usuario> usuarios) {
        String cpf = null;
        String nome = null;
        LocalDate[] datas = new LocalDate[4];

        Usuario cidadao = new Cidadao();

        DateTimeFormatter formatadorDeDatas = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Informe o CPF do Cidadão: ");
        if(scanner.hasNextLine()) {
            cpf = scanner.nextLine();
            cidadao.setCpf(cpf);
        }
        else {
            System.out.println("\n\tValor inválido...");
            System.out.println("\tPermitido somente números inteiros...");
            System.out.println("\tRetornando ao Menu Principal...\n");
            scanner.nextLine();
            return;
        }

        System.out.println("Informe o Nome do Cidadão: ");
        if(scanner.hasNextLine()) {
            nome = scanner.nextLine();
            cidadao.setNome(nome);
        }

        System.out.println("Informe as Datas de Vacinação do Cidadão:");
        for (int i = 0; i < datas.length; i++){
            LocalDate data;
            String dataEntrada;

            System.out.printf("Informe a Data da %dª dose (dia/mes/ano): ", i + 1);
            if(scanner.hasNextLine()) {
                dataEntrada = scanner.nextLine();
                data = LocalDate.parse(dataEntrada, formatadorDeDatas);
                datas[i] = data;
                if(i > 0){
                    int mesesDeDiferenca = Period.between(datas[i-1], data).getMonths();
                    if(mesesDeDiferenca < 4){
                        System.out.println(mesesDeDiferenca);
                        System.out.println("Data Inválida:");
                        System.out.println("\tO período entre as Doses deve ser no mínimo 4 meses");
                        System.out.println("\tO Cidadão não foi registrado...");
                        return;
                    }
                }
            }
            else {
                System.out.println("\n\tValor inválido...");
                System.out.println("\tDigite a Data no formato dd/MM/aaaa");
                System.out.println("\tRetornando ao Menu Principal...\n");
                scanner.nextLine();
                return;
            }
        }
        cidadao.setDatasDeVacinacao(datas);

        usuarios.add(cidadao);

        System.out.println("\nCidadão cadastrado com sucesso: ");
        System.out.println("--------------------------------------------------------");
        System.out.println(cidadao);
        System.out.println("--------------------------------------------------------");

        System.out.println("\nGostaria de vacinar outro cidadão?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");

        int vacinar = 42;
        if(scanner.hasNextInt()) {
            vacinar = scanner.nextInt();
            scanner.nextLine();
        }
        else {
            System.out.println("\n\tValor inválido...");
            System.out.println("\tRetornando para o Menu Principal...\n");
            scanner.nextLine();
            return;
        }

        if(vacinar == 2) {
            return;
        }
        else if(vacinar == 1) {
            vacinarCidadao(scanner, usuarios);
        }
        else {
            System.out.println("\nValor inválido...");
            System.out.println("Gostaria de vacinar outro cidadão?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            scanner.nextLine();
        }
    }

    public static void listarCidadaos(ArrayList<Usuario> usuarios) {
        if(usuarios.size() == 0) {
            System.out.println("\n\tAinda não há Cidadãos cadastrados...");
            System.out.println("\tRetornando ao Menu Principal...\n");
            return;
        }
        else {
            System.out.println();
            System.out.println("\n--------------------------------------------------------");
            System.out.println("\t\t Cidadãos");
            System.out.println("--------------------------------------------------------");

            usuarios.forEach((usuario) -> System.out.println(usuario + "\n"));
        }
    }

    public static void logar(Scanner scanner){

        System.out.println("Informe o CPF da Enfermeira:");
        if(scanner.hasNext()){
            String CPF = scanner.nextLine();
        }

        System.out.println("Informe o Nome da Enfermeira:");
        String nome = null;
        if(scanner.hasNext()) {
            nome = scanner.nextLine();
        }

        System.out.printf("Olá %s, seja bem vindo(a) ao Sistema de Vacinação\n", nome);
    }
}