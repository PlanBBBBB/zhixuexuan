# 智学轩在线教育平台

## 使用教程

1.  创建数据，导入数据库文件；
2.  开启 vue 项目：`npm run serve`;
3.  开启 nacos ：`.\startup.cmd -m standalone`;
4.  开启 minio：`.\minio.exe server D:\lessons\Xuecheng\minio_data\data1 D:\lessons\Xuecheng\minio_data\data2 D:\lessons\Xuecheng\minio_data\data3 D:\lessons\Xuecheng\minio_data\data4`;
5.  开启 xxlJob：执行 `mvn package`命令将 admin 项目打包成 jar 包，再进入到 `cd D:\IdeaProjects\xxl-job-2.3.1\xxl-job-admin\target\`，然后执行`java -jar .\xxl-job-admin-2.3.1.jar `
6.  开启 nginx：进入 ` cd D:\lessons\Xuecheng\nginx-1.23.1` 执行 `start .\nginx.exe`；
7.  开启 es 和 kibana：`cd 'D:\SoftServer\elasticsearch-7.9.1\bin\'` ，然后执行 `.\elasticsearch.bat`；进入 `cd 'D:\SoftServer\kibana-7.9.1\bin\'`，执行 `.\kibana.bat`，访问 `http://127.0.0.1:5601`;
8.  开启 rabbitmq 服务：安装好 `erlang` 并配置好环境变量后，执行 `cd 'D:\Program Files\RabbitMQ Server\rabbitmq_server-3.11.8\sbin'` ，然后执行 `rabbitmq-plugins enable rabbitmq_management` ，开启服务：`rabbitmq-server start`，访问 `http://localhost:15672`，账号密码默认为 `guest`;
9.  开启 frp：`cd D:\frps\frp4` 然后执行 `frpc.exe -c frpc.ini`;
10.  开启 redis：`cd d:\Program Files\Redis`，执行命令：`redis-server redis.windows.conf`。
