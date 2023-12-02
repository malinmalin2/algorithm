package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13144 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] numbers = new int[N];
		boolean[] visited = new boolean[100001];
		for(int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
		if(N == 1) {
			System.out.println(1);
			return;
		}
		int answer = 0;
		int left = 0, right = 1;
		visited[numbers[left]] = true;
		while(left < N && right < N) {
			if(visited[numbers[right]]) {
				answer += (right - left);
				visited[numbers[left]] = false;
				left++;
			}
			else {
				visited[numbers[right]] = true;
				right++;
			}
		}
		for(int i = 1; i <= right - left; i++) answer += i;
		System.out.println(answer);
	}
}
