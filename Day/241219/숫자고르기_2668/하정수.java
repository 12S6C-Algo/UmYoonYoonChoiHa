package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class bj2668 {
	static int N;
	static int[] nums;
	static boolean[] selected;
	static List<Integer> answers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nums = new int[N+1];
		selected = new boolean[N+1];
		answers = new ArrayList<Integer>();
		for(int i = 1; i <= N; i++) {
			nums[i] = sc.nextInt();
		}
		
		for(int i = 1; i <= N; i++) {
			selected[i] = true;
			dfs(i, i);
			selected[i] = false;
		}
		Collections.sort(answers);
		System.out.println(answers.size());
		for(int answer : answers) {
			System.out.println(answer);
		}
	}
	
	static void dfs(int num, int start) {
		if(nums[num] == start)
			answers.add(start);
		if(!selected[nums[num]])  {
			selected[nums[num]] = true;
			dfs(nums[num], start);
			selected[nums[num]] = false;
		}
	}
}
