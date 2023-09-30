import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	static class MyMap {
		boolean flag;
		HashMap<Character, MyMap> map = new HashMap<>();
		
		MyMap(boolean flag, HashMap<Character, MyMap> map) {
			this.flag = flag;
			this.map = map;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			String answer = "YES";
			MyMap myMap = new MyMap(false, new HashMap<>());
			
			int N = Integer.parseInt(br.readLine());
			for(int n = 0; n < N; n++) {
				
				MyMap now = myMap;
				
				String s = br.readLine();
				char[] list = s.toCharArray();
				
				for(int i = 0; i < list.length; i++) {
					
					char c = list[i];
					
					if(now.map.get(c) == null) {
						// 마지막 원소일 경우 true로 표시
						if(i == list.length - 1) now.map.put(c, new MyMap(true, new HashMap<>()));
						else now.map.put(c, new MyMap(false, new HashMap<>()));
					}
					else {
						if(now.map.get(c).flag == true) {
							answer = "NO";
							break;
						}
						if(i == list.length - 1) {
							answer = "NO";
							break;
						}
					}
					
					now = now.map.get(c);
				}
			}
			System.out.println(answer);
		}
		
	}
}
