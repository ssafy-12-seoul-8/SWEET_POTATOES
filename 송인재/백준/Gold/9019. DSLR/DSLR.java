import java.io.*;
import java.util.*;

public class Main {

  static class Command {
    int number;
    String commandLine;

    Command(int number, String commandLine) {
      this.number = number;
      this.commandLine = commandLine;
    }
  }

  static Queue<Command> queue = new LinkedList<>();
  static Set<Integer> visited = new HashSet<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());

    for (int t = 1; t <= cases; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      Command result = bfs(a, b);

      System.out.println(result.commandLine);
    }
  }

  static Command bfs(int a, int b) {
    Command init = new Command(a, "");

    queue.clear();
    visited.clear();
    queue.add(init);
    visited.add(a);

    while (!queue.isEmpty()) {
      Command current = queue.poll();

      for (int i = 0; i < 4; i++) {
        Command next = command(i, current);

        if (visited.contains(next.number)) {
          continue;
        }

        visited.add(next.number);

        if (next.number == b) {
          return next;
        }

        queue.add(next);
      }
    }

    return init;
  }

  static Command command(int i, Command command) {
    Command toBeReturned = new Command(command.number, command.commandLine);

    switch (i) {
      case 0:
        toBeReturned.commandLine += "D";
        toBeReturned.number = d(toBeReturned.number);
        break;
      case 1:
        toBeReturned.commandLine += "S";
        toBeReturned.number = s(toBeReturned.number);
        break;
      case 2:
        toBeReturned.commandLine += "L";
        toBeReturned.number = l(toBeReturned.number);
        break;
      default:
        toBeReturned.commandLine += "R";
        toBeReturned.number = r(command.number);
    }

    return toBeReturned;
  }

  static int d(int num) {
    return 2 * num % 10_000;
  }

  static int s(int num) {
    return (num - 1 + 10_000) % 10_000;
  }

  static int l(int num) {
    int first = num / 1_000;

    num *= 10;
    num += first;

    return num % 10_000;
  }

  static int r(int num) {
    int last = num % 10;

    num /= 10;
    num += last * 1_000;

    return num;
  }

}
