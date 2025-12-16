import java.io.*;
import java.util.*;

public class Main {

  static class Order {
    int number;
    int time;
    int table;

    Order(int number, int time, int table) {
      this.number = number;
      this.time = time;
      this.table = table;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    Queue<Order> orderPq = new PriorityQueue<>((o1, o2) -> {
      if (o1.time == o2.time) {
        return o2.table - o1.table;
      }

      return o1.time - o2.time;
    });
    Queue<Integer> tablePq = new PriorityQueue<>();
    long total = 0;
    long r = 1;
    int lastMin = 0;

    for (int i = 1; i <= k; i++) {
      tablePq.add(i);
    }

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int number = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());

      if (!tablePq.isEmpty()) {
        orderPq.add(new Order(number, time + lastMin, tablePq.poll()));

        continue;
      }

      Order current = orderPq.poll();
      total += current.number * r++;

      tablePq.add(current.table);

      while (!orderPq.isEmpty() && orderPq.peek().time == current.time) {
        Order same = orderPq.poll();
        total += same.number * r++;

        tablePq.add(same.table);
      }

      orderPq.add(new Order(number, time + current.time, tablePq.poll()));

      lastMin = current.time;
    }

    while (!orderPq.isEmpty()) {
      total += orderPq.poll().number * r++;
    }

    System.out.println(total);
  }

}
