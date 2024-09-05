import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int N, minTime;
	static int[][] map;
	static List<int[]> personList, stairList, ETA;				// [2] [3] [2]
	static List<Integer> ETA1, ETA2;
	static Deque<Integer> stair1, stair2, wait1, wait2;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			minTime = Integer.MAX_VALUE;
			N = sc.nextInt();
			map = new int[N][N];
			personList = new ArrayList<>();
			stairList = new ArrayList<>();
			ETA = new ArrayList<>();
			ETA1 = new ArrayList<>();
			ETA2 = new ArrayList<>();
			
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < N; m++) {
					int data = sc.nextInt();
					if (data == 1)
						personList.add(new int[] {n, m});
					if (data >= 2)
						stairList.add(new int[] {n, m, data});	// stair[2] = 계단길이
				}
			}
			
			for (int p = 0; p < personList.size(); p++) {
				int[] person = personList.get(p);				// ETA : {계단거리1, 계단거리2}
				ETA.add(getNearbyStair(person, stairList.get(0), stairList.get(1)));
			}
			
			int stairLength1 = stairList.get(0)[2];
			int stairLength2 = stairList.get(1)[2];
			stair1 = new LinkedList<>();
			for (int i = 0; i < stairLength1; i++)
				stair1.addLast(0);								// 계단1 길이만큼 대기열 추가
			stair2 = new LinkedList<>();
			for (int i = 0; i < stairLength2; i++)
				stair2.addLast(0);								// 계단2 길이만큼 대기열 추가
			wait1 = new LinkedList<>();
			wait2 = new LinkedList<>();
			
			pickETA(new int[ETA.size()], 0);
			
			System.out.println("#" + tc + " " + minTime);
			
		}
		
	}
	
	static int[] getNearbyStair(int[] person, int[] stair1, int[] stair2) {
		int distance1 = Math.abs(person[0] - stair1[0]) + Math.abs(person[1] - stair1[1]);
		int distance2 = Math.abs(person[0] - stair2[0]) + Math.abs(person[1] - stair2[1]);
		
		return new int[] {distance1, distance2};
	}
	
	static void pickETA(int[] pick, int idx) {					// 2^(머릿수) 만큼 완전탐색
		
		if (idx == ETA.size()) {
			
			ETA1.clear();
			ETA2.clear();
			
			int etaIdx = 0;
			for (int eta : pick) {
				if (eta == 1)
					ETA1.add(ETA.get(etaIdx++)[0]);				// 계단1 사람들의 거리(=대기열까지 시간) 저장
				else
					ETA2.add(ETA.get(etaIdx++)[1]);				// 계단2 사람들의 거리(=대기열까지 시간) 저장
			}
			
			getHappyTime();
			
			return;
		}
	
        pick[idx] = 1;
        pickETA(pick, idx + 1);

        pick[idx] = 2;
        pickETA(pick, idx + 1);
		
	}
	
	static void getHappyTime() {
		
		int time = 0;
		int stairFirst1 = 0;
		int stairFirst2 = 0;
		int stairCnt1 = 0;
		int stairCnt2 = 0;
		int happyCnt = 0;
		
		while (happyCnt < ETA.size()) {
			
			time++;
			
			// 계단 출구 -> 무조건 한칸 뽑고 사람이 있다면 happyCnt stairCnt 처리
			stairFirst1 = stair1.pollFirst();
			happyCnt += stairFirst1;
			stairCnt1 -= stairFirst1;
			
			stairFirst2 = stair2.pollFirst();
			happyCnt += stairFirst2;
			stairCnt2 -= stairFirst2;
			
			// 계단 입구 -> stairCnt < 3 유지한채로 대기열에서 집어넣기
			stairFirst1 = 0;
	        while (!wait1.isEmpty() && stairCnt1 < 3) {
				wait1.pollFirst();
				stairFirst1++;
				stairCnt1++;
			}
			stair1.addLast(stairFirst1);
			
			stairFirst2 = 0;
	        while (!wait2.isEmpty() && stairCnt2 < 3) {
				wait2.pollFirst();
				stairFirst2++;
				stairCnt2++;
			}
			stair2.addLast(stairFirst2);
			
			// 모든 사람들 한칸씩 전진시키고 0 도달 = 계단 입구 -> 대기열 추가
			for (int i = 0; i < ETA1.size(); i++) {
				ETA1.set(i, ETA1.get(i) - 1);
				if (ETA1.get(i) == 0) wait1.addLast(0);
			}
			
			for (int i = 0; i < ETA2.size(); i++) {
				ETA2.set(i, ETA2.get(i) - 1);
				if (ETA2.get(i) == 0) wait2.addLast(0);
			}
			
		}

		minTime = Math.min(minTime, time);
		
	}
}