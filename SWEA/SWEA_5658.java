import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			String s = br.readLine();
			char[] c = s.toCharArray();
			
			HashSet<String> set = new HashSet<>();

			for(int i = 0; i < N; i++) { // 회전 횟수
				char temp = c[0];
				for(int j = 1; j < N; j++) {
					char temp2 = c[j];
					c[j] = temp;
					temp = temp2;
				}
				c[0] = temp;
				
				// 4개로 분리
				int a = N / 4;
				for(int j = 0; j < N; j += a) {
					s = "";
					for(int k = j; k < j + a; k++) {
						s += c[k];
					}
					set.add(s);
				}
			}
			List<String> list = new ArrayList<>(set);
			Collections.sort(list, Collections.reverseOrder());

			
			System.out.println("#" + t + " " + Integer.parseInt(list.get(K - 1), 16));
		}
	}

}
