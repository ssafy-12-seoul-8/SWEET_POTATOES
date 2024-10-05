import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int cnt1 = 0;
		int cnt2 = 0;
		
		if(N==1) {
			System.out.println(1);
		}else {
			while(N>6*cnt1+1) {
				cnt2++;
				cnt1 += cnt2;
			}
			System.out.println(cnt2+1);
		}
		
		
		
	} // main


} // Main class