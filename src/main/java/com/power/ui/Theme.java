/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.power.ui;

import java.awt.Color;
import java.awt.Font;

/**
 * Power's own visual identity: a dark theme with round power
 * orbs that heat up from cool teal to electric yellow as values grow.
 * (Deliberately different from 2048's beige/orange square tiles.)
 */
public final class Theme {

    private Theme() {}

    // Surfaces
    public static final Color BACKGROUND  = new Color(0x0E1120);
    public static final Color BOARD       = new Color(0x161A2E);
    public static final Color BOARD_EDGE  = new Color(0x2A3050);
    public static final Color EMPTY_SLOT  = new Color(0x232842);
    public static final Color CHIP        = new Color(0x1B2038);

    // Text
    public static final Color TEXT        = new Color(0xE8EAF6);
    public static final Color TEXT_MUTED  = new Color(0x8A90B4);
    public static final Color TEXT_ON_BRIGHT = new Color(0x14162A);

    // Accent (buttons, meter, title)
    public static final Color ACCENT      = new Color(0x00E5C3);
    public static final Color ACCENT_2    = new Color(0xFF3D9A);

    public static final Font TITLE_FONT  = new Font("SansSerif", Font.BOLD, 34);
    public static final Font LABEL_FONT  = new Font("SansSerif", Font.BOLD, 10);
    public static final Font SCORE_FONT  = new Font("SansSerif", Font.BOLD, 22);
    public static final Font BUTTON_FONT = new Font("SansSerif", Font.BOLD, 13);
    public static final Font STATUS_FONT = new Font("SansSerif", Font.PLAIN, 12);
    public static final Font KEY_FONT    = new Font("Monospaced", Font.BOLD, 11);

    public static final int GAP = 14;
    public static final int TILE_SIZE = 96;

    /** Cool-to-hot energy ramp. */
    public static Color tileColor(int value) {
        return switch (value) {
            case 0    -> EMPTY_SLOT;
            case 2    -> new Color(0x2EC4B6); // teal
            case 4    -> new Color(0x2A9DF4); // sky
            case 8    -> new Color(0x3D5AFE); // electric blue
            case 16   -> new Color(0x6A4CFF); // indigo
            case 32   -> new Color(0x9B4DFF); // violet
            case 64   -> new Color(0xC94BFF); // purple
            case 128  -> new Color(0xF13FD0); // magenta
            case 256  -> new Color(0xFF3D9A); // hot pink
            case 512  -> new Color(0xFF5A5F); // coral red
            case 1024 -> new Color(0xFF8A3D); // orange
            case 2048 -> new Color(0xFFD60A); // electric yellow
            default   -> new Color(0xFFFFFF); // white-hot beyond the goal
        };
    }

    public static Color textColor(int value) {
        return value >= 2048 ? TEXT_ON_BRIGHT : Color.WHITE;
    }

    /** Values from 128 up get a glow halo. */
    public static boolean glows(int value) {
        return value >= 128;
    }
}
