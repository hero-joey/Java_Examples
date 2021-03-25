package com.hero.designpatten.flyweight.notepad.v2;

/**
 * @description: CharacterStyle
 * @date: 2021/3/24 10:01
 * @author: maccura
 * @version: 1.0
 */
public class CharacterStyle {
    private Font font;
    private int size;
    private int colorRGB;
    public CharacterStyle(Font font, int size, int colorRGB) {
        this.font = font;
        this.size = size;
        this.colorRGB = colorRGB;
    }

    @Override
    public boolean equals(Object obj) {
        CharacterStyle otherStyle = (CharacterStyle) obj;
        return font.equals(otherStyle.font)
                && size == otherStyle.size
                && colorRGB == otherStyle.colorRGB;
    }
}
