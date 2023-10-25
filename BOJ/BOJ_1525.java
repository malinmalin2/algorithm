import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    
    static class Info {
        int cnt;
        String mapString;
		public Info(int cnt, String mapString) {
			this.cnt = cnt;
			this.mapString = mapString;
		}
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String map = "";
        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                map += Integer.parseInt(st.nextToken());
            }
        }
        
        String dest = "123456780";
		if(map.equals(dest)) {
			System.out.println(0);
			return;
		}
		
    	Queue<Info> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.add(new Info(0, map));
        set.add(map);
        
        int cnt, y, x, newY, newX, zero, idx;
        char ch;
        String newMap;
        
        while(!q.isEmpty()) {
            Info info = q.poll();
            cnt = info.cnt;
            map = info.mapString;
            zero = map.indexOf('0');
            y = zero / 3;
            x = zero % 3;
            
            for(int d = 0; d < 4; d++) {
            	newY = y + dy[d];
            	newX = x + dx[d];
            	if(newY >= 0 && newY < 3 && newX >= 0 && newX < 3) {
            		idx = newY * 3 + newX;
            		ch = map.charAt(idx);
            		newMap = map.replace(ch, 't');
            		newMap = newMap.replace('0', ch);
            		newMap = newMap.replace('t', '0');
            		if(newMap.equals(dest)) {
            			System.out.println(cnt + 1);
            			return;
            		}
            		if(set.contains(newMap)) continue;
            		set.add(newMap);
            		q.add(new Info(cnt + 1, newMap));
            	}
            }
        }
        System.out.println("-1");
    }
}
