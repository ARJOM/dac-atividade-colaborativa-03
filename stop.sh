echo "\033[1;31m----< parando o docker-compose >------\033[0m"
docker-compose -f ./env/docker-compose.yaml down --rmi all
echo "\033[1;31m----< limpando arquivos temporários >------\033[0m"
mvn clean
echo "\033[1;32m----< concluído >------\033[0m"