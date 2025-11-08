import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    Deque<Character> stack = new ArrayDeque<>();
    Map<Character, Integer> opsDegree = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    opsDegree.put('*', 2);
    opsDegree.put('/', 2);
    opsDegree.put('+', 1);
    opsDegree.put('-', 1);
    opsDegree.put('(', 0);
    opsDegree.put(')', 0);

    for (int i = 0; i < line.length(); i++) {
      char next = line.charAt(i);

      if (!opsDegree.containsKey(next)) {
        sb.append(next);

        continue;
      }

      if (next == '(' || stack.isEmpty() || opsDegree.get(next) > opsDegree.get(stack.peek())) {
        stack.push(next);

        continue;
      }

      while (!stack.isEmpty() && opsDegree.get(next) <= opsDegree.get(stack.peek())) {
        if (next == ')' && stack.peek() == '(') {
          stack.pop();

          break;
        }

        sb.append(stack.pop());
      }

      if (opsDegree.get(next) != 0) {
        stack.push(next);
      }
    }

    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    System.out.println(sb);
  }

}
