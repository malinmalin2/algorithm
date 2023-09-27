
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[][] map = new int[9][9];
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 9; i++) {
			String s = br.readLine();
			char[] c = s.toCharArray();
			for(int j = 0; j < 9; j++) {
				map[i][j] = c[j] - '0';
			}
		}
		
		sol(0);
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static void sol(int cnt) {
		
		if(cnt == 81) { // 끝까지 왔으니까 스도쿠 성공
			flag = true; // 사전순으로 해야하므로 더이상 탐색 X
			return;
		}
		
		int row = cnt / 9;
		int col = cnt % 9;
		
		if(map[row][col] != 0) sol(cnt + 1);
		else {
			for(int i = 1; i <= 9; i++) {
				if(check(row, col, i)) { // 해당 자리에 i를 넣을 수 있는지
					map[row][col] = i;
					sol(cnt + 1);
					
					if(flag) return;
					map[row][col] = 0;
				}
			}
		}
		
	}

	private static boolean check(int row, int col, int num) {
		
		for(int i = 0; i < 9; i++) {
			if(map[row][i] == num || map[i][col] == num) return false;
		}
		
		int startRow = row / 3 * 3;
		int startCol = col - col % 3;
		for(int i = startRow; i < startRow + 3; i++) {
			for(int j = startCol; j < startCol + 3; j++) {
				if(map[i][j] == num) return false;
			}
		}
		return true;
	}
	
	
}


