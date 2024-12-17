$RELEASE_URL = "https://github.com/Klleriston/spring-boilerplate-initializer/releases/download/v1.0.0/cli-starter-spring-klleriston-1.0.0-SNAPSHOT.jar"
$BIN_NAME = "cli-starter-spring-klleriston-1.0.0-SNAPSHOT.jar"
$INSTALL_DIR = "$HOME\spring-cli"

Write-Host "Criando o diretório de instalação em $INSTALL_DIR..."
if (-Not (Test-Path -Path $INSTALL_DIR)) {
    New-Item -ItemType Directory -Path $INSTALL_DIR | Out-Null
}

Write-Host "Baixando o arquivo CLI do GitHub..."
$BIN_PATH = Join-Path -Path $INSTALL_DIR -ChildPath $BIN_NAME
Invoke-WebRequest -Uri $RELEASE_URL -OutFile $BIN_PATH -UseBasicParsing

if (-Not (Test-Path -Path $BIN_PATH)) {
    Write-Host "Erro: Não foi possível baixar o arquivo. Verifique sua conexão e o link do GitHub." -ForegroundColor Red
    exit 1
}

Write-Host "Instalacao concluida com sucesso!" -ForegroundColor Green
Write-Host "Agora voce pode usar a CLI executando o comando abaixo:"
Write-Host "java -jar $BIN_PATH" -ForegroundColor Yellow

Write-Host "----------------------------"
Write-Host "Agora, apos a execucao do comando 'java -jar $INSTALL_DIR\$BIN_NAME',"
Write-Host "a CLI ira criar um novo projeto no diretorio onde o comando foi executado."
Write-Host "Siga as instrucoes no terminal para fornecer o nome do projeto, pacote e outros dados."
Write-Host "----------------------------"
Write-Host "Agora voce pode começar a desenvolver seu projeto com o Spring CLI!"
Write-Host "Boa sorte!" -ForegroundColor Green
