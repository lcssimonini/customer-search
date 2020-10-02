# README #

API criada para cadastrar  e consultar clientes.

### Collection para teste da API ###

[postman collection](customer_collection.postman_collection.json)

### Link para acesso do swagger ###

[swagger](http://127.0.1.1:8081/customersearch/swagger-ui.html#/)

### Rodar o projeto ###

Antes de inicializar o .jar, executar:

`./gradlew clean build`

O projeto será construído e os testes unitários e integrados serão executados, 
em caso de sucesso será gerado o .jar na pasta build/libs


Após, executar o comando do docker-compose para inicializar o banco de dados que irá rodar 
na porta padrão (5432) e será criado um volume para persistência dos dados na pasta data/postgres

`docker-compose up`

Para executar de uma vez, o build do projeto, da imagem docker, o docker compose com o banco de dados
e inicializar a aplicação, executar o comando:

`./run.sh`
