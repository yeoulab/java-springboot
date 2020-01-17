# java-springboot
java springboot test


# Mysql Docker run
docker run -d --name mysql -v /var/lib/mysql:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root mysql

# Mysql 실행 후, database 생성
1) docker exec -it mysql /bin/bash
2) mysql -u root -p -> 패스워드입력
3) CREATE DATABASE test DEFAULT CHARACTER UTF8;
4) show databases;
