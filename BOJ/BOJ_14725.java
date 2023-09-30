import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_14725 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// TreeMap을 이용한 자동정렬
		TreeMap<String, TreeMap> map = new TreeMap<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			
			TreeMap now = map; // 루트부터 시작
			for(int j = 0; j < K; j++) {
				String s = st.nextToken();
				if(now.get(s) == null) { // 트리에 없으면 생성
					now.put(s, new TreeMap<>());
				}
				now = (TreeMap) now.get(s); // 자식으로 넣어줘야 하므로 now 변경
			}
		}
		
		print(map, 0);
		System.out.println(sb);
		
	}

	private static void print(TreeMap<String, TreeMap> map, int n) {
		for(String s : map.keySet()) {
			for(int i = 0; i < n; i++) sb.append("--");
			sb.append(s);
			sb.append("\n");
			print((TreeMap)map.get(s), n + 1);
			
		}
	}
}
