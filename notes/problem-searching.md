# Problem searching

## Objectives

* Homework 1 Q&A
* Recap of Graph
* DFS (Depth First Search)
* Recursion Review
* BFS (Breadth First Search)

## Metrics/Desired Outcomes

* Understanding BFS/DFS
* Able to implement BFS/DFS

### Recap of Graph

* Graph
* Node
* Edge

> Graph is just an abstract data structure you can use to traverse and reason behind
certain problem.

### Examples

* Map
* Maze
* Game Tree
* http://visualgo.net/dfsbfs.html
* http://qiao.github.io/PathFinding.js/visual/

> We have data now, how do we process it to produce a useful output?

### Depth First Search (DFS)

![DFS](Depth-First-Search.gif)

#### Pseudocode

```javascript
function DFS(v) {
    // label v as discovered
    for (node in Graph.neighbors(v)) {
        if (!node.isDiscovered()) {
            DFS(n);
        }
    }
}
```
### Recursion Review

![Recursion by Google](imgs/recursion.png)

* Base case
* Induction

## Breadth First Search (BFS)

![BFS](imgs/Breadth-First-Search-Algorithm.gif)

### Pseudocode

```javascript
function BFS(v) {
    for (node in G) {
        node.distance = Number.MAX_VALUE;
        node.parent = null;
    }

    // create empty queue Q      
    var queue = new Queue();

    v.distance = 0;
    queue.enqueue(v);

    while (!queue.isEmpty()) {
        var u = queue.dequeue();

        for (node in Graph.neighbors(u)) {
            if (node.distance == Number.MAX_VALUE) {
                node.distance = u.distance + edge.value
                // note that I'm leaving edge value up to
                // you to implement
                node.parent = u;
                queue.enqueue(node);
            }
        }
    }
}
```

## Learning

1. Solve https://www.hackerrank.com/challenges/saveprincess
2. ~~Implement Game interface~~

> Due to time constraint, I decide to remove the game interface as part of learning from this class; we will talk about it when I talk about Dijkstra algorithm. Stay Tuned!
