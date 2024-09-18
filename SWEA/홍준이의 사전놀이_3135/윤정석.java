package d5;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

class UserSolution {
	
	static class Node {
		Node[] child = new Node[26];
		char value;
		int childNum;
		
	}

	static class Trie {
		Node root;
		
		public Trie() {
			this.root = new Node();
		}
		
		public void input(String str) {
			Node cur = this.root;
			
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				int num = c - 'a';
				
				if(cur.child[num] == null) {
					cur.child[num] = new Node();
					cur.child[num].value = c;
				}
				
				cur = cur.child[num];
				cur.childNum++;
			}
			
		}
		
		public int find(String str) {
			Node cur = this.root;
			
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				int num = c - 'a';
				
				if(cur.child[num] == null) return 0;
				
				cur = cur.child[num];
			}
			
			return cur.childNum;
		}
		
	}
	
	static Trie trie;
	
	public void init() { // 각 테스트케이스 시작마다 호출되는 함수
		trie = new Trie();
	}
	
	public void insert(int buffer_size, String buf) { // 홍준이가 공책에 추가하는 새로운 단어의 길이(= buffer_size)와 문자열 정보(= buf)가 인자로 주어지는 함수
		trie.input(buf);
	}
	
	public int query(int buffer_size, String buf) { // buffer_size 길이의 buf 문자열이 주어졌을 때에, 현재 공책에 적힌 단어들 중 buf로 시작하는 단어의 갯수를 반환하는 함수
		return trie.find(buf);
	}
}

public class D5_3135 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);

		UserSolution dictManager = new UserSolution();
		
		for (int TestCase = in.nextInt(), tc = 1; tc <= TestCase; tc = tc + 1) {

			int Query_N = in.nextInt();

			out.print("#" + tc);

			dictManager.init();

			for (int i = 1; i <= Query_N; i++) {
				int type = in.nextInt();

				if (type == 1) {
					String buf = in.next();
					dictManager.insert(buf.length(), buf);
				}
				else {
					String buf = in.next();
					int answer = dictManager.query(buf.length(), buf);
					out.print(" " + answer);
				}
			}
			out.println("");
		}
		out.close();
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				}
				catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

	}
}