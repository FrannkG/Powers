
LLM: Claude 

Entry 1: 

Among a team we are building a desktop game in Java Swing called “Powers”. Its inspired by 2048 but should have its own appearance and later on its own win condition. My team and I are working in NetBeans with a Maven project, Java 17 and no external libraries. 

We are currently in Phase 2: generating the UI Skeleton and the basic logic. I will ask for one class at a time, some specifics are that the base package is com.power with additional sub-packages that being ui, ui.render, input, logic, model. This game is also completely separate from the already made 2048, no similarities in regards to the color scheme should be considered. 

Entry 2: 

Generate com.power.ui.Theme: a final class which holds every color, font and szie constant. Use a dark theme with a deep navy blue background, dark board, teal and pink accents. The opposite of 2048’s colors. Additionally include tileColor(int value) that ramps from teal (2) through blue, violet, magenta, pink orange and a bright yellow in the final 2048, text color (int value), and glows (int value) that return true for 128 and up. 

 

Output: ui/Theme.java: all the colors, fonts and sizes. The dark navy theme with the teal and pink accents plus the tile color ramp. 

 

Entry 3: Generate com.power.render.TileRenderer: an interface with render 2D Graphics, int value and int size for a individual tile face. In the requirements document, it is possible that the team will agree to change the numbers to shape later. This will allow to swap the look without affecting the board. 

 

Output: render/TileRedenderer.java: interface with one method, render (), for a single tile of the board 

 

Entry 4: 

Generate com.power.render.OrbTileRenderer implementing TileRenderer. Draw the tiles as round glowing orbs instead of the square. Empty cells are a dim place holder ring. The filled orbs use a vertical gradient a Theme.tileColor, a glossy highlight, a glow halo when Theme.glows(value), the number centered, and a small "2^n" exponent badge under the number. 

 

Output: render/OrbTileRenderer.java: draws tiles as round glowing orbs with the number and a small 2^n label. Representing the powers 

 

Entry 5: 

 

Generate com.power.ui.BoardPanel extends JPanel, painting the 4x4 grid on a dark board with a thin outline, using TileRenderer for each cell. It should scale to the panel size. 

 

Output: ui/BoardPanel.java: draws the 4x4 grid on a dark board using the tile renderer. 

 

Entry 6: 

Generate com.power.ui.PillButton extends JButton, custom fill pill shaped button with accent-colored outlines that fills when the accent color when you hover.  

Output: ui/PillButton.java: a rounded outline button that fills in when you hover over it. 

 

Entry 7: 

Prompt: 

Make a PowerMeter in com.power.ui. It's a progress bar that says POWER LEVEL and shows how close you are to the goal tile. The bar should go from teal to pink. 

Output: ui/PowerMeter.java: a progress bar showing how close you are to the goal. 

Entry 8  

Make HeaderPanel in com.power.ui for the top of the screen. On the left put the title "P O W E R S" and a line that says the goal. On the right put SCORE and BEST boxes with the New Game button under them. Put the power meter at the bottom. Add methods to update the score, best score, goal and power level, and one for when New Game is clicked. 

 

Output: ui/HeaderPanel.java: the top bar with the POWERS title, Score and Best boxes, New Game button and power meter. 

Entry 9 

Make an InputHandler class in com.power.input. The arrow keys and WASD should move, and R should reset the game. Use key bindings instead of a KeyListener so the keys always work. 

Output: input/InputHandler.java: connects the arrow keys, WASD and R to moves and reset. 

 

 

Entry 10  

Make MainFrame in com.power.ui, the main game window. Put the header at the top, the board in the middle and the controls at the bottom. Connect the New Game button and the keys. When you move, it should call the GameEngine and show a message if you win or lose. Add a refresh method that updates everything on screen. No game rules in here. 

Output: ui/MainFrame.java: the main window that puts the header, board and key hints together. 

Entry 11 

Make an enum called Direction in com.power.logic with UP, DOWN, LEFT and RIGHT. 

Output: logic/Direction.java: a list of the four directions (UP, DOWN, LEFT, RIGHT). 

 

Entry 12 

Make a MoveResult record in com.power.logic that says what happened after a move: if the board changed, how many points you got, if you won, and if the game is over. 

Output: logic/MoveResult.java: holds what happened after a move (changed, points, won, game over). 

 

Entry 13 

Make a Board class in com.power.model that stores the 4x4 grid of numbers (0 means empty). Add get, set, clear, a way to copy the board, and a way to load numbers into it. No game rules. 

Output: model/Board.java: stores the 4x4 grid of numbers. 

 

Entry 14 

Make a WinCondition interface in com.power.logic that checks if the player won. We want our own win rule later, so the game should be able to use any rule. 

Output: logic/WinCondition.java: an interface for the win rule, so we can change it later. 

Entry 15  

Make ClassicWinCondition in com.power.logic that uses WinCondition. It's the normal "reach 2048" rule. For now just make it always return false and leave a comment about what it will really check. 

Output: logic/ClassicWinCondition.java: the "reach 2048" rule. Stub: always returns false for now. 

 

Entry 16 

Make TileSpawner in com.power.logic. Later it should put a 2 or 4 in a random empty spot (2 most of the time). For now just make it always put a 2 in the top left corner. 

Output: logic/TileSpawner.java: adds new tiles. Stub: always puts a 2 in the top-left corner. 

Entry 17 

Make ScoreManager in com.power.logic that keeps track of the score and high score. For now, loading the high score should just give back 1024 and saving should do nothing. 

Output: logic/ScoreManager.java: keeps the score and high score. Stub: high score is always 1024. 

Entry 18  

Make GameEngine in com.power.logic. This is the only class the UI talks to. Everything should be fake for now: a new game loads a board that shows every number from 2 to 2048, every move adds 4 points without moving anything, you can never win or lose, and the highest tile is always 512. Add comments saying what each method will really do later. 

Output: logic/GameEngine.java: the main game logic. Stub: loads a fake board and every move adds 4 points. 

 

Entry 19 

Make the main class called Powers in com.power. It should open the game window. 

Output: Powers.java: the main class. Starts the game and opens the window. 

 

Entry 20 

Write JUnit tests that check the fake methods return the fake values: a new game starts with score 0, a move gives 4 points, and you can't win or lose yet. 

Output: GameEngineStubTest.java: 3 tests that check the stubs return their fake values. 

 

FIXES AND CHANGES 

 

Entry 2b — Package kept getting renamed 

  

Instead of suing ui.render and ui, it would be better to change it as Net Beans Keeps hiding either or. 

Output: The AI explained that NetBeans hides empty packages, so com.power.ui folded into com.power.ui.render. It suggested renaming the package to com.power.render. 

 

Entry 20b 

Build error 

This error occurred when building the game, saying that while building and cleaning up it wasnt able to find SwingUtilities, UIManager, GameEnginer and MainFrame in main.java 

 

Additional errors that I fixed on my own were that the file failed building after the file OrbTileRenderer was misspelled to OrbTileRenderere 

 

And instead of calling the main class main changed it to ‘Powers’ 

 

 