import java.io.*;
import java.util.*;

class Solution {
    static int size,time;
    static List<String> cache;
    public int solution(int cacheSize, String[] cities) {
        time = 0;
        size = cacheSize;
        cache = new ArrayList();
        
        if(cacheSize ==0){
            return 5*cities.length;
        }
        for(int i =0;i<cities.length;i++){
            String city = cities[i].toLowerCase();
            insert(city);
        }
        int answer = time;
        return answer;
    }
    
    public static void insert(String city){
        if(!cache.contains(city)){
            if(cache.size()==size){
                cache.remove(0);
            }
            cache.add(city);    
            time+=5;
        }
        
        else{
            cache.remove(city);
            cache.add(city);
            time++;
        }
    }
}
