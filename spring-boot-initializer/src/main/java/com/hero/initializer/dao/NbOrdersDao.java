package com.hero.initializer.dao;

import com.hero.initializer.entity.NbOrders;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 订单表(NbOrders)表数据库访问层
 *
 * @author maccura
 * @since 2020-09-14 15:15:57
 */
public interface NbOrdersDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    NbOrders queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<NbOrders> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param nbOrders 实例对象
     * @return 对象列表
     */
    List<NbOrders> queryAll(NbOrders nbOrders);

    /**
     * 新增数据
     *
     * @param nbOrders 实例对象
     * @return 影响行数
     */
    int insert(NbOrders nbOrders);

    /**
     * 修改数据
     *
     * @param nbOrders 实例对象
     * @return 影响行数
     */
    int update(NbOrders nbOrders);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}