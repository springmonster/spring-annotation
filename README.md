# Spring Annotation
## @Configuration和@Bean
@Configuration对应的就是xml文件

@Bean对应的就是xml中的bean

采用AnnotationConfigApplicationContext进行初始化

在@Bean上可以进行value的更改，也就是被Spring托管的bean的名称

## @ComponentScan和@ComponentScans

@ComponentScan对应xml中<context:component-scan base-package=""/>标签

将扫描到的带@Component，@Controller，@Service，@Repository的注解托管给Spring容器

@ComponentScans可以对应多个@ComponentScan，可以进行一些规则的制定，例如针对Annotation的excludeFilter，includeFilter

## 自定义TypeFilter
继承TypeFilter实现match方法，对于@ComponentScan中value对应的package下的所有class进行扫描，获取类的信息，返回true

这里需要把useDefaultFilters设置为false