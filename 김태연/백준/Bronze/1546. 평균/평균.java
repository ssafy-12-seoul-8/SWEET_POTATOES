import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		double[] scores = new double[N];
		int maxScore = -1;
		for (int i=0; i<N; i++) {
			int input = sc.nextInt();
			scores[i] = input;
			maxScore = Math.max(maxScore, input);
		}
		
		double sum = 0;
		
		for (int i=0; i<N; i++) {
			scores[i] = (scores[i] / maxScore) * 100;
			sum += scores[i];
		}
		
		double average = sum / N;
		System.out.println(average);
		
	}
}
