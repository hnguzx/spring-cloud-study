#replace.sh 用于将上次构建的结果备份，然后将新的构建结果移动到合适的位置
#!/bin/bash
# 先判断文件是否存在，如果存在，则备份
file="/home/guzx/workspace/pri_diary-0.0.1-SNAPSHOT.jar"
if [ -f "$file" ]
then
   echo "文件存在，将原文件备份"
#原来为mv
   mv /home/guzx/workspace/pri_diary-0.0.1-SNAPSHOT.jar  /home/guzx/workspace/pri_diary-0.0.1-SNAPSHOT.jar.`date +%Y%m%d%H%M%S`
fi
echo "从Jenkins中去取jar包"
mv /root/.jenkins/workspace/private_diary_java/target/pri_diary-0.0.1-SNAPSHOT.jar /home/guzx/workspace/
echo "执行到这里了,结束！"
#此处 /home/admin/workspace/personal-0.0.1-SNAPSHOT.jar根据自己实际jar包名称和路径修改
