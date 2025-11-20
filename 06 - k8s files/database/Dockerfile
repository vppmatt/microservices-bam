#note using an older version of mysql as v8+ is harder to check
FROM mysql:5.7
ARG DBPASSWORD
ENV MYSQL_ROOT_PASSWORD=${DBPASSWORD}
ENV MYSQL_DATABASE=usermanager
COPY ./init.sql /docker-entrypoint-initdb.d/init.sql
COPY mem.cnf /etc/mysql/conf.d/mem.cnf