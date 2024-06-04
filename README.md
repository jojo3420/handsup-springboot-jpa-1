## 실전! 스프링 부트와 JPA 활용1 - 웹 애플리케이션 개발
- 인프런: https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-JPA-%ED%99%9C%EC%9A%A9-1


## h2 DB 
```shell
h2-db/h2/bin/h2.sh
```
실행상태에서 sessionid 있는 상태에서 DB 생성 
JDBC URL: jdbc:h2:~/jpashop

이후 접속 
```shell
http://localhost:8082
```
JDBC URL: jdbc:h2:tcp://localhost/~/jpashop