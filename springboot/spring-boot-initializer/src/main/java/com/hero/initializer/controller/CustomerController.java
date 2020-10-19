package com.hero.initializer.controller;

import com.hero.initializer.entity.Customer;
import com.hero.initializer.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Customer)表控制层
 *
 * @author maccura
 * @since 2020-09-11 16:25:24
 */
@RestController
@RequestMapping("customer")
public class CustomerController {
    /**
     * 服务对象
     */
    @Resource
    private CustomerService customerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Customer selectOne(Integer id) {
        return this.customerService.queryById(id);
    }

}