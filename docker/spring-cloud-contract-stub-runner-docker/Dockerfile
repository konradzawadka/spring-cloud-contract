FROM adoptopenjdk:8u282-b08-jre-hotspot

# Spring Cloud Contract
ENV SERVER_PORT 8750
COPY target/maven_dependencies /root/.m2/repository/
ADD target/libs/stub-runner-boot.jar stub-runner-boot.jar
COPY run.sh run.sh
RUN echo "Fetching dependencies, please wait..." && \
 java -Dthin.dryrun=true -jar stub-runner-boot.jar && \
 java -Dthin.dryrun=true -jar stub-runner-boot.jar --thin.profile=rabbit && \
 java -Dthin.dryrun=true -jar stub-runner-boot.jar --thin.profile=kafka && \
 awk '{ sub("\r$", ""); print }' /run.sh > /run_unix.sh && \
 chmod +x /run_unix.sh
CMD ["/run_unix.sh"]
