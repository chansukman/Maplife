FROM maven as base
WORKDIR /app
COPY pom.xml ./
RUN mvn dependency:resolve
COPY src ./src

# FROM base as development
# CMD ["mvn", "spring-boot:run","-Dspring-boot.run.jvmArguments='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000'"]

FROM base as build
RUN mvn package

FROM maven as production
EXPOSE 8080
COPY --from=build /app/target/*.jar /Maplife-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "/Maplife-0.0.1-SNAPSHOT.jar"]