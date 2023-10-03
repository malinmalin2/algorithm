class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int cnt = 0;
        int zeroCnt = 0;
        
        int check = 0;
        while(!s.equals("1")) {
            cnt++;
            String newS = "";
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') zeroCnt++;
                else newS += '1';
            }
            
            int num = newS.length();
            s = Integer.toBinaryString(num);
        }
        
        answer[0] = cnt;
        answer[1] = zeroCnt;
        
        return answer;
    }
}
