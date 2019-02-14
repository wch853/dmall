# 基于SpringBoot全家桶搭建项目后端工程
使用 `IDEA` 引导创建名为 `dmall` 的 `SpringBoot` 项目，选中必要的 `web` 等模块，在此项目下以 'Module' 的形式创建多个工程，项目基础结构如下：

|— dmall // 项目根目录<br/>
|&emsp;|— dmall-common // 公用接口类、工具模块、公用业务逻辑<br/>
|&emsp;|— dmall-user // 用户服务模块<br/>
|&emsp;|— dmall-product // 产品服务模块<br/>
|&emsp;|— script // 脚本文件<br/>
|&emsp;|— pom.xml // 组织pom<br/>
|&emsp;|— README.md 项目文档<br/>

## 项目环境
项目区分为 `dev`、`prd` 两个环境，分别用于本地开发、调试和生产。
```bash
# 打包参数
mvn package -P dev
# spring启动参数
spring.profiles.active=dev
```

## 基础pom配置
### 根目录下pom
- 修改打包方式为 `pom` 
```xml
    <packaging>pom</packaging>
```

- 组织 `module`
```xml
    <modules>
        <module>dmall-common</module>
        <module>dmall-user</module>
        <module>dmall-product</module>
    </modules>
```

- 修改依赖方式
使用 `<dependencyManagement>` 标签包裹原有依赖，标识子模块中的各依赖如果不标明版本号，则使用此 `pom` 中的版本号（为了统一基础包版本，多个模块公用的jar包都需要在父pom中声明版本号）。
```xml
    <dependencyManagement>
        <dependencies>
        <!-- -->
        </dependencies>
    </dependencyManagement>
```

### 子工程pom
- 以 `dmall` 项目作为 `parent`
```xml
    <parent>
        <artifactId>dmall</artifactId>
        <groupId>com.wch</groupId>
        <version>2.0-SNAPSHOT</version>
        <relativePath>../pom.xml</relativePath>
    </parent>
```

- 定义profile
本项目使用 `dev`、`prd` 两个环境，在有些情况下可能需要使用不同的配置，比如开发和生产环境用于连接数据库的域名是不同的，在这种情况下将两个域名写在统一个配置文件是不明智的，建议区分文件保存。本项目针对区分环境的文件应用到 `Maven` 的配置文件中(PS：`SpringBoot` 实际支持 `application.properties` 配置文件区分环境，但是本项目为了囊括这个知识点使用了 `Maven` 进行区分)：
```xml
    <!-- 定义两个profile -->
    <profiles>
        <profile>
            <id>dev</id>
            <properties>
                <profiles.active>dev</profiles.active>
            </properties>
            <activation>
                <!-- 默认激活 dev -->
                <activeByDefault>true</activeByDefault>
            </activation>
        </profile>
        <profile>
            <id>prd</id>
            <properties>
                <profiles.active>prd</profiles.active>
            </properties>
        </profile>
    </profiles>
    
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
        <resources>
            <resource>
                <!-- 打包所有文件 -->
                <directory>src/main/resources/</directory>
                <!-- 排除环境专用文件 -->
                <excludes>
                    <exclude>config/dev/</exclude>
                    <exclude>config/prd/</exclude>
                </excludes>
            </resource>
            <resource>
                <!-- 打包激活环境文件 -->
                <directory>src/main/resources/config/${profiles.active}/</directory>
                <!-- 打包到 resources/config 目录下-->
                <targetPath>config</targetPath>
            </resource>
        </resources>
    </build>
```

使用打包命令 `mvn package -P prfile` 来指定打包需要环境下的配置文件。

## 基础工具
### 统一响应对象
为了保持与前端交互良好的数据格式，对外的 `http` 接口服务设置统一响应对象 `com.wch.dmall.vo.ResponseVo`，其参数如下：
```java
    /**
     * 接口调用成功标志
     */
    private boolean success;

    /**
     * 接口调用状态码
     */
    private int code;

    /**
     * 接口调用消息提示
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;
```

统一响应对象的枚举定义在 `com.wch.dmall.enums.ResponseEnum`，所有响应方式都定义在此枚举中。

### 统一业务异常
有业务含义的异常在必要时以自定义异常的形式手工抛出，统一业务异常定义在 `com.wch.dmall.exception.BusinessException`。

### Json工具
用于对特定数据使用 `Json` 的方式进行序列化和反序列化，定义在 `com.wch.dmall.utils.JsonUtil`。

### Protostuff工具
`Protostuff` 序列化/反序列化的速度很快，且生成的序列化内容小。定义在 `com.wch.dmall.utils.ProtostuffUtil`。

