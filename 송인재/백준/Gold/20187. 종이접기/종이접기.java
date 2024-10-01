import java.io.*;
import java.util.*;

public class Main {

  static int[][] pattern = {
      { 0, 1, 2, 3 },
      { 1, 0, 3, 2 },
      { 2, 3, 0, 1 },
      { 3, 2, 1, 0 },
  };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    String lastRL = "";
    String lastUD = "";

    for (int i = 0; i < 2 * k; i++) {
      String direction = st.nextToken();

      if (direction.equals("U") || direction.equals("D")) {
        lastUD = direction;
      } else {
        lastRL = direction;
      }
    }

    int lastCommand = getLastCommand(lastUD);
    lastCommand += getLastCommand(lastRL);

    int penetration = Integer.parseInt(br.readLine());
    int[] paperPattern = pattern[lastCommand];
    int[] penetrationPattern = pattern[paperPattern[penetration]];
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < Math.pow(2, k); i++) {
      boolean isUpper = i % 2 == 0;

      for (int j = 0; j < Math.pow(2, k - 1); j++) {
        if (isUpper) {
          sb.append(penetrationPattern[0])
              .append(" ")
              .append(penetrationPattern[1])
              .append(" ");
        } else {
          sb.append(penetrationPattern[2])
              .append(" ")
              .append(penetrationPattern[3])
              .append(" ");
        }
      }

      sb.append("\n");
    }

    System.out.println(sb);
  }

  static int getLastCommand(String command) {
    switch (command) {
      case "R":
        return 1;
      case "D":
        return 2;
    }

    return 0;
  }

}
