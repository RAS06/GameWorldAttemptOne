package Main;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Attempt One");

        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);

        frame.pack();


        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gamePanel.startGameThread();


    }

}