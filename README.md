[toc]

# Spring Annotation
## @Configuration和@Bean
**查看MainConfig**

[@Configuration解释1](https://blog.csdn.net/u012260707/article/details/52021265)

[@Configuration解释2，原理](https://www.jianshu.com/p/666c11b91b20)

@Configuration对应的就是xml文件

@Bean对应的就是xml中的bean

采用AnnotationConfigApplicationContext进行初始化

在@Bean上可以进行value的更改，也就是被Spring托管的bean的名称

## @ComponentScan和@ComponentScans
**查看MainConfig**

[@ComponentScan解释1](https://blog.csdn.net/luojinbai/article/details/85877956)

[@ComponentScan解释2](https://www.jianshu.com/p/64aac6461d5b)

@ComponentScan对应xml中<context:component-scan base-package=""/>标签

将扫描到的带@Component，@Controller，@Service，@Repository的注解托管给Spring容器

@ComponentScans可以对应多个@ComponentScan，可以进行一些规则的制定，例如针对Annotation的excludeFilter，includeFilter

## 自定义TypeFilter
**查看MyTypeFilter方法**

继承TypeFilter实现match方法，对于@ComponentScan中value对应的package下的所有class进行扫描，获取类的信息，返回true

这里需要把useDefaultFilters设置为false

## @Scope
**查看MainConfig2，IOCTest的test2方法**

[@Scope解释1](https://www.jianshu.com/p/852eae3b08d4)

- Singleton 单例，感觉是享元模式？？？
- Prototype 每次都New一个新的实例
- Request 同一个请求创建一个实例？？？
- Session 同一个session创建一个实例？？？

## @Lazy
**查看MainConfig2，IOCTest的test2方法**

[@Lazy解释1](https://blog.csdn.net/u014677702/article/details/86687311)

[@Lazy解释2](https://www.jianshu.com/p/9072400fac94)

针对于@Scope是Singleton的情况下

单实例的bean在容器启动的时候初始化

懒加载之后就是实际调用的时候才初始化

## @Conditional

**查看MainConfig2，IOCTest的test3方法，LinuxCondition，WindowsCondition**

[@Conditional解释1](https://blog.csdn.net/xcy1193068639/article/details/81491071)

[@Conditional解释2](https://www.jianshu.com/p/566f22bda03c)

@Conditional后面需要有实现了Condition接口的实现类，满足条件的bean才会被托管

这里可以配置VM Options的参数，例如：-Dos.name=Linux

@Conditional可以加在类上，也可以加在方法上

## @Import
**查看MainConfig3，IOCTest的testImport方法，MyImportSelector，ColorBeanFactory**

[@Import解释1](https://www.jianshu.com/p/56d4cadbe5c9)

[@Import解释2](https://www.jianshu.com/p/7eb0c2b214a7)

给容器中注册组件
- 包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）
- @Bean 导入第三方包里面的组件
- @Import 快速给容器导入组件
    1. @Import({类})，id默认是全类名
    2. ImportSelector，返回需要导入的组件的全类名的数组
    3. ImportBeanDefinitionRegistrar，手动注册bean
- 使用Spring提供的FactoryBean（工厂bean）
    1. 默认获取的bean是factory中的getObject对象
    2. 如果想获取工厂bean，则在名称前面添加&

## Bean的生命周期 @Bean

[bean生命周期解释1](https://www.jianshu.com/p/ebbb129612ec)

[bean生命周期解释2](https://www.jianshu.com/p/1dec08d290c1)

1. 指定初始化和销毁，通过@Bean（**查看Car，IOCTestLifeCycle还有MainConfigOfLifeCycle**）
    - 如果是单实例的bean，在容器启动的时候创建对象
        1. 通过@Bean的initMethod, destroyMethod进行初始化和销毁
    - 如果是多实例的bean，在获取对象的时候创建对象
        1. 通过@Bean的initMethod进行初始化
        2. 容器不会调用销毁方法，需要自己手动销毁
2. 通过让Bean实现InitializingBean，DisposableBean进行创建和销毁（**查看Cat，IOCTestLifeCycle还有MainConfigOfLifeCycle**）
3. 通过使用JSR250中的注解（**查看Dog，IOCTestLifeCycle还有MainConfigOfLifeCycle**）
    - @PostConstruct 初始化
    - @PreDestroy 销毁
4. BeanPostProcessor，bean的后置处理器，在bean的初始化前后进行处理工作（**查看MyBeanPostProcessor，IOCTestLifeCycle还有MainConfigOfLifeCycle**）
    - postProcessBeforeInitialization 在初始化之前调用
    - postProcessAfterInitialization 在初始化之后调用

## @PropertySource

## @Value
**查看IOCTestPropertyValue，person以及person.properties**

[@PropertySource解释1](https://www.cnblogs.com/whx7762/p/7885735.html)

1. 基本数值
2. 可以写SpEL，#{}
3. 可以写${}，取出配置文件中（properties）的值（在运行环境变量里面的值）
    
    需要添加@PropertySource
    - @PropertySource 指定property文件的位置
    - @PropertySources 指定多个property文件
    
    对应xml中的什么？
    ```xml
    <context:property-placeholder location="classpath:person.properties"/>
    ```
4. ignoreResourceNotFound

properties中的值，其实就是
```java
 ConfigurableEnvironment configurableEnvironment = annotationConfigApplicationContext.getEnvironment();
 String property = configurableEnvironment.getProperty("person.nickName");
```

## 自动加载
**查看IOCTestPropertyValue，person以及person.properties**
### @Autowired(Spring规范)
[@Autowired解释1](https://blog.csdn.net/u014677702/article/details/86687212)

[@Autowired解释2](https://www.jianshu.com/p/931cdba58cf7)

[构造器循环依赖](https://blog.csdn.net/revivedsun/article/details/84642316)

[循环依赖](https://cloud.tencent.com/developer/article/1497692)

1. 默认优先按照类型去容器中找对应的组件 applicationContext.getBean(BookDao.class);
2. 如果找到多个相同类型的组件，再将属性的名称作为组件id去容器中查找 application
.getBean("bookDao")
3. @Qualifier("bookDao")，使用@Qualifier指定需要装配的组件id，而不是使用属性名
4. 自动装配默认一定要将属性赋值好，没有就报错
5. 结合@Autowired，required=false，就不是必须的，不报错
6. @Primary，让Spring自动装配的时候，首选的bean，如果还有@Qualifier，那么就装配@Qualifier的值

**查看Boss类**
- @Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
- 在方法上写@Autowired，或者在参数上写@Autowired
- 写在有参构造器上@Autowired，如果只有一个有参的构造器，那么@Autowired可以省略
- @Bean+方法参数，默认不写@Autowired，都可以从容器中拿到bean

### @Resource(JSR250)
默认按照组件名称进行加载

不支持@Primary，不支持@Autowired(required=false)
### @Inject(JSR330)
导入javax.inject的包，和@Autowired一样

### 自定义组件想使用Spring容器底层的一些组件（ApplicationContext，BeanFactory，xxx）
**查看Red类**

[Aware解释1](https://blog.csdn.net/javaloveiphone/article/details/52143126)

自定义组件实现xxxAware，在创建对象的时候，会调用接口规定的方法注入相关组件

把Spring底层一切组件注入到自定义Bean中

是xxxProcessor处理，ApplicationContextAware=>ApplicationContextAwareProcessor

## @Profile
**查看IOCTestProfile，color.properties，mydatasource.properties，MainConfigOfProfile，MainConfigOfProfile1，
Yellow，MyDataSource**

Spring提供的激活和切换一系列组件的功能

指定组件在哪个环境的情况下才能被注册到容器中，不指定，任何环境下都能注册这个组件

如何配置使profile生效
1. 通过命令行参数，VM Options，-Dspring.profiles.active=test
2. 代码方式激活某种环境，查看IOCTestProfile test02
3. 加载配置类上，只有是指定环境的时候，整个配置类中的所有配置才能生效

## AOP
1. 导入aop模块；Spring AOP：(spring-aspects)
2. 定义一个业务逻辑类（MathCalculator）；在业务逻辑运行的时候将日志进行打印（方法之前、方法运行结束、方法出现异常，xxx）
3. 定义一个日志切面类（LogAspects）：
切面类里面的方法需要动态感知MathCalculator.div运行到哪里然后执行； 	
通知方法：
    - 前置通知(@Before)：logStart：在目标方法(div)运行之前运行
    - 后置通知(@After)：logEnd：在目标方法(div)运行结束之后运行（无论方法正常结束还是异常结束）
    - 返回通知(@AfterReturning)：logReturn：在目标方法(div)正常返回之后运行
    - 异常通知(@AfterThrowing)：logException：在目标方法(div)出现异常以后运行
    - 环绕通知(@Around)：动态代理，手动推进目标方法运行（joinPoint.procced()）
4. 给切面类的目标方法标注何时何地运行（通知注解）；
5. 将切面类和业务逻辑类（目标方法所在类）都加入到容器中;
6. 必须告诉Spring哪个类是切面类(给切面类上加一个注解：@Aspect)
7. 给配置类中加 @EnableAspectJAutoProxy 【开启基于注解的aop模式】

不要自己创建对象，要用Spring容器中的

## @Transactional
环境搭建：
1. 导入相关依赖 数据源、数据库驱动、Spring-jdbc模块
2. 配置数据源、JdbcTemplate（Spring提供的简化数据库操作的工具）操作数据
3. 给方法上标注 @Transactional 表示当前方法是一个事务方法；
4. @EnableTransactionManagement 开启基于注解的事务管理功能；
		@EnableXXX
5. 配置事务管理器来控制事务;
		@Bean
		public PlatformTransactionManager transactionManager()

