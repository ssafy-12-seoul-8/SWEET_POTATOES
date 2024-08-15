
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static class Robot{
		int idx;
		int time;
		
		
		public Robot(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}
		
	}
    
    public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int t = 1; t <= T; t++)
		{
            // 명령어의 수
			int n = sc.nextInt();
			
			Robot O = new Robot(1,0);
			
			Robot B = new Robot(1,0);
			
			// 시간
			int time = 0;
			
			for(int i=0 ; i<n ;i++) {
				
				String s = sc.next();
				
				if(s.equals("O")) {
					
					int btn = sc.nextInt();
					
					int moveTime = Math.abs(btn - O.idx);
					
					O.idx = btn;
					
					// 전에 O가 버튼을 누른 경우
					O.time = O.time + moveTime + 1;
					
					// 전에 B가 버튼을 누른 경우
					time = time + 1;
					
					time = Math.max(time, O.time);
					
					// 버튼 누른 후 시간 맞춤
					O.time = time;
					

				}
				if(s.equals("B")){
					
					int btn = sc.nextInt();
					
					int moveTime = Math.abs(btn - B.idx);
					
					B.idx = btn;
					
					// 전에 B가 버튼을 누른 경우
					B.time = B.time + moveTime +1;
					
					// 전에 O가 버튼을 누른 경우
					time = time + 1;
					
					time = Math.max(time, B.time);
					
					// 버튼 누른 후 시간 맞춤
					B.time = time;

				}
				
			}
			
			System.out.print("#"+t+" ");
			System.out.println(time);
		}
	}
}