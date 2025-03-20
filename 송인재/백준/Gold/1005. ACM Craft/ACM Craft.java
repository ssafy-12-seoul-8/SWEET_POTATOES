import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int t = 0; t < cases; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] times = new int[n + 1];
            int[] maxTime = new int[n + 1];
            int[] enterCount = new int[n + 1];
            Map<Integer, List<Integer>> graph = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                int time = Integer.parseInt(st.nextToken());
                times[i] = time;
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                enterCount[to]++;

                graph.putIfAbsent(from, new ArrayList<>());
                graph.get(from)
                        .add(to);
            }

            int w = Integer.parseInt(br.readLine());

            for (int i = 1; i <= n; i++) {
                if (enterCount[i] == 0) {
                    queue.add(i);
                }
            }

            while (!queue.isEmpty()) {
                int current = queue.poll();

                if (current == w && enterCount[current] == 0) {
                    break;
                }

                if (!graph.containsKey(current)) {
                    continue;
                }

                for (int next : graph.get(current)) {
                    enterCount[next]--;
                    maxTime[next] = Math.max(maxTime[next], times[current]);

                    if (enterCount[next] == 0) {
                        queue.add(next);
                        times[next] += maxTime[next];
                    }
                }
            }

            System.out.println(times[w]);
        }
    }

}
