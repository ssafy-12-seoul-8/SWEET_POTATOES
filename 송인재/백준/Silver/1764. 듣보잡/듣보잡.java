import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    Set<String> noHear = new HashSet<>();
    SortedSet<String> db = new TreeSet<>();

    for (int i = 0; i < n; i++) {
      String notHeard = br.readLine();

      noHear.add(notHeard);
    }

    for (int j = 0; j < m; j++) {
      String notSeen = br.readLine();

      if (noHear.contains(notSeen)) {
        db.add(notSeen);
      }
    }

    System.out.println(db.size());

    while (!db.isEmpty()) {
      System.out.println(db.first());
      db.remove(db.first());
    }
  }

}
