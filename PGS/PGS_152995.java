import java.util.Arrays;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        int myScoreA = scores[0][0];
        int myScoreB = scores[0][1];
        int mySum = scores[0][0] + scores[0][1];
        // 근무 태도 점수 내림차순 정렬.
        // 조회하면서 가장 큰 동료 평가 점수를 저장해둬서 나보다 크다면 인센티브 X
        
        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });
        
        int maxScore = scores[0][1]; // 일단 여기서 시작
        for(int i = 0; i < scores.length; i++) {
            if(scores[i][1] < maxScore) { //  인센티브 X
                if(myScoreA == scores[i][0] && myScoreB == scores[i][1]) return -1;
            }
            else {
                maxScore = Integer.max(maxScore, scores[i][1]);
                if(scores[i][0] + scores[i][1] > mySum) answer++;
            }
        }
        
        return answer;
    }
}
