import java.util.*;
import java.io.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        // 바위 개수
		int N = rocks.length;
		// 처음과 끝 점을 포함한 위치들
		int[] arr = new int[N+2];
		arr[0] = 0;
		arr[N+1] = distance;
		for(int i=0 ; i<N ; i++) {
			arr[i+1] = rocks[i];
		}
		
		Arrays.sort(arr);
		
//		System.out.println(Arrays.toString(arr));
		
		long L = 0;
		long R = distance;
		
		
		// 각 지점 사이의 거리의 최솟값 중에 가장 큰 값
		while(L<=R) {
			long mid = (L+R)/2;
//			System.out.println(mid);
			
			long end = 0;
			int cnt = 0;
			
			for(int i=0 ; i<N+2 ; i++) {
				if(arr[i]>=end) {
					end = arr[i] + mid;
					continue;
				}
				cnt++;
			}
			
//			System.out.println("cnt : "+cnt);
			if(cnt>n) {
				// 불가능
//				System.out.println("불가능");
				R = mid-1;
			}else {
				// 가능
//				System.out.println("가능");
				L = mid +1;
			}
			
		}
        
        answer = (int)R;
        
        return answer;
    }
}