package com.hero.designpatten.IdGeneratorRefine;

import sun.font.TrueTypeFont;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @description: RandomIdGenerator
 * @date: 2021/2/26 14:26
 * @author: maccura
 * @version: 1.0
 */
public class RandomIdGenerator implements IdGenerator {

    private String generateRandomAlphameric(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("hostname不能为空");
        }

        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();

        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);

            boolean isDigital = randomAscii > '0' && randomAscii < '9';
            boolean isUppercase = randomAscii > 'A' && randomAscii < 'Z';
            boolean isLowercase = randomAscii > 'a' && randomAscii < 'z';

            if (isDigital || isUppercase || isLowercase) {
                randomChars[count] = (char) randomAscii;
                ++count;
            }
        }

        return new String(randomChars);
    }

    private String getLastSubstrSplitByDot(String hostName) {
        if (hostName == null || hostName.isEmpty()) {
            throw new IllegalArgumentException("hostname不能为空");
        }

        String[] tokens = hostName.split("\\.");
        return tokens[tokens.length - 1];
    }

    private String getLastFiledOfHostName() throws UnknownHostException {
        String substrOfHostName = null;
        String hostName = InetAddress.getLocalHost().getHostName();
        if (hostName == null || hostName.isEmpty()) {
            throw new UnknownHostException("hostname不能为空");
        }

        substrOfHostName = getLastSubstrSplitByDot(hostName);
        return substrOfHostName;
    }

    @Override
    public String generate() {
        String substrOfHostName = null;
        try {
            substrOfHostName = getLastFiledOfHostName();
        } catch (UnknownHostException e) {
            throw new IdGenerationFailureException("host name is empty");
        }

        Long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);

        return String.format("%s-%d-%s", substrOfHostName, currentTimeMillis, randomString);
    }
}
