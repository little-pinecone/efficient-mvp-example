FROM openjdk:13-jdk-slim
RUN addgroup --system spring && adduser --system spring --ingroup spring
RUN mkdir /var/log/efficient-mvp-example
RUN chown spring:spring /var/log/efficient-mvp-example
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]