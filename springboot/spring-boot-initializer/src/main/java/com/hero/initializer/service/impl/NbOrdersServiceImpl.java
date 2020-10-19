package com.hero.initializer.service.impl;

import com.hero.initializer.entity.NbOrders;
import com.hero.initializer.dao.NbOrdersDao;
import com.hero.initializer.service.NbOrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单表(NbOrders)表服务实现类
 *
 * @author maccura
 * @since 2020-09-14 15:15:57
 */
@Service("nbOrdersService")
public class NbOrdersServiceImpl implements NbOrdersService {
    @Resource
    private NbOrdersDao nbOrdersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public NbOrders queryById(Integer id) {
        return this.nbOrdersDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<NbOrders> queryAllByLimit(int offset, int limit) {
        return this.nbOrdersDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param nbOrders 实例对象
     * @return 实例对象
     */
    @Override
    public NbOrders insert(NbOrders nbOrders) {
        this.nbOrdersDao.insert(nbOrders);
        return nbOrders;
    }

    /**
     * 修改数据
     *
     * @param nbOrders 实例对象
     * @return 实例对象
     */
    @Override
    public NbOrders update(NbOrders nbOrders) {
        this.nbOrdersDao.update(nbOrders);
        return this.queryById(nbOrders.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.nbOrdersDao.deleteById(id) > 0;
    }
}