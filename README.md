# sping-boot-microservies

- docker-compose up -d
- mvn clean package -DskipTests
- mcn sping-boot:run

# Docker
- Docker desktop打不开，尝试 注销以前创建的桌面镜像相关的各种数据。
- wsl --unregister docker-desktop
- wsl --unregister docker-desktop-data

- docker desktop在界面无法登录，可以用命令行 docker login

# 第一节 新建项目及三个模块

- 新建项目后，部分依赖显示 Offline 不能自动下载，需要手动。从https://mvnrepository.com/ 搜索到对应的依赖，下载jar，然后放到本地仓库。一般本地仓库的位置是 user/.m2/repository. 按照依赖的名字去放，比如依赖的名字是 com.mysql 那么还要进到对应的 ../com/mysql目录下。放好在VsCode左下角的Maven 标题右侧，选第三个选项 reload all maven projects。如果没有对应的目录存在，手动创建即可

- 多模块项目，只要在父项目根目录下有一个.mvn 这些文件就够了

- 父项目不需要 src 。POM文件里的依赖也不需要。

- 子模块 POM 文件里的 parent信息要和父项目一致。