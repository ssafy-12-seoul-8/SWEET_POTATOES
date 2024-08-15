
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
            String str = sc.next();
			str = str +" ";
			
			int cnt = 0;
			
			for(int i=0 ; i<str.length() ; i++) {
				char c = str.charAt(i);
				
				if(c=='(' && str.charAt(i+1)==')') {
				}else if(c==')') {
					cnt++;
				}else if(c=='(') {
					cnt++;
				}
			}
			
			
			System.out.print("#"+t+" ");
			System.out.println(cnt);
		}
	}
}