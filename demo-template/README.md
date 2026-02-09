# t_demo CRUD 模板说明

本模板基于 RuoYi-Cloud 常用规范输出，强调：
- 字段不加 `demo` 前缀（如 `id/name/code/type`）。
- 数据库不使用外键，仅使用索引优化。
- 使用 **MyBatis-Plus**（对应引入 `mybatis-plus-boot-starter`）。
- 使用 `ReqVo/Dto/ResVo` 分层，禁止直接返回实体类。
- 列表查询支持 `keyword` 关键字搜索。
- 接口使用 **Swagger** 注解（`@Api`/`@ApiOperation`）。
- ServiceImpl 处理逻辑加日志便于排查异常。

## 依赖示例（按实际项目引入）
```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.5</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
```

## SQL
参考 `sql/t_demo.sql`。
