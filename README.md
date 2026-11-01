# Power

A 2048-inspired tile-sliding puzzle game in Java Swing. **Phase 2: UI skeleton with stubbed logic.**

## Open in NetBeans
1. Unzip the folder.
2. NetBeans: **File → Open Project…**, then select the `Power` folder (NetBeans recognizes it as a Maven project because of `pom.xml`).
3. Press **F6 (Run Project)**. The main class is `com.power.Powers`.
4. Requires JDK 17 or newer.

Command line: `mvn package` then `java -jar target/Power-0.2.0-SKELETON.jar`

## Controls
- Arrow keys or WASD: move (stubbed)
- R or **New Game**: reset

## Structure
```
src/main/java/com/power/
├── Powers.java                entry point
├── ui/
│   ├── MainFrame.java         main window layout + keycap footer
│   ├── HeaderPanel.java       wordmark, stat chips, New Game, power meter
│   ├── BoardPanel.java        4x4 grid
│   ├── PillButton.java        outlined pill button
│   ├── PowerMeter.java        progress bar toward the goal tile
│   └── Theme.java             dark palette and fonts
├── render/
│   ├── TileRenderer.java      interface (orbs now, shapes later)
│   └── OrbTileRenderer.java   round glowing orbs with a 2ⁿ badge
├── input/InputHandler.java    arrow/WASD/R key bindings
├── logic/
│   ├── GameEngine.java        STUB: core game logic facade
│   ├── Direction.java
│   ├── MoveResult.java
│   ├── TileSpawner.java       STUB
│   ├── ScoreManager.java      STUB (load/save)
│   ├── WinCondition.java      interface for a custom win rule later
│   └── ClassicWinCondition.java  STUB
└── model/Board.java           4x4 grid data
```

See `PROMPT_LOG.md` for the prompts used to generate each component.

