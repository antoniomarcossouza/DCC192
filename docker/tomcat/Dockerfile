FROM tomcat:10-jdk17

RUN mv /usr/local/tomcat/webapps.dist/* /usr/local/tomcat/webapps/
COPY ./tomcat-users.xml /usr/local/tomcat/conf/
COPY ./context.xml /usr/local/tomcat/webapps/manager/META-INF/
COPY ./portal.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]
