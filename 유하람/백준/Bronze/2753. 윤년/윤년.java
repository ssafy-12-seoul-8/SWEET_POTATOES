import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int year = sc.nextInt();
		
		if(year%4==0) {
			if(year%100==0) {
				if(year%400==0) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}else {
				System.out.println(1);
			}
		}else {
			System.out.println(0);
		}
		
		
		
	}

}