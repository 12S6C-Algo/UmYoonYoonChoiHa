import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 감시 {
	static int N, M;
	static char[][] arr;
	static int blindSpot;
	static int minSpot = Integer.MAX_VALUE;
	static List<int[]> cctvLocations = new ArrayList<>();
	static char[][] map;
	static int[] direction;

	public static void main(String[] args) throws IOException {
		setupInput();
		recursion(0);
		System.out.println(minSpot);
	}

	static void recursion(int depth) {
		if (depth >= cctvLocations.size()) {
			// 로직 수행
			clearMap();
			for (int i = 0; i < cctvLocations.size(); i++) {
				int[] nowLocation = cctvLocations.get(i);
				int r = nowLocation[0];
				int c = nowLocation[1];
				int[] cctv = cctvLocations.get(i);
				char cctvValue = arr[cctv[0]][cctv[1]];

				if (cctvValue == '1') {
					if (direction[i] == 1) {
						changeMap(r, c, 1);
					} else if (direction[i] == 2) {
						changeMap(r, c, 2);
					} else if (direction[i] == 3) {
						changeMap(r, c, 3);
					} else if (direction[i] == 4) {
						changeMap(r, c, 4);
					}
				} else if (cctvValue == '2') {
					if (direction[i] == 1) {
						changeMap(r, c, 1);
						changeMap(r, c, 3);
					} else if (direction[i] == 2) {
						changeMap(r, c, 2);
						changeMap(r, c, 4);
					}
				} else if (cctvValue == '3') {
					if (direction[i] == 1) {
						changeMap(r, c, 1);
						changeMap(r, c, 2);
					} else if (direction[i] == 2) {
						changeMap(r, c, 2);
						changeMap(r, c, 3);
					} else if (direction[i] == 3) {
						changeMap(r, c, 3);
						changeMap(r, c, 4);
					} else if (direction[i] == 4) {
						changeMap(r, c, 4);
						changeMap(r, c, 1);
					}
				} else if (cctvValue == '4') {
					if (direction[i] == 1) {
						changeMap(r, c, 1);
						changeMap(r, c, 2);
						changeMap(r, c, 3);
					} else if (direction[i] == 2) {
						changeMap(r, c, 2);
						changeMap(r, c, 3);
						changeMap(r, c, 4);
					} else if (direction[i] == 3) {
						changeMap(r, c, 3);
						changeMap(r, c, 4);
						changeMap(r, c, 1);
					} else if (direction[i] == 4) {
						changeMap(r, c, 4);
						changeMap(r, c, 1);
						changeMap(r, c, 2);
					}
				} else if (cctvValue == '5') {
					changeMap(r, c, 1);
					changeMap(r, c, 2);
					changeMap(r, c, 3);
					changeMap(r, c, 4);
				}
			}
			int checks = check();
			minSpot = Math.min(minSpot, checks);

			return;
		}

		int[] nowCCTV = cctvLocations.get(depth);
		char cctvValue = arr[nowCCTV[0]][nowCCTV[1]];

		if (cctvValue == '1' || cctvValue == '3' || cctvValue == '4') {
			for (int i = 1; i <= 4; i++) {
				direction[depth] = i;
				recursion(depth + 1);
			}
		} else if (cctvValue == '2') {
			for (int i = 1; i <= 2; i++) {
				direction[depth] = i;
				recursion(depth + 1);
			}
		} else {
			direction[depth] = 5;
			recursion(depth + 1);
		}
	}

	static int check() {
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') {
					result++;
				}
			}
		}
		return result;
	}

	static void clearMap() {
		for (int i = 0; i < N; i++) {
			map[i] = arr[i].clone();
		}
	}

	// 1 상 2 우 3 하 4 좌
	static void changeMap(int r, int c, int n) {
		if (n == 1) {
			// top
			r--;
			while (0 <= r && arr[r][c] != '6') {
				if (arr[r][c] == '0') {
					map[r][c] = '#';
				}
				r--;
			}
		} else if (n == 2) {
			// right
			c++;
			while (c < M && arr[r][c] != '6') {
				if (arr[r][c] == '0') {
					map[r][c] = '#';
				}
				c++;
			}
		} else if (n == 3) {
			// bottom
			r++;
			while (r < N && arr[r][c] != '6') {
				if (arr[r][c] == '0') {
					map[r][c] = '#';
				}
				r++;
			}
		} else if (n == 4) {
			// left
			c--;
			while (0 <= c && arr[r][c] != '6') {
				if (arr[r][c] == '0') {
					map[r][c] = '#';
				}
				c--;
			}
		}
	}

	static void setupInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		arr = new char[N][M];

		for (int i = 0; i < N; i++) {
			String[] inputArr = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = inputArr[j].charAt(0);
				if (arr[i][j] == '0') {
					blindSpot++;
				} else if (arr[i][j] != '6') {
					cctvLocations.add(new int[] { i, j });
				}
			}
		}
		map = new char[N][M];
		direction = new int[cctvLocations.size()];
		Arrays.fill(direction, 1);
	}
}

/*
 * 모든 경우의수 ? 8개의 씨시티비라면 ? -> 1,2,3,4,5 의씨씨티비 각각의 경우를 생각해야함 1 일경우 4방향 2 일경우 2방향
 * 3일경우 4방향 4일경우 4방향 5일경우 1번으로 끝남.
 */
