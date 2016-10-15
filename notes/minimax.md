# Objectives

* Adversarial search
* Decision Theory
* Minimax
* Homework 3 Announcement

# Metrics/Desired Outcomes

* Apply Minimax to solve simple game

## Adversarial Search

In this chapter, we will cover competitive environments, in which the agents'
goals are in conflict, giving rise to adversarialsearch problems -- often known as games.

Mathematical game theory, a branch of economics, views any multiagent environment
as a game, provided that the impact of each agent on the other is "significant",
regardless of whether the agents are cooperative or competitive. In AI, the most
common games are of a rather specialized kind -- what game theorists call deterministic, 
turn-taking, two-players, zero-sum games of perfect information (such as chess).

Games have engaged the intellectual faculties of humans -- sometimes to an 
alarming degree -- for as long as civilization has existed. For AI researchers,
the abstract nature of games makes them an appealing subject for study. The state
of a game is easy to represent, and agents are usually restricted to a small number 
of actions whose outcomes are defined by precise rules. Physical games, such as
conquest and ice hockey, have much more complicated descriptions, a much larger
range of possible actions, and rather imprecise rules defining the legality of 
actions,. With exception of robot soccer, these physical games have not abstracted
too much interest in the AI community.

We begin with a definition of the optimal move and an algorithm for finding it.
We then look at techniques for choosing a good move when time is limitted. 
Pruning allows us to ignore portions of the search tree that make no difference 
to the final choice, and heuristic evluattion functions allow us to approximate
the true utility of a state without doing a complete search.

A game can be formally defined as kind of search problem with the following elements:

* S0: The initial state, which specifies how the game is set up at the start
* Player(s): defines which player has the move in a state
* Actions(s): Returns the state of legal moves in a state
* Result(s, a): The transition model, which defines the result of a move
* Terminal-test(s): A terminal test, which is true when the game is over and false otherwise
* Utility(s, p): a utlity function (also called an objective function or payoff function), 
define the final numeric value for a game that ends in terminal state s for a player p. 
In chess, the outcome is a win, loss, or draw, with values of 1, 0, or 1/2. Some games 
have a wider variety of possible outcomes.

A zero-sum game is (confingly) defined as one where the total payoff to all players 
is the same for every instance of the game. Chess is zero-sum because every game
has payoff of either 0 + 1, 1 + 0 or 1/2 + 1/2. "Constant-sum" would have been a
better term, but zero-sum is traditional and makes sense if you imagine each 
player is charged an entry fee of 1/2.

## Minmax

* Used in decision theory/game theory
* Under the assumption of both players (you and your opponent(s)) play their best moves
    * Minimize the loss at worst case
    * Opponent **minimize** the score
    * You **maximize** the score
* Originally covers only turn-based 2 players game
* This has been adapted to general games now
* Again relies on a **evaluate** function
* Eventually *tree traversal*

## Picture worthes a thousand words

![Minimax graph](imgs/minimax-example.png)

## Examples

1. Tic-tac-toe
2. Zero sum number game

## Pseudocode

** [From Wikipedia](https://en.wikipedia.org/wiki/Minimax)**
```js
function minimax(node, depth, maximizingPlayer)
    if depth = 0 or node is a terminal node
        return the heuristic value of node
    if maximizingPlayer
        bestValue := -∞
        for each child of node
            val := minimax(child, depth - 1, FALSE)
            bestValue := max(bestValue, val)
        return bestValue
    else
        bestValue := +∞
        for each child of node
            val := minimax(child, depth - 1, TRUE)
            bestValue := min(bestValue, val)
        return bestValue

(* Initial call for maximizing player *)
minimax(origin, depth, TRUE)
```

**Our modification to use Graph interface**
```js
function minimax(graph, sourceNode, depth, maximizingPlayer) {
    // usually being optimized in a way to compute even before
    // the end of game by **evaluate** function
    if (depth = 0 || sourceNode is a leaf) {
        return evaluate(soureNode.gameState); // return a number
    }
    
    if (maximizingPlayer) {
        bestValue = Number.MAX_VALUE; // positive infinite
        for (node in graph.neighbors(sourceNode)) {
            value = minimax(node, graph, depth - 1, false);
            bestValue = Math.max(bestValue, value);
        }
        return bestValue;
    } else {
        bestValue = Number.MIN_VALUE; // negative infinite
        for (node in graph.neighbors(sourceNode)) {
            value = minimax(node, graph, depth - 1, true);
            bestValue = Math.min(bestValue, value);
        }
        return bestValue;
    }
}

// initial call of the above function to traverse 3 level for example
minimax(graph, startingNode, 3, TRUE); 
```