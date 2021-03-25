package com.hero.designpatten.flyweight.chinesechess.v2;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: ChessBoard
 * @date: 2021/3/24 9:30
 * @author: maccura
 * @version: 1.0
 */
public class ChessBoard {
    private Map<Integer, ChessPiece> chessPieces = new HashMap<>();
    public ChessBoard() {
        init();
    }

    private void init() {
        chessPieces.put(1, new ChessPiece(
                ChessPieceUnitFactory.getChessPiece(1), 0,0));
        chessPieces.put(2, new ChessPiece(
                ChessPieceUnitFactory.getChessPiece(2), 1,0));
        //...省略摆放其他棋子的代码...
    }

    public void move(int chessPieceId, int toPositionX, int toPositionY) {
        //...省略...
    }
}
