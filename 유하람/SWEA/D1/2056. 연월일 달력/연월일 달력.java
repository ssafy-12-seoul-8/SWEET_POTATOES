
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
            String strDay = sc.next();
			
			int inputDay = Integer.parseInt(strDay);
			
			int year = inputDay/10000;
			
			int month = (inputDay%10000)/100;
			
			int day = inputDay%100;
			
			String answer = "-1";
			
			switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if(0<day&&day<=31) {
					answer = "1";
					break;
				}
			case 4:
			case 6:
			case 9:
			case 11:
				if(0<day&&day<=30) {
					answer = "1";
					break;
				}
			case 2:
				if(0<day&&day<=28) {
					answer = "1";
				}
			}
			
			if(answer.equals("1")) {
				answer = ""+ strDay.charAt(0) + strDay.charAt(1) + strDay.charAt(2) + strDay.charAt(3) + "/" + strDay.charAt(4)+ strDay.charAt(5) + "/" + strDay.charAt(6) + strDay.charAt(7);
			}
			
			System.out.printf("#%d %s",t,answer);
			System.out.println();
            
		}
	}
}