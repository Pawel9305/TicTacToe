package com.game.tictactoegame;

import java.util.Random;

public class BackgroundLogic {

    public String[][] boardCreator(int fields) {
        String[][] gameBoard = new String[fields][fields];
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                gameBoard[i][j] = "\s";
            }
        }
        return gameBoard;
    }

    public boolean isUsed(int x, int y, String[][] board) {
        return board[x - 1][y - 1].equals("X") || board[x - 1][y - 1].equals("O");
    }

    public void computerMove(String[][] board) {
        boolean isInUse = true;
        while (isInUse) {
            int moveRow = new Random().nextInt(board.length);
            int moveColumn = new Random().nextInt(board.length);
            if (!board[moveRow][moveColumn].equals("X") && !board[moveRow][moveColumn].equals("O")) {
                board[moveRow][moveColumn] = "O";
                isInUse = false;
            }
        }
    }
}
