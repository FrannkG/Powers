package com.power.logic;

import com.power.model.Board;

import java.util.Random;

/**
 * Places a new tile in a random empty cell after each successful move.
 * Requirement: tiles spawn "with different probabilities".
 * Planned: 90% chance of 2, 10% chance of 4.
 */
public class TileSpawner {

    public static final double CHANCE_OF_FOUR = 0.10;

    private final Random random;

    public TileSpawner() {
        this(new Random());
    }

    /** Seeded constructor so tests can be deterministic. */
    public TileSpawner(Random random) {
        this.random = random;
    }

    /**
     * STUB: always spawns a 2 in the top-left cell if it is empty.
     * @return true if a tile was placed.
     */
    public boolean spawn(Board board) {
        if (board.isEmpty(0, 0)) {
            board.set(0, 0, 2);
            return true;
        }
        return false;
    }

    /** STUB: returns a hard-coded value instead of rolling probabilities. */
    public int nextTileValue() {
        return 2;
    }
}
