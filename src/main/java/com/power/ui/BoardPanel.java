/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.power.ui;

import com.power.model.Board;
import com.power.render.OrbTileRenderer;
import com.power.render.TileRenderer;

import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * The 4x4 grid of power orbs on a dark panel with a thin outline.
 * Purely visual: it paints whatever snapshot it's given.
 */
public class BoardPanel extends JPanel {

    private int[][] values = new int[Board.SIZE][Board.SIZE];
    private TileRenderer renderer = new OrbTileRenderer();

    public BoardPanel() {
        int side = Board.SIZE * Theme.TILE_SIZE + (Board.SIZE + 1) * Theme.GAP;
        setPreferredSize(new Dimension(side, side));
        setOpaque(false);
        setFocusable(false); // key input is handled at the frame level
    }

    /** Called by MainFrame after every move / reset. */
    public void update(int[][] snapshot) {
        this.values = snapshot;
        repaint();
    }

    /** Swap in a shape/icon renderer later without touching this class. */
    public void setTileRenderer(TileRenderer renderer) {
        this.renderer = renderer;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int side = Math.min(getWidth(), getHeight());
        int offsetX = (getWidth() - side) / 2;
        int offsetY = (getHeight() - side) / 2;

        // Board panel with a thin glowing edge
        g2.setColor(Theme.BOARD);
        g2.fillRoundRect(offsetX, offsetY, side - 1, side - 1, 28, 28);
        g2.setStroke(new BasicStroke(1.5f));
        g2.setColor(Theme.BOARD_EDGE);
        g2.drawRoundRect(offsetX, offsetY, side - 1, side - 1, 28, 28);

        int tile = (side - (Board.SIZE + 1) * Theme.GAP) / Board.SIZE;

        for (int r = 0; r < Board.SIZE; r++) {
            for (int c = 0; c < Board.SIZE; c++) {
                int x = offsetX + Theme.GAP + c * (tile + Theme.GAP);
                int y = offsetY + Theme.GAP + r * (tile + Theme.GAP);
                Graphics2D tg = (Graphics2D) g2.create(x, y, tile, tile);
                renderer.render(tg, values[r][c], tile);
                tg.dispose();
            }
        }
        g2.dispose();
    }
}
