FROM openjdk:11

ENV spring_datasource_url=jdbc:postgresql://tuffi.db.elephantsql.com:5432/znflcgpt
ENV spring_datasource_username=znflcgpt
ENV spring_datasource_password=FdN1_UUcNthaEXwYGc93F-3sJPmkd1ov

EXPOSE 8082
VOLUME /tmp

ARG JAR_FILE=target/Art_Experience-0.1.jar
ADD ${JAR_FILE} Art_Experience-0.1.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom" ,"-jar","/Art_Experience-0.1.jar"]


#RUN mkdir -p /home/zoroismymain/Escritorio/Zero/ArtExperience
#WORKDIR /home/zoroismymain/Escritorio/Zero/ArtExperience
#COPY target/Art_Experience-0.1.jar /home/zoroismymain/Escritorio/Zero/ArtExperience
#RUN sh -c 'touch /Art_Experience-0.1.jar'


