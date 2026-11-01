/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.power.logic;

/**
 * Immutable summary of what happened after one move.
 * The UI reads this to decide what to repaint / announce.
 */
public record MoveResult(
        boolean boardChanged,
        int pointsGained,
        boolean won,
        boolean gameOver
) {
    /** Convenience value for "nothing happened". */
    public static MoveResult noChange() {
        return new MoveResult(false, 0, false, false);
    }
}
