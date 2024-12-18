// 24.12.18 Wed

package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_22866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] buildings = new int[N + 1];
        int maxFloor = -1;
        for (int i = 1; i < N + 1; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
            maxFloor = Math.max(maxFloor, buildings[i]);
        }

        int[] cntBuilding = new int[N + 1];
        int[] closerBuilding = new int[N + 1];
        Stack<Integer> visibleBuildings = new Stack<>();

        for (int i = 1; i < N + 1; i++) {
            while (!visibleBuildings.isEmpty() && buildings[visibleBuildings.peek()] <= buildings[i]) {
                visibleBuildings.pop();
            }

            cntBuilding[i] += visibleBuildings.size();
            if (!visibleBuildings.isEmpty()) {
                closerBuilding[i] = visibleBuildings.peek();
            }
            visibleBuildings.push(i);
        }

        visibleBuildings.clear();
        for (int i = N; i >= 1; i--) {
            while (!visibleBuildings.isEmpty() && buildings[visibleBuildings.peek()] <= buildings[i]) {
                visibleBuildings.pop();
            }

            cntBuilding[i] += visibleBuildings.size();
            if (!visibleBuildings.isEmpty()) {
                if (closerBuilding[i] != 0) {
                    if (Math.abs(closerBuilding[i] - i) > Math.abs(visibleBuildings.peek() - i)) {
                        closerBuilding[i] = visibleBuildings.peek();
                    }
                } else {
                    closerBuilding[i] = visibleBuildings.peek();
                }
            }

            visibleBuildings.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            if (cntBuilding[i] == 0) {
                sb.append(0).append("\n");
            } else {
                sb.append(cntBuilding[i]).append(" ").append(closerBuilding[i]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
