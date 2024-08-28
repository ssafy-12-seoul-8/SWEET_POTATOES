import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N;
	static List<List<Integer>> orderList = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int[] nums = new int[N];
		int[] ops = new int[4];
		for (int n = 0; n < N; n++)
			nums[n] = sc.nextInt();
		for (int n = 0; n < 4; n++)
			ops[n] = sc.nextInt();
		
		long max = Long.MIN_VALUE;
		long min = Long.MAX_VALUE;
		
		makeOrderList(ops, new ArrayList<>());
		
		for (List<Integer> order : orderList) {
			long ans = nums[0];
			for (int i = 1; i < N; i++) {
				int num = nums[i];
				int op = order.get(i - 1);
				
				if (op == 0)		ans += num;
				if (op == 1)		ans -= num;
				if (op == 2)		ans *= num;
				if (op == 3) {
					if (ans > 0)	ans /= num;
					else			ans = -(-ans)/num;
				
				}
			}
			max = Math.max(max, ans);
			min = Math.min(min, ans);
		}
		
		System.out.println(max);
		System.out.println(min);
		
	}

	static void makeOrderList(int[] ops, List<Integer> order) {
		
		if (order.size() == N - 1) {
			orderList.add(new ArrayList<>(order));
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (ops[i] > 0) {
				ops[i]--;
				order.add(i);
				makeOrderList(ops, order);
				order.remove(order.size() - 1);
				ops[i]++;
			}
		}
		
	}
	
}