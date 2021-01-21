package com.hero.zookeeper;

import com.hero.zookeeper.idmaker.IdMaker;
import org.junit.Test;

/**
 * @description: IdMakerTest
 * @date: 2021/1/21
 * @author: bear
 * @version: 1.0
 */
public class IdMakerTest {
    @Test
    public void testMakeId() {
        String nodeName = "/test/Id/ID_";
        for (int i = 0; i < 10; i++) {
            String id = IdMaker.makeId(nodeName);
            System.out.printf("Id值为: %s%n", id);
        }
        IdMaker.destroy();
    }
}
