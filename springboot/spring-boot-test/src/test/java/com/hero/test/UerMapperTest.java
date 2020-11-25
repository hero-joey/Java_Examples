package com.hero.test;

import com.hero.test.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: UerMapperTest
 * @date: 2020/11/9
 * @author: bear
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
public class UerMapperTest {
    @MockBean
    private UserMapper userMapper;

    @Test(expected = NullPointerException.class)
    public void testCreateUser() {
        BDDMockito.given(userMapper.createUser("admin")).willReturn(1);
        BDDMockito.given(userMapper.createUser("")).willReturn(0);
        BDDMockito.given(userMapper.createUser(null)).willThrow(NullPointerException.class);

        Assert.assertEquals(Integer.valueOf(1), userMapper.createUser("admin"));
        Assert.assertEquals(Integer.valueOf(0), userMapper.createUser(""));
        Assert.assertEquals(Integer.valueOf(0), userMapper.createUser("spring"));
        Assert.assertEquals(Integer.valueOf(0), userMapper.createUser(null));
    }
}
