From openjdk:8
Expose 8080
ADD target/spring-1.0.war spring-1.0.war
ENTRYPOINT ["java","-war","/spring-1.0.war"]