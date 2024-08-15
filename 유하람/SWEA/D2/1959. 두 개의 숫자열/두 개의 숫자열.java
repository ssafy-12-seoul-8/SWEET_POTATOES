
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int t = 1; t <= T; t++)
		{
            int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] Barr;
			int[] Sarr;
			
			if(N>=M) {
				Barr = new int[N];
				Sarr = new int[M];
				
				for(int i=0 ; i<N ; i++) {
					Barr[i] = sc.nextInt();
				}
				
				for(int i=0 ; i<M ; i++) {
					Sarr[i] = sc.nextInt();
				}
			}else {
				Sarr = new int[N];
				Barr = new int[M];
				
				for(int i=0 ; i<N ; i++) {
					Sarr[i] = sc.nextInt();
				}
				
				for(int i=0 ; i<M ; i++) {
					Barr[i] = sc.nextInt();
				}
			}
			
			int B = Barr.length;
			int S = Sarr.length;
			
			int sum;
			int max = Integer.MIN_VALUE;
			
			for(int i=0 ; i<=B-S ; i++) {
				sum = 0;
				for(int j=0 ; j<S ; j++) {
					sum += Sarr[j]*Barr[j+i];
				}
				if(sum>max)
					max=sum;
			}
			
			System.out.print("#"+t+" ");
			System.out.println(max);
		}
	}
}