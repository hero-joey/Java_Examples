package com.hero.mybatis.controller;

import com.hero.mybatis.entity.Person;
import com.hero.mybatis.service.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 人员表(Person)表控制层
 *
 * @author maccura
 * @since 2020-09-14 10:59:49
 */
@RestController
@RequestMapping("person")
public class PersonController {
    /**
     * 服务对象
     */
    @Resource
    private PersonService personService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Person selectOne(Integer id) {
        return this.personService.queryById(id);
    }

}