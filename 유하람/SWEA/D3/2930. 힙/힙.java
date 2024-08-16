
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int t = 1; t <= T; t++)
		{
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            
            System.out.print("#"+t);
            
            // 연산 수
			int n = sc.nextInt();
			
			for(int i=0 ; i<n ; i++) {
				// 연산 종류
				int oper = sc.nextInt();
				
				if(oper==1) {
					// 삽입할 숫자
					int num = sc.nextInt();					
					pq.add(num);
					
				}else {
					if(pq.isEmpty()) {
						System.out.print(" "+-1);
					}else {
						int tmp = pq.poll();
						System.out.print(" "+tmp);
					}

				}
			}
			
			System.out.println();
		}
	}
}