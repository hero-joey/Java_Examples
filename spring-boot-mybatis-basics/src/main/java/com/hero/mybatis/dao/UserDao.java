package com.hero.mybatis.dao;

import com.hero.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * (User)表数据库访问层
 *
 * @author hero
 * @since 2020-09-13 13:38:18
 */
public interface UserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<User> findUsersByNamesAndJobs(User user);

    List<User> findUsersByUserIds(List<User> users);

    List<User> findUsersByIds(Integer[] ids);

    List<User> findUsersByNameAndIds(Map userMap);

    List<User> findUsersByNamesAndJobs2(User user);

    List<User> findUsersByNamesOrJobs(User user);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param user 实例对象
     * @return 对象列表
     */
    List<User> queryAll(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param tId 主键
     * @return 影响行数
     */
    int deleteById(Integer tId);

}