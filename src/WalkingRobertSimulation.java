/**
 * LC 874 easy greed
 *
 * A robot on an infinite grid starts at point (0, 0) and faces north.  The robot can receive one of three possible types of commands:
 *
 *     -2: turn left 90 degrees
 *     -1: turn right 90 degrees
 *     1 <= x <= 9: move forward x units
 *
 * Some of the grid squares are obstacles.
 *
 * The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])
 *
 * If the robot would try to move onto them, the robot stays on the previous grid square instead (but still continues following the rest of the route.)
 *
 * Return the square of the maximum Euclidean distance that the robot will be from the origin.
 *
 *
 *
 * Example 1:
 *
 * Input: commands = [4,-1,3], obstacles = []
 * Output: 25
 * Explanation: robot will go to (3, 4)
 *
 * Example 2:
 *
 * Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * Output: 65
 * Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)
 *
 *
 *
 * Note:
 *
 *     0 <= commands.length <= 10000
 *     0 <= obstacles.length <= 10000
 *     -30000 <= obstacle[i][0] <= 30000
 *     -30000 <= obstacle[i][1] <= 30000
 *     The answer is guaranteed to be less than 2 ^ 31.
 */



import java.util.*;
public class WalkingRobertSimulation {

    /**
     * Pipeline :
     * 1. make sure the moving direction of the robert
     * 2. check whether there is an obstacle in the moving direction, if it does, stop
     * 3. calculate the max Euclidean distance in each of the movement.
     * @param commands
     * @param obstacles
     * @return
     */



    public static int robotSim(int[] commands, int[][] obstacles) {

        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles){
            obstacleSet.add(obs[0] + " " + obs[1]); // make sure to add string " "
        }

        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}}; // North, West, South, East
        int dir = 0, x = 0, y = 0, ans = 0;
        for (int cmd : commands){
            //System.out.println(dir);
            if (cmd == -2) { // if robot turn left
                dir = (dir - 1 + 4)%4;
            } else if (cmd == -1){ // robot turns right
                dir = (dir + 1 + 4)%4;
            } else {
                while (cmd > 0 && !obstacleSet.contains((x + dirs[dir][0]) + " " + (y + dirs[dir][1]))) {
                    cmd--;
                    x += dirs[dir][0];
                    y += dirs[dir][1];
                    // fSystem.out.println("x: " + x + "  y: " + y);
                }
                ans = Math.max(ans, x * x + y * y);
            }
        }
        return ans;
    }

    public static void main(String[] args){

        int[] commands = new int[]{4,-1,4,-2,4};
        int[][] obstacles = new int[][]{{2,4}};
        //int[] commands = new int[]{4,-1,3};
        //int[][] obstacles = new int[][]{};

        System.out.println(robotSim(commands, obstacles));
    }

}
