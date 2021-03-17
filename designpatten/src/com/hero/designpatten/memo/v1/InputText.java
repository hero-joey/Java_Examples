package com.hero.designpatten.memo.v1;

/**
 * @description: InputText
 * @date: 2021/3/17 9:20
 * @author: maccura
 * @version: 1.0
 */
public class InputText {

    private StringBuilder text = new StringBuilder();

    public void append(String text) {
        this.text.append(text);
    }

    public String getText() {
        return text.toString();
    }

    public void setText(String text) {
        this.text.replace(0, this.text.length(), text);
    }
}
