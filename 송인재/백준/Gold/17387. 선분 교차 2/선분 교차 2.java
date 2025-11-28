import java.io.*;
import java.util.*;

public class Main {

  static class Point {
    long x;
    long y;

    Point(long x, long y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Point[][] points = new Point[2][2];

    for (int i = 0; i < 2; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int j = 0; j < 2; j++) {
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());

        points[i][j] = new Point(x, y);
      }
    }

    System.out.println(isIntersect(points[0][0], points[0][1], points[1][0], points[1][1]));
  }

  static int isIntersect(Point a, Point b, Point c, Point d) {
    int abc = ccw(a, b, c);
    int abd = ccw(a, b, d);
    int cda = ccw(c, d, a);
    int cdb = ccw(c, d, b);

    if (isCollinear(abc, abd, cda, cdb)) {
      return isOverlapping(a, b, c, d) ? 1 : 0;
    }

    return abc * abd <= 0 && cda * cdb <= 0 ? 1 : 0;
  }

  static boolean isCollinear(int abc, int abd, int cda, int cdb) {
    return abc == 0 && abd == 0 && cda == 0 && cdb == 0;
  }

  static boolean isOverlapping(Point a, Point b, Point c, Point d) {
    return Math.max(a.x, b.x) >= Math.min(c.x, d.x) &&
        Math.max(c.x, d.x) >= Math.min(a.x, b.x) &&
        Math.max(a.y, b.y) >= Math.min(c.y, d.y) &&
        Math.max(c.y, d.y) >= Math.min(a.y, b.y);
  }

  static int ccw(Point a, Point b, Point c) {
    long product = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);

    if (product > 0) {
      return 1;
    }

    if (product < 0) {
      return -1;
    }

    return 0;
  }

}
