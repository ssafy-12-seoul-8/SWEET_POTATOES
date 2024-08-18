import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
       	String str = "";
        
        for (int i = 1; i <= N; i++) {
        	String S = i + "";
            String result = "";
            
            for (int j = 0; j < S.length(); j++) {
            	char C = S.charAt(j);
                if (C == '3' || C == '6' || C == '9') {
                	result += "-";
                }
            }
            
            if (result.length() == 0) {
            	result += S;
            }
            
            str += result + " ";
        }
        
        System.out.println(str);
	}
}