## 集成MyBatis
### 数据库访问层依赖
- 数据访问框架：`MyBatis` 是一款半自动 `ORM` 框架，支持手写 `SQL`（更灵活），能与 `Spring` 无缝对接（配置方便），也是当下最流行的企业级 `Java` 应用配置（入坑资料多）。
- 数据库：`MySQL`，开源、免费、轻量、好用、入坑资料多、学习成本低。
- 数据源：`Druid`，被夸上天的数据源，自带监控。

### 配置
- 依赖jar包：
```xml
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
    </dependency>
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid-spring-boot-starter</artifactId>
    </dependency>
```

- 数据库配置文件 `jdbc.properties`：
```properties
url=jdbc:mysql://127.0.0.1:3306/dmall?useUnicode=true&characterEncoding=utf8&useSSL=false
username=RW_dmall
password=RW_dmall

filters=state
maxActive=20
initialSize=1
maxWait=60000
minIdle=1

timeBetweenEvictionRunsMillis=60000
minEvictableIdleTimeMillis=300000

testWhileIdle=true
testOnBorrow=false
testOnReturn=false

poolPreparedStatements=true
maxOpenPreparedStatements=20

asyncInit=true
```

- `MyBatis` 数据源配置
```java
@Configuration
public class DatasourceConfig {

    /**
     * 用户数据源
     *
     * @return
     * @throws Exception
     */
    @Bean
    public DataSource userDataSource() throws Exception {
        Resource resource = new PathMatchingResourcePatternResolver().getResource("classpath:config/jdbc.properties");
        Properties properties = PropertiesLoaderUtils.loadProperties(new EncodedResource(resource));
        return DruidDataSourceFactory.createDataSource(properties);
    }

    @Bean
    public org.apache.ibatis.session.Configuration mybatisConfiguration() {
        org.apache.ibatis.session.Configuration mybatisConfiguration = new org.apache.ibatis.session.Configuration();
        mybatisConfiguration.setMapUnderscoreToCamelCase(true);
        return mybatisConfiguration;
    }

    /**
     * 用户sqlSessionFactory
     * 没有实用自动配置的SqlSessionFactory，因此 application.properties 关于mybatis的配置需要手工配置
     *
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory userSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean userSqlSessionFactoryBean = new SqlSessionFactoryBean();
        userSqlSessionFactoryBean.setDataSource(userDataSource());
        userSqlSessionFactoryBean.setConfiguration(mybatisConfiguration());
        userSqlSessionFactoryBean.setTypeAliasesPackage("com.wch.dmall.po");
        userSqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return userSqlSessionFactoryBean.getObject();
    }

    /**
     * 用户sqlSessionTemplate
     *
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionTemplate userSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(userSqlSessionFactory());
    }
}
```

## 集成Redis
- `Redis` 连接配置
```properties
spring.redis.host=127.0.0.1
spring.redis.password=
spring.redis.timeout=10s
spring.redis.database=0
spring.redis.lettuce.pool.max-active=8
spring.redis.lettuce.pool.max-wait=-1s
spring.redis.lettuce.pool.max-idle=8
spring.redis.lettuce.pool.min-idle=0
```

- `redisTemplate` 配置
`spring-boot-starter-data-redis 2.x` 版本使用 `lettuce` 替代 `jedis` 作为底层依赖，完成上述配置后会自动装配 `redisConnectionFactory`。
替换默认装配的 `redisTemplate` （默认使用 `JdkSerializationRedisSerializer` 作为序列化工具，被序列化对象必须实现 `Serializable` 接口，且序列化的内容长度长，不易阅读）。
在有的情况下我们希望直接将二级制数据写入 `redis`，结合 `protostuff` 是个很好的选择，`ProtostuffSerializer` 的实现在 `com.wch.dmall.redis.ProtostuffSerializer`（[参考资料](https://spldeolin.com/posts/redis-template-protostuff/)）。
```java
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisConfig {

    /**
     * 对可读写要求较高的数据，其value序列化成Json格式
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    /**
     * 对可读性要求不高、频繁读写、占用内存高的数据，使用protostuff序列化
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisBytesTemplate(LettuceConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setKeySerializer(new ProtostuffSerializer());
        template.setValueSerializer(new ProtostuffSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
```

- 进一步封装 `RedisTemplate` 
`RedisTemplate` 提供的API实际很糟糕，需要进一步封装，定义在 `com.wch.dmall.redis.CacheClient`。

## 集成TestNG
- 普通测试只需在类上加 `@org.testng.annotations.Test` 注解，此类下的每个 `public` 方法都可以作为单元测试执行。
- `Spring` 集成测试可以编写一个测试父类，其它需要使用 `Spring` 的测试类只需要继承这个父类即可。
```java
@Test
@SpringBootTest
public class SpringTestBaseConfig extends AbstractTestNGSpringContextTests {
}
```