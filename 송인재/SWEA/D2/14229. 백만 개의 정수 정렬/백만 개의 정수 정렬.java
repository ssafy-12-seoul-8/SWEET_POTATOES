import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static final int size = 1_000_000;
	static final int[] nums = new int[size];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < size; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(0, size - 1);
		
		System.out.println(nums[size / 2]);
	}
	
	static void quickSort(int left, int right) {
		if (left >= right) {
			return;
		}
		
		int pivot = lomuto(left, right);
		
		quickSort(left, pivot - 1);
		quickSort(pivot + 1, right);
	}
	
	static int lomuto(int left, int right) {
		int pivot = nums[right];
		int index = left - 1;
		
		for (int i = left; i < right; i++) {
			if (nums[i] < pivot) {
				int temp = nums[++index];
				nums[index] = nums[i];
				nums[i] = temp;
			}
		}
		
		nums[right] = nums[++index];
		nums[index] = pivot;
		
		return index;
	}
	
}
