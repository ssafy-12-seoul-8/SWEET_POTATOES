import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		// 시험 본 과목의 개수
		int N = sc.nextInt();
		
		float[] score = new float[N];
		
		float max = 0;
		
		for(int i=0 ; i<N ; i++) {
			score[i] = sc.nextInt();
			max = Math.max(max, score[i]);
		}
		
		float sum = 0;
		
		for(int i=0 ; i<N ; i++) {
			sum += (score[i]/max)*100;
		}
		
		System.out.println(sum/N);
		
		
	} // main

}