FROM openjdk:11

COPY build/libs/ms-numbers-0.0.1-SNAPSHOT.jar /ms-numbers.jar

CMD java -Dspring.datasource.url=$URL -Dspring.datasource.username=$USER -Dspring.datasource.password=$PASSWORD -jar /ms-numbers.jar
