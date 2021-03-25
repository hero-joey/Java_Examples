package com.hero.designpatten.flyweight.notepad.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: CharacterStyleFactory
 * @date: 2021/3/24 10:03
 * @author: maccura
 * @version: 1.0
 */
public class CharacterStyleFactory {
    private static final List<CharacterStyle> styles = new ArrayList<>();
    public static CharacterStyle getStyle(Font font, int size, int colorRGB) {
        CharacterStyle newStyle = new CharacterStyle(font, size, colorRGB);
        for (CharacterStyle style : styles) {
            if (style.equals(newStyle)) {
                return style;
            }
        }
        styles.add(newStyle);
        return newStyle;
    }
}
