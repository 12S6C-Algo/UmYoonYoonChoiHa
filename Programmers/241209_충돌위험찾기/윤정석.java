import java.util.*;

class Solution {

    public int solution(int[][] points, int[][] routes) {
        Queue<int[]> q = new LinkedList<>();
        
        for (int robot = 0; robot < routes.length; robot++) {
            int sr = points[routes[robot][0] - 1][0];
            int sc = points[routes[robot][0] - 1][1];
            
            int er = points[routes[robot][1] - 1][0];
            int ec = points[routes[robot][1] - 1][1];
            
            int time = 0, route = 1, routeNum = routes[robot].length;
            
            q.offer(new int[] {sr, sc, er, ec, time, robot, route, routeNum});
        }
        
        Map<String, Integer> cumul = new HashMap<>();
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int sr = cur[0], sc = cur[1];
            int er = cur[2], ec = cur[3];
            int time = cur[4];
            int robot = cur[5];
            int route = cur[6];
            int routeNum = cur[7];
            
            String key = sr + "," + sc + "," + time;
            cumul.put(key, cumul.getOrDefault(key, 0) + 1);
            
            if (sr < er) sr++;
            else if (sr > er) sr--;
            else if (sc < ec) sc++;
            else if (sc > ec) sc--;
            
            if(sr == er && sc == ec) {
                if(routeNum > route + 1) {
                    int nextRoute = route + 1;
                    er = points[routes[robot][nextRoute] - 1][0];
                    ec = points[routes[robot][nextRoute] - 1][1];
                    q.offer(new int[] {sr, sc, er, ec, time + 1, robot, nextRoute, routeNum});
                } else {
                    int newTime = time + 1;
                    String tmpKey = sr + "," + sc + "," + newTime;
                    cumul.put(tmpKey, cumul.getOrDefault(tmpKey, 0) + 1);
                }
            } else {
                q.offer(new int[] {sr, sc, er, ec, time + 1, robot, route, routeNum});
            }
        }
        
        int answer = 0;
        for (int cnt : cumul.values()) {
            if (cnt > 1) answer++;
        }
        
        return answer;
    }
}
