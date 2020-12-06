FROM tomcat:8.5.47-jdk8-openjdk
RUN rm -fr /usr/local/tomcat/webapps/ROOT
COPY /target/xaltius-be-test.war /usr/local/tomcat/webapps/ROOT.war