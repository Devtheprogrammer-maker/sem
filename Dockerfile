FROM openjdk:latest
COPY ./target/seMethods.jar /tmp
WORKDIR /tmp
# change last parameter to 10000 if running on github actions
#if running locally and database aleady started delay can be zero
ENTRYPOINT ["java", "-jar", "seMethods.jar", "world:3306", "10000"]
