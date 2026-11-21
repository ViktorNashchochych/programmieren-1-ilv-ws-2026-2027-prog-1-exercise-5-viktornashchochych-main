package at.ac.hcw.tictactoe;

import java.util.Scanner;

public class Player {
    /*
     * Define instance variables
     *
     * Define a constructor
     *
     * Define public methods
     *
     * */

    private char symbol;
    private String name;

    
    public Player(char symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }


    public void makeMove(TicTacToe game, Scanner scanner) {
        int position;

        do {
            System.out.print(name + " make your move (choose a number): ");
            position = scanner.nextInt();
        } while (position < 1 || position > 9 ||
            !game.placeTic(this, (position - 1) / 3, (position - 1) % 3));
}

}
