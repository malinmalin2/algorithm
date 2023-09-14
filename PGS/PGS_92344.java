import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int[][] save = new int[board.length][board[0].length];
        int startRow, startCol, endRow, endCol, degree;
        
        for(int k = 0; k < skill.length; k++) {
            startRow = skill[k][1];
            startCol = skill[k][2];
            endRow = skill[k][3];
            endCol = skill[k][4];
            degree = skill[k][5];
            
            if(skill[k][0] == 1) degree = -degree;
            save[startRow][startCol] += degree;
            if(endRow + 1 < board.length) save[endRow + 1][startCol] -= degree;
            if(endCol + 1 < board[0].length) save[startRow][endCol + 1] -= degree;
            if(endRow + 1 < board.length && endCol + 1 < board[0].length) save[endRow + 1][endCol + 1] += degree;
        }

        for(int i = 1; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                save[i][j] += save[i-1][j];
            }
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 1; j < board[0].length; j++) {
                save[i][j] += save[i][j-1];
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] += save[i][j];
                if(board[i][j] >= 1) answer++;
            }
        }
        
        return answer;
    }
}