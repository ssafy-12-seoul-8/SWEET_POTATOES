import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 맨 뒤 num 추가
		// 2. 맨 뒤 원소 제거
		// >> 맨 뒤에서부터 최소 몇 개를 선택해야 mod로 나누었을 때
		//    0, 1, ... mod-1 경우가 최소 한 번 이상 ??
		
		int Q = sc.nextInt();	// Query 개수
		int M = sc.nextInt();	// mod
		
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
			int cmd = sc.nextInt();
			
			if (cmd == 1) {
				num = sc.nextLong();
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
						System.out.println(-1);
						continue query;
					}
				}
				
				// 조건을 만족하는 가장 앞의 쿼리 인덱스 찾기 (targetIdx)
				// 마지막으로 발행된 쿼리 인덱스(idx) - targetIdx - deletedCnt => !!!!
				int targetIdx = mods[0].peek();
				for (int m = 1; m < M; m++) {
					targetIdx = Math.min(targetIdx, mods[m].peek());
				}
				System.out.println(idx - targetIdx + 1);
				
// // 시간초과 ********************************************************************
//				// 조건을 만족하는 가장 앞의 쿼리 인덱스 찾기
//				// -> 이 인덱스가 저장된 mods[mod] 찾기
//				// -> lastAdded의 뒤에서부터 이 mod가 나올때까지 cnt++
//				int targetIdx = mods[0].peek();
//				int targetMod = 0;
//				for (int m = 1; m < M; m++) {
//					if (targetIdx > mods[m].peek()) {
//						targetIdx = mods[m].peek();
//						targetMod = m;
//					}
//				}
//				int cnt = 0;
//				for (int i = lastAdded.size() - 1; i >= 0; i--) {
//					cnt++;
//					if (lastAdded.get(i) == targetMod) break;	// 뒤에서부터 몇번째??
//				}
//				System.out.println(cnt);
// // 시간초과 ********************************************************************
				
			}
			
//			// TEST **********************************************************
//			System.out.print("lastAdded: ");
//			for (int la : lastAdded)
//				System.out.print(la + " ");
//			System.out.println();
//			if (!mods[0].isEmpty())
//				System.out.println("mod[0]: " + mods[0].peek());
//			if (!mods[1].isEmpty())
//				System.out.println("mod[1]: " + mods[1].peek());
//			if (!mods[2].isEmpty())
//				System.out.println("mod[2]: " + mods[2].peek());
//			if (!mods[3].isEmpty())
//				System.out.println("mod[3]: " + mods[3].peek());
//			// TEST **********************************************************
			
		}
		
	}
}