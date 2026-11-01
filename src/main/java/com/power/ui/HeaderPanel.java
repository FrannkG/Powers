/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.power.ui;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;

/**
 * Top bar: spaced-out POWER wordmark + goal on the left, stat chips and
 * the New Game pill on the right, and a power-level meter underneath.
 */
public class HeaderPanel extends JPanel {

    private final JLabel scoreValue = new JLabel("0");
    private final JLabel bestValue = new JLabel("0");
    private final JLabel goalLabel = new JLabel(" ");
    private final PillButton resetButton = new PillButton("New Game");
    private final PowerMeter meter = new PowerMeter();

    public HeaderPanel() {
        setLayout(new BorderLayout(0, 16));
        setOpaque(false);

        JPanel top = new JPanel(new BorderLayout(Theme.GAP, 0));
        top.setOpaque(false);

        // Left: wordmark + goal
        JPanel left = new JPanel();
        left.setOpaque(false);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("P O W E R S");
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Theme.ACCENT);
        goalLabel.setFont(Theme.STATUS_FONT);
        goalLabel.setForeground(Theme.TEXT_MUTED);
        left.add(title);
        left.add(Box.createVerticalStrut(2));
        left.add(goalLabel);
        top.add(left, BorderLayout.WEST);

        // Right: chips + button
        JPanel right = new JPanel();
        right.setOpaque(false);
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));

        JPanel chips = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        chips.setOpaque(false);
        chips.add(statChip("SCORE", scoreValue, Theme.ACCENT));
        chips.add(statChip("BEST", bestValue, Theme.ACCENT_2));
        chips.setAlignmentX(Component.RIGHT_ALIGNMENT);
        right.add(chips);
        right.add(Box.createVerticalStrut(10));

        JPanel buttonRow = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        buttonRow.setOpaque(false);
        buttonRow.add(resetButton);
        buttonRow.setAlignmentX(Component.RIGHT_ALIGNMENT);
        right.add(buttonRow);

        top.add(right, BorderLayout.EAST);

        add(top, BorderLayout.CENTER);
        add(meter, BorderLayout.SOUTH);
    }

    /** Rounded dark chip with a colored stripe on the left. */
    private JPanel statChip(String label, JLabel value, Color stripe) {
        JPanel chip = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Theme.CHIP);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 14, 14);
                g2.setColor(stripe);
                g2.fillRoundRect(0, 8, 4, getHeight() - 16, 4, 4);
                g2.dispose();
            }
        };
        chip.setOpaque(false);
        chip.setBorder(BorderFactory.createEmptyBorder(6, 16, 6, 18));
        JLabel l = new JLabel(label);
        l.setFont(Theme.LABEL_FONT);
        l.setForeground(Theme.TEXT_MUTED);
        value.setFont(Theme.SCORE_FONT);
        value.setForeground(Theme.TEXT);
        chip.add(l, BorderLayout.NORTH);
        chip.add(value, BorderLayout.CENTER);
        return chip;
    }

    public void setScore(int score) {
        scoreValue.setText(String.valueOf(score));
    }

    public void setHighScore(int best) {
        bestValue.setText(String.valueOf(best));
    }

    public void setGoal(String text) {
        goalLabel.setText("Goal: " + text);
    }

    public void setPower(double progress, String label) {
        meter.setProgress(progress, label);
    }

    public void onReset(ActionListener listener) {
        resetButton.addActionListener(listener);
    }
}

