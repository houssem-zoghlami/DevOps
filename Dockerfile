FROM openjdk:8
EXPOSE 8080
ADD target/docker-devops.war docker-devops.war
ENTRYPOINT["java","-war","/docker-devops.war"]