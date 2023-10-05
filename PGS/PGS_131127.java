import java.util.*;

class Solution {
    static HashMap<String, Integer> map;
    
    static boolean check(String[] want, int[] number) {
        for(int i = 0; i < want.length; i++) {
            if(map.containsKey(want[i])) {
                if(map.get(want[i]) < number[i]) return false;
            }
            else return false;
        }
        return true;
    }
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        map = new HashMap<>();
        for(int i = 0; i < 10; i++) map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        if(check(want, number)) answer++;
        if(discount.length == 10) return answer;
        
        for(int i = 10; i < discount.length; i++) {
            String beforeDis = discount[i - 10];
            map.put(beforeDis, map.get(beforeDis) - 1);
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
            if(check(want, number)) answer++;
        }
        
        return answer;
    }
}
