import java.util.Scanner;

public class Main {


	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int start = sc.nextInt();
		int prev = sc.nextInt();
		int type = 0;
		if(start>prev) {
			type = 1;
		}else {
			type = 2;
		}
		
		for(int i=3 ; i<=8 ; i++) {
			int curr = sc.nextInt();
			
			if(type==1) {
				if(prev<curr) {
					type = 0;
					break;
				}
			}else {
				if(prev>curr) {
					type = 0;
					break;
				}
			}
			prev = curr;
			
		}
		
		switch(type) {
		case 0:
			System.out.println("mixed");
			break;
		case 1 :
			System.out.println("descending");
			break;
		case 2 : 
			System.out.println("ascending");
		}
		
		
		
	} // main


}
