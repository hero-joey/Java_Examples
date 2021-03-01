package com.hero.designpatten.IdGeneratorRefine;

/**
 * @description: IdGenerationFailureException
 * @date: 2021/3/1 9:38
 * @author: maccura
 * @version: 1.0
 */
public class IdGenerationFailureException extends RuntimeException {
    public IdGenerationFailureException(String message) {
        super(message);
    }
}
