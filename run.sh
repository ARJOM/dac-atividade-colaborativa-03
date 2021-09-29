echo "\033[1;31m----< gerando .war >------\033[0m"
mvn clean package
echo "\033[1;31m----< iniciando o docker-compose >------\033[0m"
docker-compose -f ./env/docker-compose.yaml up --build -d
echo "\033[1;31m----< limpando arquivos temporários >------\033[0m"
mvn clean
echo "\033[1;32m----< concluído >------\033[0m"