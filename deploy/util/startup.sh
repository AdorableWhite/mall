#!/bin/sh

rabbitmq-server&

sudo /usr/local/nginx/sbin/nginx&

cd /home/instpower/instpower-api/
./start-8085.sh restart

cd /home/instpower/instpower-bd-api/
./start-8086.sh restart

cd /home/instpower/instpower-admin/
./start-8084.sh restart

cd /home/instpower/instpower-server/
./start-9104.sh restart

cd /home/instpower/instpower-testing/
./start-8899.sh restart
