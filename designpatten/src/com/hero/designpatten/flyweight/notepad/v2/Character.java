package com.hero.designpatten.flyweight.notepad.v2;

/**
 * @description: Character
 * @date: 2021/3/24 10:12
 * @author: maccura
 * @version: 1.0
 */
public class Character {
    private char c;
    private CharacterStyle style;
    public Character(char c, CharacterStyle style) {
        this.c = c;
        this.style = style;
    }
}
