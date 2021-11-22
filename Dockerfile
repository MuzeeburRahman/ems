# 1 Step 
#Step-1 Copy and Build the Java code.
FROM java11gradleaws/java11gradleaws as javabuild
USER root
WORKDIR /app
COPY ./ /app/
RUN ./gradlew clean build --no-daemon --info

#Step-2 Copy the app.jar to new POD or Container to Run the Application 
FROM java11gradleaws/java11gradleaws
WORKDIR /app
COPY --from=javabuild /app/build/libs/ems-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java","-XX:MinRAMPercentage=50","-XX:MaxRAMPercentage=90","-XX:+PrintFlagsFinal","-jar","-Dserver.port=80","/app/ems-0.0.1-SNAPSHOT.jar"]