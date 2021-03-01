package com.hero.designpatten.Idgenerator;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @description: IdGenerator
 * @date: 2021/2/25 10:55
 * @author: maccura
 * @version: 1.0
 */
public class IdGenerator {

    public static String generate() {
        String id = null;

        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            System.out.println(hostName);

            String[] splits = hostName.split("\\.");
            if (splits.length > 0) {
                hostName = splits[0];
            }

            char[] randomChars = new char[8];
            int count = 0;
            Random random = new Random();

            while (count < 8) {
                int randomAscii = random.nextInt(122);

                if (randomAscii >= 48 && randomAscii <= 57) {
                    randomChars[count] = (char)('0' + (randomAscii - 48));
                    count++;
                } else if (randomAscii >= 65 && randomAscii <= 90) {
                    randomChars[count] = (char)('A' + (randomAscii - 65));
                    count++;
                } else if (randomAscii >= 97 && randomAscii <= 122) {
                    randomChars[count] = (char)('a' + (randomAscii - 97));
                    count++;
                }

            }

            id = String.format("%s-%d-%s", hostName, System.currentTimeMillis(), new String(randomChars));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return id;
    }

    public static void main(String[] args) {
        System.out.println(generate());
    }

}
