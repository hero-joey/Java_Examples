package com.hero.initializer.service;

import com.hero.initializer.entity.User;
import java.util.List;
import java.util.Map;

/**
 * (User)表服务接口
 *
 * @author hero
 * @since 2020-09-13 13:38:20
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param tId 主键
     * @return 实例对象
     */
    User queryById(Integer tId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    List<User> findUsersByNames(User user);
    List<User> findUsersByNamesAndJobs(User user);

    List<User> findUsersByNamesOrJobs(User user);
    List<User> findUsersByNamesOrJobs2(User user);
    List<User> findUsersByUserIds(List<User> users);
    List<User> findUsersByIds(Integer[] ids);
    List<User> findUsersByNameAndIds(Map userMap);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param tId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer tId);

}