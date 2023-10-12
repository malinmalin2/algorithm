import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Position {
		int x;
		int y;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int n, k;
	static Position[] posList;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		posList = new Position[n + 1];
		posList[0] = new Position(0, 0);
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			posList[i] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		// 원점 거리 기준 오름차순 정렬
		Arrays.sort(posList, (o1, o2) -> {
			double a = getDistance(new Position(0, 0), o1);
			double b = getDistance(new Position(0, 0), o2);
			if(a < b) return -1;
			else if (a > b) return 1;
			else return 0;
		});
		
		// 이분탐색으로 연로통 용량을 찾음
		int left = 0;
		int right = 14143;
		int mid;
		int answer = 0;
		double dist;
		
		while(left <= right) {
			isVisited = new boolean[1001];
			mid = (left + right) / 2;
			dist = mid * 10; // mid 용량으로 가능한 거리
 			if(bfs(dist)) left = mid + 1; // 불가능하므로 용량 늘림
 			else { // 가능하므로 더 적은 용량 시도
 				right = mid-1;
 				answer = mid;
 			}
		}
		System.out.println(answer);
	}
	
	private static boolean bfs(double dist) {
		LinkedList<Integer> q = new LinkedList<>();
 		q.add(0); // 원점부터 시작
 		int cnt = 0;
 		int size = 0;
 		while(!q.isEmpty()) {
 			if(cnt > k) return true; // k번을 초과해서 급유하였음
 			size = q.size();
 			for(int i = 0; i < size; i++) {
 				int num = q.poll();
 				if(!isVisited[num]) {
 					isVisited[num] = true;
 					for(int j = 1; j <= n; j++) {
 						if(num == j) continue;
 						if(getDistance(posList[j], posList[num]) <= dist) { // 가능한 경우
 							if(getDistance(new Position(10000, 10000), posList[j]) <= dist) return false; // 도착지와 비교. 가능하면 바로 return
 							q.add(j); // 도착지까지 불가능하면 다른 곳에 더 들러보자
 						}
 					}
 				}
 			}
 			cnt++;
 		}
 		return true;
	}

	static double getDistance(Position a, Position b) {
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
	}
}
