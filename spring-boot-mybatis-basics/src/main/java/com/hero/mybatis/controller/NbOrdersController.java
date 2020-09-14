package com.hero.mybatis.controller;

import com.hero.mybatis.entity.NbOrders;
import com.hero.mybatis.service.NbOrdersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单表(NbOrders)表控制层
 *
 * @author maccura
 * @since 2020-09-14 15:15:57
 */
@RestController
@RequestMapping("nbOrders")
public class NbOrdersController {
    /**
     * 服务对象
     */
    @Resource
    private NbOrdersService nbOrdersService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public NbOrders selectOne(Integer id) {
        return this.nbOrdersService.queryById(id);
    }

}