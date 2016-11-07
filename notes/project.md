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

1. Sign up an account at codingame.
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
onto any "wall" (includes the spaces already being moved to and edge).

Here is a very good starting point for you to implement some strategy of the game: 
http://csclub.uwaterloo.ca/contest/xiao_strategy.php
