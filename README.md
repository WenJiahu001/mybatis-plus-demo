# mybatis-plus-demo
ok
- 单表代码生成，生成entity,dto,vo,controller,service,dao等
- 统一异常拦截，自定义异常,去掉了不必要的异常堆栈信息
- 统一参数校检，自定义验证注解
- 统一文档生成，无需手写，根据数据库注释统一生成Swagger文档
- 统一填充createTime,updateTime
- 统一逻辑删除，开发者无需关注逻辑删除
- 统一mysql乐观锁，通过注解实现乐观锁，避免多人修改数据产生的线程安全问题
- 统一aop日志 打印入参入库+自定义注解

next
- 日志异步写 方案？elk？
- security 实现简单 token验证 接入redis
- 实现rbac模型
- DockerFile 
- 借助 mybaits-plus 玩多租户
- 数据权限怎么做
- auth2.0？