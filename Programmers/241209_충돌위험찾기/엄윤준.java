import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        int rsz = routes.length;
        boolean[] end = new boolean[rsz]; // 종료를 판단할 boolean배열
        
        int[][] currs = new int[rsz][2]; // 현재 로봇 위치
        int[][] goal = new int[rsz][2]; // 로봇 목표 위치
        int[] ridx = new int[rsz]; // 목표 인덱스 저장
        
        int[] first = new int[101];
        for(int i = 0; i < rsz; i++) {
            currs[i] = Arrays.copyOf(points[routes[i][0] - 1], 2);
            goal[i] = Arrays.copyOf(points[routes[i][1] - 1], 2);
            ridx[i] = 1;

            // 처음 위치 겹치는지 확인
            first[routes[i][0]]++; 
            if(first[routes[i][0]] == 2) {
                answer++;
            }
        }
        while(true) {
            // 종료 조건 확인
            int endCnt = 0;
            for(int i = 0; i < rsz; i++) {
                if(end[i]) endCnt++;
            }
            
            if(endCnt >= rsz) break;
            
            int[][] map = new int[101][101]; // 중복 확인용 2차원 배열
            
            for(int i = 0; i < rsz; i++) {
                if(end[i]) continue; // 종료된 로봇 건너뜀
                
                if(currs[i][0] != goal[i][0]) {
                    if(currs[i][0] < goal[i][0]) {
                        currs[i][0]++;
                    }else {
                        currs[i][0]--;
                    }
                } else if(currs[i][1] != goal[i][1]) {
                    if(currs[i][1] < goal[i][1]) {
                        currs[i][1]++;
                    }else {
                        currs[i][1]--;
                    }
                }

                // 중복된 위치들 카운트
                map[currs[i][0]][currs[i][1]]++;
                if(map[currs[i][0]][currs[i][1]] == 2) {
                    answer++;
                }
            }

            // 종료 or 다음 루트 계산
            for(int i = 0; i < rsz; i++) {
                if(currs[i][0] == goal[i][0] && currs[i][1] == goal[i][1]) {
                    ridx[i]++;
                    if(ridx[i] >= routes[i].length) {
                        end[i] = true;
                    }else {
                        goal[i] = Arrays.copyOf(points[routes[i][ridx[i]] - 1], 2);
                    }
                }
            }
            
        }
        
        return answer;
    }
}
