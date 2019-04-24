package gui;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {

    private static final Dimension FRAME_DIMENSION = new Dimension(700, 700);
    static final int ROW_LENGTH = 8;
    static final int ROWS_NUMBER = 8;

    private MenuBar menuBar = new MenuBar();

    public Board() {
        super("Chess Without Castling");
    }

    public void drawBoard() {
        this.setResizable(false);
        this.setSize(FRAME_DIMENSION);
        this.setJMenuBar(menuBar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(new BoardPanel());
        this.setVisible(true);
    }

}