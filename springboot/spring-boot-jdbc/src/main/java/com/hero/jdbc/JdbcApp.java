package com.hero.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description: 1.加上数据库驱动
 * 2.配置
 * 3.以上操作,springboot会自动配置好DataSource JdbcTemplate
 * 4.默认支持4种datasource:tomcat，dbcp
 * 5.自己配置数据源，只需要注入datasource到spring容器中
 * 6.首先要启用事务EnableTransactionManagement，然后在相应操作中增加Transactional注解
 * 注意：默认只会对运行时事务做回滚处理，非运行时异常不会回滚事务，rollbackFor字段可以指定回滚异常
 * 7.事务要生效，需要在最外层调用的函数增加Transactional注解,内部函数不会生效
 * @param:p
 * @return:
 * @auther: bear
 * @date: 2020/10/20
 */

@EnableTransactionManagement
@SpringBootApplication
public class JdbcApp {
    public static void main(String[] args) throws SQLException {
        SpringApplication springApplication = new SpringApplication(JdbcApp.class);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
        System.out.println(configurableApplicationContext.getBean(TestConfig.class).toString());
        System.out.println(configurableApplicationContext.getBean(DataSource.class));
        System.out.println(configurableApplicationContext.getBean(JdbcTemplate.class));
        DataSource dataSource = configurableApplicationContext.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection.getCatalog());
        System.out.println(dataSource.getClass().getSimpleName());
        configurableApplicationContext.getBean(CompanyDao.class).insertProduct("mp3");
        configurableApplicationContext.getBean(CompanyDao.class).insertProduct("mp4");
        //configurableApplicationContext.getBean(CompanyDao.class).insertProduct("mp3");
        configurableApplicationContext.close();

    }
}
