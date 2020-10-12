package com.hero.initializer.controller;

import com.hero.initializer.entity.NbUser;
import com.hero.initializer.service.NbUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户表(NbUser)表控制层
 *
 * @author maccura
 * @since 2020-09-14 15:15:37
 */
@RestController
@RequestMapping("nbUser")
public class NbUserController {
    /**
     * 服务对象
     */
    @Resource
    private NbUserService nbUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public NbUser selectOne(Integer id) {
        return this.nbUserService.queryById(id);
    }

}