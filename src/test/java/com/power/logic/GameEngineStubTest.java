/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.power.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Phase 2 smoke tests: confirm the stubs return their mock values.
 * These will be replaced with real rule tests in Phase 3.
 */
class GameEngineStubTest {

    @Test
    void newGameLoadsMockBoard() {
        GameEngine engine = new GameEngine();
        int[][] b = engine.getBoardSnapshot();
        assertEquals(2, b[0][0]);
        assertEquals(2048, b[2][2]);
        assertEquals(0, engine.getScore());
    }

    @Test
    void moveStubReturnsMockResult() {
        GameEngine engine = new GameEngine();
        MoveResult r = engine.move(Direction.LEFT);
        assertTrue(r.boardChanged());
        assertEquals(4, r.pointsGained());
        assertFalse(r.won());
        assertFalse(r.gameOver());
    }

    @Test
    void endStateStubsAreFalse() {
        GameEngine engine = new GameEngine();
        assertFalse(engine.isGameOver());
        assertFalse(engine.hasWon());
        assertTrue(engine.canMove());
    }
}

