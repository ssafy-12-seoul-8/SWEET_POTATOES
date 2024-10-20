import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int T = sc.nextInt();
		
		List<Integer> initMembers = new ArrayList<>();
		for (int i = 0; i < T; i++)
			initMembers.add(sc.nextInt());
		
		List<HashSet<Integer>> parties = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			int size = sc.nextInt();
			
			HashSet<Integer> party = new HashSet<>();
			for (int j = 0; j < size; j++)
				party.add(sc.nextInt());
			
			parties.add(party);
		}
		
		Queue<Integer> bfs = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		for (int member : initMembers) {
			bfs.add(member);
			visited[member] = true;
		}
		
		while (!bfs.isEmpty()) {
			int dangerMember = bfs.poll();
			
			for (HashSet<Integer> party : parties) {
				if (party.contains(dangerMember)) {
					
					for (int member : party) {
						if (!visited[member]) {
							bfs.add(member);
							visited[member] = true;
						}
					}
				}
			}
		}
		
		int cnt = 0;
		check:
		for (HashSet<Integer> party : parties) {
			for (int member : party)
				if (visited[member]) continue check;
			
			cnt++;
		}
		
		System.out.println(cnt);
	}
}