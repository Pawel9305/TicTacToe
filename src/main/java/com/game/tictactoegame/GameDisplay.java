package com.game.tictactoegame;

import java.util.Scanner;

public class GameDisplay {

    public String[][] boardSizeChoice() {
        Scanner scanner = new Scanner(System.in);
        BackgroundLogic backgroundLogic = new BackgroundLogic();
        System.out.println("Welcome int TicTacToe game !\nInsert a size of a board: ");
        int size = scanner.nextInt();
        String[][] board = backgroundLogic.boardCreator(size);
        System.out.println("This is your board");
        boardDisplay(board);
        return board;
    }

    public int numberOfPlayersChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose opponent: [1 - computer/2 - another player]");
        String choice = scanner.next();
        boolean opponent = false;
        while (!opponent) {
            if (choice.equals("1") || choice.equals("2")) {
                opponent = true;
            } else {
                System.out.println("You've entered a wrong value! Insert 1 for computer or 2 for another player.");
                choice = scanner.next();
            }
        }
        if (choice.equals("2")) {
            return 2;
        } else {
            return 1;
        }
    }

    public void boardDisplay(String[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                System.out.print("|" + gameBoard[i][j]);
            }
            System.out.println("|");
        }
    }

    public void fieldChoice(String[][] board, Player player) {
        Scanner scanner = new Scanner(System.in);
        BackgroundLogic backgroundLogic = new BackgroundLogic();
        boolean used = true;
        while (used) {
            System.out.println("Select a row");
            int row = scanner.nextInt();
            int rowMove = checkAnswer(row, board);
            System.out.println("Select a column");
            int column = scanner.nextInt();
            int columnMove = checkAnswer(column, board);
            used = backgroundLogic.isUsed(rowMove, columnMove, board);
            if (used) {
                System.out.println("This field is already in use! Please try another one");
            } else {
                player.playerMove(rowMove, columnMove, board);
                boardDisplay(board);
            }
        }
    }

    private int checkAnswer(int answer, String[][] board) {
        Scanner scanner = new Scanner(System.in);
        if (answer - 1 > board.length - 1 || answer - 1 < 0) {
            boolean isCorrect = false;
            while (!isCorrect) {
                System.out.println("You've entered incorrect value! Try again");
                answer = scanner.nextInt();
                if (answer - 1 < board.length && answer - 1 >= 0) {
                    isCorrect = true;
                }
            }
        }
        return answer;
    }

    public boolean isWin(String[][] board) {
        GameEngine gameEngine = new GameEngine();
        int winHorizontally = gameEngine.checkHorizontally(board);
        int winVertically = gameEngine.checkVertically(board);
        int crossWin = gameEngine.checkCross(board);
        int revCrossWin = gameEngine.checkReversedCross(board);
        boolean draw = gameEngine.isDraw(board);
        if (winHorizontally == 1 || winVertically == 1 || crossWin == 1 || revCrossWin == 1) {
            System.out.println("X wins!");
            return true;
        } else if (winHorizontally == 2 || winVertically == 2 || crossWin == 2 || revCrossWin == 2) {
            System.out.println("O wins!");
            return true;
        } else if (draw) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }

    public void gameplay() {
        BackgroundLogic backgroundLogic = new BackgroundLogic();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            int opponents = numberOfPlayersChoice();
            Player player1 = new Player("X");
            String[][] playingBoard = boardSizeChoice();
            boolean win = false;
            while (!win) {
                System.out.println("Player1 move");
                fieldChoice(playingBoard, player1);
                win = isWin(playingBoard);
                if (win) {
                    break;
                }
                if (opponents == 1) {
                    System.out.println("It's my turn now");
                    backgroundLogic.computerMove(playingBoard);
                    boardDisplay(playingBoard);
                } else {
                    Player player2 = new Player("O");
                    System.out.println("Player2 move");
                    fieldChoice(playingBoard, player2);
                }
                win = isWin(playingBoard);
            }
            boolean correct = false;
            while (!correct) {
                System.out.println("Do you want to restart? [y/n]");
                String answer = scanner.next();
                if (answer.equals("y")) {
                    break;
                } else if (answer.equals("n")) {
                    correct = true;
                    quit = true;
                } else {
                    System.out.println("You've entered wrong value! ");
                }
            }
        }
    }
}

