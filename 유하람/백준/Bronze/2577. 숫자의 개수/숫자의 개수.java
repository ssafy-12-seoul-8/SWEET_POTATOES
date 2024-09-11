import java.util.Scanner;

public class Main {


	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt()*sc.nextInt()*sc.nextInt();

		int[] cnt = new int[10];
		
		
		while(num>0) {
			cnt[num%10]++;
			num /= 10;
		}
		
		for(int i : cnt)
			System.out.println(i);
		
		
	} // main


}
