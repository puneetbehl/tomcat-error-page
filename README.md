# Grails 4 Application
This is an example Grails 4 application which is configured with context. It also customize Tomcat default error pages when the request is made out of context. 

For example - when you request http://localhost:8080/synchr/missing, it will show default error page from Grails. But, when you hit http://localhost:8080/missing or http://localhost:8080/synchr/% it will return the custom HTML error page under [src/main/resources/templates/error.html]


## Running with Embedded Tomcat

1. Execute `./gradlew bootRepackage` from the command line.
2. Run the application with command `java -jar build/libs/synchr-06092021-0.1.war`
