package com.hero.rabbitmq;

import com.hero.rabbitmq.pojo.BizDetail;
import com.hero.rabbitmq.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqAppTests {

	@Autowired
	MessageService messageService;

	@Test
	public void contextLoads() {

		messageService.sendMessage();
	}

}
