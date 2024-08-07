import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			sc.nextInt();	// 숫자 한개 버리고
			
			Queue<Integer> queue = new LinkedList<Integer>();
			
			// 입력받기
			for (int i=0; i<8; i++) {
				queue.add(sc.nextInt());	// 입력받은 숫자 하나 더하기
			}
			
			int count = 0;
			while (true) {
				int number = queue.poll();
//				System.out.println(count + "번째 number 출력 : " + number);
				number -= ++count;
//				System.out.println("count 출력 : " + count);
				count %= 5;
				if (number <= 0) {
					queue.add(0);
//					System.out.println("반복문 종료 !");
					break;
				} else {
					queue.add(number);
				}
			}
			
			System.out.print("#" + test_case);
			while (!queue.isEmpty()) {
				System.out.print(" " + queue.poll());
			}

			System.out.println();
		}
	}
}