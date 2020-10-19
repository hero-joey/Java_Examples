package com.hero.mybatis.service;

import com.hero.mybatis.entity.NbUser;
import java.util.List;

/**
 * 用户表(NbUser)表服务接口
 *
 * @author maccura
 * @since 2020-09-14 15:15:37
 */
public interface NbUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    NbUser queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<NbUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param nbUser 实例对象
     * @return 实例对象
     */
    NbUser insert(NbUser nbUser);

    /**
     * 修改数据
     *
     * @param nbUser 实例对象
     * @return 实例对象
     */
    NbUser update(NbUser nbUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}