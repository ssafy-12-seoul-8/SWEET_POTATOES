import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		// 나무의 수
		// 1<= N <= 1,000,000
		long N = sc.nextInt();
		
		// 가져가려고 하는 나무의 길이
		// 1<= M <=2,000,000,000
		long M = sc.nextInt();
		
		// 나무의 높이들
		List<Long> trees = new ArrayList<>();
		
		for(int i=0 ; i<N ; i++) {
			trees.add(sc.nextLong());
		}
		
		long L = 0;
		long R = (long) Math.pow(10, 9);
		
		while(L<=R) {
			long mid = (L+R)/2;
			
			long tmp = 0;
			
			for(long t : trees) {
				if(t>mid) {
					tmp += t-mid;
				}
			}
			
			if(tmp>=M) {
				// 가능
				L = mid + 1;
			}else {
				// 불가능
				R = mid - 1;
			}
		}
		
		System.out.println(R);
		
	} // main

} // Main class
