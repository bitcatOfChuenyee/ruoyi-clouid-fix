# ruoyi-demo-template (t_demo CRUD 模板说明)

本模板基于 RuoYi-Cloud 常用规范输出，强调：
- 字段不加 `demo` 前缀（如 `id/name/code/type`）。
- 数据库不使用外键，仅使用索引优化。
- 使用 **MyBatis-Plus**（对应引入 `mybatis-plus-boot-starter`），查询使用 **Mapper XML**。
- 使用 `ReqVo/ResVo` 分层，禁止直接返回实体类。
- 列表查询支持 `keyword` 关键字搜索。
- 接口使用 **Swagger** 注解（`@Tag`/`@Operation` + `@Parameter`）。
- ServiceImpl 处理逻辑加日志便于排查异常。
- 响应 `ResVo` 统一 `SnakeCase` 输出。

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

## 权限菜单 SQL (RuoYi-Cloud)
参考 `sql/ruoyi_demo_menu.sql`。

## MyBatis 下划线转驼峰配置
```yaml
mybatis:
  configuration:
    map-underscore-to-camel-case: true
```
