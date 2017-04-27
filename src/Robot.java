
/**
 * Created by Reiley Hillman
 * Helped by Elisa Strope, Stack Overflow.
 * Last Updated 3/25/2017
 */

public class Robot{

    private int currentRow;
    private int currentColumn;
    private char robotName = 'R';
    private int exitRow;
    private int exitColumn;
    String type = "none";
    private int facing = 2;
    protected Maze currentMaze;

    /**
     * Default constructor
     */
    public Robot() {
    }

    /**
     * Robot constructor
     * @param maze
     */
    public Robot(Maze maze) {
        //create the robot and place it at the start of the maze
        currentRow = maze.getStartRow();
        currentColumn = maze.getStartCol();
        currentMaze = maze;
        currentMaze.setCell(getCurrentRow(), getCurrentColumn(), getRobotName());
        exitRow = maze.getExitRow();
        exitColumn = maze.getExitCol();

    }

    /**
     * This method sets the current column the robot is in
     * changeRow is either 0, -1, or 1
     * @param changeRow
     */
    public boolean setCurrentRow(int changeRow) {
        boolean moved = false;
        int maybeRow = currentRow + changeRow;
        if(maybeRow >= 0 && maybeRow < currentMaze.getRows() && currentMaze.openCell(maybeRow, getCurrentColumn())) {
            currentMaze.setCell(getCurrentRow(), getCurrentColumn(), ' ');
            this.currentRow += changeRow;
            currentMaze.setCell(getCurrentRow(), getCurrentColumn(), getRobotName());
            if (changeRow != 0)
                moved = true;
        }
        return moved;
    }

    /**
     * This method sets the current column the robot is in
     * changeCol is either 0, -1, or 1
     * @param changeCol
     */
    public boolean setCurrentColumn(int changeCol) {
        boolean moved = false;
        int maybeCol = currentColumn + changeCol;
        if(maybeCol >= 0 && maybeCol < currentMaze.getCols() && currentMaze.openCell(getCurrentRow(), maybeCol)){
            currentMaze.setCell(getCurrentRow(), getCurrentColumn(), ' ');
            this.currentColumn += changeCol;
            currentMaze.setCell(getCurrentRow(), getCurrentColumn(), getRobotName());
            if (changeCol != 0)
                moved = true;
        }
        return moved;
    }

    /**
     * This method sets the robot's name
     * @param robotName
     */
    public void setRobotName(char robotName) {
        this.robotName = robotName;

    }

    /**
     * This method sets the direction the robot is facing
     * @param facing
     */
    public void setFacing(int facing) {
        this.facing = facing;
    }

    /**
     * This method gets the direction the robot is facing
     * @return facing
     */
    public int getFacing() {
        return facing;
    }

    /**
     * This method gets the type of the robot
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * This method gets the current row the robot is in
     * @return currentRow
     */
    public int getCurrentRow() {
        return currentRow;
    }

    /**
     * This method gets the current column the robot is in
     * @return currentColumn
     */
    public int getCurrentColumn() {
        return currentColumn;
    }

    /**
     * This method gets the robot name
     * @return robotName
     */
    public char getRobotName() {
        return robotName;
    }

    /**
     * This method chooses the move direction. It is overridden by the RandomRobot and RightHandRobot classes
     * @return i
     */
    public int[] chooseMoveDirection() {
        int[] i = new int[2];
        return i;
    }

    /**
     * This method moves the robot. It is overridden in the RandomRobot and RightHandRobot classes
     * @param position
     * @return validMove
     */
    public boolean move(int[] position) {
        boolean validMove = true;

        try {
            this.setCurrentRow(position[0]);
            this.setCurrentColumn(position[1]);
        } catch(IndexOutOfBoundsException e) {
            validMove = false;
        }

        return validMove;
    }

    /**
     * This method checks to see if the robot has finished the maze
     * @return solved
     */
    public boolean solved() {
        boolean solved = false;

        if (currentRow==exitRow&&currentColumn==exitColumn) {
            solved = true;
        }
        return solved;
    }
}

