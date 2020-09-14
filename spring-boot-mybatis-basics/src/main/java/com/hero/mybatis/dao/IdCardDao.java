package com.hero.mybatis.dao;

import com.hero.mybatis.entity.IdCard;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (IdCard)表数据库访问层
 *
 * @author maccura
 * @since 2020-09-14 10:57:42
 */
public interface IdCardDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    IdCard queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<IdCard> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param idCard 实例对象
     * @return 对象列表
     */
    List<IdCard> queryAll(IdCard idCard);

    /**
     * 新增数据
     *
     * @param idCard 实例对象
     * @return 影响行数
     */
    int insert(IdCard idCard);

    /**
     * 修改数据
     *
     * @param idCard 实例对象
     * @return 影响行数
     */
    int update(IdCard idCard);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}