#!/bin/sh

STATUS=$(docker exec mysql-primary sh -c 'mysql -u root -proot -e "SHOW MASTER STATUS"')

CURRENT_LOG=$(echo $STATUS | awk '{print $6}')
CURRENT_POS=$(echo $STATUS | awk '{print $7}')

SOURCE_HOST='mysql-primary'
SOURCE_USER='repl'
SOURCE_PASSWORD='password'

SET_PRIMARY_SQL="CHANGE REPLICATION SOURCE TO \
  SOURCE_HOST='$SOURCE_HOST', \
  SOURCE_USER='$SOURCE_USER', \
  SOURCE_PASSWORD='$SOURCE_PASSWORD',\
  SOURCE_LOG_FILE='$CURRENT_LOG',\
  SOURCE_LOG_POS=$CURRENT_POS;"

docker exec mysql-replica sh -c "mysql -u root -proot -e \"$SET_PRIMARY_SQL\""
docker exec mysql-replica sh -c "mysql -u root -proot -e 'SHOW SLAVE STATUS\G'"
