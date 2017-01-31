package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGUI extends JFrame implements ActionListener {
    private TicTacToe model;
    private JButton[][] button;
    
    public TicTacToeGUI() {
        model = new TicTacToe();
        button = new JButton[3][3];
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));
        for(int i = 0; i < button.length; i++) {
            for(int j = 0; j < button[i].length; j++) {
                button[i][j] = new JButton();
                button[i][j].setFont(new Font("Arial", Font.PLAIN, 36));
                button[i][j].addActionListener(this);
                buttonPanel.add(button[i][j]);
            }
        }
        add(buttonPanel);
    }
    
    public void actionPerformed(ActionEvent event) {
        int row = 0;
        int col = 0;
        for(int i = 0; i < button.length; i++) {
            for(int j = 0; j < button[i].length; j++) {
                if(button[i][j] == event.getSource()) {
                    row = i;
                    col = j;
                }
            }
        }
        model.setMark(row, col);
        String tag = model.getMark(row, col).symbol();
        button[row][col].setText(tag);
        button[row][col].setEnabled(true);
        TicTacToe.Result result = model.getResult();
        if(result != TicTacToe.Result.NONE) {
            JOptionPane.showMessageDialog(this, 
                                          String.valueOf(result), 
                                          "Game Over", 
                                          JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        TicTacToeGUI window = new TicTacToeGUI();
		window.setTitle("Tic Tac Toe");		
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 400);
        window.setVisible(true);
    }
}