import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static List<List<Integer>> pickedList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		List<int[]> houseList = new ArrayList<>();
		List<int[]> chickList = new ArrayList<>();
		for (int n1 = 0; n1 < N; n1++) {
			for (int n2 = 0; n2 < N; n2++) {
				int num = sc.nextInt();
				if (num == 1) houseList.add(new int[] {n1, n2});
				if (num == 2) chickList.add(new int[] {n1, n2});
			}
		}
		
		// [집No][집No-치킨No 치킨거리]
		// 집1 - {치킨거리A, 치킨거리B, ...}
		// 집2 - {치킨거리A, 치킨거리B, ...}
		// 치킨 A,B,C ... 중 M개만 남겨서 집[1][min]+집[2][min]+... 최소 구하기
		int H = houseList.size();
		int C = chickList.size();
		int[][] chickD = new int[H][C];
		for (int h = 0; h < H; h++) {
			for (int c = 0; c < C; c++) {
				int[] house = houseList.get(h);
				int[] chick = chickList.get(c);
				chickD[h][c] = getD(house[0], house[1], chick[0], chick[1]);
			}
		}
		
		combi(C, M, 0, new ArrayList<>());
		
		int minChickD = Integer.MAX_VALUE;
		for (List<Integer> picked : pickedList) {
			int minChiSum = 0;
			for (int h = 0; h < H; h++) {
				int minChiDH = Integer.MAX_VALUE;
				for (int p : picked) {
					minChiDH = Math.min(minChiDH, chickD[h][p]);
				}
				minChiSum += minChiDH;
			}
			minChickD = Math.min(minChickD, minChiSum);
		}
		
		System.out.println(minChickD);
		
	}
	
	static int getD(int r1, int c1, int r2, int c2) {
		int distance = Math.abs(r1 - r2) + Math.abs(c1 - c2); 
		return distance;
	}

	static void combi(int C, int M, int idx, List<Integer> picked) {
		if (M == picked.size()) {
			pickedList.add(new ArrayList<>(picked));
			return;
		}
		
		for (int c = idx; c < C; c++) {
			picked.add(c);
			combi(C, M, c + 1, picked);
			picked.remove(picked.size() - 1);
		}
	}
	
}