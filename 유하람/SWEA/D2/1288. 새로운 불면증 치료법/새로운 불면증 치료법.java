
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
			
			int num;
			
			int mul=1;
			
			boolean[] cnt = new boolean[10];
			
			while(true) {
				
				num = mul*N;

				String str = Integer.toString(num);
				
				
				int len = str.length();
				
				for(int i=0 ; i<len ; i++) {
					int idx = str.charAt(i) - '0';
					cnt[idx] = true;
				}
				
				
				if(isEnd(cnt)) {
					break;
				}
				
				mul++;

			}
			
			System.out.print("#"+t+" ");
			System.out.println(num);

		}
	}
    
    static boolean isEnd(boolean[] cnt) {
		for(int i=0 ; i<10 ; i++) {
			if(cnt[i]==false) {
				return false;
			}
		}
		return true;
	}
}