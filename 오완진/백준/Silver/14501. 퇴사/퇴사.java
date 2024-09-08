import java.util.Scanner;

public class Main {
	
	static int N, maxMoney;
	static int[][] NN;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		NN = new int[N+1][2];
		for (int n = 1; n <= N; n++) {
			NN[n][0] = sc.nextInt();
			NN[n][1] = sc.nextInt();
		}
		
		btk(0, 0);
		
		System.out.println(maxMoney);
	}
	
	static void btk(int day, int money) {
		
		if (day == N) {
			maxMoney = Math.max(maxMoney, money);
			return;
		}
		
		if (day + NN[day + 1][0] <= N)
			btk(day + NN[day + 1][0], money + NN[day + 1][1]);
		btk(day + 1, money);
		
	}
	
}