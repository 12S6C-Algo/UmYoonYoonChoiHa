import java.util.*;

class Solution {

    static class Robot {
        int r;  
        int c;  
        int target_r;
        int target_c;
        boolean isArrived;
        Robot(int r, int c, int target_r, int target_c) {
            this.r = r;
            this.c = c;
            this.target_r = target_r;
            this.target_c = target_c;
            this.isArrived = false;
        }
        void move() {
            if (isArrived) return; 
            if (r < target_r) r++;
            else if (r > target_r) r--;
            else if (c < target_c) c++;
            else if (c > target_c) c--;
            if (r == target_r && c == target_c) {
                isArrived = true;
            }
        }
    }
    static List<Robot> robots;
    static Map<String, Integer> map;
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        robots = new ArrayList<>();
        for (int idx = 0; idx < routes.length; idx++) {
            int start = routes[idx][0] - 1;
            int end = routes[idx][1] - 1; 
            robots.add(new Robot(points[start][0], points[start][1], points[end][0], points[end][1]));
        }
       
        map = new HashMap<>();  
     
            // 로봇이동및현위치저장
            for (Robot robot : robots) {
                if (!robot.isArrived) {
                    String position = robot.r + "," + robot.c;
                    if (map.containsKey(position)) {
                        map.put(position, map.get(position) + 1);
                    } 
                    else {
                        map.put(position, 1);
                    }
                }
            }
            
            // 충돌위험체크
            for (String xy : map.keySet()) {
                if (map.get(xy) > 1) {
                    System.out.println(xy);
                    answer++;  
                }
            }
        
        while (true) {    
            map = new HashMap<>();  
     
            // 로봇이동및현위치저장
            for (Robot robot : robots) {
                if (!robot.isArrived) {
                    robot.move();
                    String position = robot.r + "," + robot.c;
                    if (map.containsKey(position)) {
                        map.put(position, map.get(position) + 1);
                    } 
                    else {
                        map.put(position, 1);
                    }
                }
            }
            
            // 충돌위험체크
            for (String xy : map.keySet()) {
                if (map.get(xy) > 1) {
                    System.out.println(xy);
                    answer++;  
                }
            }
            
            // 도착여부확인
            boolean allArrived = true;
            for (Robot robot : robots) {
                if (!robot.isArrived) {
                    allArrived = false;
                    break;
                }
            }
            
            if (allArrived) break;
        }
        return answer;
    }
}
