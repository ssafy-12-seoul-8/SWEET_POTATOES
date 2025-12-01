import java.util.*;
import java.io.*;

public class Main {
    
  static class Point {
    int x;
    int y;
    
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  
  static int[] rep;
    
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Point[][] points = new Point[n + 1][2];
    rep = new int[n + 1];
    
    for (int i = 1; i <= n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ax = Integer.parseInt(st.nextToken());
        int ay = Integer.parseInt(st.nextToken());
        int bx = Integer.parseInt(st.nextToken());
        int by = Integer.parseInt(st.nextToken());
        points[i][0] = new Point(ax, ay);
        points[i][1] = new Point(bx, by);
        rep[i] = i;
    }
    
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (i == j || find(i) == find(j)) {
                continue;
            }
            
            if (isIntersect(points[i], points[j])) {
                union(i, j);
            }
        }
    }
    
    int groupCount = 0;
    int maxGroup = 0;
    int[] counts = new int[n + 1];
    
    for (int i = 1; i <= n; i++) {
        int thisRep = find(i);
        counts[thisRep]++;
    }
    
    for (int i = 1; i <= n; i++) {
        if (counts[i] != 0) {
            groupCount++;
            maxGroup = Math.max(maxGroup, counts[i]);
        }
    }
    
    System.out.println(groupCount);
    System.out.println(maxGroup);
  }
  
  static void union(int x, int y) {
      int repX = find(x);
      int repY = find(y);
      
      if (repX == repY) {
          return;
      }
      
      if (repY > repX) {
          rep[repY] = repX;
      } else {
          rep[repX] = repY;
      }
  }
  
  static int find(int x) {
      if (rep[x] != x) {
          rep[x] = find(rep[x]);
      }
      
      return rep[x];
  }
  
  static boolean isIntersect(Point[] ab, Point[] cd) {
      int abc = ccw(ab[0], ab[1], cd[0]);
      int abd = ccw(ab[0], ab[1], cd[1]);
      int cda = ccw(cd[0], cd[1], ab[0]);
      int cdb = ccw(cd[0], cd[1], ab[1]);
      
      if (isCollinear(abc, abd, cda, cdb)) {
          return isOverlapping(ab[0], ab[1], cd[0], cd[1]);
      }
      
      return abc * abd <= 0 && cda * cdb <= 0;
  }
  
  static int ccw(Point a, Point b, Point c) {
    int product = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    
    if (product > 0) {
        return 1;
    }
    
    if (product < 0) {
        return -1;
    }
    
    return 0;
  }
  
  static boolean isCollinear(int abc, int abd, int cda, int cdb) {
    return abc == 0 && abd == 0 && cda == 0 && cdb == 0;
  }
  
  static boolean isOverlapping(Point a, Point b, Point c, Point d) {
    return Math.max(a.x, b.x) >= Math.min(c.x, d.x)
        && Math.max(a.y, b.y) >= Math.min(c.y, d.y)
        && Math.max(c.x, d.x) >= Math.min(a.x, b.x)
        && Math.max(c.y, d.y) >= Math.min(a.y, b.y);
  }
}