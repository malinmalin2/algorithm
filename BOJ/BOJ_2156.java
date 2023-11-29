import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] num = new int[n];
		for(int i = 0; i < n; i++) num[i] = Integer.parseInt(br.readLine());
		
		// 0 = 선택 X, 이전의 1을 가져옴
		// 1 = 선택 O, 이전 것과 함께 선택, 이전의 2와 현재를 더함
		// 2 = 선택 O, 다음 것과 함께 선택할 것임, 이전의 0과 현재를 더함
		int[][] dp = new int[n][3];
		dp[0][0] = 0;
		dp[0][1] = num[0];
		dp[0][2] = num[0];
		
		for(int i = 1; i < n; i++) {
			dp[i][0] = Integer.max(dp[i - 1][0], dp[i - 1][1]);
			dp[i][0] = Integer.max(dp[i][0], dp[i - 1][2]);
			dp[i][1] = dp[i - 1][2] + num[i];
			dp[i][2] = dp[i - 1][0] + num[i];
		}
//		System.out.println(dp[n - 1][0] + " " + dp[n - 1][1] + " " + dp[n - 1][2]);
		int ans = Integer.max(dp[n - 1][0], dp[n - 1][1]);
		ans = Integer.max(ans, dp[n - 1][2]);
		System.out.println(ans);
	}
}
