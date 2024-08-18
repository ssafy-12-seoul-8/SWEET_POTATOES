
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.List;
import java.util.ArrayList;

class Solution
{
    static class bc{
		int idx;
		int x;
		int y;
		int c;
		int p;
		
		bc(int idx, int x, int y, int c, int p){
			this.idx =idx;
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
			BCs[idx] = this;
		}

		@Override
		public String toString() {
			return "bc [idx=" + idx + ", x=" + x + ", y=" + y + ", c=" + c + ", p=" + p + "]";
		}
		
	}
	
	static class user{
		int x;
		int y;
		int charge = 0;
		int[] route;
		int[] charges;
		
		user(int x, int y){
			this.x = x;
			this.y = y;
		}		
	}
	
	static int M;
	static int A;
	static bc[] BCs;
	static int charge;
	
	static int[] dy = {0,-1,0,1,0};
	static int[] dx = {0,0,1,0,-1};
    
    
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int t = 1; t <= T; t++)
		{
            System.out.print("#"+t+" ");
			
			// 총 이동 시간
			M = sc.nextInt();
			
			// BC의 개수
			A = sc.nextInt();
			BCs = new bc[A];
			
			// 이동 정보 입력
			user user1 = new user(1,1);
			
			user1.route = new int[M+1];
			user1.charges = new int[M+1];
			for(int i=1 ; i<=M ; i++) {
				user1.route[i] = sc.nextInt();
			}
			
			user user2 = new user(10,10);
			
			user2.route = new int[M+1];
			user2.charges = new int[M+1];
			for(int i=1 ; i<=M ; i++) {
				user2.route[i] = sc.nextInt();
			}
			
			// BC 정보 입력
			for(int i=0 ; i<A ; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int c = sc.nextInt();
				int p = sc.nextInt();
				
				bc BC = new bc(i, x, y, c, p);
			}
			
			for(int i=0 ; i<=M ; i++) {
				move(i,user1,user2);
			}
			
//			System.out.println("충전 과정");
//			System.out.println(Arrays.toString(user1.charges));
//			System.out.println(Arrays.toString(user2.charges));
			
			System.out.println(charge);
			charge = 0;
		}
	}
    
    static int dis(bc BC, user User) {
		return Math.abs(BC.x - User.x) + Math.abs(BC.y - User.y);
	}
	
	static void move(int time, user user1, user user2) {
		
		user1.x += dx[user1.route[time]];
		user1.y += dy[user1.route[time]];
		
		user2.x += dx[user2.route[time]];
		user2.y += dy[user2.route[time]];
		
		List<Integer> bcIdx1 = new ArrayList<>();
		List<Integer> bcIdx2 = new ArrayList<>();
		
		for(int i=0 ; i<A ; i++) {
			if(dis(BCs[i],user1) <= BCs[i].c) {
				bcIdx1.add(i);
			}
			if(dis(BCs[i],user2) <= BCs[i].c) {
				bcIdx2.add(i);
			}
		}
		
		int tmpCharge1 = 0;
		int tmpCharge2 = 0;
		
		for(int bc1 : bcIdx1) {
			for(int bc2 : bcIdx2) {
				if(bc1==bc2) {
					tmpCharge1 = BCs[bc1].p;
				}else {
					int tmp1 = BCs[bc1].p;
					int tmp2 = BCs[bc2].p;
					tmpCharge2 = Math.max(tmpCharge2, tmp1+tmp2);
				}
			}
		}
		
		if(bcIdx1.isEmpty()) {
			for(int bc2 : bcIdx2) {
				user2.charge = Math.max(user2.charge, BCs[bc2].p);
				tmpCharge2 = user2.charge;
			}
		}else if(bcIdx2.isEmpty()) {
			for(int bc1 : bcIdx1) {
				user1.charge = Math.max(user1.charge, BCs[bc1].p);
				tmpCharge2 = user1.charge;
			}
		}
		
//		user1.charges[time] = user1.charge;
//		user2.charges[time] = user2.charge;
		
		charge += Math.max(tmpCharge1, tmpCharge2);
		user1.charge = 0;
		user2.charge = 0;
		
	}
    
}