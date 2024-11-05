
import java.util.*;
import java.io.*;

public class Main {
	
    static int N, M, K;
    static int[] parent;
    static int[] size;
    static List<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];	// 조상 번호
        size = new int[N + 1];		// 우리팀 수
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
        	// 자기 자신의 값 할당 (유니온파인드 초기 작업)
            parent[i] = i;
            size[i] = 1;
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());	// i 번째 u 값
            int v = Integer.parseInt(st.nextToken());	// i 번째 v 값
            adj[u].add(v);
            adj[v].add(u);

            if (i == K) continue;	// K번째는 연결X
            union(u, v);	// u랑 v랑 연결해버림
        }
        
        // 입력 끝
        
        // 두 유니온의 크기 구하기
        int teamA = 0;
        int teamB = 0;
        for (int i = 1; i <= N; i++) {
        	// i번째 노드의 조상을 찾으러 감
            int root = find(i);
            if (!visited[root]) {
                visited[root] = true;
                // A팀의 값이 0이면 A팀 사이즈를 갱신하고
                if (teamA == 0) teamA = size[root];
                // A팀 사이즈가 있으면 B팀 사이즈를 갱신
                else teamB = size[root];
            }
        }

        // 최단 거리 합 계산
        long result = (long) teamA * teamB;
        System.out.println(result);
    }

    // 최고조상찾기
    static int find(int x) {
    	// 자기 자신 값이 아니면
        if (parent[x] != x) {
        	// 내 조상 값을 찾으러 감
            parent[x] = find(parent[x]); // 경로 압축
        }
        return parent[x];
    }

    // 조상 합치기
    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
        	// 작은 조상을 큰 조상 아래에 합침
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }
}
