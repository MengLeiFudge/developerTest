# developerTest
开发者测试

##项目结构
本项目使用maven构建。

程序的主入口在 src\main\java\main\Main。

测试类在 src\test\java\main\Test1。

##构建、测试与缺陷提交
测试使用 Junit + Mockito，并使用 jenkins + maven 自动构建、自动执行测试。

1.修改完毕代码后，将代码推送到 github 的仓库

2.jenkins 自动拉取项目，定时2分钟编译、测试，测试成功会自动执行 clear package，从而生成 jar 包

3.redmine 从 jenkins 获取测试中的 bug