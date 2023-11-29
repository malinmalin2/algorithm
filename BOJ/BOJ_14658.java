import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] stars;
	static int L, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		stars = new int[K][2];
		// stars들 저장해놓고, 각각에 대해 조회하는 것.
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			stars[i][0] = Integer.parseInt(st.nextToken());
			stars[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int answer = Integer.MIN_VALUE;
		int row, col;
		for(int i = 0; i < K; i++) {
			row = stars[i][0];
			for(int j = 0; j < K; j++) {
				col = stars[j][1];
				answer = Integer.max(answer, sol(row, col));
			}
		}
		System.out.println(K - answer);
		
	}
	
	static int sol(int row, int col) {
		int result = 0;
		// 해당 좌표가 row ~ row + L, col ~ col + L 에 포함하면 튕겨낼 수 있음
		for(int i = 0; i < K; i++) {
			if(stars[i][0] >= row && stars[i][0] <= row + L && stars[i][1] >= col && stars[i][1] <= col + L) result++;
		}
		return result;
	}
}
