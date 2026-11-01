/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.power.logic;

/**
 * Tracks current score and best (high) score.
 * Planned: persist high score to disk (see Storage Management in the
 * requirements doc) via java.util.prefs.Preferences or a small file.
 */
public class ScoreManager {

    private int score;
    private int highScore;

    public int getScore() {
        return score;
    }

    public int getHighScore() {
        return highScore;
    }

    public void add(int points) {
        score += points;
        if (score > highScore) {
            highScore = score;
        }
    }

    public void resetScore() {
        score = 0;
    }

    /** STUB: will read the saved high score. Returns a mock value for now. */
    public int loadHighScore() {
        highScore = 1024;
        return highScore;
    }

    /** STUB: will write the high score to storage. Currently does nothing. */
    public void saveHighScore() {
        // no-op in Phase 2
    }
}

