/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.power.render;

import com.power.ui.Theme;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;

/**
 * Power's default tile look: round "power orbs" instead of squares.
 * Big number in the middle, with a small 2ⁿ exponent badge underneath
 * as a nod to the game's name.
 */
public class OrbTileRenderer implements TileRenderer {

    @Override
    public void render(Graphics2D g, int value, int size) {
        int pad = size / 14;
        int d = size - pad * 2;

        if (value == 0) {
            // Empty slot: a dim ring
            g.setColor(Theme.EMPTY_SLOT);
            g.fillOval(pad, pad, d, d);
            g.setStroke(new BasicStroke(2f));
            g.setColor(Theme.BOARD_EDGE);
            g.drawOval(pad + 1, pad + 1, d - 2, d - 2);
            return;
        }

        Color base = Theme.tileColor(value);

        // Glow halo for high values
        if (Theme.glows(value)) {
            float r = size / 2f;
            Color inner = new Color(base.getRed(), base.getGreen(), base.getBlue(), 120);
            Color outer = new Color(base.getRed(), base.getGreen(), base.getBlue(), 0);
            g.setPaint(new RadialGradientPaint(new Point2D.Float(r, r), r,
                    new float[]{0.6f, 1f}, new Color[]{inner, outer}));
            g.fillOval(0, 0, size, size);
        }

        // Orb body: lighter at top, darker at bottom
        g.setPaint(new GradientPaint(0, pad, base.brighter(), 0, pad + d, base.darker()));
        g.fillOval(pad, pad, d, d);

        // Glossy highlight
        g.setColor(new Color(255, 255, 255, 45));
        g.fillOval(pad + d / 5, pad + d / 10, d * 3 / 5, d / 3);

        // Number
        String text = String.valueOf(value);
        int fontSize = text.length() <= 2 ? size * 2 / 5 : text.length() == 3 ? size / 3 : size / 4;
        g.setFont(new Font("SansSerif", Font.BOLD, fontSize));
        g.setColor(Theme.textColor(value));
        FontMetrics fm = g.getFontMetrics();
        int x = (size - fm.stringWidth(text)) / 2;
        int y = (size - fm.getHeight()) / 2 + fm.getAscent() - size / 20;
        g.drawString(text, x, y);

        // Exponent badge: 2ⁿ
        int exp = Integer.numberOfTrailingZeros(value);
        String badge = "2^" + exp;
        g.setFont(new Font("SansSerif", Font.BOLD, Math.max(9, size / 9)));
        FontMetrics bm = g.getFontMetrics();
        Color c = Theme.textColor(value);
        g.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), 170));
        g.drawString(badge, (size - bm.stringWidth(badge)) / 2, y + bm.getAscent() + size / 30);
    }
}
