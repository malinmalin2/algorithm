import java.util.*;

class Solution {
    static int[][] visited;
    static ArrayList<Integer> groupInfo = new ArrayList<>();
    static Queue<int[] > q;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    static int[] now;
    static int cnt, n, m, groupNum = 1;
    static int newRow, newCol;
    
    static void bfs(int[][] land, int row, int col) {
        q = new LinkedList<>();
        cnt = 0;
        visited[row][col] = groupNum;
        q.add(new int[]{row, col});
        while(!q.isEmpty()) {
            now = q.poll();
            cnt++;
            for(int d = 0; d < 4; d++) {
                newRow = now[0] + dy[d];
                newCol = now[1] + dx[d];
                if(newRow < 0 || newRow >= n || newCol < 0 || newCol >= m || land[newRow][newCol] == 0 || visited[newRow][newCol] != 0) continue;
                visited[newRow][newCol] = groupNum;
                q.add(new int[]{newRow, newCol});
            }
        }
        groupNum++;
        groupInfo.add(cnt); // groupNum에 맞는 cnt(총 석유량) 추가
    }
    
    public int solution(int[][] land) {
        groupInfo.add(0);
        n = land.length;
        m = land[0].length;
        visited = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(land[i][j] == 1 && visited[i][j] == 0) bfs(land, i, j);
            }
        }
        
        // bfs 로 조회하면서, 조회하지 않은 칸에 대해서 그룹번호 넣어주고.
        // 그 그룹번호 조회해서 oil cnt 넣어줌.
        // 다 돌고 나서, 그룹번호 조회한 후에 oil cnt 0으로 만들어서 다 둘러봄.
        int answer = 0;
        int tempAnswer;
        HashSet<Integer> set;
        List<Integer> list;
        for(int j = 0; j < m; j++) {
            tempAnswer = 0;
            set = new HashSet<>();
            for(int i = 0; i < n; i++) {
                if(visited[i][j] != 0) set.add(visited[i][j]); // groupNum 넣어줌
            }
            // 해당 인덱스에 대해 cnt 조회
            list = new ArrayList<>(set);
            for(int i = 0; i < list.size(); i++) {
                tempAnswer += groupInfo.get(list.get(i));
            }
            answer = Integer.max(tempAnswer, answer);
        }
        
        return answer;
    }
}
