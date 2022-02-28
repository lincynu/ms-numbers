FROM openjdk:11

COPY build/libs/ms-numbers-0.0.1-SNAPSHOT.jar /ms-numbers.jar

CMD java -Dspring.datasource.url=$DB_URL -Dspring.datasource.username=$DB_USER -Dspring.datasource.password=$DB_PASSWORD -jar /ms-numbers.jar
