package com.hero.designpatten.flyweight.chinesechess.v2;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: ChessPieceUnitFactory
 * @date: 2021/3/24 9:28
 * @author: maccura
 * @version: 1.0
 */
public class ChessPieceUnitFactory {
    private static final Map<Integer, ChessPieceUnit> pieces = new HashMap<>();
    static {
        pieces.put(1, new ChessPieceUnit(1, "車", ChessPieceUnit.Color.BLACK));
        pieces.put(2, new ChessPieceUnit(2,"馬", ChessPieceUnit.Color.BLACK));
        //...省略摆放其他棋子的代码...
    }

    public static ChessPieceUnit getChessPiece(int chessPieceId) {
        return pieces.get(chessPieceId);
    }
}
