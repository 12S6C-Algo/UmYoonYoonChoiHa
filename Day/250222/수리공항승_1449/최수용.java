import java.io.*;
import java.util.*;

class Main {

    static int N, L,SZ,ANS;
    static boolean[] leak;
    public static void main(String[] args) throws IOException{
        input();
        block();
        System.out.print(ANS);
    }
    
    static void block(){
        for(int i =0;i<SZ;){
            // leak
            if(leak[i]){
                ANS++;
                int tape = L; 
                // int tape = L -1; // 양쪽 끝 0.5씩 제외
                while(i < SZ && tape > 0){
                    leak[i] = false;
                    i++;
                    tape--;
                }
            }
            else i++;
        }
    }
    
    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        SZ = 1001;
        ANS = 0;
        
        leak = new boolean[SZ];  
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            leak[Integer.parseInt(st.nextToken())] = true;
        }
    }
}
