# fastlms

> src/main/resources/application.yml
```java
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/fastlms?serverTimezone=Asia/Seoul&characterEncoding=UTF-8
    username: root
    password: password

  jpa:
    generate-ddl: true
    hibernate:
      ddl-auto: update
    show-sql: true
    
  mail:
    host: smtp.gmail.com
    port: 587
    username: ekswn120@gmail.com
    password: password
    properties:
      mail:
        smtp:
          starttls:
            enable: true
            
logging:
  level:
    root: info
    
mybatis:
  mapper-locations: mybatis/**/*.xml
  configuration:
    map-underscore-to-camel-case: true
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```
