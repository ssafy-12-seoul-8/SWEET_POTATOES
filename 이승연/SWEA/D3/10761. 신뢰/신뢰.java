import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int buttonCount = sc.nextInt();

            int bPosition = 1;
            int oPosition = 1;
            int bTime = 0;
            int oTime = 0;
            int count = 0;

            for (int i = 0; i < buttonCount; i++) {
                String button = sc.next();
                int num = sc.nextInt();

                if (button.equals("B")) {
                    // (현재 위치 - 버튼까지 걸린시간) + (버튼 누르는 시간)
                    int bCount = Math.abs(bPosition - num);
                    bTime = Math.max(count, bTime + bCount) + 1;
                    bPosition = num;
                    count = bTime;
                } else {
                    int oCount = Math.abs(oPosition - num);
                    oTime = Math.max(count, oTime + oCount) + 1;
                    oPosition = num;
                    count = oTime;
                }

            }

            System.out.printf("#%d ", test_case);
            System.out.println(count);
        }
	}
}