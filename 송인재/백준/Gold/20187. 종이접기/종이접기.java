import java.io.*;

public class Main {

  static int[][] pattern = {
      { 0, 1, 2, 3 },
      { 1, 0, 3, 2 },
      { 2, 3, 0, 1 },
      { 3, 2, 1, 0 },
  };
  static int lastCommand;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(br.readLine());
    String command = br.readLine();
    int penetration = Integer.parseInt(br.readLine());

    getLastCommand(command.charAt(command.length() - 3));
    getLastCommand(command.charAt(command.length() - 1));

    int[] holePattern = pattern[lastCommand];
    int[] paperHole = pattern[holePattern[penetration]];
    int rowNum = (int) Math.pow(2, k);
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < rowNum; i++) {
      int index = i % 2 == 0 ? 0 : 2;

      for (int j = 0; j < rowNum; j++) {
        sb.append(paperHole[index++])
            .append(" ");

        if (index == 2 || index == 4) {
          index -= 2;
        }
      }

      sb.append("\n");
    }

    sb.deleteCharAt(sb.length() - 1);
    System.out.println(sb);
  }

  static void getLastCommand(char command) {
    switch (command) {
      case 'R':
        lastCommand += 1;
        break;
      case 'D':
        lastCommand += 2;
    }
  }

}
