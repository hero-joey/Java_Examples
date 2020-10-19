package com.hero.initializer.controller;

import com.hero.initializer.entity.IdCard;
import com.hero.initializer.service.IdCardService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (IdCard)表控制层
 *
 * @author maccura
 * @since 2020-09-14 10:57:44
 */
@RestController
@RequestMapping("idCard")
public class IdCardController {
    /**
     * 服务对象
     */
    @Resource
    private IdCardService idCardService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public IdCard selectOne(Integer id) {
        return this.idCardService.queryById(id);
    }

}