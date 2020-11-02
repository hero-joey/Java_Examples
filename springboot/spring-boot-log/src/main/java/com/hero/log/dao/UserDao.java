package com.hero.log.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @description: UserDao
 * @date: 2020/11/2
 * @author: bear
 * @version: 1.0
 */
@Component
public class UserDao {

    Logger  logger = LoggerFactory.getLogger(UserDao.class);

    public void log() {
        logger.debug("dao debug log");
        logger.info("dao info log");
        logger.warn("dao warn log");
        logger.error("dao error log");
    }
}
