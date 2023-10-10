import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static int dy[] = {0, 1, 0, -1};
	static int dx[] = {1, 0, -1, 0}; // 우, 상, 좌, 하
	static int[][] map;
	static int pos = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1 && pos == -1) pos = i;
			}
		}
		for(int t = 0; t < T; t++) {
			affect();
			rotate(pos);
			rotate(pos + 1);
		}
		
		int answer = 0;
		for(int i = 0; i < R; i++) for(int j = 0; j < C; j++) answer += map[i][j];
		System.out.println(answer + 2);
	}
	
	static void rotate(int row) {
		dy[1] *= -1;
		dy[3] *= -1;
		int col = 0;
		int saved = 0;
		int d = 0;
		while(true) {
			int newY = row + dy[d];
			int newX = col + dx[d];
			if(newY < 0 || newY >= R || newX < 0 || newX >= C) {
				d++;
				continue;
			}
			if((newY == pos || newY == pos + 1) && newX == 0) break;
			int temp = map[newY][newX];
			map[newY][newX] = saved;
			saved = temp;
			row = newY;
			col = newX;
		}
		
	}
	
	static void affect() { // 먼지의 확산
		int[][] newMap = new int[R][C];
		for(int i = 0; i < R; i++) newMap[i] = map[i].clone();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				int amount = newMap[i][j]; // 먼지의 양
				int cnt = 0;
				if(amount > 0) {
					for(int d = 0; d < 4; d++) {
						int newY = i + dy[d];
						int newX = j + dx[d];
						if(newY >= 0 && newY < R && newX >= 0 && newX < C) {
							if(newMap[newY][newX] == -1) continue; // 공기청정기가 있음
							map[newY][newX] += amount / 5;
							cnt++;
						}
					}
					if(newMap[i][j] != -1) map[i][j] = map[i][j] - amount / 5 * cnt;
				}
			}
		}
	}
}
