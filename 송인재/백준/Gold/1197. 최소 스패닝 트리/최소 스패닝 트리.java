import java.util.*;
import java.io.*;

public class Main {
  
  static class Edge {
    int from;
    int to;
    int weight;
    
    Edge(int from, int to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }
  }
  
  static int[] rep;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int v = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());
    Queue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
    rep = new int[v + 1];
    int totalWeight = 0;
    
    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      Edge edge = new Edge(from, to, weight);
      
      pq.add(edge);
    }
    
    for (int i = 1; i <= v; i++) {
      rep[i] = i;
    }
    
    while (!pq.isEmpty()) {
      Edge edge = pq.poll();
      int repFrom = find(edge.from);
      int repTo = find(edge.to);
      
      if (repFrom == repTo) {
        continue;
      }
      
      union(repFrom, repTo);
      
      totalWeight += edge.weight;
    }
    
    System.out.println(totalWeight);
  }
  
  static int find(int x) {
    if (rep[x] != x) {
      rep[x] = find(rep[x]);
    }
    
    return rep[x];
  }
  
  static void union(int x, int y) {
    int repX = find(x);
    int repY = find(y);
    
    if (repX < repY) {
      rep[repY] = repX;
      
      return;
    }
    
    rep[repX] = repY;
  }
}