import java.util.Scanner;

public class Solution {
	
	static int N = 1000000;
	static int[] arr = new int[N];
	static int[] tmp = new int[N];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int n = 0; n < N; n++)
			arr[n] = sc.nextInt();
		
		MergeSort(0, N - 1);
		System.out.println(arr[500000]);
		
	}
	
	// left : 왼쪽 구간의 시작
	// right : 오른쪽 구간의 끝
	static void MergeSort(int left, int right) {
		if (left == right) return;
		// mid : 왼쪽 구간의 끝 / mid + 1 : 오른쪽 구간의 시작
		int mid = (left + right) / 2;
		// 왼쪽 분할
		MergeSort(left, mid);
		// 오른쪽 분할
		MergeSort(mid + 1, right);
		// 병합
		Merge(left, mid, right);
	}
	
	static void Merge(int left, int mid, int right) {
		// 왼쪽 절반의 요소를 가리킬 포인터
		int L = left;
		// 오른쪽 절반의 요소를 가리킬 포인터
		int R = mid + 1;
		// tmp 배열의 인덱스
		int idx = left;
		
		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R])
				tmp[idx++] = arr[L++];
			else
				tmp[idx++] = arr[R++];
		}
		
		if (L <= mid) {
			for (int i = L; i <= mid; i++)
				tmp[idx++] = arr[i];
		}
		
		else {
			for (int i = R; i <= right; i++)
				tmp[idx++] = arr[i];
		}
		
        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
		
	}
}
