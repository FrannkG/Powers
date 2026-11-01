package com.power.ui;

import com.power.input.InputHandler;
import com.power.logic.Direction;
import com.power.logic.GameEngine;
import com.power.logic.MoveResult;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Main window / layout:
 *
 *   +-----------------------------------------+
 *   | P O W E R           [SCORE] [BEST]      |
 *   | Goal: ...           ( NEW GAME )        |
 *   | POWER LEVEL ===========-------- 2^11    |
 *   +-----------------------------------------+
 *   |            4 x 4 grid of orbs           |
 *   +-----------------------------------------+
 *   | [↑][↓][←][→] / WASD move   [R] reset    |
 *   +-----------------------------------------+
 */
public class MainFrame extends JFrame {

    private final GameEngine engine;
    private final HeaderPanel header = new HeaderPanel();
    private final BoardPanel board = new BoardPanel();
    private final JLabel status = new JLabel(" ");

    public MainFrame(GameEngine engine) {
        super("Powers");
        this.engine = engine;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel root = new JPanel(new BorderLayout(0, 18));
        root.setBackground(Theme.BACKGROUND);
        root.setBorder(BorderFactory.createEmptyBorder(22, 22, 18, 22));

        root.add(header, BorderLayout.NORTH);
        root.add(board, BorderLayout.CENTER);
        root.add(buildFooter(), BorderLayout.SOUTH);
        setContentPane(root);

        header.onReset(e -> resetGame());
        InputHandler.install(root, this::handleMove, this::resetGame);

        refresh();
        pack();
        setMinimumSize(getSize());
        setLocationRelativeTo(null);
    }

    /** Footer: keycap hints on the left, status message on the right. */
    private JPanel buildFooter() {
        JPanel footer = new JPanel(new BorderLayout());
        footer.setOpaque(false);

        JPanel keys = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        keys.setOpaque(false);
        for (String k : new String[]{"↑", "↓", "←", "→"}) {
            keys.add(keycap(k));
        }
        keys.add(hint(" / "));
        keys.add(keycap("WASD"));
        keys.add(hint(" move    "));
        keys.add(keycap("R"));
        keys.add(hint(" reset"));
        footer.add(keys, BorderLayout.WEST);

        status.setFont(Theme.STATUS_FONT);
        status.setForeground(Theme.TEXT_MUTED);
        footer.add(status, BorderLayout.EAST);
        return footer;
    }

    private JLabel keycap(String text) {
        JLabel l = new JLabel(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Theme.CHIP);
                g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 8, 8);
                g2.setColor(Theme.BOARD_EDGE);
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 8, 8);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        l.setFont(Theme.KEY_FONT);
        l.setForeground(Theme.TEXT);
        l.setBorder(BorderFactory.createEmptyBorder(3, 7, 3, 7));
        return l;
    }

    private JLabel hint(String text) {
        JLabel l = new JLabel(text);
        l.setFont(Theme.STATUS_FONT);
        l.setForeground(Theme.TEXT_MUTED);
        return l;
    }

    private void handleMove(Direction dir) {
        MoveResult result = engine.move(dir);
        status.setText(dir + "  +" + result.pointsGained() + "  (stub)");
        refresh();

        if (result.won() || engine.hasWon()) {
            JOptionPane.showMessageDialog(this, "Full power! You win.", "Power", JOptionPane.INFORMATION_MESSAGE);
        } else if (result.gameOver() || engine.isGameOver()) {
            JOptionPane.showMessageDialog(this, "Out of moves. Game over.", "Power", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void resetGame() {
        engine.newGame();
        status.setText("New game");
        refresh();
    }

    /** Pull current state from the engine and push it into the views. */
    private void refresh() {
        board.update(engine.getBoardSnapshot());
        header.setScore(engine.getScore());
        header.setHighScore(engine.getHighScore());
        header.setGoal(engine.getGoalText());

        int highest = engine.getHighestTile();
        int goal = engine.getGoalTile();
        int exp = highest == 0 ? 0 : Integer.numberOfTrailingZeros(highest);
        int goalExp = Integer.numberOfTrailingZeros(goal);
        header.setPower((double) exp / goalExp, "2^" + exp + " / 2^" + goalExp);
    }
}
