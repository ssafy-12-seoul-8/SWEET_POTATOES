import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 동굴의 길이 (짝수)
		int H = sc.nextInt();	// 동굴의 높이
		
		int[] stalactite = new int[N/2];	// 종유석
		int[] stalagmite = new int[N/2];	// 석순
		
		
		for(int i=0 ; i<N ; i++) {
			if(i%2==0) {
				// 석순
				stalagmite[i/2] = sc.nextInt();
			}else {
				// 종유석
				stalactite[i/2] = sc.nextInt();
			}
		}
		// 석순 오름차순 정렬
		Arrays.sort(stalagmite);
		// 종유석 오름차순 정렬
		Arrays.sort(stalactite);
		
		// 최소 파괴 횟수
		int min = N;
		
		// 최소 파괴 구간 수
		int cnt = 0;
		
		// 높이 i에서 파괴 횟수
		for(int i=0 ; i<H ; i++) {
			int totalColl = coll(stalagmite, i) + coll(stalactite, H-i+1);
			
			if(totalColl < min) {
				min = totalColl;
				cnt = 1;
			}else if(totalColl==min) {
				cnt++;
			}
		}
		
		System.out.println(min+" "+cnt);
		
		
		
	}	// main

	private static int coll(int[] rock, int h) {
		int L = 0;
		int R = rock.length-1;
		
		while(L<=R) {
			int mid = (L+R)/2;
			
			if(rock[mid]<h) {
				L = mid +1;
			}else {
				R = mid -1;
			}
		}
		
		return rock.length - L;
	}


}

