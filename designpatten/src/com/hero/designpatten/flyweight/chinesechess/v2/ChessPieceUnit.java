package com.hero.designpatten.flyweight.chinesechess.v2;

/**
 * @description: ChessPiece
 * @date: 2021/3/24 9:16
 * @author: maccura
 * @version: 1.0
 */
public class ChessPieceUnit {
    private int id;
    private String text;
    private Color color;

    public ChessPieceUnit(int id, String text, Color color) {
        this.id = id;
        this.text = text;
        this.color = color;
    }

    public enum Color {
        RED,
         BLACK;
    }
}
