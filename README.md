Datbase: ![image](https://github.com/DQLIU1995/little-cafe/assets/88858740/b7de0bd4-d985-449c-a5d9-8540da447530)

Basic Feature

- All Users are able to see the menu
- Manager is able to log in and modify the menu or modidy the category


Set up
- I use Default Setting in Idea Springboot/Maven to set up the project


Dependencies: 
In Pom.xml file

Application properties: 
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=${DATABASE_ENDPOINT}
spring.datasource.username=${DATABASE_USER_NAME}
spring.datasource.password=${DATABASE_PASSWORD}
mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
mybatis.configuration.map-underscore-to-camel-case=true
spring.servlet.multipart.max-file-size=100MB
spring.servlet.multipart.max-request-size=100MB

Project Description: 
- ![image](https://github.com/DQLIU1995/little-cafe/assets/88858740/9a16319f-792c-43b3-b731-c61be77899cf)
