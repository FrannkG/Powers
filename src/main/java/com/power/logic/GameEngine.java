/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.power.logic;

import com.power.model.Board;

/**
 * Core game logic facade. The UI only talks to this class.
 *
 * PHASE 2 STATUS: every method below is a STUB that returns
 * hard-coded / mock values so the UI skeleton can run end to end.
 * Phase 3 replaces the stub bodies with real slide/merge logic.
 */
public class GameEngine {

    /** Hard-coded board shown by the skeleton so every tile color is visible. */
    private static final int[][] MOCK_BOARD = {
            {2,    4,    8,   16},
            {32,   64,  128,  256},
            {512, 1024, 2048,   0},
            {0,    0,    2,     4}
    };

    private final Board board = new Board();
    private final ScoreManager scoreManager = new ScoreManager();
    private final TileSpawner spawner = new TileSpawner();
    private WinCondition winCondition = new ClassicWinCondition(2048);

    public GameEngine() {
        scoreManager.loadHighScore();
        newGame();
    }

    /** STUB: loads the mock board instead of an empty board + 2 random tiles. */
    public void newGame() {
        board.load(MOCK_BOARD);
        scoreManager.resetScore();
    }

    /**
     * STUB: slide and merge tiles in the given direction.
     * Real version: compress -> merge -> compress each row/column,
     * add merged values to score, spawn a tile if the board changed,
     * then check win / game over.
     *
     * Currently returns a fixed result and does not touch the board.
     */
    public MoveResult move(Direction direction) {
        int mockPoints = 4;
        scoreManager.add(mockPoints);
        return new MoveResult(true, mockPoints, false, false);
    }

    /** STUB: real version checks for empty cells or adjacent equal tiles. */
    public boolean canMove() {
        return true;
    }

    /** STUB: always false for now. */
    public boolean isGameOver() {
        return false;
    }

    /** STUB: delegates to the win condition, which is itself stubbed. */
    public boolean hasWon() {
        return winCondition.isMet(board, scoreManager.getScore());
    }

    // ----- Read-only accessors for the UI -----

    public int[][] getBoardSnapshot() {
        return board.snapshot();
    }

    public int getScore() {
        return scoreManager.getScore();
    }

    public int getHighScore() {
        return scoreManager.getHighScore();
    }

    public String getGoalText() {
        return winCondition.describe();
    }

    /**
     * STUB: real version scans the board for the largest value.
     * Returns a mock value so the power meter shows partial charge.
     */
    public int getHighestTile() {
        return 512;
    }

    /** Tile value the power meter counts toward. */
    public int getGoalTile() {
        return 2048;
    }

    /** Lets a future mode swap in a different win rule. */
    public void setWinCondition(WinCondition winCondition) {
        this.winCondition = winCondition;
    }
}
