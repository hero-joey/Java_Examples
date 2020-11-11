package com.hero.test;

import com.hero.test.controller.BookController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @description: BookControllerTest
 * WebMvcTest不需要执行在web环境中执行
 * @date: 2020/11/9
 * @author: bear
 * @version: 1.0
 */

@RunWith(SpringRunner.class)
//这种方式只测试controller，不会加载spring容器, 如果依赖其他bean会测试失败
//SpringBootTest会加载整个容器
@WebMvcTest(controllers = BookController.class)
public class BookControllerTest2 {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testBookHome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book/home")).andExpect(MockMvcResultMatchers.status().isOk());
        //mockMvc.perform(MockMvcRequestBuilders.get("/book/home")).andExpect(MockMvcResultMatchers.content().string("aaa"));
    }

    @Test
    public void testShow() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book/show").param("id", "400")).andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/book/show").param("id", "400")).andExpect(MockMvcResultMatchers.content().string("book400"));
    }

}
