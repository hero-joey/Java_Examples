package com.hero.designpatten.proxy;

/**
 * @description: IUserController
 * @date: 2021/3/5 10:34
 * @author: maccura
 * @version: 1.0
 */
public interface IUserController {
    UserVo login(String telephone, String password);
    UserVo register(String telephone, String password);
}
