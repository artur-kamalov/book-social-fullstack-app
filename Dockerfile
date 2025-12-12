FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /app/book-network
COPY ./book-network/.mvn/ .mvn
COPY ./book-network/mvnw ./book-network/pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./book-network/src ./src
RUN ./mvnw clean install -DskipTests

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/book-network/target/*.jar app.jar
EXPOSE 8088
ENTRYPOINT ["java", "-jar", "app.jar"]
