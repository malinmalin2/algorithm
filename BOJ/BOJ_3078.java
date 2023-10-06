import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] chars = new int[21];
		int[] myFriends = new int[N + 1];
		
		long answer = 0;
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			int len = s.length();
			if(chars[len] > 0) answer += chars[len];
			myFriends[i] = len;
			chars[len]++;
			
			if(i >= K) chars[myFriends[i - K]]--;
			
		}
		System.out.println(answer);
	}
}
