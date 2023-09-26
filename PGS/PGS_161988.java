class Solution {
    public long solution(int[] sequence) {
        int[] a = new int[sequence.length];
        int[] b = new int[sequence.length];
        
        int c = 1;
        for(int i = 0; i < sequence.length; i++) {
            a[i] = sequence[i] * c;
            c *= -1;
            b[i] = sequence[i] * c;
        }
        
        long[] dpA = new long[sequence.length];
        long[] dpB = new long[sequence.length];
        
        dpA[0] = a[0];
        dpB[0] = b[0];
        long answer = Math.max(dpA[0], dpB[0]);
        for(int i = 1; i < sequence.length; i++) {
            dpA[i] = Math.max(a[i], dpA[i - 1] + a[i]);
            dpB[i] = Math.max(b[i], dpB[i - 1] + b[i]);
            answer = Math.max(dpA[i], answer);
            answer = Math.max(dpB[i], answer);
        }
        
        return answer;
    }
}
