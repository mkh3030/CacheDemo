# CacheDemo
h2 db 캐쉬 데모

# API 문서 
localhost:8080/swagger-ui.html

# h2 db console
localhost:8080/h2-console 
jdbc URL : 톰캣 구동시 jdbc:h2:mem:3cc8bb37-ba20-4f31-a6d3-c630b25cf5f0 같은 형식으로 표출됨
id : sa
pw : 없음


# 실행방법(윈도우10 기준, maven 설치필수, jdk1.8에서 작성)
git clone https://github.com/mkh3030/CacheDemo.git
cd CacheDemo
mvn compile
아래 1, 2번중 택일. 1번의 경우 jar 파일 생성. 2번의 경우 jar파일 생성없으나 환경변수 추가해야 한글깨짐 방지
1.mvn package 
  java -jar -Dfile.encoding=UTF-8 target/cacheh2-0.0.1-SNAPSHOT.jar
2.환경변수 추가(jvm 동작시 utf-8로 동작) JAVA_TOOL_OPTION=-Dfile.encoding=UTF-8
  mvn exec
  mvn exec:java -Dexec.mainClass=com.example.cacheh2.Cacheh2Application 
