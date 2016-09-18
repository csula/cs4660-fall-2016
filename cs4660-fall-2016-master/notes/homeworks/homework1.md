# Homework 1

## Important note

Before you start this homework, be sure to click [here to start homework repository](https://classroom.github.com/assignment-invitations/d81e544ad4dc4b205f3ae61d41824625)

> Note that this repository will be private and only be yours, please don't share
> your code out to your colleague(s). Sharing code will be considered as cheating
> and thus will be graded as zero for both parties.

## Description

**Graph Representation**

* Being able to read from file (Java IO)
* Utilize interface/abstract class (Object Oriented)

In this homework, you will start your assignment just like exercise before. You will need to read from file, parse information line by line and store them correctly. Eventually, you will implement methods to use those variables.

You will need to implement/modify three files (`AdjacencyList.java`, `AdjacencyMatrix.java` and `ObjectOriented.java` under `src/main/java/csula/cs460/graphs/strategy`).

In these three classes, you will be implementing similar methods for graph (e.g. `adjacent`, `neighbors` or `addNode` ... etc. you can check these method description out under `Graph.java`) but with different data structure.

Please review the note from lesson 1 - knowledge representation for differences of these three way of representing graph.

**Input format**

```
4
0:3:4
1:2:1
2:3:4
3:1:2
```

First line is the total number of nodes.

> In this homework, we will create node with unique id starting from 0  
> In other word, if we have four nodes; they are node 0, 1, 2, 3

Starting from second line, you will get `fromNode`:`toNode`:`value` for each edge.

Your job is to parse these lines of edges and add them into graph.

## Bonus

Answer the following questions in plain text format

1. Explain with the runtime analysis on each method you have implemented in each of
the representation using Big-O notation
2. Consider chess, what is the performance measure, environment, actuator and sensor?
3. Same with chess, formulate the problem in 5 components (initial state, possible
actions, transition model, goal test, and path cost)
4. Define chess environment type, is it fully observable or partially observable,
is it deterministic or stochastic, is it discrete or continuous, is it benign or
adversarial?

## Tasks

1. Read graph from file
2. Verify code by looking at graph
3. Visualize graph [Optional]

## Deliverable

* `AdjacencyList.java`, `AdjacencyMatrix.java` and `ObjectOriented` under graph/strategy package
* Github Pull Requests (be sure to pass all unit tests)

:no_entry_sign: DO NOT MODIFY ANY EXISTING TEST CODES AND INTERFACES :no_entry_sign:

## Grading Rubric

* Pass unit tests [10 pts]
* Bonus Question - see bonus questions above [2 pts]
