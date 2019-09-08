元注解的作用就是负责注解其他注解，包括以下4个
@Documented
@Inherited
下面这两个是一定要写的
@Retention   表示需要在什么级别保存该注释信息，用于描述注解的生命周期（自定义应该多用RUNTIME）
@Target      用于描述注解的使用范围