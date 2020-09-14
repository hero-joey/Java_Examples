package com.hero.mybatis.service.impl;

import com.hero.mybatis.entity.Person;
import com.hero.mybatis.dao.PersonDao;
import com.hero.mybatis.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 人员表(Person)表服务实现类
 *
 * @author maccura
 * @since 2020-09-14 10:59:49
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {
    @Resource
    private PersonDao personDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Person queryById(Integer id) {
        return this.personDao.queryById(id);
    }

    @Override
    public Person findPersonById(Integer id) {
        return this.personDao.findPersonById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Person> queryAllByLimit(int offset, int limit) {
        return this.personDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param person 实例对象
     * @return 实例对象
     */
    @Override
    public Person insert(Person person) {
        this.personDao.insert(person);
        return person;
    }

    /**
     * 修改数据
     *
     * @param person 实例对象
     * @return 实例对象
     */
    @Override
    public Person update(Person person) {
        this.personDao.update(person);
        return this.queryById(person.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.personDao.deleteById(id) > 0;
    }
}