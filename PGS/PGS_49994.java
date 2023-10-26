class Solution {
    static int[] dx = {0, 0, -1, 1}; // 상, 하, 좌, 우
    static int[] dy = {-1, 1, 0, 0};
    
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] map = new boolean[11][11][4];
        char c;
        int x = 5, y = 5;
        int oldX = 0, oldY = 0, newX = 0, newY = 0;
        int D = 0;
        for(int i = 0; i < dirs.length(); i++) {
            c = dirs.charAt(i);
            switch (c) {
                case 'U' : D = 0;
                           break;
                case 'D' : D = 1;
                           break;
                case 'L' : D = 2;
                           break;
                case 'R' : D = 3;
                           break;
            }
            newX = x + dx[D];
            newY = y + dy[D];
            if(newX < 0 || newX > 10 || newY < 0 || newY > 10) continue;
            
            oldX = x;
            oldY = y;
            x = newX;
            y = newY;
            if(map[newY][newX][D]) continue;
            map[newY][newX][D] = true;
            if(D % 2 == 0) map[oldY][oldX][D + 1] = true;
            else map[oldY][oldX][D - 1] = true;
            answer++;
        }
        return answer;
    }
}
