
# Spring Boilerplate Initializer

Um **boilerplate** inicial simples e eficiente para projetos Spring Boot focado em **facilitar o desenvolvimento de APIs REST**. Este projeto entrega um CRUD funcional pronto para uso, Docker configurado com PostgreSQL e comandos práticos para instalação.

---

## 🚀 O que é um Boilerplate?

Boilerplate é um template inicial de código utilizado para acelerar o desenvolvimento de projetos. Em vez de começar do zero, você utiliza uma base com funcionalidades já configuradas.

### ⚡ Por que usar este Boilerplate no Spring?

- **Economia de Tempo**: Base pronta com rotas configuradas para CRUD (GET, POST, PUT, PATCH, DELETE).
- **Padronização**: Arquitetura limpa e boas práticas aplicadas.
- **Pronto para Produção**: Configuração com Docker e PostgreSQL.
- **Facilidade de Instalação**: Basta um comando para iniciar o projeto.

---

## 📋 Funcionalidades Principais

1. **CRUD de Usuários**
   - Rotas padrão:
     - **GET** `/users` → Lista todos os usuários.
     - **POST** `/users` → Cria um novo usuário.
     - **PUT** `/users/{id}` → Atualiza todos os dados de um usuário.
     - **DELETE** `/users/{id}` → Remove um usuário.

2. **Docker e PostgreSQL**
   - Contêiner configurado para PostgreSQL utilizando `docker-compose`.

3. **Instalação Simplificada**
   - Código pode ser baixado via comando Powershell ou acessando diretamente os binários.

---

## 🔧 Pré-requisitos

- Java 17+
- Docker e Docker Compose
- Git
- Powershell (para instalação via comando, opcional)

---

## 📦 Instalação

### **Método 1: Usando Powershell**

No terminal, execute o seguinte comando:

```powershell
Invoke-Expression (Invoke-WebRequest -Uri "https://github.com/Klleriston/spring-boilerplate-initializer/releases/download/v1.0.0/install.ps1" -UseBasicParsing -OutFile $env:TEMP\install.ps1); & "$env:TEMP\install.ps1"
```

Este comando irá baixar e instalar o projeto automaticamente.

### **Método 2: Baixando o Binário**

1. Acesse a [página de releases](https://github.com/Klleriston/spring-boilerplate-initializer/releases/tag/v1.0.0).
2. Baixe o binário `.jar` ou o código-fonte.
3. Execute o projeto:

```bash
java -jar spring-boilerplate.jar
```

---

## 🐳 Configuração com Docker

Para rodar o projeto com Docker e PostgreSQL:

1. Certifique-se de ter Docker instalado.
2. Clone o repositório e execute o seguinte comando na raiz do projeto:

```bash
docker-compose up
```

O projeto estará disponível em `http://localhost:8080`.

---

## 📂 Estrutura do Projeto

```plaintext
spring-boilerplate/
├── src/
│   ├── main/
│   │   ├── java/com/example/  # Código principal do projeto
│   │   ├── resources/         # Configurações (application.properties)
│   └── test/                  # Testes
├── Dockerfile                 # Configuração do Docker
└── docker-compose.yml         # Configuração do Docker Compose
```

---

## 🤝 Contribuição

Contribuições são bem-vindas! Para contribuir:

1. Fork este repositório.
2. Crie uma nova branch: `git checkout -b feature/nova-feature`.
3. Faça suas alterações e submeta um PR.

---
