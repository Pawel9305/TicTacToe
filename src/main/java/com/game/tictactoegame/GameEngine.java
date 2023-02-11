package com.game.tictactoegame;

public final class GameEngine {

    public int checkHorizontally(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            int xCounter = 0;
            int oCounter = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals("X")) {
                    xCounter++;
                    if (xCounter == board[i].length) {
                        return 1;
                    }
                }
                if (board[i][j].equals("O")) {
                    oCounter++;
                    if (oCounter == board.length) {
                        return 2;
                    }
                }
            }
        }
        return 0;
    }

    public int checkVertically(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            int xCounter = 1;
            int oCounter = 1;
            for (int j = 1; j < board.length; j++) {
                if (board[j][i].equals("X") && board[j][i].equals(board[j - 1][i])) {
                    xCounter++;
                } else if (board[j][i].equals("O") && board[j][i].equals(board[j - 1][i])) {
                    oCounter++;
                }
                if (xCounter == board.length) {
                    return 1;
                }
                if (oCounter == board.length) {
                    return 2;
                }
            }
        }
        return 0;
    }

    public int checkCross(String[][] board) {
        int xCounter = 0;
        int oCounter = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i].equals("X")) {
                xCounter++;
                if (xCounter == board.length) {
                    return 1;
                }
            }

            if (board[i][i].equals("O")) {
                oCounter++;
                if (oCounter == board.length) {
                    return 2;
                }
            }
        }
        return 0;
    }

    public int checkReversedCross(String[][] board) {
        int xCounter = 0;
        int oCounter = 0;

        for (int i = 0; i < board.length; i++) {
            if (board[i][board.length - 1 - i].equals("X")) {
                xCounter++;
                if (xCounter == board.length) {
                    return 1;
                }
            } else if (board[i][board.length - 1 - i].equals("O")) {
                oCounter++;
                if (oCounter == board.length) {
                    return 2;
                }
            }
        }
        return 0;
    }

    public boolean isDraw(String[][] board) {
        int counter = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals("X") || board[i][j].equals("O")) {
                    counter++;
                    if (counter == board.length * board.length) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
