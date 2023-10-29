import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1644 {
	static boolean[] visited;
	static ArrayList<Integer> numbers = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		int answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N == 1) {
			System.out.println(0);
			return;
		}
		else if(N == 2) {
			System.out.println(1);
			return;
		}
		visited = new boolean[N + 1];
		init();
		
		int left = 0;
		int right = 1;
		int sum = numbers.get(left) + numbers.get(right);
		while(left < right && left >= 0 && right <= N) {
			if(sum < N) {
				right += 1;
				sum += numbers.get(right);
			}
			else {
				if(sum == N) answer += 1;
				sum -= numbers.get(left);
				left += 1;
			}
		}
		if(numbers.contains(N)) answer += 1;
		System.out.println(answer);
	}
	private static void init() {
		for(int i = 2; i < visited.length; i++) {
			if(visited[i]) continue;
			for(int j = i * 2; j < visited.length; j += i) {
				if(visited[j]) continue;
				visited[j] = true;
			}
		}
		for(int i = 2; i < visited.length; i++) if(!visited[i]) numbers.add(i);
	}
}
