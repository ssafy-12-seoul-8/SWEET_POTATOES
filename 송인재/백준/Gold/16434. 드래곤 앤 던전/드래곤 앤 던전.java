import java.util.*;
import java.io.*;

public class Main {

  static class Hero {

    long attack;
    long maxHp;
    long currHp;

    Hero(int attack) {
      this.attack = attack;
    }

    void startWith(int attack, long maxHp) {
      this.attack = attack;
      this.maxHp = maxHp;
      this.currHp = maxHp;
    }

  }

  static int n, attack;
  static int[][] rooms;
  static Hero hero;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    attack = Integer.parseInt(st.nextToken());
    rooms = new int[n][3];
    hero = new Hero(attack);
    long left = 1;
    long right = Long.MAX_VALUE - 1;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      rooms[i][0] = Integer.parseInt(st.nextToken());
      rooms[i][1] = Integer.parseInt(st.nextToken());
      rooms[i][2] = Integer.parseInt(st.nextToken());
    }

    while (left <= right) {
      long mid = (left + right) / 2;

      if (isPossible(mid)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    System.out.println(left);
  }

  static boolean isPossible(long maxHp) {
    hero.startWith(attack, maxHp);

    for (int i = 0; i < n; i++) {
      int[] atRoom = rooms[i];

      if (atRoom[0] == 1) {
        int monsterAttack = atRoom[1];
        int monsterHp = atRoom[2];
        long division = monsterHp / hero.attack;
        
        if (monsterHp % hero.attack == 0) {
          division--;
        }

        hero.currHp -= monsterAttack * division;

        if (hero.currHp <= 0) {
          return false;
        }
      } else {
        int attackIncrease = atRoom[1];
        int hpIncrease = atRoom[2];
        hero.attack += attackIncrease;
        hero.currHp = Math.min(hero.currHp + hpIncrease, maxHp);
      }
    }

    return true;
  }

}