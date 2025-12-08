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
    
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    rep = new int[n + 1];
    List<Edge> edges = new ArrayList<>();
    int[][] stars = new int[n][4];
    
    for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        stars[i][0] = i;
        stars[i][1] = Integer.parseInt(st.nextToken());
        stars[i][2] = Integer.parseInt(st.nextToken());
        stars[i][3] = Integer.parseInt(st.nextToken());
        rep[i + 1] = i + 1;
    }
    
    for (int i = 1; i <= 3; i++) {
        final int dimension = i;
        
        Arrays.sort(stars, Comparator.comparingInt(s -> s[dimension]));
        
        for (int j = 1; j < n; j++) {
            int weight = Math.abs(stars[j - 1][i] - stars[j][i]);
            
            edges.add(new Edge(stars[j - 1][0], stars[j][0], weight));
        }
    }
    
    edges.sort(Comparator.comparingInt(e -> e.weight));
    
    int count = 0;
    int totalWeight = 0;
    
    for (int i = 0; i < edges.size(); i++) {
        Edge edge = edges.get(i);
        
        if (union(edge.from, edge.to)) {
            totalWeight += edge.weight;
            count++;
        }
        
        if (count == n) {
            break;
        }
    }
    
    System.out.println(totalWeight);
  }
  
  static int find(int x) {
      if (rep[x] != x) {
          rep[x] = find(rep[x]);
      }
      
      return rep[x];
  }
  
  static boolean union(int x, int y) {
      int repX = find(x);
      int repY = find(y);
      
      if (repX == repY) {
          return false;
      }
      
      rep[repY] = repX;
      
      return true;
  }
}