/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.power.logic;

import com.power.model.Board;

/** Classic 2048 rule: win when any tile reaches the target value. */
public class ClassicWinCondition implements WinCondition {

    private final int target;

    public ClassicWinCondition(int target) {
        this.target = target;
    }

    @Override
    public boolean isMet(Board board, int score) {
        // STUB: real check will scan the board for a tile >= target.
        return false;
    }

    @Override
    public String describe() {
        return "Reach " + target;
    }
}
