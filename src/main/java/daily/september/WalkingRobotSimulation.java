package daily.september;

import java.util.HashSet;
import java.util.Set;
/**
 * 874. Walking Robot Simulation java solution
 * */
public class WalkingRobotSimulation {

        public int robotSim(int[] commands, int[][] obstacles) {
            // directions: N,E,S,W
            int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};

            //store obstacles in a hashset for quick lookup
            Set<String> obstacleSet = new HashSet<>();
            for(int[] obstacle: obstacles){
                obstacleSet.add(obstacle[0]+ ","+ obstacle[1]);
            }

            int x=0, y=0; //robot starting position
            int direction=0; // start facing north(index 0 in the directions array)
            int maxDistanceSq= 0; //Maximum euclidean distance square

            for(int command: commands){
                if(command == -2){
                    //turn left 90 degrees (counterclockwise)
                    direction=(direction+3) % 4;
                } else if (command == -1){
                    direction =(direction+1)% 4;
                } else {
                    //move forward by command steps
                    for(int i=0; i < command; i++){
                        int nextX = x + directions[direction][0];
                        int nextY = y + directions[direction][1];

                        //Check if the next position is an obstacle
                        if(!obstacleSet.contains(nextX+","+ nextY)){
                            //move to the next position
                            x= nextX;
                            y= nextY;
                            //Calculate the distance squared from the origin
                            maxDistanceSq=Math.max(maxDistanceSq, x*x+ y*y);
                        } else {
                            // Stop moving if an obstacle is encountered
                            break;
                        }
                    }
                }
            }
            return maxDistanceSq; //return the maximum Euclidean distance squared
        }
    }

}
