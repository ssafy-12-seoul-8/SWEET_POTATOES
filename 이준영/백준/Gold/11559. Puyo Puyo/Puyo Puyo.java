import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] field;
	static boolean[][] visited;
	static boolean check;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		field = new char[12][6];
		int time = 0;
		
		for(int i=0;i<12;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0;j<6;j++) {
				field[i][j] = str.charAt(j);
			}
		}
		
		while(true) {
			visited = new boolean[12][6];
			check = false;
			for(int i=0;i<12;i++) {
				for(int j=0;j<6;j++) {
					if(field[i][j]!='.'&& !visited[i][j]) {
						bfs(i,j,field[i][j]);
					}
				}
			}
			if(!check) {
				break;
			} else {
				time+=1;
				for(int j=0;j<6;j++) {
					Stack<Character> stack = new Stack<>();
					for(int i=0;i<12;i++) {
						if(field[i][j]!='.') {
							stack.push(field[i][j]);
							field[i][j] = '.';
						}
					}
					int size = 11;
					while(!stack.isEmpty()) {
						field[size--][j] = stack.pop();
					}
				}
			}	
		}
		System.out.println(time);
	}
	static void bfs(int y, int x,char color) {
		ArrayList<int[]> lst = new ArrayList<>();
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {y,x});
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int t_y = tmp[0];
			int t_x = tmp[1];
 			if(!visited[t_y][t_x]) {
 				visited[t_y][t_x] = true;
 				lst.add(new int[] {t_y,t_x});
 				for(int k=0;k<4;k++) {
 					int ny = t_y + dy[k];
 					int nx = t_x + dx[k];
 					if(0<=nx && nx<6 && 0<=ny && ny<12 && field[ny][nx] == color) {
 						queue.add(new int[] {ny,nx});
 					}
 				}
 			}
		}
		if(lst.size()<4) {
			return;
		}
		for(int[] tmp:lst ) {
			field[tmp[0]][tmp[1]] = '.';
		}
		check = true;
	}
}
