package com.hero.mybatis.service.impl;

import com.hero.mybatis.entity.IdCard;
import com.hero.mybatis.dao.IdCardDao;
import com.hero.mybatis.service.IdCardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (IdCard)表服务实现类
 *
 * @author maccura
 * @since 2020-09-14 10:57:43
 */
@Service("idCardService")
public class IdCardServiceImpl implements IdCardService {
    @Resource
    private IdCardDao idCardDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public IdCard queryById(Integer id) {
        return this.idCardDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<IdCard> queryAllByLimit(int offset, int limit) {
        return this.idCardDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param idCard 实例对象
     * @return 实例对象
     */
    @Override
    public IdCard insert(IdCard idCard) {
        this.idCardDao.insert(idCard);
        return idCard;
    }

    /**
     * 修改数据
     *
     * @param idCard 实例对象
     * @return 实例对象
     */
    @Override
    public IdCard update(IdCard idCard) {
        this.idCardDao.update(idCard);
        return this.queryById(idCard.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.idCardDao.deleteById(id) > 0;
    }
}