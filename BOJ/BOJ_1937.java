import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1937 {
	static int[][] map;
	static int[] dx = {0, 0, -1, 1}; // 상, 하, 좌, 우
	static int[] dy = {-1, 1, 0, 0};
	
	static int[][] saved;
	static int ans = Integer.MIN_VALUE;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		saved = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				ans = Math.max(ans, dfs(i, j));
			}
		}
		System.out.println(ans);
	}
	
	static int newX, newY;
	private static int dfs(int x, int y) {
		if(saved[y][x] != 0) return saved[y][x];
		saved[y][x] = 1;

		for(int d = 0; d < 4; d++) {
			newX = x + dx[d];
			newY = y + dy[d];
			if(newX < 0 || newX >= n || newY < 0 || newY >= n) continue;
			if(map[newY][newX] <= map[y][x]) continue;
			saved[y][x] = Math.max(saved[y][x], dfs(newX, newY) + 1);
		}
		return saved[y][x];
	}
}
