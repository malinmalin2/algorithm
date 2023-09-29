import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Info {
		int now;
		int depth;
		Info(int now, int depth) {
			this.now = now;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if(N == 1) {
			System.out.println(1);
			return;
		}
		// 하이퍼튜브도 역으로 가정
		ArrayList<Integer>[] list = new ArrayList[N + M + 1];
		for(int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			for(int k = 0; k < K; k++) {
				int temp = Integer.parseInt(st.nextToken());
				// 역-하이퍼튜브
				list[temp].add(N + m);
				list[N + m].add(temp);
			}
		}
		
		Queue<Info> q = new LinkedList<>();
		boolean[] isVisited = new boolean[N + M + 1];
		q.add(new Info(1, 1));
		isVisited[1] = true;
		
		while(!q.isEmpty()) {
			Info info = q.poll();
			int now = info.now;
			int depth = info.depth;
			
			for(int i = 0; i < list[now].size(); i++) {
				int n = list[now].get(i);
				if(n == N) {
					System.out.println(depth / 2 + 1);
					return;
				}
				if(!isVisited[n]) {
					isVisited[n] = true;
					q.add(new Info(n, depth + 1));
				}
//				for(int j = 0; j < list[tube].size(); j++) {
//					int n = list[tube].get(j); // 튜브와 연결되어 있는 역
//					if(n == N) {
//						System.out.println((depth + 1));
//						return;
//					}
//					if(!isVisited[n]) {
//						isVisited[n] = true;
//						q.add(new Info(n, depth + 1));
//					}
//					
//				}
			}
		}
		System.out.println(-1);
	}

}
