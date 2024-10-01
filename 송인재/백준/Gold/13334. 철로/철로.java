import java.io.*;
import java.util.*;

public class Main {
	
	static class Route {
		int prior;
		int later;
		
		Route(int home, int office) {
			if (home <= office) {
				this.prior = home;
				this.later = office;
			} else {
				this.prior = office;
				this.later = home;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Route[] routes = new Route[n];
		Queue<Integer> pq = new PriorityQueue<>();
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int home = Integer.parseInt(st.nextToken());
			int office = Integer.parseInt(st.nextToken());
			routes[i] = new Route(home, office);
		}
		
		Arrays.sort(routes, (r1, r2) -> {
			if (r1.later == r2.later) {
				return r1.prior - r2.prior;
			}
			
			return r1.later - r2.later;
		});
		
		int d = Integer.parseInt(br.readLine());
		
		for (Route route : routes) {
			while (!pq.isEmpty() && route.later - d > pq.peek()) {
				pq.poll();
			}
			
			if (route.later - d <= route.prior) {
				pq.add(route.prior);
			}
			
			max = Math.max(max, pq.size());
		}
		
		System.out.println(max);
	}
	
}