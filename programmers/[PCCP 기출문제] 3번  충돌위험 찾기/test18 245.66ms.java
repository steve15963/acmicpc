import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int collCount = 0;
        int size = routes.length;
        int remainingRobots = size;

        Queue<Integer>[] RobotJobs = (Queue<Integer>[]) new Queue[size]; // Tracks if each robot reached its target

        for (int i = 0; i < size; i++) {
            RobotJobs[i] = new LinkedList<>(); // 각 요소에 LinkedList 할당
        }

        int[][] robots = new int[size][2]; // Current positions of robots

        for(int i = 0 ; i < size ; i++){
            int robot  = routes[i][0] - 1;


            robots[i][0] = points[robot][0];
            robots[i][1] = points[robot][1];

            for(int j = 1; j < routes[i].length; j++){
                RobotJobs[i].offer(routes[i][j]);
                //System.out.println(robot + " " + routes[i][j]);
            }  
        }

        collCount += checkCollisions(robots,RobotJobs);

        while (remainingRobots > 0) {
            for (int i = 0; i < size; i++) {
                // If the robot hasn't arrived at its destination, move it
                if (RobotJobs[i].isEmpty())
                    continue;
                else if(move(points[RobotJobs[i].peek() - 1 ], robots[i])) {
                    RobotJobs[i].poll();
                    //System.out.println("로봇" + i +"도착 " + RobotJobs[i].poll() + ",다음 목적지 " + RobotJobs[i].peek() );
                    if(RobotJobs[i].isEmpty()){
                        robots[i][0] = -1;
                        robots[i][1] = -1;
                        remainingRobots--;
                    }
                    else {
                        move(points[RobotJobs[i].peek() - 1 ], robots[i]);
                    }
                }
            }
            // Check for collisions and add to collision count
            collCount += checkCollisions(robots,RobotJobs);
        }

        return collCount;
    }
    public int checkCollisions(int[][] robots, Queue[] RobotJobs) {
        Set<String> uniquePositions = new HashSet<>();
        Set<String> collisionPositions = new HashSet<>();
        int collisionCount = 0;

        for (int i = 0; i < robots.length; i++) {
            // 해당 로봇이 이미 목적지에 도달한 경우, 충돌 검사에서 제외
            if (RobotJobs[i].isEmpty()) continue;

            int[] robot = robots[i];
            String positionKey = robot[0] + "," + robot[1];

            // 이미 해당 위치에 다른 로봇이 있으면 충돌 카운트 증가
            if (uniquePositions.contains(positionKey)) {
                // 이전에 같은 위치에서 충돌이 발생한 경우 중복 카운트 방지
                if (!collisionPositions.contains(positionKey)) {
                    //System.out.println("충돌 위치: " + positionKey);
                    collisionCount++;
                    collisionPositions.add(positionKey);
                }
            } else {
                uniquePositions.add(positionKey);
            }
        }
        //System.out.println("-------------");
        return collisionCount;
    }

    public boolean move(int[] target, int[] robot) {
        //System.out.print("로봇 " + robot[0] + "," + robot[1]);
        if (robot[0] < target[0]) {
            robot[0]++;
        } else if (robot[0] > target[0]) {
            robot[0]--;
        } else if (robot[1] < target[1]) {
            robot[1]++;
        } else if (robot[1] > target[1]) {
            robot[1]--;
        } else {
            //System.out.println(" >> " + robot[0] + "," + robot[1]);
            return true; // Robot has reached its target
        }
        //System.out.println(" >> " + robot[0] + "," + robot[1]);
        return false;
    }
}