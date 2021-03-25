package com.hero.designpatten.flyweight.chinesechess.v1;

/**
 * @description: ChessPiece
 * @date: 2021/3/24 9:16
 * @author: maccura
 * @version: 1.0
 */
public class ChessPiece {
    private int id;
    private String text;
    private Color color;
    private int positionX;
    private int positionY;

    public ChessPiece(int id, String text, Color color, int positionX, int positionY) {
        this.id = id;
        this.text = text;
        this.color = color;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public enum Color {
        RED,
         BLACK;
    }
}
