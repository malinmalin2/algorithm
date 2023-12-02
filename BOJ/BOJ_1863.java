package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1863 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		Deque<Integer> stack = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer.parseInt(st.nextToken());
		stack.addLast(Integer.parseInt(st.nextToken()));
		int y;
		for(int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			if(!stack.isEmpty() && stack.peekLast() > y) {
				while(!stack.isEmpty() && stack.peekLast() > y) {
					stack.pollLast();
					answer++;
				}
			}
			if(stack.isEmpty()) stack.addLast(y);
			else if(stack.peekLast() != y) stack.addLast(y);
		}
		while(!stack.isEmpty()) {
			y = stack.pollLast();
			if(y == 0) continue;
			answer++;
		}
		System.out.println(answer);
	}
}
