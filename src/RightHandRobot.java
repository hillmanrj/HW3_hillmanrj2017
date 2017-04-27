

/**
 * Created by Reiley Hillman
 * Helped by Elisa Strope, Stack Overflow.
 * Last Updated 4/11/2017
 */

public class RightHandRobot extends Robot{
    final int north = 0;
    final int east = 1;
    final int south = 2;
    final int west = 3;

    int facing;
    final int[] moveNorth = {-1,0};
    final int[] moveEast = {0,1};
    final int[] moveSouth = {1,0};
    final int[] moveWest = {0,-1};

    /**
     * This method allows RandomRobot to see the maze class
     *
     * @param maze
     */
    public RightHandRobot(Maze maze) {
        super(maze);
        facing = south;
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
    public int[] chooseMoveDirection(){
        int[] movement = new int[2];
        movement[0] = moveNorth[0];
        movement[1] = moveNorth[1];
        switch(facing) {
            case south:
                movement[0] = moveWest[0];
                movement[1] = moveWest[1];
                break;
            case west:
                movement[0] = moveNorth[0];
                movement[1] = moveNorth[1];
                break;
            case east:
                movement[0] = moveSouth[0];
                movement[1] = moveSouth[1];
                break;
            case north:
                movement[0] = moveEast[0];
                movement[1] = moveEast[1];
                break;
        }

        return movement;
    }

    /**
     * This method moves the robot.
     *
     * @param position
     * @return validMove
     */
    @Override
    public boolean move(int[] position) {
        boolean validMove = false;
        if (match(position, moveNorth)){
            if (check(position)){
                validMove = true;
                this.setCurrentRow(position[0]);
                this.setCurrentColumn(position[1]);
                facing = north;
            }
            else
                facing = south;
        }
        else if(match(position, moveSouth)){
            if (check(position)){
                validMove = true;
                this.setCurrentRow(position[0]);
                this.setCurrentColumn(position[1]);
                facing = south;
            }
            else
                facing =  north;
        }
        else if(match(position, moveEast)) {
            if (check(position)) {
                validMove = true;
                this.setCurrentRow(position[0]);
                this.setCurrentColumn(position[1]);
                facing = east;
            } else
                facing = west;
        }
        else if(match(position, moveWest)) {
            if (check(position)) {
                validMove = true;
                this.setCurrentRow(position[0]);
                this.setCurrentColumn(position[1]);
                facing = west;
            } else
                facing = east;
        }

        return validMove;
    }

    public boolean match(int[] position, int[] direction){
        if (position[0] == direction[0]&& position[1] == direction[1])
            return true;
        else
            return false;
    }

    public boolean check(int[] position){
        if (super.currentMaze.openCell(getCurrentRow() + position[0], getCurrentColumn() + position[1])) {
            return true;
        }
        else
            return false;
    }
}
