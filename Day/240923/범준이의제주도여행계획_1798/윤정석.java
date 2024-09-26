/* 24.09.24 Tue
 * 
 * 문제 개요
 * 1. 한 번 갔던 관광포인트는 다시 방문하지 않음
 * 2. 하루 이동+놀이에 소요되는 시간 <= 9 -> 호텔 입실
 * 3. M일 째 날에도 9시간 가능 -> 그 전에 공항 도착
 * 
 * EX.
 * 1일차: A - H
 * 2일차: H - H
 * 3일차: H - A
 * 
 * 관광지 -> 순열로 선택
 * 호텔 -> 중복순열로 선택
 * 
 * 오답노트: 완전탐색 + 구현
 * 1. M은 휴가 기간임 ex. M = 1 -> 0박 1일 -> 호텔을 선택할 필요가 없음
 * 2. 순열로 선택한 관광지를 조건에 일치하지 않으면 패스시키지 않고, 그 관광지를 그대로 사용하고자 한게 코드를 더욱 복잡하게 만듦
 * 		- 어차피 순열의 순서를 따른다면 모든 경로를 확인할 수 있었기에 이렇게 판단함.
 * 		- 하지만 조건에 맞지 않는 관광지를 그대로 패스시켜버리는게 코드가 간단하고 구현하기 편함.
 * 
 * ※ 시간복잡도가 작은 코드의 경우, 해당 관광지에서 가장 가까운 호텔을 미리 찾아 시간복잡도를 줄였다.
 * 	 이러한 완전탐색의 문제의 경우, 시간 복잡도를 줄이는 여러 방법들이 있지만 답에 영향을 주지 않는 조건을 추가로 적용시키는게 중요할 것 같다. 
 * 
 */

package d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D5_1798 {
	
	static int[][] dist;
	static int[] playTime, sati;
	static List<Integer> playIdx, hotelIdx, eachPath, bestPath;
	static int N, M, maxSati;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			dist = new int[N + 1][N + 1];
			for (int from = 1; from < N; from++) {
				st = new StringTokenizer(br.readLine());
				for (int to = from + 1; to < N + 1; to++) {
					int d = Integer.parseInt(st.nextToken());
					dist[from][to] = d;
					dist[to][from] = d;
				}
			}
			
			playTime = new int[N + 1];
			sati = new int[N + 1];
			playIdx = new ArrayList<>(); // 순열 선택을 위해
			hotelIdx = new ArrayList<>(); // 중복 순열 선택을 위해
			
			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				char place = st.nextToken().charAt(0);
				
				if(place == 'A') continue; // 공항의 인덱스는 무조건 1이라 판단
				
				if(place == 'P') {
					int pt = Integer.parseInt(st.nextToken());
					int sa = Integer.parseInt(st.nextToken());
					playTime[i] = pt;
					sati[i] = sa;
					playIdx.add(i);
				} else hotelIdx.add(i);
			}
			
			maxSati = 0;
			bestPath = new ArrayList<>();
			eachPath = new ArrayList<>();
			permWR(0, new int[M - 1]);
			sb.append("#").append(tc).append(" ").append(maxSati);
			if(maxSati > 0) {
				for (int i : bestPath) {
					sb.append(" ").append(i);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	// 순열: 관광지 선택 with 호텔, 공항 
	static void perm(int preIdx, int satiSum, int curTimeSum, int day, int[] hotel, boolean[] visit) {
		// 해당일에 관광지 방문
		for (int idx : playIdx) {
			if(visit[idx]) continue;
			
			int travelTime = dist[preIdx][idx];
			int play = playTime[idx];
			
			if(curTimeSum + travelTime + play <= 540) {
				visit[idx] = true;
				eachPath.add(idx);
				perm(idx, satiSum + sati[idx], curTimeSum + travelTime + play, day, hotel, visit);
				eachPath.remove(eachPath.size() - 1);
				visit[idx] = false;
			}
		}
		
		// 마지막날을 제외한 해당일에 더이상 관광지를 방문할 수 없는 경우 -> 호텔로 이동
		if(day < M - 1 && curTimeSum + dist[preIdx][hotel[day]] <= 540) {
			eachPath.add(hotel[day]);
			perm(hotel[day], satiSum, 0, day + 1, hotel, visit);
			eachPath.remove(eachPath.size() - 1);
		}
		// 마지막날에 더이상 관광지를 방문할 수 없는 경우 -> 공항으로 이동
		else if(day == M - 1 && curTimeSum + dist[preIdx][1] <= 540) {
			eachPath.add(1);
			if(maxSati < satiSum) {
				maxSati = satiSum;
				bestPath = new ArrayList<>(eachPath);
			}
			eachPath.remove(eachPath.size() - 1);
		}
		
	}
	
	// 중복 순열: 호텔 선택
	static void permWR(int depth, int[] out) {
		if(depth == M - 1) { // 1박에 호텔 1개
			perm(1, 0, 0, 0, out, new boolean[N + 1]);
			return;
		}
		
		for (int idx : hotelIdx) {
			out[depth] = idx;
			permWR(depth + 1, out);
		}
	}
	
}
