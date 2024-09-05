import java.io.*;
import java.util.*;

public class Solution {
	
	static class Person {
		int x;
		int y;
		int distance1;
		int distance2;
		
		Person(int x, int y, int distance1, int distance2) {
			this.x = x;
			this.y = y;
			this.distance1 = distance1;
			this.distance2 = distance2;
		}
		
		int getDistance(Stair stair) {
			return stair.id == 1 ? distance1 : distance2;
		}
		
		void initDistance(Stair stair) {
			if (stair.id == 1) {
				distance1 = Math.abs(stair.x - this.x) + Math.abs(stair.y - this.y);
			} else {
				distance2 = Math.abs(stair.x - this.x) + Math.abs(stair.y - this.y);
			}
		}
		
		Person update(Stair stair) {
			if (stair.id == 1) {
				return new Person(x, y, distance1 - 1, 0);
			} else {
				return new Person(x, y, 0, distance2 - 1);
			}
		}
	}
	
	static class Stair {
		int id;
		int x;
		int y;
		int depth;
		Queue<Person> pq;
		Queue<Person> temp;
		
		Stair(int id, int x, int y, int depth) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.pq = new PriorityQueue<>((o1, o2) -> o1.getDistance(this) - o2.getDistance(this));
			this.temp = new LinkedList<>();
		}
		
		void addPerson(Person person) {
			pq.add(person);
		}
		
		int move() {
			int time = 0;
			
			while (!pq.isEmpty()) {
				int count = 0;
				int limit = pq.size();
				
				for (int i = 0; i < limit; i++) {
					Person person = pq.poll();
					int distance = person.getDistance(this);
					
					if (distance > 0) {
						temp.add(person.update(this));
					}
					
					if (distance == -depth) {
						continue;
					}
					
					if (distance <= 0) {
						if (distance == 0 && count == 3) {
							temp.add(person);
							
							continue;
						}
						
						count++;
						temp.add(person.update(this));
					}
				}
				
				while (!temp.isEmpty()) {
					pq.add(temp.poll());
				}
				
				time++;
			}
			
			return time;
		}
	}
	
	static int n, minTime;
	static boolean[] isOne;
	static List<Person> people = new ArrayList<>();
	static List<Stair> stairs = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			n = Integer.parseInt(br.readLine());
			minTime = Integer.MAX_VALUE;
			people.clear();
			stairs.clear();
			int stairId = 1;
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					int num = Integer.parseInt(st.nextToken());
					
					switch (num) {
					case 1:
						people.add(new Person(i, j, 0, 0));
						break;
					case 0:
						break;
					default:
						stairs.add(new Stair(stairId++, i, j, num));
					}
				}
			}
			
			putDistance();			
			combination(new boolean[people.size()], 0, 0);
			System.out.println("#" + t + " " + minTime);
		}
	}
	
	static void putDistance() {
		people.forEach(person -> stairs.forEach(stair -> person.initDistance(stair)));
	}
	
	static void combination(boolean[] isOne, int index, int selected) {
		complete(isOne);
		
		for (int i = index; i < people.size(); i++) {
			isOne[i] = true;
			
			combination(isOne, i + 1, selected + 1);
			
			isOne[i] = false;
		}
	}
	
	static void complete(boolean[] isOne) {
		for (int i = 0; i < isOne.length; i++) {
			int stairId = isOne[i] ? 0 : 1;
			
			stairs.get(stairId)
				.addPerson(people.get(i));
		}
		
		int max = 0;
		
		for (Stair stair : stairs) {
			max = Math.max(max, stair.move());
		}
		
		minTime = Math.min(minTime, max);
	}

}
