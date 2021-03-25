package com.hero.designpatten.flyweight.chinesechess.v1;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: ChessBoard
 * @date: 2021/3/24 9:21
 * @author: maccura
 * @version: 1.0
 */
public class ChessBoard {
    private Map<Integer, ChessPiece> chessPieces = new HashMap<>();

    public ChessBoard() {
    }

    private void init() {
        chessPieces.put(1, new ChessPiece(1, "车", ChessPiece.Color.RED, 0, 0));
        chessPieces.put(2, new ChessPiece(2, "马", ChessPiece.Color.RED, 0, 1));
        //省略其它棋子
    }

    public void move(int chessPieceId, int toPositionX, int toPositionY) {
        //...省略...
    }
}
