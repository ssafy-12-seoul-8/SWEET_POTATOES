import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long[][] room;
	static int N;
	static long A;
	static long answer;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		// 방의 개수
		N = Integer.parseInt(st1.nextToken());
		// 용사의 초기 공격력
		A = Long.parseLong(st1.nextToken());
		
		room = new long[N][3];
		
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			// i번 쩨 방의 정보
			room[i][0]=Long.parseLong(st2.nextToken());
			room[i][1]=Long.parseLong(st2.nextToken());
			room[i][2]=Long.parseLong(st2.nextToken());
		}
		
		answer = Long.MAX_VALUE;
		
		// 최대 생명력에 따라 이분 탐색
		BS(0,(long)Math.pow(10, 18) * 9);
		
		System.out.println(answer);
		
		
	}

	private static void BS(long L, long H) {
		
		while(L<=H) {
			long mid = (L+H)/2;
			
			// 용사 상태 초기화
			long A1 = A;
			
			if(Clear(mid, A1)>0){
				answer = Math.min(mid, answer);
				H = mid -1;
			}else {
				L = mid +1;
			}
		}
	}

	private static long Clear(long HP, long a1) {
		
		long initHP = HP;
		
		for(int i=0 ; i<N ; i++) {
			// 방의 정보 : 1 ->  몬스터, 2 -> 포션
			long t = room[i][0];
			// 몬스터 공격력 or 용사 공격력 증가
			long a = room[i][1];
			// 몬스터 or 포션 생명력
			long h = room[i][2];
			
			if(t==1) {
				// 몬스터 방
				long myAtk = 1+(h-1)/a1;
				long monAtk = 1+(HP-1)/a;
				if(myAtk<=monAtk) {
					// 몬스터 죽음
					HP -= (myAtk-1)*a;
					continue;
				}else {
					// 용사 죽음
					HP = -1;
					return HP;
				}
				
			}else {
				// 포션 방
				a1 += a;
				HP += h;
				if(HP>initHP) {
					HP = initHP;
				}
			}
			
		}
		
		
		return HP;
	}

}