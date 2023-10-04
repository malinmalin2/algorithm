import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] map = new int[9][9];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 9; i++) {
			String s = br.readLine();
			char[] numbers = s.toCharArray();
			for(int j = 0; j < 9; j++) {
				map[i][j] = numbers[j] - '0';
			}
		}
		sol();
		
	}

	private static void sol() {
		boolean flag = false;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(map[i][j] == 0) {
					flag = true;
					for(int k = 1; k <= 9; k++) {
						map[i][j] = k;
						if(check()) sol();
					}
					map[i][j] = 0;
				}
			}
		}
		
		if(!flag) {
			for(int i = 0; i < 9; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			System.out.println();
		}
	}
	
	private static boolean check() {
		boolean[] isVisited;
		for(int i = 0; i < 9; i++) {
			isVisited = new boolean[10];
			for(int j = 0; j < 9; j++) {
				if(map[i][j] == 0) continue;
				if(isVisited[map[i][j]]) return false;
				isVisited[map[i][j]] = true;
			}
		}
		for(int i = 0; i < 9; i++) {
			isVisited = new boolean[10];
			for(int j = 0; j < 9; j++) {
				if(map[j][i] == 0) continue;
				if(isVisited[map[j][i]]) return false;
				isVisited[map[j][i]] = true;
			}
		}
		

		
		return true;
	}
}
