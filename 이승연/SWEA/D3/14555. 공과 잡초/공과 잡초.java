import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
           	String str = sc.next();
            int count = 0;
            
            for (int i = 0; i < str.length() - 1; i++) {
            	char c1 = str.charAt(i);
                char c2 = str.charAt(i + 1);
                
                if (c1 == '(' && c2 == '|') {
                	count++;
                } else if (c1 == '|' && c2 == ')') {
                	count++;
                } else if (c1 == '(' && c2 == ')') {
                	count++;
                }
            }
            
			System.out.printf("#%d ", test_case);
			System.out.println(count);
		}
	}
}