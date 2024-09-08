import java.util.*;
import java.io.*;

public class Main {

  static final char[] colors = { 'w', 'r', 'b', 'y', 'o', 'g' };
  static final char[][][] cube = new char[6][3][3];
  static final char[][] tempAxis = new char[3][3];
  static final char[] tempSide = new char[3];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());

    for (int t = 1; t <= cases; t++) {
      initCube();

      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int i = 0; i < n; i++) {
        String command = st.nextToken();
        char axis = command.charAt(0);
        int axisNum = decideAxis(axis);
        char direction = command.charAt(1);
        boolean isClock = direction == '+';

        rotateAxis(axisNum, isClock);
        rotateSides(axisNum);

        if (!isClock) {
          rotateSides(axisNum);
          rotateSides(axisNum);
        }
      }

      printUpside();
    }
  }

  static void initCube() {
    for (int i = 0; i < 6; i++) {
      char color = colors[i];

      for (int j = 0; j < 3; j++) {
        Arrays.fill(cube[i][j], color);
      }
    }
  }

  static int decideAxis(char axis) {
    switch (axis) {
      case 'U':
        return 0;
      case 'F':
        return 1;
      case 'R':
        return 2;
      case 'D':
        return 3;
      case 'B':
        return 4;
      default:
        return 5;
    }
  }

  static void rotateAxis(int axisNum, boolean isClock) {
    rotateClock(axisNum);

    if (!isClock) {
      rotateClock(axisNum);
      rotateClock(axisNum);
    }
  }

  static void rotateClock(int axisNum) {
    for (int i = 0; i < 3; i++) {
      System.arraycopy(cube[axisNum][i], 0, tempAxis[i], 0, 3);
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        cube[axisNum][j][2 - i] = tempAxis[i][j];
      }
    }
  }

  static void rotateSides(int axisNum) {
    switch (axisNum) {
      case 0:
        for (int i = 0; i < 3; i++) {
          tempSide[i] = cube[1][0][i];
          cube[1][0][i] = cube[2][0][i];
          cube[2][0][i] = cube[4][0][i];
          cube[4][0][i] = cube[5][0][i];
          cube[5][0][i] = tempSide[i];
        }
        break;
      case 1:
        for (int i = 0; i < 3; i++) {
          tempSide[i] = cube[5][i][2];
          cube[5][i][2] = cube[3][2][2 - i];
          cube[3][2][2 - i] = cube[2][2 - i][0];
          cube[2][2 - i][0] = cube[0][2][2 - i];
          cube[0][2][2 - i] = tempSide[i];
        }
        break;
      case 2:
        for (int i = 0; i < 3; i++) {
          tempSide[i] = cube[1][i][2];
          cube[1][i][2] = cube[3][2 - i][0];
          cube[3][2 - i][0] = cube[4][2 - i][0];
          cube[4][2 - i][0] = cube[0][i][2];
          cube[0][i][2] = tempSide[i];
        }
        break;
      case 3:
        for (int i = 0; i < 3; i++) {
          tempSide[i] = cube[2][2][i];
          cube[2][2][i] = cube[1][2][i];
          cube[1][2][i] = cube[5][2][i];
          cube[5][2][i] = cube[4][2][i];
          cube[4][2][i] = tempSide[i];
        }
        break;
      case 4:
        for (int i = 0; i < 3; i++) {
          tempSide[i] = cube[2][i][2];
          cube[2][i][2] = cube[3][0][i];
          cube[3][0][i] = cube[5][2 - i][0];
          cube[5][2 - i][0] = cube[0][0][i];
          cube[0][0][i] = tempSide[i];
        }
        break;
      case 5:
        for (int i = 0; i < 3; i++) {
          tempSide[i] = cube[4][i][2];
          cube[4][i][2] = cube[3][i][2];
          cube[3][i][2] = cube[1][2 - i][0];
          cube[1][2 - i][0] = cube[0][2 - i][0];
          cube[0][2 - i][0] = tempSide[i];
        }
        break;
      default:
        break;
    }
  }

  static void printUpside() {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        sb.append(cube[0][i][j]);
      }

      if (i < 2) {
        sb.append("\n");
      }
    }

    System.out.println(sb);
  }

}