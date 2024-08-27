import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] pipe = new char[R][C];
		int y=0;
		int x=0;
		int dir=0;   // 직전방향 나타냄 0은 왼쪽 1은 위, 2는 오른쪽 3은 아래
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			String str=st.nextToken();
			for(int j=0;j<C;j++) {
				pipe[i][j] = str.charAt(j);
				if(pipe[i][j]=='M') {
					y=i;
					x=j;
				}
			}
		}
		if(0<=y-1 && y-1<R && (pipe[y-1][x]=='|'||pipe[y-1][x]=='+'||pipe[y-1][x]=='1'||pipe[y-1][x]=='4')) {
			dir=1;
			y=y-1;
		}
		else if(0<=y+1 && y+1<R && (pipe[y+1][x]=='|'||pipe[y+1][x]=='+'||pipe[y+1][x]=='2'||pipe[y+1][x]=='3')) {
			dir=3;
			y=y+1;
		}
		else if(0<=x-1 && x-1<C && (pipe[y][x-1]=='-'||pipe[y][x-1]=='+'||pipe[y][x-1]=='1'||pipe[y][x-1]=='2')) {
			dir=0;
			x=x-1;
		} else {
			dir=2;
			x=x+1;
		}
		while(pipe[y][x]!='.') {
			switch (pipe[y][x]) {
				case '|':
					if(dir==1) {
						y=y-1;
					} else {
						y=y+1;
					}
					break;
				case '-':
					if(dir==0) {
						x=x-1;
					} else {
						x=x+1;
					}
					break;
				case '+':
					switch (dir) {
						case 0:
							x=x-1;
							break;
						case 1:
							y=y-1;
							break;
						case 2:
							x=x+1;
							break;
						case 3:
							y=y+1;
							break;
					}
					break;
				case '1':
					if(dir==0) {
						y=y+1;
						dir=3;
					} else {
						x=x+1;
						dir=2;
					}
					break;
				case '2':
					if(dir==3) {
						x=x+1;
						dir=2;
					} else {
						y=y-1;
						dir=1;
					}
					break;
				case '3':
					if(dir==2) {
						y=y-1;
						dir=1;
					} else {
						x=x-1;
						dir=0;
					}
					break;
				case '4':
					if(dir==2) {
						y=y+1;
						dir=3;
					} else {
						x=x-1;
						dir=0;
					}
			}
		}
		int count=0;
		char result='a';
		int[] arr = new int[4];
		if(0<=x-1 && x-1<C && (pipe[y][x-1]=='-'||pipe[y][x-1]=='+'||pipe[y][x-1]=='1'||pipe[y][x-1]=='2')) {
			arr[count]=0;
			count++;
		} 
		if(0<=y-1 && y-1<R && (pipe[y-1][x]=='|'||pipe[y-1][x]=='+'||pipe[y-1][x]=='1'||pipe[y-1][x]=='4')) {
			arr[count]=1;
			count++;
		}
		if(0<=x+1 && x+1<C && (pipe[y][x+1]=='-'||pipe[y][x+1]=='+'||pipe[y][x+1]=='3'||pipe[y][x+1]=='4')){
			arr[count]=2;
			count++;
		}
		if(0<=y+1 && y+1<R && (pipe[y+1][x]=='|'||pipe[y+1][x]=='+'||pipe[y+1][x]=='2'||pipe[y+1][x]=='3')) {
			arr[count]=3;
			count++;
		}
		if (count==4) {
			result = '+';
		} else {
			int a = arr[0]*4+arr[1];
			switch (a) {
				case 1:
					result='3';
					break;
				case 2:
					result='-';
					break;
				case 3:
					result='4';
					break;
				case 6:
					result='2';
					break;
				case 7:
					result='|';
					break;
				case 11:
					result='1';
					break;
			}
		}
		y+=1;
		x+=1;
		System.out.println(y+" "+x+" "+result);
		
	}
}