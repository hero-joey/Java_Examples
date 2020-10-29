package com.hero.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: CompanyDao
 * @date: 2020/10/29
 * @author: bear
 * @version: 1.0
 */
@Repository
public class CompanyDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CompanyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void queryCustomer() {
        String sql = "select * from customers";
        jdbcTemplate.execute(sql);
    }

    public void insertProduct(String name) {
        String sql = "insert into products(name) values('"+name+"')";
        jdbcTemplate.execute(sql);
    }

    //rollbackFor字段可以指定哪些异常进行回滚
    //noRollbackFor字段可以指定哪些异常进行回滚

    @Transactional
    public void batchInsertProduct(String... names) {
        for (String name : names) {
            String sql = "insert into products(name) values('"+name+"')";
            jdbcTemplate.execute(sql);
        }
    }
}
