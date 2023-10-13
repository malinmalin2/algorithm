import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Person {
		int rTime; // 예약
		int aTime; // 도착
		public Person(int rTime, int aTime) {
			this.rTime = rTime;
			this.aTime = aTime;
		}
		@Override
		public String toString() {
			return "Person [rTime=" + rTime + ", aTime=" + aTime + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Person> people = new ArrayList<>();
		ArrayList<Person> origin = new ArrayList<>();
		int[] time = new int[200001]; // time 배열
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int rTime = Integer.parseInt(st.nextToken());
			int aTime = Integer.parseInt(st.nextToken());
			Person person = new Person(rTime, aTime);
			people.add(person);
			origin.add(person);
		}
		
		Collections.sort(origin, (o1, o2) -> {
			if(o1.aTime == o2.aTime) return o1.rTime - o2.rTime;
			return o1.aTime - o2.aTime; // 도착순 정렬
		});
		Collections.sort(people, (o1, o2) -> {
			if(o1.aTime == o2.aTime) return o1.rTime - o2.rTime;
			return o1.aTime - o2.aTime; // 도착순 정렬
		});
		for(int i = 0; i < N; i++) time[origin.get(i).rTime] = i; // 예약시간 손님 인덱스 저장
		
		int now = people.get(0).aTime; // 현재 시각
		int answer = Integer.MIN_VALUE;

		Queue<Integer> q = new LinkedList<>(); // 가능한 손님
		while(people.size() > 0) {
			
			boolean flag = true;
			int selectedIndex = 0;
			// 현재 시간에 예약한 사람이 있고, 제때 도착했으면 큐에 넣음
			if(now < 200001) { 
				if(time[now] > 0 && origin.get(time[now]).aTime <= now) q.add(time[now]); // 가능한 사람의 인덱스가 들어감.
			}
			if(!q.isEmpty()) {
				int temp = q.poll();
				Person p = origin.get(temp);
				int test = people.indexOf(p);
				if(test != -1) {
					selectedIndex = test;
					flag = false;
				}
			}
			if(people.get(0).aTime > now) {
				now = people.get(0).aTime;
				continue;
			}
			if(flag) selectedIndex = 0;
			
			answer = Math.max(answer, now - people.get(selectedIndex).aTime);
			people.remove(selectedIndex);
			now++;
		}
		System.out.println(answer);
	}
}
