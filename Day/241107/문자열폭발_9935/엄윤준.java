package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열폭발_9935 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		char[] c = new char[input.length()];
		c = input.toCharArray();
		
		char[] bomb = br.readLine().toCharArray();
		int bs = bomb.length;
		Stack<Character> st = new Stack<>();
		
		for (int i = 0; i < c.length; i++) {
			st.push(c[i]);
			int stsize = st.size();
			// stack 사이즈가 bomb사이즈보다 크거나 같은 상황에서
			// stack의 마지막이 bomb의 마지막과 같다면 확인해서 빼주기
			if (stsize >= bs && st.peek() == bomb[bs-1]) {
				int cnt = 0;
				for (int j = 0; j < bs; j++) {
					if (st.get(stsize - bs + j) == bomb[j]) {
						cnt++;
					}
				}
				if (cnt == bs) {
					for (int j = 0; j < bomb.length; j++) {
						st.pop();
					}
				}
			}
		}
		
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < st.size(); i++) {
			ans.append(st.get(i));
		}
				
		if (ans.length() == 0) {
			System.out.println("FRULA");
		} else {
			System.out.println(ans);
		}
		
	}

}
