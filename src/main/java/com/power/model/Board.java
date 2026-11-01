/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.power.model;

import java.util.Arrays;

/**
 * Data model for the 4x4 grid. Holds tile values only (0 = empty).
 * Contains no game rules — those live in the logic package.
 */
public class Board {

    public static final int SIZE = 4;

    private final int[][] cells = new int[SIZE][SIZE];

    public int get(int row, int col) {
        return cells[row][col];
    }

    public void set(int row, int col, int value) {
        cells[row][col] = value;
    }

    public void clear() {
        for (int[] row : cells) {
            Arrays.fill(row, 0);
        }
    }

    public boolean isEmpty(int row, int col) {
        return cells[row][col] == 0;
    }

    /** Returns a defensive copy so callers can't mutate the board directly. */
    public int[][] snapshot() {
        int[][] copy = new int[SIZE][];
        for (int r = 0; r < SIZE; r++) {
            copy[r] = cells[r].clone();
        }
        return copy;
    }

    /** Loads values from a 4x4 array (used by stubs and tests). */
    public void load(int[][] values) {
        for (int r = 0; r < SIZE; r++) {
            System.arraycopy(values[r], 0, cells[r], 0, SIZE);
        }
    }
}
