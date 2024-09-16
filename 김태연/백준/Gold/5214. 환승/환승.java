package 환승;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Subway {
	int index;
	List<HyperTube> hyperTubeList = new ArrayList<>();
}

class HyperTube {
	int index;
	List<Subway> subwayList = new ArrayList<>();
}

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 역을 담을 노드
		Subway[] subwayArr = new Subway[N+1];
		HyperTube[] hyperTubeArr = new HyperTube[M+1];
		
		for (int i=1; i<=N; i++) {
			Subway subway = new Subway();
			subway.index = i;
			subwayArr[i] = subway;
		}
		
		for (int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			HyperTube hyperTube = new HyperTube();
			hyperTube.index = i;

			// 역이랑 하이퍼튜브랑 연결하기
			for (int j=0; j<K; j++) {
				int index = Integer.parseInt(st.nextToken());
				Subway subway = subwayArr[index];
				// 하이퍼튜브에도 서브웨이 추가하고
				// 서브웨이에도 하이퍼튜브 추가함
				hyperTube.subwayList.add(subway);
				subway.hyperTubeList.add(hyperTube);
			}
			hyperTubeArr[i] = hyperTube;
		}
		
		// 입력끝.
		
		// BFS 사용하기
		// 목표는 1번역에서 N번역으로 가는 것
		int[] distance = new int[N+1];
//		for (int i=1; i<=N; i++) {
//			distance[i] = 0;
//		}
		Queue<Subway> queue = new LinkedList<>();
		
		// 1번 역에서 출발
		queue.add(subwayArr[1]);
		distance[1] = 1;
		
		while (!queue.isEmpty()) {
			Subway subway = queue.poll();
			
			// 현재 역과 연결된 하이퍼튜브들 하나씩 불러옴
			for (int i=0; i<subway.hyperTubeList.size(); i++) {
				HyperTube hyperTube = subway.hyperTubeList.get(i);
				// i번째 하이퍼튜브와 연결된 역들을 모두 탐색
				for (int j=0; j<hyperTube.subwayList.size(); j++) {
					// i번째 하이퍼튜브와 연결된 j번째 역
					Subway nextSubway = hyperTube.subwayList.get(j);
					int nextIndex = nextSubway.index;
					// 만약 아직 방문하지 않았다면
					if (distance[nextIndex] == 0) {
						distance[nextIndex] = distance[subway.index] + 1;
						queue.add(nextSubway);
					}
				}
				
			}
			
		}
		
		int result = -1;
		if (distance[N] != 0) result = distance[N];
		
		System.out.println(result);
		
		
		
	}
}
