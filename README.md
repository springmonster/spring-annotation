[toc]

# Spring Annotation
## @Configuration和@Bean
**查看MainConfig**

@Configuration对应的就是xml文件

@Bean对应的就是xml中的bean

采用AnnotationConfigApplicationContext进行初始化

在@Bean上可以进行value的更改，也就是被Spring托管的bean的名称

## @ComponentScan和@ComponentScans
**查看MainConfig**

@ComponentScan对应xml中<context:component-scan base-package=""/>标签

将扫描到的带@Component，@Controller，@Service，@Repository的注解托管给Spring容器

@ComponentScans可以对应多个@ComponentScan，可以进行一些规则的制定，例如针对Annotation的excludeFilter，includeFilter

## 自定义TypeFilter
**查看MyTypeFilter方法**

继承TypeFilter实现match方法，对于@ComponentScan中value对应的package下的所有class进行扫描，获取类的信息，返回true

这里需要把useDefaultFilters设置为false

## @Scope
**查看MainConfig2，IOCTest的test2方法**
- Singleton 单例，感觉是享元模式？？？
- Prototype 每次都New一个新的实例
- Request 同一个请求创建一个实例？？？
- Session 同一个session创建一个实例？？？

## @Lazy
**查看MainConfig2，IOCTest的test2方法**

针对于@Scope是Singleton的情况下

单实例的bean在容器启动的时候初始化

懒加载之后就是实际调用的时候才初始化

## @Conditional

**查看MainConfig2，IOCTest的test3方法，LinuxCondition，WindowsCondition**

@Conditional后面需要有实现了Condition接口的实现类，满足条件的bean才会被托管

这里可以配置VM Options的参数，例如：-Dos.name=Linux

@Conditional可以加在类上，也可以加在方法上

## @Import
**查看MainConfig3，IOCTest的testImport方法，MyImportSelector，ColorBeanFactory**

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