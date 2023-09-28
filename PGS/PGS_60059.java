class Solution {
    static int[][] map;
    static int N, M;
    
    static void rotate(int[][] key) {
        int N = key.length;
        int[][] temp = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) temp[i][j] = key[N - j - 1][i];
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) key[i][j] = temp[i][j];
        }
    }
    
    static boolean move(int startRow, int startCol, int[][] key) {
        for(int i = startRow; i < startRow + M; i++) {
            for(int j = startCol; j < startCol + M; j++) {
                map[i][j] += key[i- startRow][j- startCol];
            }
        }
        
        return check();
    }
    
    static boolean check() {
        for(int i = M - 1; i < N + M - 1; i++) {
            for(int j = M - 1; j < N + M - 1; j++) {
                if(map[i][j] != 1) return false;
            }
        }
        return true;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        N = lock.length;
        M = key.length;
        
        for(int d = 0; d < 4; d++) {
            rotate(key);
            
            for(int y = 0; y <= N + M - 2; y++) {
                for(int x = 0; x <= N + M - 2; x++) {
                    map = new int[N + 2 * M - 2][N + 2 * M - 2];
                    for(int i = M - 1; i <= N + M - 2; i++) {
                        for(int j = M - 1; j <= N + M - 2; j++) {
                            map[i][j] = lock[i - M + 1][j - M + 1];
                        }
                    }

                    if(move(x, y, key)) return true;   
                }
            }
        }
        return false;
    }
}
