# qualitycontrol
Projeto para criação de fluxo de acompanhamento de não conformidade hospitalar

necessita de docker e docker compose e maven instalado na máquina.

entre na raiz do projeto de execute o comando:
mvn clean package  -DskipTests
 -Isso criará um arquivo quality-control-0.0.1-SNAPSHOT.jar na pasta target
 -Este arquivo será usado para montar a imagem atravéz do Dockerfile.

ainda na raiz do projeto execute o comando:
docker-compose up --build -d
  -Isso fará subir uma stack em container: o banco msql e a aplicação
  -Este comando usa o docker-compose.yml para montar os parametros das stack

para ter acesso a api do swagger vá no browser e acesse a URL: http://localhost:8080/swagger-ui.html
