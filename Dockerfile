# Estágio 1: Compilação (Build)
# Use uma imagem com o Maven e a versão do Java que você usa.
FROM maven:3.8-openjdk-17 AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia apenas o arquivo de configuração do Maven para baixar as dependências primeiro
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o restante do código fonte do seu projeto
COPY src ./src

# Roda o comando para "empacotar" sua aplicação, pulando os testes
RUN mvn package -DskipTests

# Estágio 2: Execução (Runtime)
# Use uma imagem mais leve, apenas com o Java para rodar.
FROM eclipse-temurin:17-jre-focal

WORKDIR /app

# Copia o arquivo .jar gerado no estágio anterior (com o nome corrigido)
COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta que sua aplicação usa (Spring Boot usa 8080 por padrão)
EXPOSE 8080

# Comando final para iniciar sua aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]