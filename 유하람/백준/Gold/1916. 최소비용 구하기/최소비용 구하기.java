import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 도시의 수
        int M = Integer.parseInt(br.readLine()); // 버스의 수

        List<int[]>[] adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            adjList[start].add(new int[]{end, price});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] degree = new int[N + 1];
        Arrays.fill(degree, Integer.MAX_VALUE);
        degree[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currCost = curr[1];

            if (degree[currNode] < currCost) continue;

            for (int[] next : adjList[currNode]) {
                int nextNode = next[0];
                int nextCost = currCost + next[1];

                if (nextCost < degree[nextNode]) {
                    degree[nextNode] = nextCost;
                    pq.add(new int[]{nextNode, nextCost});
                }
            }
        }

        System.out.println(degree[end]);
    }
}
