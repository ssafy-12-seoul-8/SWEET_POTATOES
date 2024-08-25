
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			String str = sc.next();
			
			char tmp = '0';
			int count = 0;
			
			for(int i=0 ; i<str.length() ; i++) {
				if(tmp!=str.charAt(i)) {
					tmp = str.charAt(i);
					count++;
				}
			}
			
			System.out.println("#"+tc+" "+count);
			
		}
	}
}