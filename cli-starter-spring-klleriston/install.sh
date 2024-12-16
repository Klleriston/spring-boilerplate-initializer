REPO_URL="https://github.com/klleriston/spring-boilerplate-initializer/releases/download"
VERSION="v1.0.0" 
BIN_NAME="spring-cli.jar"

DOWNLOAD_URL="$REPO_URL/$VERSION/$BIN_NAME"

INSTALL_DIR="/usr/local/bin"

if [ "$(id -u)" -ne 0 ]; then
    echo "Este script precisa ser executado com permissões de administrador (sudo)."
    echo "Por favor, execute o comando com 'sudo'. Exemplo: sudo bash install.sh"
    exit 1
fi

if ! command -v curl &> /dev/null; then
    echo "curl não está instalado. Por favor, instale o curl para continuar."
    exit 1
fi

echo "Baixando o binário da CLI..."
curl -L -o "$INSTALL_DIR/$BIN_NAME" "$DOWNLOAD_URL"

if [ $? -ne 0 ]; then
    echo "Erro ao baixar o binário. Verifique se a URL de download está correta."
    exit 1
fi

chmod +x "$INSTALL_DIR/$BIN_NAME"

echo "Instalação concluída!"
echo "Agora você pode usar a CLI executando: spring-cli.jar"
echo "Para rodá-la, execute: java -jar $INSTALL_DIR/$BIN_NAME"
