package csula.cs4660.graphs.search;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import csula.cs4660.games.models.Tile;
import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Graph;
import csula.cs4660.graphs.Node;
import csula.cs4660.graphs.representations.Representation;
import csula.cs4660.graphs.searches.AstarSearch;
import csula.cs4660.graphs.searches.BFS;
import csula.cs4660.graphs.utils.Parser;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertEquals;

public class AStarTest {
    private Stopwatch timer;
    private ClassLoader classLoader;
    Graph[] graph1s;
    Graph[] graph2s;
    Graph[] graph3s;
    Graph graph4;
    Graph graph5;

    @Before
    public void warmup() {
        File file1 = new File(classLoader.getResource("homework-2/grid-1.txt").getFile());
        File file2 = new File(classLoader.getResource("homework-2/grid-2.txt").getFile());
        File file3 = new File(classLoader.getResource("homework-2/grid-3.txt").getFile());
        File file4 = new File(classLoader.getResource("homework-2/grid-4.txt").getFile());
        File file5 = new File(classLoader.getResource("homework-2/grid-5.txt").getFile());

        graph1s = buildGraphs(file1);
        graph2s = buildGraphs(file2);
        graph3s = buildGraphs(file3);
        graph4 = buildGraph(file4);
        graph5 = buildGraph(file5);
    }

    private Graph[] buildGraphs(File file) {
        Graph[] graphs = new Graph[3];

        graphs[0] = Parser.readRectangularGridFile(
            Representation.STRATEGY.ADJACENCY_LIST,
            file
        );

        graphs[1] = Parser.readRectangularGridFile(
            Representation.STRATEGY.ADJACENCY_MATRIX,
            file
        );

        graphs[2] = Parser.readRectangularGridFile(
            Representation.STRATEGY.OBJECT_ORIENTED,
            file
        );

        return graphs;
    }
    
    private Graph buildGraph(File file) {
        return Parser.readRectangularGridFile(
            Representation.STRATEGY.ADJACENCY_LIST,
            file
        );
    }

    @Test
    public void aWarmUpSearches() {
        Arrays.stream(graph1s)
            .forEach(graph -> {
                Parser.converEdgesToAction(
                    graph.search(
                        new AstarSearch(),
                        new Node<>(new Tile(3, 0, "@1")),
                        new Node<>(new Tile(4, 4, "@6")))
                );
            });
        Arrays.stream(graph2s)
            .forEach(graph -> {
                Parser.converEdgesToAction(
                    graph.search(
                        new AstarSearch(),
                        new Node<>(new Tile(3, 0, "@1")),
                        new Node<>(new Tile(13, 0, "@8")))
                );
            });
        Arrays.stream(graph3s)
            .forEach(graph -> {
                Parser.converEdgesToAction(
                    graph.search(
                        new AstarSearch(),
                        new Node<>(new Tile(3, 0, "@1")),
                        new Node<>(new Tile(2, 7, "@2")))
                );
            });
        Parser.converEdgesToAction(
            graph4.search(
                new AstarSearch(),
                new Node<>(new Tile(4, 0, "@1")),
                new Node<>(new Tile(6, 201, "@4")))
        );
        Parser.converEdgesToAction(
            graph5.search(
                new AstarSearch(),
                new Node<>(new Tile(4, 0, "@1")),
                new Node<>(new Tile(201, 206, "@5")))
        );
        System.out.println("Warn up searches spends " + timer.stop());
    }

    @Before
    public void setUp() {
        classLoader = getClass().getClassLoader();
        timer = Stopwatch.createStarted();
    }

    @Test(timeout=15)
    public void testAStar1() {
        Arrays.stream(graph1s)
            .forEach(graph -> {
                assertEquals(
                    "Test A* on graph 1",
                    "SSSSE",
                    Parser.converEdgesToAction(
                        graph.search(
                            new AstarSearch(),
                            new Node<>(new Tile(3, 0, "@1")),
                            new Node<>(new Tile(4, 4, "@6")))
                    )
                );
            });

        System.out.println("A star 1 spends " + timer.stop());
    }

