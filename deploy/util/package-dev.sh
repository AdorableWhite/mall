#!/bin/bash

# 请注意
# 本脚本的作用是把本项目编译的结果保存到deploy文件夹中


DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"
cd $DIR/../..
MALL_HOME=/home/mall
#echo "MALL_HOME $ADMINSTPOWER_HOMEIN_HOME"

#cd $INSTPOWER_HOME/instpower-admin-web
# 安装阿里node镜像工具
#npm install --registry=https://registry.npm.taobao.org
# 安装node项目依赖环境
#npm install
#npm run build:dep

cd $MALL_HOME
mvn clean install -Dmaven.test.skip=true -Pdev
cp -f $MALL_HOME/mall/target/mall-0.0.1-SNAPSHOT.jar $MALL_HOME/deploy/mall/mall.jar
#cp -f $INSTPOWER_HOME/instpower-bd-api/target/instpower-bd-api-*-exec.jar $INSTPOWER_HOME/deploy/instpower/instpower-bd-api.jar
