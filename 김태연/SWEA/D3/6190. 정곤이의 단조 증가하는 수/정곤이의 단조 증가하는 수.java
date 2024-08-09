import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int N = sc.nextInt();
			// 저장할 배열 생성
			int[] array = new int[N];	// 2, 4, 7, 10 저장함.
			// A1 = 2
			// A2 = 4
			// A3 = 7
			// A4 = 10
			
			for (int i=0; i<N; i++) {
				array[i] = sc.nextInt();
			}
			// 저장완료
			
			// 하나씩 곱해봄?
			// A1 * A2, A1 * A3, .. A3 * A4 해서 단조인지 아닌지 알아내야함.
			// 그 중 최대값을 찾기때문에. 뒤에서부터 돌리면 빠름
			// 큰거*큰거가 더 크니까.
			// 30000 * 30000 = 900 000 000	9억.
			
			
			// i,j 에 대해서 Ai Aj 곱 구하기
			// 단, j는 반드시 i보다 크거나 같음
			int product;
			int max = -1;	// 없으면 -1을 반환하기 때문에
			for (int i=1; i<N-1; i++) {
				for (int j=i+1; j<N; j++) {	// j는 반드시 i보다 크다. j = i+1 부터 시작.

					product = array[i] * array[j];
					if (isDanjo(product)) {
						// 곱을 계산했는데 단조라면
						max = Math.max(max, product);	// 최댓값을 갱신시키자
					}
				}
			}
		

			System.out.println("#" + test_case + " " + max);
		}
	}
	
	static boolean isDanjo(Integer X) {
		// X 가 몇자리 수인지 판단해야함.
		String number = X.toString();	// 숫자를 문자열로 바꾸고
		int k = number.length();		// 길이를 측정
		
		for (int i=0; i<k-1; i++) {		// 만약 오른쪽 숫자가 왼쪽 숫자보다 작으면 (단조가아님)
			if (number.charAt(i+1) < number.charAt(i)) {	// -'0' 안해도 됨(어차피 아스키값도 순서대로임)
				return false;			// false 반환
			}
		}
		return true;		// false를 반환하지 않았다면, true 를 반환
	}
}