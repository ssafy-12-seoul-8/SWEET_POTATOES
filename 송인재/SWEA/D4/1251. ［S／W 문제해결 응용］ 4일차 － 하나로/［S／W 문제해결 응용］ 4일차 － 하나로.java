import java.io.*;
import java.util.*;

public class Solution {
	
	static class Island {
		int id;
		int x;
		int y;
		
		Island(int id, int x, int y) {
			this.id = id;
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object other) {
			return this.id == ((Island) other).id;
		}
	}
	
	static class Edge {
		Island dep;
		Island dest;
		double fine;
		
		Edge(Island dep, Island dest) {
			this.dep = dep;
			this.dest = dest;
			long xDiff = Math.abs(dep.x - dest.x);
			long yDiff = Math.abs(dep.y - dest.y);
			long distanceSq = xDiff * xDiff + yDiff * yDiff;
			fine = distanceSq * e;
		}
	}
	
	static int n;
	static Island[] rep;
	static double e;
	static Queue<Edge> tunnels;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			n = Integer.parseInt(br.readLine());
			rep = new Island[n];
			tunnels = new PriorityQueue<>((o1, o2) -> Double.compare(o1.fine, o2.fine));
			
			StringTokenizer xs = new StringTokenizer(br.readLine());
			StringTokenizer ys = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				int x = Integer.parseInt(xs.nextToken());
				int y = Integer.parseInt(ys.nextToken());
				Island coordinate = new Island(i, x, y);
				rep[i] = coordinate;
			}
			
			e = Double.parseDouble(br.readLine());
			
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					tunnels.add(new Edge(rep[i], rep[j]));
				}
			}
			
			int count = 0;
			double min = 0;
			
			while (!tunnels.isEmpty() && count < n - 1) {
				Edge tunnel = tunnels.poll();
				Island depRep = findSet(tunnel.dep);
				Island destRep = findSet(tunnel.dest);
				
				if (depRep == destRep) {
					continue;
				}
				
				rep[destRep.id] = depRep;
				count++;
				min += tunnel.fine;
			}
			
			System.out.println("#" + t + " " + Math.round(min));
		}
	}
	
	static Island findSet(Island x) {
		if (rep[x.id] != x) {
			rep[x.id] = findSet(rep[x.id]);
		}
		
		return rep[x.id];
	}
	
	static void union(Island x, Island y) {
		rep[findSet(y).id] = findSet(x);
	}

}
