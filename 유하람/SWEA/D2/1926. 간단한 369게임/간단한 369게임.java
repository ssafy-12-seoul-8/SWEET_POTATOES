
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		
        int N = sc.nextInt();
		
		for(int n=1 ; n<=N ; n++) {
			
			String num = Integer.toString(n);
			
			if(num.contains("3") || num.contains("6") || num.contains("9")) {
				
				int len = num.length();
				
				for(int i=0 ; i<len ; i++) {
					
					char c = num.charAt(i);
					
					if(c =='3') {
						System.out.print("-");
					}else if(c =='6') {
						System.out.print("-");
					}else if(c =='9') {
						System.out.print("-");
					}
					
				}
				
			}else {
				System.out.print(num);
			}
			
			System.out.print(" ");
			
			
			
		}
        
	}
}