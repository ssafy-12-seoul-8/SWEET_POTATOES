import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(obj -> obj[1]));
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        long max = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < n + 1; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < n + 1; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u)
                .add(v);
            graph.get(v)
                .add(u);
        }

        pq.add(new int[] { r, a[r] });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int energy = current[1];
            
            if (max < energy) {
                break;
            }

            if (visited[currentNode]) {
                continue;
            }

            max += b[currentNode];
            visited[currentNode] = true;

            if (!graph.containsKey(currentNode)) {
                continue;
            }

            for (int next : graph.get(currentNode)) {
                if (visited[next]) {
                    continue;
                }
                
                pq.add(new int[] { next, a[next] });
            }
        }

        System.out.println(max);
    }

}

/*
시간 복잡도
- N = 500,000
- 완전탐색 시 500k * 500k = 250b -> 2500초
- O(N log N) / O(N) 고려 필요

접근
- 그래프 저장
- 그래프 별 간선으로 이어진 노드들을 정복 가능한 것부터 보장하게 정렬 -> O(N log N)
- BFS
- 그래프 별이 아닌 나아가면서 정복할 수 있는 노드를 우선순위로 정렬 필요 -> PQ (node 번호, a)
- 그래프 간선 여부 확인은 visited, max 처리 이후여야 함
*/