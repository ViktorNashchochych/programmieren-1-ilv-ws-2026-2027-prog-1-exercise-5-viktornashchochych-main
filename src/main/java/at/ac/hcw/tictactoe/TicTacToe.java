package at.ac.hcw.tictactoe;

import java.util.Scanner;

public class TicTacToe {

    /*
    * Define instance variables
    *
    * Define a constructor
    *
    * Define public and private methods
    *
    * */
 
private char[][] gameBoard;
private Player p1;
private Player p2;

private static final int ROWS = 3;
private static final int COLS = 3;

public TicTacToe(Player p1, Player p2) {
    this.p1 = p1;
    this.p2 = p2;
    this.gameBoard = new char[ROWS][COLS];
}
  
public boolean placeTic(Player p, int row, int col) {
    if (gameBoard[row][col] != '\0') {
        return false;
    }

    gameBoard[row][col] = p.getSymbol();
    return true;
}



private void prettyPrintGameBoard() {
    for (int row = 0; row < ROWS; row++) {
        for (int col = 0; col < COLS; col++) {
            char cell = gameBoard[row][col];

            if (cell == '\0') {
                cell = (char) ('1' + row * COLS + col);
            }

            System.out.print(cell);

            if (col < COLS - 1) {
                System.out.print(" | ");
            }
        }

        System.out.println(" ");

        if (row < ROWS - 1) {
            System.out.println("--+---+--");
        }
    }
}



public boolean checkIfWon(Player p) {
    char symbol = p.getSymbol();

    // Check rows and columns
    for (int i = 0; i < 3; i++) {
        if (gameBoard[i][0] == symbol &&
            gameBoard[i][1] == symbol &&
            gameBoard[i][2] == symbol) {
            return true;
        }

        if (gameBoard[0][i] == symbol &&
            gameBoard[1][i] == symbol &&
            gameBoard[2][i] == symbol) {
            return true;
        }
    }

    // Check diagonals
    if (gameBoard[0][0] == symbol &&
        gameBoard[1][1] == symbol &&
        gameBoard[2][2] == symbol) {
        return true;
    }

    if (gameBoard[0][2] == symbol &&
        gameBoard[1][1] == symbol &&
        gameBoard[2][0] == symbol) {
        return true;
    }

    return false;
}



public void playGame() {
    Scanner scanner = new Scanner(System.in);

    for (int round = 0; round < 9; round++) {
        Player currentPlayer;

        if (round % 2 == 0) {
            currentPlayer = p1;
        } else {
            currentPlayer = p2;
        }

        prettyPrintGameBoard();
        System.out.println();

        currentPlayer.makeMove(this, scanner);

        if (checkIfWon(currentPlayer)) {
            System.out.println(currentPlayer.getName() + " has won the game!");
            prettyPrintGameBoard();
            return;
        }
    }

    System.out.println("Nobody wins!");
    prettyPrintGameBoard();
}


    public static void main(String[] args) {

        /*
        * Create Instances of Class Player like:
        * Player p1 = new Player(....);
        * Player p2 = new Player(....);
        * Create an Instance of TicTacToe itself:
        * TicTacToe ttt = new TicTacToe(....);
        * Start the game via the reference (ttt)
        * */

    }
}
