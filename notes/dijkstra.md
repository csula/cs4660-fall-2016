# Dijkstra's Algorithm

## Objectives

* Homework 1 solution and discussion
* Best-first algorithm
* Understand Dijkstra's algorithm
* Implement Dijkstra's algorithm
* Understand difference of BFS and Dijkstra's algorithm

## Metrics/Desired Outcomes

* Able to implement Dijkstra's algorithm
* Able to apply DijkStra's algorithm to find shortest path for weighted graph

### Homework 1 Common Problems

1. General
    * Definition of `adjacent(x, y)`  
    > Adjacent of x and y means that there is edge from x to y and there may not be edge from y to x.
1. AdjacencyList
    * Utilize `equals` method (that can be used in `contain`)
2. AdjacencyMatrix
    * Forgot to adjust the size of `nodes` and `adjacencyMatrix`
    * Assigning 1 to as edge value (regardless of the actual edge value from graph-2)
    * `Id` and `index` confusion

### Homework 1 Solution (check this respository)

## Dijkstra's Algorithm

[Visualization link](https://www.cs.usfca.edu/~galles/visualization/Dijkstra.html)

### Pseudocode

```js
function Dijkstra(Graph, source) {
    // Initialization
    var dist = {};
    var prev = {};
    dist[source] ← 0

    // create priority vertex queue Q

    for (each vertex v in Graph) {
        if (v ≠ source) {
            // Unknown distance from source to v
            dist[v] ← INFINITY
            // Predecessor(parent) of v
            prev[v] ← UNDEFINED
        }

        Q.add_with_priority(v, dist[v])
    }

    while (Q is not empty) {
        // Remove and return best vertex
        u ← Q.extract_min()
        // only v that is still in Q
        for (each neighbor v of u) {
            alt = dist[u] + length(u, v)
            if (alt < dist[v]) {
                dist[v] ← alt
                prev[v] ← u
                Q.decrease_priority(v, alt)
            }
        }
    }

    // may want to consider return right away when find out
    // dest node

    return dist[], prev[]
}
```

### Difference between BFS and Dijkstra's Algorithm

BFS search by level and not taking edge value into account.
Dijkstra's algorithm is like BFS but taking edge value as part of consideration.
