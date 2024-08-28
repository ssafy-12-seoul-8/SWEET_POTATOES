import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int count = 0;
	static char[][] arr = new char[5][5];
	static boolean[][] visited = new boolean[5][5];
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<5;i++) {
			String str = sc.nextLine();
			for(int j=0;j<5;j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		btk(0,0,0,-1);
		System.out.println(count);
	}
	
	static void btk(int cur,int c_len,int y_count,int start) {	
		if(y_count>=4) {
			return;
		}
		
		if(c_len==7) {
			if(check(start)) {
				count+=1;
			}
			return;
		}
		if(cur==25) {
			return;
		}
		btk(cur+1,c_len,y_count,start);
		int y = cur/5;
		int x = cur%5;
		if(c_len==0) {
			visited[y][x] = true;
			if(arr[y][x]=='Y') {
				btk(cur+1,c_len+1,y_count+1,cur);
			} else {
				btk(cur+1,c_len+1,y_count,cur);
			}
			visited[y][x] = false;
			return;
		} else {
			visited[y][x] = true;
			if(arr[y][x]=='Y') {
				btk(cur+1,c_len+1,y_count+1,start);
			} else {
				btk(cur+1,c_len+1,y_count,start);
			}
			visited[y][x] = false;
			return;
		}
	}
	static boolean check(int start) {
		int count1 = 0;
		int y = start/5;
		int x = start%5;
		boolean[][] visit = new boolean[5][5];
		Queue<int[]> queue =new LinkedList<>();
		queue.add(new int[] {y,x});
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int y1 = tmp[0];
			int x1 = tmp[1];
			if(!visit[y1][x1]) {
				count1+=1;
				visit[y1][x1]=true;
				for(int k=0;k<4;k++) {
					int ny = y1+dy[k];
					int nx = x1+dx[k];
					if(0<=nx && nx<5 && 0<=ny && ny<5 && visited[ny][nx] &&!visit[ny][nx]) {
						queue.add(new int[] {ny,nx});
					}
				}
			}
		}
		if(count1==7) {
			return true;
		} else {
			return false;
		}
	}
}
