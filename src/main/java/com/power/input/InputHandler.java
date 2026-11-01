/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.power.input;

import com.power.logic.Direction;

import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

/**
 * Maps Arrow keys and WASD to Directions using Swing Key Bindings
 * (more reliable than KeyListener — works regardless of which child
 * component has focus, so there's no input lag or "dead" keys).
 */
public final class InputHandler {

    private InputHandler() {}

    public static void install(JComponent root, Consumer<Direction> onMove, Runnable onReset) {
        InputMap im = root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

        bind(root, im, "UP",    "W", Direction.UP,    onMove);
        bind(root, im, "DOWN",  "S", Direction.DOWN,  onMove);
        bind(root, im, "LEFT",  "A", Direction.LEFT,  onMove);
        bind(root, im, "RIGHT", "D", Direction.RIGHT, onMove);

        // R = quick board reset
        im.put(KeyStroke.getKeyStroke("R"), "reset");
        root.getActionMap().put("reset", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onReset.run();
            }
        });
    }

    private static void bind(JComponent root, InputMap im, String arrow, String letter,
                             Direction dir, Consumer<Direction> onMove) {
        String actionKey = "move." + dir.name();
        im.put(KeyStroke.getKeyStroke(arrow), actionKey);
        im.put(KeyStroke.getKeyStroke(letter), actionKey);
        root.getActionMap().put(actionKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onMove.accept(dir);
            }
        });
    }
}
