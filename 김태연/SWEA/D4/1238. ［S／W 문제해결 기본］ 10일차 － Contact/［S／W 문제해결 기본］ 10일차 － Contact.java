import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

		
	static boolean[] visited;
	static List<Integer>[] adjList;
	static int max;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			max = -1;
			int N = sc.nextInt();	// data
			int M = sc.nextInt();	// 시작점

			// 엣지들을 모아두는 리스트
			visited = new boolean[101];
			adjList = new ArrayList[101];
			
			for (int i=1; i<101; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			
			for (int i=0; i< N/2; i++) {
			
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				// 중복 추가를 안하기 위해선 어떻게 해야할까?
				// 2, 17 을 받았으면, adjList[2] 에 17 을 추가한다. (추가하기 전에 없는지 확인한다)
				if (!adjList[from].contains(to)) {
					adjList[from].add(to);
//					System.out.println(from + "에 " + to + " 추가");
				}
			}
			
			// 입력받기 완료
			
			
			// 최고값 찾기
			
			call(adjList[M]);
			
			System.out.println("#" + test_case + " " + max);

		}

	}

	
	static void call(List<Integer> callList) {

		// 다음번에 전화할 사람들 목록
		List<Integer> nextCallList = new ArrayList<>();
		
		// callList의 0번부터 시작해서 끝번까지 다 전화를 돌린다
		for (int i=0; i< callList.size(); i++) {
			// 한 명씩 전화한다.
			int thisMan = callList.get(i);	// thisMan 에 7을 저장한다.
			
			
			// 전화하지 않은 사람만 목록에 추가한다.
			if (visited[thisMan]) continue;
			
			// 이번에 전화 걸었으니까 걸었다고 표시함.
			visited[thisMan] = true;
			
			
			// 7이 전화할 사람들의 목록을 nextCallList에 저장한다.
			for (int j=0; j<adjList[thisMan].size(); j++) {
				int nextMan = adjList[thisMan].get(j);
				// 전화하지 않은 사람만 목록에 추가한다.
				if (visited[nextMan]) continue;
				nextCallList.add(adjList[thisMan].get(j));
			}
		}
		
		// 다음번에 전화할 사람이 없다면
		if (nextCallList.size() == 0) {
			// 이번에 전화한 사람들 목록에서 제일 큰 값을 반환한다
			for (int i=0; i<callList.size(); i++) {
				max = Math.max(max, callList.get(i));
			}
			return;
		}
		
		// 목록에 전화했으면, 다음 시간대로 이동한다.
		call(nextCallList);
		
	}
	

}