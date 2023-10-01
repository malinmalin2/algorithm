import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class City implements Comparable<City>{
		int index;
		int time;
		
		City(int index, int time) {
			this.index = index;
			this.time = time;
		}

		@Override
		public int compareTo(City o) {
			return this.time - o.time;
		}
	}
	
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시 수 (노드 수)
		int M = Integer.parseInt(st.nextToken()); // 도로 수 (간선 수)
		int X = Integer.parseInt(st.nextToken()); // 파티 도시 위치
		
		
		// X 출발 -> 각 도시 도착 용도.
		ArrayList<City>[] list1 = new ArrayList[N + 1];
		
		// 각 도시 출발 -> X 도착 용도.
		// 뒤집어서 저장하면 X 출발 -> 각 도시 도착으로 구하면 됨
		ArrayList<City>[] list2 = new ArrayList[N + 1];
		
		for(int i = 0; i < N + 1; i++) {
			list1[i] = new ArrayList<>();
			list2[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			list1[start].add(new City(end, time));
			list2[end].add(new City(start, time));
		}
		
		
		int[] time1 = dijkstra(X, list1);
		int[] time2 = dijkstra(X, list2);
		
		int answer = Integer.MIN_VALUE;
		for(int i = 1; i <= N; i++) {
			answer = Math.max(answer, time1[i] + time2[i]);
		}
		System.out.println(answer);
	}
	
	static int[] dijkstra(int start, ArrayList<City>[] list) {
		boolean[] isVisited = new boolean[N + 1];
		int[] time = new int[N + 1];
		Arrays.fill(time, Integer.MAX_VALUE);
		
		PriorityQueue<City> q = new PriorityQueue<>();
		
		q.add(new City(start, 0));
		time[start] = 0;
		
		while(!q.isEmpty()) {
			City now = q.poll();
			if(isVisited[now.index]) continue;
			
			isVisited[now.index]= true;
			for(City next : list[now.index]) {
				if(time[next.index] > now.time + next.time) time[next.index] = now.time + next.time;
				q.add(new City(next.index, time[next.index]));
			}
		}
		return time;
	}
}
