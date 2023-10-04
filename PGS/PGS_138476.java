import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            int num = tangerine[i];
            if(map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        
        Collections.sort(keys, (v1, v2) -> (map.get(v2).compareTo(map.get(v1))));

        int cnt = 0;
        for (int key : keys) {
            if(cnt >= k) break;
            answer++;
            cnt += map.get(key);
        }
        
        return answer;
    }
}
