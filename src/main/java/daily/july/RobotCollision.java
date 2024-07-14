package daily.july;

import java.util.*;
import java.util.stream.Collectors;

public class RobotCollision {
        class Robot {
            int position;
            int health;
            char direction;

            Robot(int position, int health, char direction) {
                this.position = position;
                this.health = health;
                this.direction = direction;
            }
        }

        public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

            List<Robot> robots = new ArrayList<>();
            for (int i = 0; i < positions.length; i++) {
                robots.add(new Robot(positions[i], healths[i], directions.charAt(i)));
            }

            Stack<Robot> stack = new Stack<>();

            if (robots.get(0).direction == 'R') {
                process(robots, 'R', stack);
            } else{
                process(robots, 'L', stack);
            }



            List<Integer> result = new ArrayList<>();
            for (Robot robot : stack) {
                result.add(robot.health);
            }

            return result;
        }

        public void process(List<Robot> robots, char direct, Stack<Robot> stack){
            for (Robot robot : robots) {
                if (robot.direction == direct) {
                    stack.push(robot);
                } else {
                    while (!stack.isEmpty() && stack.peek().direction == direct) {
                        Robot currRobot = stack.peek();
                        if (currRobot.health > robot.health && currRobot.position < robot.position ) {
                            if(currRobot.direction =='R' &&  robot.direction=='L'){
                                currRobot.health--;
                                robot.health = 0;
                            }
                            break;
                        } else if (currRobot.health > robot.health && currRobot.position > robot.position ) {
                            currRobot.health--;
                            robot.health = 0;
                            break;
                        }
                        else if (currRobot.health < robot.health) {
                            robot.health--;
                            stack.pop();
                        }else {
                            robot.health = 0;
                            stack.pop();
                            break;
                        }
                    }
                    if(robot.health > 0){
                        stack.push(robot);
                    }

                }
            }
        }
    }