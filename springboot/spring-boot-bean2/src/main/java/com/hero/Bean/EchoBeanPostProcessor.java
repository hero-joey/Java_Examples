package com.hero.Bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * BeanPostProcessor����ÿ��bean��ʼ����ʱ�򣬵���һ��
 * ���ܷ���null������������оͻ�ȡ����
 * @description: EchoBeanPostProcessor
 * @date: 2020/10/8
 * @author: bear
 * @version: 1.0
 */

@Component
public class EchoBeanPostProcessor implements BeanPostProcessor {
    //����bean����װ��(�������ã�����set)���֮�󴥷�
    //������Զ�ָ����Bean��һЩ��������˵���ظö���Ĵ������
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("======postProcessBeforeInitialization======" + bean.getClass());

        if (bean instanceof User) {
            return new LogUser();
        }
        return bean;
    }


    //����bean init����֮�󴥷���
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("======postProcessAfterInitialization======"  + bean.getClass());
        return bean;
    }
}
