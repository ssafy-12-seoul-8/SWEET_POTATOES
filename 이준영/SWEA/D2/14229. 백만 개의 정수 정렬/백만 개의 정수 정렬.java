import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[1000000];
		for(int i=0;i<1000000;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		quick(0,999999);
		System.out.println(arr[500000]);
	}
	static void quick(int left,int right) {
		if (right-left<=0)
			return;
		int pivot = arr[left];
		int i = left+1;
		int j = right;
		while(i<=j) {
			while(i<=j && arr[i]<=pivot) {
				i++;
			} 
			while(arr[j]>pivot) {
				j--;
			}
			if(i<j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		arr[left] = arr[j];
		arr[j] = pivot;
		quick(left,j-1);
		quick(j+1,right);
		return;
	}
}
