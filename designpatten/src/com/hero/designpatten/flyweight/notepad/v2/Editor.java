package com.hero.designpatten.flyweight.notepad.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: Editor
 * @date: 2021/3/24 10:12
 * @author: maccura
 * @version: 1.0
 */
public class Editor {
    private List<Character> chars = new ArrayList<>();
    public void appendCharacter(char c, Font font, int size, int colorRGB) {
        Character character = new Character(c, CharacterStyleFactory.getStyle(font, size, colorRGB));
        chars.add(character);
    }
}
