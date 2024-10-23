import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 1. 맨 뒤 num 추가
		// 2. 맨 뒤 원소 제거
		// >> 맨 뒤에서부터 최소 몇 개를 선택해야 mod로 나누었을 때
		//    0, 1, ... mod-1 경우가 최소 한 번 이상 ??
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Q = Integer.parseInt(st.nextToken());	// Query 개수
		int M = Integer.parseInt(st.nextToken());	// mod
		
		List<Integer> lastAdded = new ArrayList<>();
		Stack<Integer>[] mods = new Stack[M];
		for (int m = 0; m < M; m++) {
			mods[m] = new Stack<Integer>();
		}
		
		int mod;
		long num;
		int idx = 0;	// 현재까지 발행된 쿼리 인덱스(1부터 시작) -> cmd 2에 의해 삭제.. 가 되도 상관이 없었네..
//		int deletedCnt = 0;					// >> 얘 필요없음

		query:
		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			
			if (cmd == 1) {
				num = Long.parseLong(st.nextToken());
				mod = (int) num % M;
				mods[mod].push(++idx);		// mods[mod]에 쿼리 인덱스를 Push (1부터 시작)
				lastAdded.add(mod);			// lastAdded에 mod 저장
			} else if (cmd == 2) {
				if (!lastAdded.isEmpty()) {
					mod = (int) lastAdded.get(lastAdded.size() - 1);	// lastAdded -> mod 꺼내오기
					lastAdded.remove(lastAdded.size() - 1);
					mods[mod].pop();
//					deletedCnt++;
					idx--;					// 3차 수정 : 쿼리 인덱스 4 -> (5삭제) -> 6 가 아니었네..
				}							// -> 4 -> 5(다시 idx--로 돌려놓기) -> 6
			} else {
				// 빈 스택 검사
				for (int m = 0; m < M; m++) {
					if (mods[m].isEmpty()) {
						sb.append(-1).append("\n");
						continue query;
					}
				}
				
				// 조건을 만족하는 가장 앞의 쿼리 인덱스 찾기 (targetIdx)
				// 마지막으로 발행된 쿼리 인덱스(idx) - targetIdx - deletedCnt => !!!!
				int targetIdx = mods[0].peek();
				for (int m = 1; m < M; m++) {
					targetIdx = Math.min(targetIdx, mods[m].peek());
				}
				sb.append(idx - targetIdx + 1).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}