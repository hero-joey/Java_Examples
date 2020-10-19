package com.hero.rabbitmq.pojo;

import java.io.Serializable;

/**
 * @description: BizDetail
 * @date: 2020/9/9 16:20
 * @author: maccura
 * @version: 1.0
 */
public class BizDetail implements Serializable {
    private String bizId;
    private String bizName;
    private String bizOperator;

    public BizDetail() {
    }

    public BizDetail(String bizId, String bizName, String bizOperator) {
        this.bizId = bizId;
        this.bizName = bizName;
        this.bizOperator = bizOperator;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public String getBizOperator() {
        return bizOperator;
    }

    public void setBizOperator(String bizOperator) {
        this.bizOperator = bizOperator;
    }

    @Override
    public String toString() {
        return "BizDetail{" +
                "bizId='" + bizId + '\'' +
                ", bizName='" + bizName + '\'' +
                ", bizOperator='" + bizOperator + '\'' +
                '}';
    }
}