    @Test(timeout=15)
    public void testAStar2() {
        Arrays.stream(graph2s)
            .forEach(graph -> {
                String result = Parser.converEdgesToAction(
                    graph.search(
                        new AstarSearch(),
                        new Node<>(new Tile(3, 0, "@1")),
                        new Node<>(new Tile(13, 0, "@8")))
                );
                String expectedOutput = "SSSSEEEEEEEEEEEEENNWNWNW";
                assertEquals(
                    "Test grid 2 number of S",
                    findNumberOfCharacter(expectedOutput, "([N])"),
                    findNumberOfCharacter(result, "([N])")
                );
                assertEquals(
                    "Test grid 2 number of S",
                    findNumberOfCharacter(expectedOutput, "([E])"),
                    findNumberOfCharacter(result, "([E])")
                );
                assertEquals(
                    "Test grid 2 number of S",
                    findNumberOfCharacter(expectedOutput, "([W])"),
                    findNumberOfCharacter(result, "([W])")
                );
                assertEquals(
                    "Test grid 2 number of E",
                    findNumberOfCharacter(expectedOutput, "([S])"),
                    findNumberOfCharacter(result, "([S])")
                );
            });

        System.out.println("A star 2 spends " + timer.stop());
    }

    @Test(timeout=15)
    public void testAStar3() {
        Arrays.stream(graph3s)
            .forEach(graph -> {
                assertEquals(
                    "Test A* on graph 3",
                    "SSSSEESESSWWWW",
                    Parser.converEdgesToAction(
                        graph.search(
                            new AstarSearch(),
                            new Node<>(new Tile(3, 0, "@1")),
                            new Node<>(new Tile(2, 7, "@2")))
                    )
                );
            });

        System.out.println("A star 3 spends " + timer.stop());
    }

    @Test(timeout=200)
    public void testAStar4() {
        String expectedOutput = "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSESE";

        String result = Parser.converEdgesToAction(
            graph4.search(
                new AstarSearch(),
                new Node<>(new Tile(4, 0, "@1")),
                new Node<>(new Tile(6, 201, "@4")))
        );
        assertEquals(
            "Test grid 4 number of S",
            findNumberOfCharacter(expectedOutput, "([S])"),
            findNumberOfCharacter(result, "([S])")
        );
        assertEquals(
            "Test grid 4 number of E",
            findNumberOfCharacter(expectedOutput, "([E])"),
            findNumberOfCharacter(result, "([E])")
        );

        System.out.println("A star 4 spends " + timer.stop());
    }

    @Test
    public void testAStar5() {
        String expectedOutput = "SSSSSSSSSSEESSEESESESSEESSEESESESESESSEESESESESESESSESEESESESSESEESSEESSEESESESESESSESEESSESESEESSESEESESSESEESESESESESSEESESESESESESESESESSEESESESESESESSEESSEESESSESEESSEESESSEESESESESESESSEESESESSEESESSESEESSEESESESESSEESSESEESESSESESESESEESSEESESESESESESESESESESESESESESESSEESESSEESSEESESESESSEESESESSEESESESSEESESESESESESESESESESESESESSESEESSEESESSEESESSEESSEESESSEESESESESESESESESESESSEESEEEESSSSSE";

        String result = Parser.converEdgesToAction(
            graph5.search(
                new AstarSearch(),
                new Node<>(new Tile(4, 0, "@1")),
                new Node<>(new Tile(201, 206, "@5")))
        );
        assertEquals(
            "Test grid 5 number of S",
            findNumberOfCharacter(expectedOutput, "([S])"),
            findNumberOfCharacter(result, "([S])")
        );
        assertEquals(
            "Test grid 5 number of E",
            findNumberOfCharacter(expectedOutput, "([E])"),
            findNumberOfCharacter(result, "([E])")
        );

        System.out.println("A star 5 spends " + timer.stop());
    }

    private int findNumberOfCharacter(String input, String regex) {
        Pattern pattern = Pattern.compile(regex); //case insensitive, use [g] for only lower
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find()) count++;

        return count;
    }
}
