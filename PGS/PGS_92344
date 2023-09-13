import java.io.*;
import java.util.*;

class Solution {
    static class Info {
        String path;
        int depth, x, y;
        public Info(String path, int depth, int x, int y) {
            this.path = path;
            this.depth = depth;
            this.x = x;
            this.y = y;
        }
    }
    
    static int map[][][];
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {1, 0, 0, -1};
    static char[] dir = {'d', 'l', 'r', 'u'};
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        map = new int[4][n + 2][m + 2]; 
        String answer = "impossible";
        Queue<Info> q = new LinkedList<>();
        q.add(new Info("", 0, y, x));
        
        loop:
        while(!q.isEmpty()) {
            Info info = q.poll();
            String path = info.path;
            int depth = info.depth;
            int nowX = info.x;
            int nowY = info.y;
            
            for(int d = 0; d < 4; d++) {
                int newX = nowX + dx[d];
                int newY = nowY + dy[d];
                if(newX >= 1 && newX <= m && newY >= 1 && newY <= n) {
                    if(depth == (k-1)) {
                        if(newX == c && newY == r) {
                            answer = path + dir[d];
                            break loop;
                        }
                    }
                    if(depth < k) {
                        if(map[d][newY][newX] != (depth + 1)) {
                            map[d][newY][newX] = depth + 1;
                            q.add(new Info(path + dir[d], depth + 1, newX, newY));
                        }
                    }
                }
            }
        }
        return answer;
    }
}
