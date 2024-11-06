package baekjoon;

import java.util.Scanner;

public class bj9935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        String bomb = sc.next();
        StringBuilder sb = new StringBuilder();

        // 문자 하나씩 순차적으로 처리
        for (int i = 0; i < text.length(); i++) {
            sb.append(text.charAt(i));

            // 현재 문자열이 폭탄 문자열을 포함하면 제거
            if (sb.length() >= bomb.length() && sb.substring(sb.length() - bomb.length()).equals(bomb)) {
                sb.setLength(sb.length() - bomb.length()); // 폭탄 문자열을 제거
            }
        }

        // 결과 출력
        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}




//public class bj9935 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		StringBuilder sb;
//		String text = sc.next();
//		String bomb = sc.next();
//		int lb = bomb.length();
//		bp: while(text.length() != 0) {
//			int lt = text.length();
//			if(lt < lb) break;
//			for(int i = 0; i <= lt-lb+1; i++) {
//				if(i == lt-lb+1) break bp;
//				if(text.substring(i, i+lb).equals(bomb)) {
//					sb = new StringBuilder().append(text.substring(0, i)).append(text.substring(i+lb));
//					text = sb.toString();
//					continue bp;
//				}
//			}
//		}
//		if(text.length() == 0)
//			System.out.println("FRULA");
//		else
//			System.out.println(text);
//	}
//}






//public class bj9935 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String text = sc.next();
//		String bomb = sc.next();
//		int lb = bomb.length();
//		bp: while(text.length() != 0) {
//			int lt = text.length();
//			if(lt < lb) break;
//			for(int i = 0; i <= lt-lb+1; i++) {
//				if(i == lt-lb+1) break bp;
//				if(text.substring(i, i+lb).equals(bomb)) {
//					text = text.substring(0, i) + text.substring(i+lb);
//					continue bp;
//				}
//			}
//		}
//		if(text.length() == 0)
//			System.out.println("FRULA");
//		else
//			System.out.println(text);
//	}
//}
