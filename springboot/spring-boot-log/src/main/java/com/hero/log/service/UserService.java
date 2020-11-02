package com.hero.log.service;

import com.hero.log.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @description: UserService
 * @date: 2020/11/2
 * @author: bear
 * @version: 1.0
 */
@Component
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    public void log() {
        logger.debug("service debug log");
        logger.info("service info log");
        logger.warn("service warn log");
        logger.error("service error log");
    }
}
