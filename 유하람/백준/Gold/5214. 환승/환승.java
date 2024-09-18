import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st1.nextToken());	// 역의 수
		int K = Integer.parseInt(st1.nextToken());	// 하이퍼튜브가 서로 연결하는 역의 개수
		int M = Integer.parseInt(st1.nextToken());	// 하이퍼튜브의 개수
		
		
		// 각 역에 포함된 하이퍼 튜브(배열)의 리스트
		List<int[]>[] adjList = new LinkedList[N+1];
		
		for(int i=1 ; i<=N ; i++) {
			adjList[i] = new LinkedList();
		}
		
		for(int i=0 ; i<M ; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int[] tube = new int[K];
			for(int j=0 ; j<K ; j++) {
				tube[j] = Integer.parseInt(st2.nextToken());
			}
			for(int k : tube) {
				adjList[k].add(tube);
			}
		}
		
		
		int[] arr = new int[N+1];	// 1번 역부터 각 역까지 가는데 방문하는 역의 개수
		Arrays.fill(arr, -1);		// 자기자신, 1
		
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(1);
		visited[1] = true;
		arr[1] = 1;
		
		out : while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(int[] tube : adjList[curr]) {
				for(int i : tube) {
					if(!visited[i]) {
						visited[i] = true;
						queue.add(i);
						arr[i] = arr[curr]+1;
						if(i==N) break out;
					}
				}
			}
		}
		
		if(arr[N]==-1) {
			System.out.println(-1);
		}else {
			System.out.println(arr[N]);
		}
		
		
	} // main


}
