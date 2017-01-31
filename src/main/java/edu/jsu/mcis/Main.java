package edu.jsu.mcis;

import java.awt.Point;
import java.util.Scanner;

public class Main {
    private static final Scanner keyboard = new Scanner(System.in);

    private static Point getUserMove() {
        System.out.print("Enter a location: ");
        int row = keyboard.nextInt();
        int col = keyboard.nextInt();
        return new Point(row, col);
    }
    
    private static void controlModel(TicTacToe model) {
        boolean success = false;
        while(!success) {
            Point move = getUserMove();
            success = model.setMark(move.x, move.y);
            if(!success) {
                System.out.println("The location (" + move.x + ", " + move.y + ") is not valid. Choose again.");
            }
        }
    }
    
    private static void viewModel(TicTacToe model) {
        System.out.println("\n" + model + "\n");
    }

	public static void main(String[] args) {
        TicTacToe model = new TicTacToe();
        TicTacToe.Result result = TicTacToe.Result.NONE;
        while(result == TicTacToe.Result.NONE) {
            String turn = (model.changeToX())? "X" : "O";
            viewModel(model);
            System.out.println("It is " + turn + "'s turn.");
            controlModel(model);
            result = model.getResult();
        }
        String conclusion = "The game is a tie.";
        if(result == TicTacToe.Result.XWINS) conclusion = "X wins!";
        else if(result == TicTacToe.Result.OWINS) conclusion = "O wins!";
        System.out.println(conclusion);
	}
}














