/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.power.ui;

import javax.swing.JButton;
import java.awt.BasicStroke;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/** Outlined, pill-shaped button that fills with the accent color on hover. */
public class PillButton extends JButton {

    private boolean hover;

    public PillButton(String text) {
        super(text);
        setFont(Theme.BUTTON_FONT);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setFocusable(false); // keep arrow keys going to the board
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setPreferredSize(new Dimension(130, 34));
        addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) { hover = true;  repaint(); }
            @Override public void mouseExited(MouseEvent e)  { hover = false; repaint(); }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        int w = getWidth() - 2, h = getHeight() - 2;

        if (hover || getModel().isPressed()) {
            g2.setColor(Theme.ACCENT);
            g2.fillRoundRect(1, 1, w, h, h, h);
            g2.setColor(Theme.TEXT_ON_BRIGHT);
        } else {
            g2.setStroke(new BasicStroke(2f));
            g2.setColor(Theme.ACCENT);
            g2.drawRoundRect(1, 1, w, h, h, h);
        }

        FontMetrics fm = g2.getFontMetrics(getFont());
        g2.setFont(getFont());
        String t = getText().toUpperCase();
        g2.drawString(t, (getWidth() - fm.stringWidth(t)) / 2,
                (getHeight() - fm.getHeight()) / 2 + fm.getAscent());
        g2.dispose();
    }
}
