package com.wch.dmall.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 数据源配置
 */
@Configuration
public class DatasourceConfig {

    @Value("${mybatis.type-aliases-package}")
    private String typeAliasesPackage;

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    @Value("${mybatis.configuration.map-underscore-to-camel-case}")
    private boolean mapUnderscoreToCamelCase;

    /**
     * 用户数据源
     *
     * @return
     * @throws Exception
     */
    @Bean
    public DataSource userDataSource() throws Exception {
        // TODO 在Spring启动中加载全部properties
        Resource resource = new PathMatchingResourcePatternResolver().getResource("classpath:config/jdbc.properties");
        Properties properties = PropertiesLoaderUtils.loadProperties(new EncodedResource(resource));
        return DruidDataSourceFactory.createDataSource(properties);
    }

    @Bean
    public org.apache.ibatis.session.Configuration mybatisConfiguration() {
        org.apache.ibatis.session.Configuration mybatisConfiguration = new org.apache.ibatis.session.Configuration();
        mybatisConfiguration.setMapUnderscoreToCamelCase(mapUnderscoreToCamelCase);
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
        userSqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        userSqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
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
