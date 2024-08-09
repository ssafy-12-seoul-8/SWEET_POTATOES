import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		StringBuilder sb = new StringBuilder();
//		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			// 한줄 다 받음.
			String line = br.readLine();

			int[] array = new int[line.length()];
			int count = 0;
			// 배열에 값 입력하기
			for (int i=0; i<line.length(); i++) {
				array[i] = line.charAt(i) - '0';
			}
			
			if (array[0] == 1) count++;
			for (int i=0; i < array.length - 1; i++) {
				if (array[i+1] != array[i]) count++;
			}
			
			sb.append("#").append(test_case).append(" ").append(count).append("\n");
			
			// 뒤에서부터 보는게 중요할것같음 ( 뒤에서부터 통일하기 때문에)
			// 앞에서부터 봐도 상관없는것 같네.. 앞에서부터 풀어보자
			
		}
		System.out.println(sb);
	}
}