/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.power;

import com.power.logic.GameEngine;
import com.power.ui.MainFrame;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Entry point for Power. Run this class to start the game.
 *
 * Phase 2: launches the UI skeleton wired to a stubbed GameEngine.
 * All game logic currently returns hard-coded / mock values.
 */
public class Main {

    public static void main(String[] args) {
        // Swing must be built on the Event Dispatch Thread.
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ignored) {
                // Fall back to default look and feel.
            }
            GameEngine engine = new GameEngine();
            MainFrame frame = new MainFrame(engine);
            frame.setVisible(true);
        });
    }
}
