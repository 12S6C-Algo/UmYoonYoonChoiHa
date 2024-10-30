package algostudy2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class P1283 {

	// 1. 왼쪽 -> 오른쪽 순서 첫글자 확인
	// 첫글자 x 해당 알파벳
	// 만약 모든 글자 지정? 지정 x인 걸로
	// 지정 x 그냥 놔두기

	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		StringTokenizer st;

		visited = new boolean[26];
		int N = Integer.parseInt(br.readLine());

		out: for (int i = 0; i < N; i++) {
			String str = br.readLine();
			char[] arr = str.toCharArray();

			// 1. 첫 글자 검사
			// 1-1. 대문자
			if (arr[0] < 'a' && !visited[arr[0] - 'A']) {
				visited[arr[0] - 'A'] = true;
				ans.append(insert(arr, 0)).append("\n");
				continue out;
			}
			// 1-2. 소문자
			if (arr[0] >= 'a' && !visited[arr[0] - 'a']) {
				visited[arr[0] - 'a'] = true;
				ans.append(insert(arr, 0)).append("\n");
				continue out;
			}

			// 2. 공백 뒤 검사
			for (int j = 1; j < arr.length; j++) {
				if (arr[j] == ' ') {
					// 2-1 대문자
					if (arr[j + 1] < 'a' && !visited[arr[j + 1] - 'A']) {
						visited[arr[j + 1] - 'A'] = true;
						ans.append(insert(arr, j + 1)).append("\n");
						continue out;
					}
					// 2-2 소문자
					else if (arr[j + 1] >= 'a' && !visited[arr[j + 1] - 'a']) {
						visited[arr[j + 1] - 'a'] = true;
						ans.append(insert(arr, j + 1)).append("\n");
						continue out;
					}
				}
			}

			// 나머지 문자 검사
			for (int j = 0; j < arr.length; j++) {
				// 공백처리
				if(arr[j]==' ') continue;
				// 대문자
				if (arr[j] <'a' && !visited[arr[j] - 'A']) {
					visited[arr[j] - 'A'] = true;
					ans.append(insert(arr, j)).append("\n");
					continue out;
				}
				// 소문자
				else if (arr[j] >= 'a' && !visited[arr[j] - 'a']) {
					visited[arr[j] - 'a'] = true;
					ans.append(insert(arr, j)).append("\n");
					continue out;
				}
			}
			// 아무것도 해당 x
			ans.append(str).append("\n");
		}
		System.out.println(ans.toString());
	}

	public static String insert(char[] arr, int key) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (i == key) {
				sb.append("[").append(arr[i]).append("]");
			} else
				sb.append(arr[i]);
		}
		return sb.toString();
	}
}
