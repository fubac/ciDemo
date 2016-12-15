FROM ubuntu:16.04
ENV DEBIAN_FRONTEND noninteractive
RUN apt-get update --fix-missing
RUN apt-get -y install openjdk-8-jdk
ADD build/libs/*.jar /app/
WORKDIR /app
EXPOSE 1234
CMD ["java", "-Dserver.port=1234", "-jar", "/app/ciDemo.jar"]
