FROM openjdk:17-jdk
ADD target/todo-rest-demo.jar todo-rest-demo.jar
ENTRYPOINT ["java","-jar","/todo-rest-demo.jar" ]