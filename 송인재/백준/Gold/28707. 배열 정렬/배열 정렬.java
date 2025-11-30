import java.io.*;
import java.util.*;

public class Main {

  static class State {
    String state;
    int cost;

    State(String state, int cost) {
      this.state = state;
      this.cost = cost;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] start = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    String startState = "";
    String endState = "";
    Map<String, Integer> dist = new HashMap<>();
    Queue<State> pq = new PriorityQueue<>(Comparator.comparingInt(state -> state.cost));

    for (int i = 0; i < n; i++) {
      start[i] = Integer.parseInt(st.nextToken()) - 1;
      startState += start[i];
    }

    int m = Integer.parseInt(br.readLine());
    int[][] swaps = new int[m][3];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      swaps[i][0] = Integer.parseInt(st.nextToken()) - 1;
      swaps[i][1] = Integer.parseInt(st.nextToken()) - 1;
      swaps[i][2] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(start);

    for (int i = 0; i < n; i++) {
      endState += start[i];
    }

    dist.put(startState, 0);
    pq.add(new State(startState, 0));

    while (!pq.isEmpty()) {
      State current = pq.poll();

      if (dist.get(current.state) < current.cost) {
        continue;
      }

      for (int i = 0; i < m; i++) {
        int[] swapOrder = swaps[i];
        String nextState = swap(current.state, swapOrder[0], swapOrder[1]);
        int nextCost = current.cost + swapOrder[2];

        if (dist.containsKey(nextState) && dist.get(nextState) <= nextCost) {
          continue;
        }

        dist.put(nextState, nextCost);
        pq.add(new State(nextState, nextCost));
      }
    }

    System.out.println(dist.getOrDefault(endState, -1));
  }

  static String swap(String value, int a, int b) {
    return value.substring(0, a) + value.charAt(b) + value.substring(a + 1, b) + value.charAt(a) + value.substring(b + 1);
  }

}
