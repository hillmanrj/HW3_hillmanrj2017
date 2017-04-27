/**
 * Created by Reiley Hillman.
 * Last Updated 3/25/2017
 */
import java.util.Random;

public class RandomRobot extends Robot{

    Random rand = new Random();
    int currentRow;
    int currentColumn;
    int[] position = new int[2];
    int n;
    String type = "random";
    int north = 0;
    int east = 1;
    int south = 2;
    int west = 3;

    /**
     * This method allows RandomRobot to see the maze class
     *
     * @param maze
     */
    public RandomRobot(Maze maze) {
        super(maze);
    }

    /**
     * This method returns the type of the maze
     *
     * @return type
     */
    public String getType() {
        return this.type;
    }

    /**
     * This method chooses the direction the robot will move
     *
     * @return movement
     */
    @Override
    public int[] chooseMoveDirection() {
        n = rand.nextInt(4);
        int[] movement = new int[2];
        if (n == north) {
            movement[0] = 0;
            movement[1] = -1;
        } else if (n == east) {
            movement[0] = 1;
            movement[1] = 0;
        } else if (n == south) {
            movement[0] = 0;
            movement[1] = 1;
        } else if (n == west) {
            movement[0] = -1;
            movement[1] = 0;
        }

        return movement;
    }

    /**
     * This method moves the robot. It is overridden in the RandomRobot and RightHandRobot classes
     *
     * @param position
     * @return validMove
     */
    public boolean move(int[] position) {
        boolean validMove = true;

        try {
            this.setCurrentRow(position[0]);
            this.setCurrentColumn(position[1]);
        } catch (IndexOutOfBoundsException e) {
            validMove = false;
        }

        return validMove;
    }
}