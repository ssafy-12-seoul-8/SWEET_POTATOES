import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int[][] SNJ = new int[N][N];
			for (int n = 0; n < N; n++)
				for (int m = 0; m < N; m++)
					SNJ[n][m] = sc.nextInt();

		int great = 9999;
		combinations = new ArrayList<>();
		combination(N, 0, new ArrayList<>());
		
		// (N combination N/2) 만큼 반복
		for (int s = 0; s < combinations.size(); s++) {
			
			int[] combi = combinations.get(s);
			boolean[] food = new boolean[N];
			for (int n = 0; n < N/2; n++)
				food[combi[n]] = true;
			
			List<Integer> food1 = new ArrayList<>();
			List<Integer> food2 = new ArrayList<>();
			
			for (int n = 0; n < N; n++) {
				if (food[n]) food1.add(n);
				else		 food2.add(n);
			}
			
			int sum1 = 0;
			int sum2 = 0;
			int compare = 0;
			
			for (int i = 0; i < N/2; i++) {
				for (int j = i+1; j < N/2; j++) {
					sum1 += (SNJ[food1.get(i)][food1.get(j)] + SNJ[food1.get(j)][food1.get(i)]);
					sum2 += (SNJ[food2.get(i)][food2.get(j)] + SNJ[food2.get(j)][food2.get(i)]);
				}
			}
			
			compare = Math.abs(sum1 - sum2);
			great = Math.min(great, compare);
			
		}
		
		System.out.println("#" + tc + " " + great);
		}
	}
	
	static List<int[]> combinations;
	
	static void combination(int N, int start, List<Integer> food) {
	    if(food.size() == N/2) {
    	int[] foods = new int[food.size()];
    	for (int f = 0; f < food.size(); f++)
    		foods[f] = food.get(f);
    	
		combinations.add(foods);
		
        return;
	    }
	    
	    for (int i = start; i < N; i++) {
	    	food.add(i);
	    	combination(N, i + 1, food);
	    	food.remove(food.size() - 1);
	    }
	}
	
}
