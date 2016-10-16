# Quiz 2

Total points: 10 pts

Due date: Oct 16th 11:59pm (at the end of day)

## Context

You woke up in the middle of empty room. You look around and realize you are in an empty room of a dungeon.

Your job is to find a way out from this empty room to a dark room containing the portal to outside world.

## Technical requirement

Implement BFS search to find path to state starting from 
`10a5461773e8fd60940a56d2e9ef7bf4` to `e577aa79473673f6158cc73e0e5dc122`

> updated at 11am Oct 15

> For Dikjstra search, you will need to take the event effect (edge cost) into the consideration. Find out the best path that returns the highest value (or lowest cost)

You will have to modify App.java to find the answer.

Please submit `solution.txt` containing link to your App.java and path from initial state to desination state to CSNS when you are done:

> You should commit your changes to your branch `quiz-2`

Example of `solution.txt`:

```
link to my solution: https://github.com/csula-students/cs-4660-fall-homework-rcliao/blob/master/src/main/java/csula/cs4660/exercises/FileRead.java

BFS Path:

Empty Room:Hall Way:-30
...

Dijkstra Path:

Empty Room:Hall Way:-30
...
```

**Hint**

* You can and should reuse your `Graph.java` implementation
* You don't know all the state ahead of time, but you can use the server as the state holder to traverse through states
