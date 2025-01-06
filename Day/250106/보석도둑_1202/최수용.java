import java.util.*;
import java.io.*;

public class Main {
  static class Jewelry implements Comparable<Jewelry>{
    int m, v;
    Jewelry(int m, int v){
      this.m = m;
      this.v = v;
    }
    @Override
    public int compareTo(Jewelry o){
      if(this.m==o.m){
        return o.v-this.v;
      }
      return this.m-o.m;
    }
  }
  
  static int N,K,C;
  static int[] bags;
  static Jewelry[] jewelries;
  static PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
    @Override
    public int compare(Integer a, Integer b){
      return b-a;
    }
  });
  public static void main(String[] args) throws IOException{
    input();
    long ans =0;
    for(int i=0,j=0;i<K;i++){
      while(j<N &&jewelries[j].m<=bags[i]){
        pq.add(jewelries[j++].v);
      }
      
      if(!pq.isEmpty()){
        ans+=pq.poll();
      }
    }
    System.out.println(ans);
  } 
  
  static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    jewelries = new Jewelry[N];
    for(int i =0;i<N;i++){
      st = new StringTokenizer(br.readLine());
      jewelries[i] = new Jewelry(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
    }
    bags = new int[K];
    for(int i =0;i<K;i++){
      bags[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(jewelries);
    Arrays.sort(bags);
  }
}
