# Project

This year, we will be using [Tron Battle](https://www.codingame.com/multiplayer/bot-programming/tron-battle)
as the class final project.

Tron battle is a snake-like game where you have to navigate your programming
agent to move on the 30x20 grid and trap your opponents!

The goal of the game is to survive as long as possible. To do so, you may need
to make decision on where to move in order to not trap yourself while trapping
your opponents into smaller spaces.

Second goal of the game is to find a path to survive yourself as long as possible.

## Algorithms

In this project, you will use all algorithms we learned in class (BFS, A*, Minimax
& AlphaBeta pruning) in additional to a couple other algorithms like flood fill
algorithm.

## Get started

1. Sign up an account at CodinGame.
2. Choose your programming language and start hacking!

## Instructions

Once you start coding, you will need to know the input and output.

Input being a few things:

```
Line 1: Two integers N and P. Where N is the total number of players and P is your player number for this game.

The N following lines: One line per player. First line is for player 0, next line for player 1, etc. Each line contains four values X0, Y0, X1 and Y1. (X0, Y0) are the coordinates of the initial position of the light ribbon (tail) and (X1, Y1) are the coordinates of the current position of the light ribbon (head) of the player. Once a player loses, his/her X0 Y0 X1 Y1 coordinates are all equal to -1 (no more light ribbon on the grid for this player).
```

And you will need to produce output being one of the following:

```
UP
DOWN
LEFT
RIGHT
```

This implies it is up to you to track any state you need, this includes board state and any other internal state.

## Strategy guide

With the board state above, you are ready to do some computation!

First step (most important step) of the game is to not die!

That implies your board state need to be correct and when you move, you cannot move
into any "wall" (includes the spaces that is already occupied to and any edge).

Here is a very good starting point for you to implement some strategy of the game: 
http://csclub.uwaterloo.ca/contest/xiao_strategy.php

Based on the article above: you can summarize down a few requirements of your code:

* Store the board state
* Store the order of moves (so you know if you move before enemy or what not)
* [Flood-fill algorithm for evaluation][1]
* [Minimax algorithm when enemy is close and you have to fight space against it][2]
* [An algorithm to find longest path in the space][3]

My suggestion is to figure out an order of strategy you want to implement and test.
This way, you don't need to implement everything all at once and can test your
implementation one chunk at a time.

In example, you might just want to store the board state and being able to get
a list of possible moves from the current board state first.

From there, you will soon face a decision on which direction to move toward from
your list of possible moves above.

To make this decision, you will need to implement some sort of logic to check
which one is better.

One way to do so is by flood-fill algorithm. From the algorithm you can compare 
which move (UP DOWN LEFT RIGHT) will take you to move space!

And then next step is to predict opponents' movement in order to block or survive
even earlier.

After you have all above implementation done, you might want to consider improving
your code by optimizing runtime performance (so you can process more moves).

[1]: https://en.wikipedia.org/wiki/Flood_fill
[2]: https://en.wikipedia.org/wiki/Alpha%E2%80%93beta_pruning
[3]: https://en.wikipedia.org/wiki/Biconnected_component

