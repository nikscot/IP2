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
        String mark = model.getMark(row, col).representation();
        button[row][col].setText(mark);
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
        TicTacToeGUI panel = new TicTacToeGUI();
        JFrame frame = new JFrame("Tic Tac Toe");
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.pack(); 
    }
}