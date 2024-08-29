import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution
{
    static class tank{
		int x;
		int y;
		char status;
		
		// 상 하 좌 우
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		
		
		void act(char cmd){
			switch(cmd) {
			case 'U' :
				this.status = '^';
				move(0);
				break;
			case 'D' :
				this.status = 'v';
				move(1);
				break;
			case 'L' :
				this.status = '<';
				move(2);
				break;
			case 'R' :
				this.status = '>';
				move(3);
				break;
			case 'S' :
				if(this.status=='^') {
					shoot(0);
				}else if(this.status=='v') {
					shoot(1);
				}else if(this.status=='<') {
					shoot(2);
				}else if(this.status=='>'){
					shoot(3);
				}
				break;
			}
		}
		
		void move(int d) {
			int x = this.x;
			int y = this.y;
			
			field[x][y] = '.';
			
			int nx = x + dr[d];
			int ny = y + dc[d];
			
			if(nx>=0 && nx<H && ny>=0 && ny<W && field[nx][ny]=='.') {
				this.x = nx;
				this.y = ny;
				field[nx][ny] = this.status;
			}
			
		}
		
		void shoot(int d) {
			int x = this.x;
			int y = this.y;
			
			int nx = x;
			int ny = y;
			
			
			while(nx>=0 && nx<H && ny>=0 && ny<W){

				
				if(field[nx][ny] == '#') {
					break;
				}
				
				if(field[nx][ny] == '*') {
					field[nx][ny] = '.';
					break;
				}
				
				nx = nx + dr[d];
				ny = ny + dc[d];
				
			}
			
		}
		
	}
	
	static int H;
	static int W;	
	static char[][] field;
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String t = br.readLine();
		int T = Integer.parseInt(t);
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			sb.append("#").append(tc).append(" ");
			
			String hw = br.readLine();
			StringTokenizer st1 = new StringTokenizer(hw);
			
			
			H = Integer.parseInt(st1.nextToken());
			W = Integer.parseInt(st1.nextToken());
			
			field = new char[H][W];
			
			tank newTank = new tank();
						
			for(int i=0 ; i<H ; i++) {
				String f = br.readLine();
				
				for(int j=0 ; j<W ; j++) {
					field[i][j] = f.charAt(j);
					if(field[i][j]=='^' || field[i][j]=='v' || field[i][j]=='<' || field[i][j]=='>') {
						newTank.x = i;
						newTank.y = j;
						newTank.status = field[i][j];
					}
				}
			}
			
			String on = br.readLine();
			int n = Integer.parseInt(on);
			
			String o = br.readLine();
			
			for(int i=0 ; i<n ; i++) {
				char oper = o.charAt(i);
				newTank.act(oper);
			}
            
            field[newTank.x][newTank.y] = newTank.status;
			
			for(int i=0 ; i<H ; i++) {
				for(int j=0 ; j<W ; j++) {
					sb.append(field[i][j]);
				}
				sb.append("\n");
			}
			
			
		}
		
		
		String answer = sb.toString();
		bw.write(answer);
		bw.flush();
		bw.close();
		br.close();
    }
}