package csula.cs4660.exercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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

        BufferedReader reader;
        String curLine;

        try {
            reader = new BufferedReader(new FileReader(file));

            ArrayList<int[]> listOfRows = new ArrayList<int[]>();

            while ((curLine = reader.readLine()) != null) {

                String[] stringInteger = curLine.split(" ");

                int length = stringInteger.length;

                int[] row = new int[length];

                for(int index = 0; index < length; index++) {

                    row[index] = Integer.parseInt(stringInteger[index]);
                }

                listOfRows.add(row);
            }

            int rows = listOfRows.size();
            int cols = listOfRows.get(0).length;

            numbers = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    numbers[i][j] = listOfRows.get(i)[j];
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Read the file assuming following by the format of split by space and next
     * line. Display the sum for each line and tell me
     * which line has the highest mean.
     *
     * lineNumber starts with 0 (programming friendly!)
     */
    public int mean(int lineNumber) {

        int sum = 0;
        int numberCount = numbers[lineNumber].length;

        for (int index = 0; index < numbers[lineNumber].length; index++) {

            sum += numbers[lineNumber][index];
        }

        return sum / numberCount;
    }

    public int max(int lineNumber) {

        int max = numbers[lineNumber][0];
        int current = max;

        for (int index = 1; index < numbers[lineNumber].length; index++) {

            current = numbers[lineNumber][index];

            if (max < current) {
                max = current;
            }
        }

        return max;
    }

    public int min(int lineNumber) {

        int min = numbers[lineNumber][0];
        int current = min;

        for (int index = 1; index < numbers[lineNumber].length; index++) {

            current = numbers[lineNumber][index];

            if (min > current) {
                min = current;
            }
        }

        return min;
    }

    public int sum(int lineNumber) {

        int sum = 0;

        for (int index = 0; index < numbers[lineNumber].length; index++) {

            sum += numbers[lineNumber][index];
        }

        return sum;
    }
}
