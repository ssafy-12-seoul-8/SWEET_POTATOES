
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.List;
import java.util.ArrayList;

class Solution
{
    static int[][] Synergy;
    
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int t = 1; t <= T; t++)
		{
            // 식재료 개수
			int N = sc.nextInt();
			int n = N/2;
			
			// 시너지
			Synergy = new int[N][N];
			
			// 식재료
			int[] food = new int[N];
			
			for(int i=0 ; i<N ; i++) {
				food[i] = i;
				for(int j=0 ; j<N ; j++) {
					Synergy[i][j] = sc.nextInt();
				}
			}
			
			List<int[]> aFood = new ArrayList<>();
			combine(food, N, n, 0, new int[n], 0, aFood);
			
			int min = Integer.MAX_VALUE;
			
			for(int[] datas : aFood) {
				
				int[] bFood = new int[n];
				int idx = 0;
				
				for(int data : food) {
					boolean tmp = true;
					for(int aData : datas) {
						if(data==aData) {
							tmp = false;
							break;
						}
					}
					if(tmp) {
						bFood[idx++]=data;
					}
				}
				
				int diff = Math.abs(calSyn(datas)-calSyn(bFood));

				if(diff < min) {
					min = diff;
				}
				
			}
			
			System.out.printf("#"+t+" ");
			System.out.println(min);
		}
	}
    static void combine(int[] food, int N, int n, int idx, int[] data, int i, List<int[]> aFood) {
		if(idx==n) {
			aFood.add(data.clone());
			return;
		}
		
		if(i>=N) {
			return;
		}
		
		data[idx] = food[i];
		combine(food, N, n, idx+1, data, i+1, aFood);
		combine(food, N, n, idx, data, i+1, aFood);
		
	}
	
	static int calSyn (int[] data) {
		int syn = 0;
		
		for(int i : data) {
			for(int j : data) {
				syn += Synergy[i][j];
			}
		}
		
		return syn;
	}
}