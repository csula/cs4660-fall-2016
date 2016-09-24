package csula.cs4660.exercises;

import com.google.common.collect.Lists;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Introduction Java exercise to read file
 */
public class FileRead {
    private int[][] numbers;
    /**
     * Read the file and store the content to 2d array of int
     * @param file read file
     */
    public FileRead(File file) {
        // TODO: read the file content and store content into numbers
        List<List<Integer>> listOfNumbers = Lists.newArrayList();
        try (Stream<String> stream = Files.lines(file.toPath())) {
            stream.forEach(line -> {
                List<Integer> lineNumbers = Lists.newArrayList();
                for (String token: line.split(" ")) {
                    lineNumbers.add(Integer.parseInt(token));
                }
                System.out.println(line);
                listOfNumbers.add(lineNumbers);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        numbers = converList(listOfNumbers);
    }

    /**
     * Read the file assuming following by the format of split by space and next
     * line. Display the sum for each line and tell me
     * which line has the highest mean.
     *
     * lineNumber starts with 0 (programming friendly!)
     */
    public int mean(int lineNumber) {
        return sum(lineNumber) / numbers[lineNumber].length;
    }

    public int max(int lineNumber) {
        int max = Integer.MIN_VALUE;
        for (int i : numbers[lineNumber]) {
            max = Integer.max(max, i);
        }
        return max;
    }

    public int min(int lineNumber) {
        int min = Integer.MAX_VALUE;
        for (int i : numbers[lineNumber]) {
            min = Integer.min(min, i);
        }
        return min;
    }

    public int sum(int lineNumber) {
        int sum = 0;
        for (int i : numbers[lineNumber]) {
            sum += i;
        }
        return sum;
    }

    private int[][] converList(List<List<Integer>> arrayList) {
        int[][] array = new int[arrayList.size()][];
        for (int i = 0; i < arrayList.size(); i++) {
            List<Integer> row = arrayList.get(i);
            array[i] = new int[row.size()];
            for (int j = 0; j < row.size(); j ++) {
                array[i][j] = row.get(j);
            }
        }
        return array;
    }
}
