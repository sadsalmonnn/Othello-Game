# Othello Game - Java Implementation  

---

## Overview

This project implements the classic **Othello** (also known as Reversi) board game in Java.  
It includes classes to represent the game state (`Othello`), the board (`OthelloBoard`), player logic (abstract `Player` and `PlayerGreedy`), and game controllers (`OthelloController`).  

The game follows the standard 8x8 board rules and includes logic for valid moves, token flipping, game-over detection, and winner calculation.

For a quick introduction to Othello, see:  
[Othello Introduction Video](https://www.youtube.com/watch?v=Ol3Id7xYsY4)

---

## Key Classes

### `Othello`  
- Manages game state: board, current player turn, number of moves made.  
- Handles making moves and switching turns.  
- Reports game statistics like counts of tokens for each player and the winner.  
- Contains a simple random-move `main` method to simulate a full game.

### `OthelloBoard`  
- Represents the 8x8 board as a 2D char array.  
- Tracks token positions (`X` for player 1, `O` for player 2, empty spaces).  
- Provides methods to check valid moves, flip tokens according to Othello rules, and count tokens per player.  
- Includes helper methods for direction-based move validation.

### `OthelloController` (abstract)  
- Base class for managing game play.  
- Defines abstract `play()` method for subclasses to implement specific game logic.  
- Provides reporting methods for moves, game state, and final results.

### `Player` (abstract)  
- Base class representing a game player, holding a reference to the game and player token.  
- Declares abstract method `getMove()` for subclasses to implement move strategies.

### `PlayerGreedy`  
- Implements `Player` that selects moves maximizing immediate token gain.  
- In case of ties, selects moves with the smallest row, then smallest column.

---

## RandomVSRandom Report Summary

1. **Conclusion:**  
   Player 2 has a slight advantage when both players use random move strategies.

2. **Video Insight:**  
   The video by Jake Vanderplas explains statistical methods like simulation and bootstrapping. Direct simulation closely relates to how this project uses code to simulate Othello games and analyze winning probabilities.

3. **Hypotheses:**  
   - Null Hypothesis (H0): Each player has a 50% chance of winning.  
   - Alternative Hypothesis (Ha): Player 2 has a greater chance of winning than Player 1.

4. **Statistical Analysis:**  
   Using bootstrapping via the `OthelloRandomProbability` class (which simulates thousands of games), results indicate Player 2 wins approximately 49% of games, Player 1 about 46%, supporting Ha and rejecting H0.

5. **Reference:**  
   - [Null Hypothesis vs Alternative Hypothesis](https://www.thoughtco.com/null-hypothesis-vs-alternative-hypothesis-3126413)

---

## How to Run

1. **Compile all classes** in the `ca.utoronto.utm.assignment1.othello` package.

2. **Run the `Othello` main method** to simulate a random move game:  
   ```bash
   java ca.utoronto.utm.assignment1.othello.Othello
