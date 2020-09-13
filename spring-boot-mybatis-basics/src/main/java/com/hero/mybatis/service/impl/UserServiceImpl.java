package com.hero.mybatis.service.impl;

import com.hero.mybatis.entity.User;
import com.hero.mybatis.dao.UserDao;
import com.hero.mybatis.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (User)表服务实现类
 *
 * @author hero
 * @since 2020-09-13 13:38:20
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<User> findUsersByNamesAndJobs(User user) {
        return this.userDao.findUsersByNamesAndJobs(user);
    }

    @Override
    public List<User> findUsersByNamesOrJobs(User user) {
        return this.userDao.findUsersByNamesOrJobs(user);
    }

    @Override
    public List<User> findUsersByNamesOrJobs2(User user) {
        return this.userDao.findUsersByNamesAndJobs2(user);
    }

    @Override
    public List<User> findUsersByUserIds(List<User> users) {
        return this.userDao.findUsersByUserIds(users);
    }

    @Override
    public List<User> findUsersByIds(Integer[] ids) {
        return this.userDao.findUsersByIds(ids);
    }

    @Override
    public List<User> findUsersByNameAndIds(Map userMap) {
        return this.userDao.findUsersByNameAndIds(userMap);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param tId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer tId) {
        return this.userDao.deleteById(tId) > 0;
    }
}