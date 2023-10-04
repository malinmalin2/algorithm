import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        int N = elements.length;
        int[] newElements = new int[N * 2];
        
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        System.arraycopy(elements, 0, newElements, N, elements.length);
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= N; i++) { // 원소 길이
            for(int j = 0; j < N; j++) { // 시작점
                int sum = 0;
                for(int k = j; k < j + i; k++) sum += newElements[k];
                set.add(sum);
            }
        }
        return set.size();
    }
}
