import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int to;
		int weight;
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
			return o1.weight - o2.weight;
		});
		
		ArrayList<Node>[] list = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++) list[i] = new ArrayList<>();

		int from, to, weight;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, weight));
			list[to].add(new Node(from, weight));
		}
		
		boolean[] visited = new boolean[N + 1];
		int answer = 0;
		pq.add(new Node(1, 0));
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			from = node.to;
			if(visited[from]) continue;
			visited[from] = true;
			weight = node.weight;
			answer += weight;
			for(int i = 0; i < list[from].size(); i++) {
				to = list[from].get(i).to;
				weight = list[from].get(i).weight;
				pq.add(new Node(to, weight));
			}
		}
		System.out.println(answer);
	}
}
