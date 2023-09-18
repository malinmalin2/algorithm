class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[] dx = {1, 0, -1, 0}; // 우, 하, 좌, 상
        int[] dy = {0, 1, 0, -1};
        int[][] map = new int[rows + 2][columns + 2];
        
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                map[i][j] = (i - 1) * columns + j;
            }
        }

        int min, startRow, startCol, endRow, endCol, nowRow, nowCol, nextRow, nextCol, d, save, temp;
        for(int q = 0; q < queries.length; q++) {
            min = Integer.MAX_VALUE;
            startRow = queries[q][0];
            startCol = queries[q][1];
            endRow = queries[q][2];
            endCol = queries[q][3];
            
            nowRow = startRow;
            nowCol = startCol;
            d = 0;
            save = map[startRow + 1][startCol];
            
            while(true) {
                temp = map[nowRow][nowCol];
                map[nowRow][nowCol] = save;
                save = temp;
                min = Math.min(min, save);
                
                nextRow = nowRow + dy[d];
                nextCol = nowCol + dx[d];
                if(nextRow > endRow || nextCol > endCol || nextRow < startRow || nextCol < startCol) {
                    d++;
                    nextRow = nowRow + dy[d];
                    nextCol = nowCol + dx[d];
                }
                nowRow = nextRow;
                nowCol = nextCol;
                
                if(nowRow == startRow && nowCol == startCol) break;
            }
            
            answer[q] = min;
        }
        return answer;
    }
}
