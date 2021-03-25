package com.hero.designpatten.flyweight.notepad.v1;

/**
 * @description: Character
 * @date: 2021/3/24 9:59
 * @author: maccura
 * @version: 1.0
 */
public class Character {
    private char c;
    private Font font;
    private int size;
    private int colorRGB;

    public Character(char c, Font font, int size, int colorRGB) {
        this.c = c;
        this.font = font;
        this.size = size;
        this.colorRGB = colorRGB;
    }
}
