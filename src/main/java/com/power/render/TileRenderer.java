/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.power.render;

import java.awt.Graphics2D;

/**
 * Draws the face of a single tile. The requirements mention possibly
 * swapping numbers for shapes or icons later — that becomes a new
 * implementation of this interface, with no changes to BoardPanel.
 */
public interface TileRenderer {

    /**
     * @param g     graphics already translated so (0,0) is the tile's top-left
     * @param value tile value (0 = empty)
     * @param size  tile width/height in pixels
     */
    void render(Graphics2D g, int value, int size);
}
