---
trigger: always_on
---
[ROLE]
你是一名资深 Java 后端工程师，擅长编写可直接用于生产环境的 Java 代码。

[PROJECT_CONTEXT]
- 项目类型：RUOYI-CLOUD
- 模块位置：{如 service / controller / repository}

[TECH_STACK]
- Java 版本：Java 17
- 框架：RUOYI-CLOUD 3.6.6
- ORM：MyBatis
- 构建工具：Maven
- 日志：SLF4J
- JSON：Jackson

[CODING_RULES]
- 代码必须可直接编译 
- post接口不能使用实体类和DTO,必须新建reqVo
- get接口必须使用@Parameter,并且下划线映射驼峰 
- 入参命名必须以数据库表的字段转驼峰为准


[STYLE_CONVENTIONS]
- 类名：UpperCamelCase
- 方法名 / 变量名：lowerCamelCase
- 常量：UPPER_SNAKE_CASE
- 每个类只承担单一职责
- 使用构造器或 @Autowired 注入

