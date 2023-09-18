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
//     public String solution(int n, int m, int x, int y, int r, int c, int k) {
//         String answer = "impossible";
//         Queue<Info> q = new LinkedList<>();
//         q.add(new Info("", 0, y, x));
        
//         loop:
//         while(!q.isEmpty()) {
//             Info info = q.poll();
//             String path = info.path;
//             int depth = info.depth;
//             int nowX = info.x;
//             int nowY = info.y;
            
//             for(int d = 0; d < 4; d++) {
//                 int newX = nowX + dx[d];
//                 int newY = nowY + dy[d];
//                 if(newX >= 1 && newX <= m && newY >= 1 && newY <= n) {
//                     if(depth == (k-1)) {
//                         if(newX == c && newY == r) {
//                             answer = path + dir[d];
//                             break loop;
//                         }
//                     }
//                     if(depth < k) q.add(new Info(path + dir[d], depth + 1, newX, newY));
//                 }
//             }
//         }
//         return answer;
//     }
// }

/* 최단거리로 빠져 나오고 k수만큼 채워주기? 그만큼 문자열 만들어서 따져봐야하는데 ... */

/* 4차원 방문배열을 쓸까? 
'd', 'l', 'r', 'u' 순서 배열
그곳에는 깊이를 저장해둠. 그래서 업데이트하고자 하는 깊이랑 같으면 가지 않는 거지. 
왜냐하면 그전에 갔던게 사전순으로 더 빠르니까*/
