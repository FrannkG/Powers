/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.power.logic;

import com.power.model.Board;

/**
 * Pluggable win rule. The requirements call for a different win
 * condition than 2048 "later down the line" — new rules implement
 * this interface and get passed to the GameEngine.
 */
public interface WinCondition {

    /** @return true if the board state counts as a win. */
    boolean isMet(Board board, int score);

    /** Short text shown in the UI, e.g. "Reach 2048". */
    String describe();
}
