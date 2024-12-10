import java.io.*;
import java.util.*;

class Solution {

    static class Robot {
        int r;
        int c; 
        int target;
        boolean isArrived; 
        int[] route; 
        int currentIdx; 
        
        Robot(int r, int c, int target, int[] route) {
            this.r = r;
            this.c = c;
            this.target = target;
            this.isArrived = false;
            this.route = route;
            this.currentIdx = 0; 
        }
        
        void move(int[][] points) {
            if (isArrived) return;

            int[] targetPoint = points[route[currentIdx] - 1];
            if (r < targetPoint[0]) {
                r++;
            } else if (r > targetPoint[0]) {
                r--;
            } else if (c < targetPoint[1]) {
                c++;
            } else if (c > targetPoint[1]) {
                c--;
            }
            if (r == targetPoint[0] && c == targetPoint[1]) {
                currentIdx++;
                if (currentIdx >= route.length) {
                    isArrived = true;
                }
            }
        }
    }

    static int[][] point;
    static boolean[] isArrived;
    static List<Robot> robotList;
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        point = new int[points.length + 1][2];
        for (int i = 1; i < points.length + 1; i++) {
            point[i] = points[i - 1];
        }

        robotList = new ArrayList<>();
        for (int[] num : routes) {
            Robot robot = new Robot(points[num[0] - 1][0], points[num[0] - 1][1], num[1], num);
            robotList.add(robot);
        }
        isArrived = new boolean[robotList.size()];
        while (!isFinished()) {
            for (Robot robot : robotList) {
                robot.move(point);
            }

            Map<String, Integer> positionMap = new HashMap<>();
            for (Robot robot : robotList) {
                if (!robot.isArrived) {
                    String position = robot.r + "," + robot.c;
                    positionMap.put(position, positionMap.getOrDefault(position, 0) + 1);
                }
            }
            for (int count : positionMap.values()) {
                if (count > 1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }

    public static boolean isFinished() {
        for (boolean arrived : isArrived) {
            if (!arrived) return false;
        }
        return true;
    }
}
