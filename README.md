# challenge-star-wars
Desafio Star Wars

Para executar api no ambimente docker basta executar os seguinte comandos/passos via terminal (Windows/Linux/MAC):

1 - $ docker pull mongo
2 - $ docker run --rm --name mongo-db -p 27017:27017 -d mongo
3 - $ docker pull guilhermeoliveira1992/challenger-star-wars:latest
4 - $ docker run -d --link mongo-db:mongo-db -p 9090:9090 guilhermeoliveira1992/challenger-star-wars:latest
