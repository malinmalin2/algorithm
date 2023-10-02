class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int sum = 0;
        boolean flag = false;
        
        for(int right = 0; right < sequence.length; right++) {
            sum += sequence[right];
            
            while(sum > k) sum -= sequence[left++];
            
            if(sum == k) {
                if((!flag) || right - left < answer[1] - answer[0]) {
                    answer[0] = left;
                    answer[1] = right;
                    flag = true;
                }
            }
        }

        return answer;
    }
}
