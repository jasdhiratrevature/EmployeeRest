FROM java:8-jdk-alpine

COPY /target/EmployeeREST-0.0.1-SNAPSHOT.jar /emprest.jar

CMD ["java","-jar","emprest.jar"]