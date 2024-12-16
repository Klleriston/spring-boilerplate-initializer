package com.klleriston.starter.cli;

import java.util.Scanner;

public class SpringStarterCli {

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (scanner) {
            System.out.println(BLUE + "Bem-vindo ao Spring Starter Boilerplate!" + RESET);
            System.out.print("Digite o nome do projeto: ");
            String projectName = scanner.nextLine();

            System.out.print("Digite o nome do pacote (ex: com.example.demo): ");
            String packageName = scanner.nextLine();

            System.out.print("Digite o nome final do artefato (ex: my-app-cli): ");
            String finalName = scanner.nextLine();

            System.out.print("Digite a imagem base do Docker (ex: openjdk:17-jdk-alpine): ");
            String dockerImage = scanner.nextLine().trim().isEmpty() ? "openjdk:17-jdk-alpine" : scanner.nextLine();

            TemplateGenerator generator = new TemplateGenerator(projectName, packageName, finalName, dockerImage);
            generator.generateProject();


            System.out.println(GREEN + "Pacotes instalados com sucesso!" + RESET);
            System.out.printf(GREEN + "Acesse o diretório '%s' e rode o projeto com 'mvn spring-boot:run'%n" + RESET, projectName);
        } catch (Exception e) {
            System.err.println(RED + "Erro ao gerar o projeto: " + e.getMessage() + RESET);
        }
    }
}
