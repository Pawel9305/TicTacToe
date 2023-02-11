package com.game.tictactoegame;

public class Player {
    private String symbol;

    public Player(String symbol) {
        this.symbol = symbol;
    }

    public void playerMove(int x, int y, String[][] board) {
        board[x - 1][y - 1] = this.symbol.toUpperCase();
    }


}
