package com.hero.designpatten.flyweight.chinesechess.v2;

/**
 * @description: ChessPiece
 * @date: 2021/3/24 9:29
 * @author: maccura
 * @version: 1.0
 */
public class ChessPiece {
    private ChessPieceUnit chessPieceUnit;
    private int positionX;
    private int positionY;
    public ChessPiece(ChessPieceUnit unit, int positionX, int positionY) {
        this.chessPieceUnit = unit;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    // 省略getter、setter方法
}
