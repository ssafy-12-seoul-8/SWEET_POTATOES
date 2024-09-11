import java.util.Scanner;

public class Main {


	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=0 ; tc<T ; tc++) {
			

			int H = sc.nextInt();
			int W = sc.nextInt();	
			int N = sc.nextInt();

			int floor = 0;
			int room = 0;
			
			if(N%H!=0) {
				floor = N%H;
				room = N/H+1;
			}else {
				floor = H;
				room = N/H;
			}
			
			
			int answer = floor*100 + room;
			
			System.out.println(answer);
		}
		
	} // main


}
