package com.hero.initializer.service.impl;

import com.hero.initializer.dao.NbUserDao;
import com.hero.initializer.entity.NbUser;
import com.hero.initializer.service.NbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户表(NbUser)表服务实现类
 *
 * @author maccura
 * @since 2020-09-14 15:15:37
 */
@Service("nbUserService")
public class NbUserServiceImpl implements NbUserService {
    @Resource
    private NbUserDao nbUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public NbUser queryById(Integer id) {
        return this.nbUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<NbUser> queryAllByLimit(int offset, int limit) {
        return this.nbUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param nbUser 实例对象
     * @return 实例对象
     */
    @Override
    public NbUser insert(NbUser nbUser) {
        this.nbUserDao.insert(nbUser);
        return nbUser;
    }

    /**
     * 修改数据
     *
     * @param nbUser 实例对象
     * @return 实例对象
     */
    @Override
    public NbUser update(NbUser nbUser) {
        this.nbUserDao.update(nbUser);
        return this.queryById(nbUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.nbUserDao.deleteById(id) > 0;
    }
}