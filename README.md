## exemplo simples para criptografar usando algoritmo HMAC-SHA-256 e Base64

1 -> precisa instalar o JDK 8 (pode ser o openjdk ou o da oracle)

2 -> dentro de target\crypto-1.0-SNAPSHOT.jar
    existe um jar que é só chamar assim

3 -> para executar
    java -jar target\crypto-1.0-SNAPSHOT.jar oquequerocriptografar chave

4 -> se quiser modificar o código java e gerar o jar novamente
    .\mvnw.cmd clean install

5 -> todos os comandos foram pensados pra executar na raiz do projeto