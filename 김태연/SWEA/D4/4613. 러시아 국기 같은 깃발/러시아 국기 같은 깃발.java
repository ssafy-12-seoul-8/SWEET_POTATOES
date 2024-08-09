import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static int N,M;
	static int count;
	static char[][] array;
	public static void main(String args[]) throws Exception
	{
//		Scanner sc = new Scanner(new File("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			array = new char[N][M];	// 배열 초기화
			
			for (int i=0; i<N; i++) {
				String line = br.readLine();
				for (int j=0; j<M; j++) {
					array[i][j] = line.charAt(j);
				}
			}
			
			// 러시아 국기를 만들기 위한 최소값 구하기.
			// 중요한거는 w를 몇줄 만들지, B를 몇줄 만들지 , R을 몇줄 만들지를 판단하는 것임.
			
			
			// 첫 줄과 마지막 줄은 반드시 W 와 R 이니깐 생각할 필요가 없고, 그러면 1번줄 ~ 최대 48번 줄까지 (0번줄과 49번줄이 끝) 고민해야하는데.
			// 경계선의 시작점을 1과 48로 만들고, 1칸씩 옮기면서 값을 비교해보면 어떨까?
			// 제일 끝에 있을때 만약 100번 칠해야 했어. 그런데 1칸씩 줄였더니 막 99번 97번 이렇게 줄어. 근데 그래도 끝까지 하긴해야해. 더 줄였는데 최소일수도 있으니까.
			// 반대로 제일 줄여놨는데 100번 칠해야한대. 그런데 조금씩 늘렸더니 칠하는 횟수가 줄어(그럴수있는가?) 당연히 그럴수있지.
			// 그러면... 브루트포스 를 사용해서 전체 탐색을 해야하는데,,, 그러면 startIdx 가 1~47까지 움직이는 동안 endIdx 가 2~48까지 움직여야해.
			// 뭐 더 좋은 생각 없으면 그렇게 해야지.
			
			// 입력값은 다 받았으니까, move startIdx 메서드와 move endIdx 메서드를 구현하면 될것같은데?
			// moveStartIdx 는 그냥 startIdx++ 하면 되잖아.
			
//			int startIdx = 1;	// 0번은 반드시 흰색이니까, boundary를 1부터 잡자.
//			int endIdx = N-1;
			int min = 9999;		// 이 값을 수정해야함
			for (int startIdx=0; startIdx < N-2; startIdx++) {		// startIdx 를 움직이는 반복문
				for (int endIdx = 1; endIdx < N-1 ; endIdx++) {	// endIdx 를 움직이는 반복문
					paintWhite(startIdx);
					paintBlue(startIdx, endIdx);
					paintRed(endIdx);
					min = Math.min(min, count);
					count = 0;				// count 초기화
				}
				
			}
			
			// 1차 오류 : 색칠하고 원래대로 돌려넣지 않음 -> 
			//			ㄴㄴ 나는 색칠을 한적이 없기 때문에(그냥 다른것만 셌음) 이런 에러가 발생하면 안됨. 이유가 다른것임. 11 -> 24, 44 -> 221. 즉 최소값을 잘 찾지 못하고 있는 상황임.
			// 왜 최소값을 잘 찾지 못할까?	count 를 초기화 했는가? 그러지 않았다.
			
			
			
//			System.out.println(Arrays.deepToString(array));
			
			sb.append("#").append(test_case).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	// 0번줄부터 startIdx번 줄 까지 흰색으로 색칠함
	static void paintWhite (int startIdx) {
		
		// startIdx번 줄까지
		for (int r=0; r <= startIdx; r++) {
			for (int c=0; c<M; c++) {	// 가로 길이만큼 반복 (0,1) , (0,2) , ... (0,M-1);
				if (array[r][c] != 'W') count++;
			}
		}
	}
	
	// startIdx 줄부터 endIdx 줄까지 파란색으로 색칠함
	static void paintBlue (int startIdx, int endIdx) {

		// startIdx줄부터 endIdx줄까지
		for (int r = startIdx+1; r <= endIdx; r++) {
			for (int c=0; c<M; c++) {
				if (array[r][c] != 'B') count++;
			}
		}
	}

	// endIdx줄 +1 부터 N-1 번 줄까지 빨간색으로 색칠함
	static void paintRed (int endIdx) {
		
		// endIdx+1 줄 부터, N-1줄까지 색칠
		for (int r = endIdx+1 ; r < N; r++) {
			for (int c=0; c<M; c++) {
				if (array[r][c] != 'R') count++;
			}
		}
	}
	
}