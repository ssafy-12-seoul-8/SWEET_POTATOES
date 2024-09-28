import java.io.*;
import java.util.*;

public class Main {

  static class Rock {
    int y;
    int x;

    Rock(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

  static int n, t;
  static int[] distance;
  static List<Rock> rocks;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());
    rocks = new ArrayList<>();
    distance = new int[n + 1];

    rocks.add(new Rock(0, 0));

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      rocks.add(new Rock(y, x));
    }

    rocks.sort((r1, r2) -> {
      if (r1.y == r2.y) {
        return r1.x - r2.x;
      }

      return r1.y - r2.y;
    });

    System.out.println(bfs());
  }

  static int bfs() {
    Queue<Integer> queue = new LinkedList<>();

    queue.add(0);

    while (!queue.isEmpty()) {
      int index = queue.poll();

      Rock current = rocks.get(index);

      if (current.y == t) {
        return distance[index];
      }

      updateUpper(index, current, queue);
      updateLower(index, current, queue);
    }

    return -1;
  }

  static void updateUpper(int index, Rock current, Queue<Integer> queue) {
    for (int i = index + 1; i < n + 1; i++) {
      if (distance[i] != 0) {
        continue;
      }

      Rock next = rocks.get(i);

      if (next.y - current.y > 2) {
        return;
      }

      if (Math.abs(next.x - current.x) > 2) {
        continue;
      }

      distance[i] = distance[index] + 1;

      queue.add(i);
    }
  }

  static void updateLower(int index, Rock current, Queue<Integer> queue) {
    for (int i = index - 1; i >= 0; i--) {
      if (distance[i] != 0) {
        continue;
      }

      Rock prev = rocks.get(i);

      if (current.y - prev.y > 2) {
        return;
      }

      if (Math.abs(current.x - prev.x) > 2) {
        continue;
      }

      distance[i] = distance[index] + 1;

      queue.add(i);
    }
  }

}
