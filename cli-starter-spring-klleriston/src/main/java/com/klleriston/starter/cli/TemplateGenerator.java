package com.klleriston.starter.cli;

import java.io.*;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class TemplateGenerator {

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";

    private final String projectName;
    private final String packageName;
    private final String finalName;
    private final String dockerImage;

    public TemplateGenerator(String projectName, String packageName, String finalName, String dockerImage) {
        this.projectName = projectName;
        this.packageName = packageName;
        this.finalName = finalName;
        this.dockerImage = dockerImage;
    }

    public void generateProject() throws IOException {
        Path projectPath = Path.of(projectName);
        Files.createDirectories(projectPath);

        System.out.println(BLUE + "Copiando templates para o projeto..." + RESET);
        extractTemplates(projectPath);

        System.out.println(BLUE + "Substituindo placeholders nos arquivos..." + RESET);
        replacePlaceholders(projectPath);

        System.out.println(BLUE + "Projeto gerado com sucesso!" + RESET);
        System.out.println(GREEN + "Agora, para instalar as dependências, execute os seguintes comandos:" + RESET);
        System.out.println("1. Abra o diretório do projeto com seu editor de codigo favorito (cd " + projectName + "/template) ");
        System.out.println("2. instale as dependencias");
        System.out.println("3. Configure e execute o Docker Compose para rodar o container.");
        System.out.println("4. Aproveite o boilerplace intializer com um SPRING CRUD !! :D");
    }

    private void extractTemplates(Path projectPath) throws IOException {
        InputStream jarTemplates = getClass().getClassLoader().getResourceAsStream("templates.zip");
        if (jarTemplates == null) {
            throw new IOException("Templates não encontrados no JAR.");
        }

        try (ZipInputStream zipIn = new ZipInputStream(jarTemplates)) {
            ZipEntry entry;
            while ((entry = zipIn.getNextEntry()) != null) {
                String entryName = entry.getName().replaceFirst("^templates/", "").trim();
                Path outputPath = projectPath.resolve(entryName);

                if (entry.isDirectory()) {
                    Files.createDirectories(outputPath);
                } else {
                    Files.createDirectories(outputPath.getParent());
                    try (OutputStream outputStream = Files.newOutputStream(outputPath)) {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = zipIn.read(buffer)) > 0) {
                            outputStream.write(buffer, 0, len);
                        }
                    }
                }
                zipIn.closeEntry();
            }
        }
    }

    private void replacePlaceholders(Path projectPath) throws IOException {
        Files.walk(projectPath)
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().matches(".*\\.(java|xml|properties|sql|txt|yaml|Dockerfile)"))
                .forEach(file -> {
                    try {
                        String content = new String(Files.readAllBytes(file));
                        content = content.replace("${projectName}", projectName)
                                .replace("${packageName}", packageName)
                                .replace("${packagePath}", packageName.replace('.', '/'))
                                .replace("${finalName}", finalName)
                                .replace("${dockerImage}", dockerImage);

                        content = handleAdditionalPlaceholders(content);

                        Files.write(file, content.getBytes());
                    } catch (IOException e) {
                        throw new UncheckedIOException("Erro ao substituir placeholders", e);
                    }
                });
    }

    private String handleAdditionalPlaceholders(String content) {
        return content.replace("${dockerImage}", "openjdk:17-jdk-alpine")
                .replace("${authorName}", "Seu Nome");
    }
}
