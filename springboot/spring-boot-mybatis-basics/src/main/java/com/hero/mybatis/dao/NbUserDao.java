package com.hero.mybatis.dao;

import com.hero.mybatis.entity.NbUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户表(NbUser)表数据库访问层
 *
 * @author maccura
 * @since 2020-09-14 15:15:37
 */
public interface NbUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    NbUser queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<NbUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param nbUser 实例对象
     * @return 对象列表
     */
    List<NbUser> queryAll(NbUser nbUser);

    /**
     * 新增数据
     *
     * @param nbUser 实例对象
     * @return 影响行数
     */
    int insert(NbUser nbUser);

    /**
     * 修改数据
     *
     * @param nbUser 实例对象
     * @return 影响行数
     */
    int update(NbUser nbUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}