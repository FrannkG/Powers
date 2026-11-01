/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.power.ui;

import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * A charge bar showing how close the player is to the goal tile.
 * Fills from teal to pink as the highest orb grows.
 */
public class PowerMeter extends JComponent {

    private double progress; // 0.0 - 1.0
    private String label = "";

    public PowerMeter() {
        setPreferredSize(new Dimension(100, 30));
    }

    public void setProgress(double progress, String label) {
        this.progress = Math.max(0, Math.min(1, progress));
        this.label = label;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Label row
        g2.setFont(Theme.LABEL_FONT);
        FontMetrics fm = g2.getFontMetrics();
        g2.setColor(Theme.TEXT_MUTED);
        g2.drawString("POWER LEVEL", 0, fm.getAscent());
        g2.setColor(Theme.TEXT);
        g2.drawString(label, getWidth() - fm.stringWidth(label), fm.getAscent());

        // Track
        int barY = fm.getHeight() + 6;
        int barH = 8;
        g2.setColor(Theme.CHIP);
        g2.fillRoundRect(0, barY, getWidth(), barH, barH, barH);

        // Fill
        int fill = (int) Math.round(getWidth() * progress);
        if (fill > 0) {
            g2.setPaint(new GradientPaint(0, 0, Theme.ACCENT, getWidth(), 0, Theme.ACCENT_2));
            g2.fillRoundRect(0, barY, fill, barH, barH, barH);
        }
        g2.dispose();
    }
}

