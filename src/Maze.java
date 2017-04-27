import java.io.*;
import java.util.Scanner;

/**
 * Created by Reiley Hillman
 * Helped by Elisa Strope, Stack Overflow.
 * Last Updated 3/25/2017
 */

public class Maze {

    int numberRows;
    int numberCol;
    int startRow;
    int startCol;
    int exitRow;
    int exitCol;
    char[][] mazeArr;
    File filename;
    String line = "";


    /**
     * This method sets all the values and stores the array from the file
     * @param filename
     */
    public Maze(File filename) {

        this.filename = filename;

        try {
            Scanner file = new Scanner(filename);
            numberRows = file.nextInt();
            numberCol = file.nextInt();
            startRow = file.nextInt();
            startCol = file.nextInt();
            exitRow = file.nextInt();
            exitCol = file.nextInt();

            file.nextLine();//this reads the end of line character left on the stream after reading an integer

            System.out.println("Welcome to Reiley's maze!\nThere are " + numberRows + " rows\nThere are " + numberCol +
                    " columns\nThe starting point is in row " + (startRow + 1) + ", column " + (startCol + 1)+
                    "\nThe exit point is in row " + (exitRow + 1) + ", column " + (exitCol + 1) + "\n");

            mazeArr = new char[numberRows][numberCol];
            for (int row = 0; row < numberRows; row++) {
                line = file.nextLine();
                for (int col = 0; col < numberCol; col++) {
                    mazeArr[row][col] = line.charAt(col);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
    }

    /**
     * This method gets the number of rows
     * @return numberRows
     */
    public int getRows() {
        return numberRows;
    }

    /**
     * This method gets the number of columns
     * @return numberCol
     */
    public int getCols() {
        return numberCol;
    }

    /**
     * This method gets the starting row
     * @return startRow
     */
    public int getStartRow() {
        return startRow;
    }

    /**
     * This method gets the starting column
     * @return startCol
     */
    public int getStartCol() {
        return startCol;
    }

    /**
     * This method gets the exit row
     * @return exitRow
     */
    public int getExitRow() {
        return exitRow;
    }

    /**
     * This method gets the exit column
     * @return exitCol
     */
    public int getExitCol() {
        return exitCol;
    }

    /**
     * This method returns the character stored in a cell
     * @param row
     * @param col
     * @return mazeArr[row][col]
     */
    public char getCell(int row, int col) {
        return mazeArr[row][col];
    }

    /**
     * This method checks to make sure the value is a valid move
     * @param row
     * @param col
     * @return isOpen
     */
    public boolean openCell(int row, int col) { //checks for open spaces in the maze
        boolean isOpen = false;

        if (row >= 0 && row < numberRows) {
            if (col >= 0 && col < numberCol) {
                if (mazeArr[row][col] == ' ')
                    isOpen = true;
                else if (mazeArr[row][col] == '*')
                    isOpen = false;
                else if (mazeArr[row][col] == 'S')
                    isOpen = true;
                else if (mazeArr[row][col] == 'X')
                    isOpen = true;
                else if (mazeArr[row][col] == 'R')
                    isOpen = true;
            }
        }
        return isOpen;
    }

    /**
     * This method sets the value stored in the cell
     * @param row
     * @param col
     * @param newCh
     */
    public void setCell(int row, int col, char newCh) {
        mazeArr[row][col] = newCh;
    }

    /**
     * This method returns the maze array as a string
     * @return output
     */
    public String toString() {
        String output = "";

        for (int i = 0; i < mazeArr.length; i++) {
            for (int j = 0; j < numberCol; j++) {
                output += mazeArr[i][j];
            }
            output += "\n";
        }
        return output;
    }
}

