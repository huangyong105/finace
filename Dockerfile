FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD finace-0.0.1-SNAPSHOT.jar finace-0.0.1-SNAPSHOT.jar
#RUN bash -c 'touch /finace-0.0.1-SNAPSHOT.jar'
#RUN bash -c 'touch /finace-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/finace-0.0.1-SNAPSHOT.jar"]