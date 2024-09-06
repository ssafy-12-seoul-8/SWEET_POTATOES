import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int Q = Integer.parseInt(st.nextToken());
		int mod = Integer.parseInt(st.nextToken());
		int count = 0;
		if(Q<mod) {
			for(int i=0;i<Q;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				if(a==1) {
					int b = Integer.parseInt(st.nextToken());
				} 
				else if(a==3) {
					sb.append(-1).append("\n");
				}
			}
			System.out.println(sb);
		}
		else {
			
			Stack<Integer> stack = new Stack<>();
			Stack<Integer>[] check = new Stack[mod];
			for(int i=0;i<mod;i++) {
				check[i]=new Stack<>();
			}
			
			arr = new int[mod*4][3];
			arr[1] = new int[] {-1,0,mod-1};
			start(1,0,mod-1);
			for(int i=0;i<Q;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				if(a==1) {
					int b = Integer.parseInt(st.nextToken());
					b = b%mod;
					stack.push(b);
					check[b].push(count);
					insert(b,count,1,0,mod-1);
					count+=1;
				} else if(a==2) {
					if(stack.isEmpty())
						continue;
					int b = stack.pop();
					check[b].pop();
					int c = 0;
					if(check[b].isEmpty()) {
						c=-1;
					} else {
						c = check[b].peek();
					}
					count-=1;
					insert(b,c,1,0,mod-1);
				} else {
					int c = arr[1][0];
					if(c==-1) {
						sb.append(-1).append("\n");
					} else {
						sb.append(count-arr[1][0]).append("\n");
					}
				}
			}
			System.out.println(sb);
		}
	}
	public static void start(int index, int left, int right) {
		if(left==right) {
			arr[index] = new int[] {-1,left,right};
			return;
		}
		arr[index] = new int[] {-1,left,right};
		int mid = (left+right)/2;
		start(index*2,left,mid);
		start(index*2+1,mid+1,right);
	}
	
	public static void insert(int num, int mini,int index, int start,int end) {
		if(start==end) {
			arr[index][0] = mini;
			return;
		}
		int mid = (start+end)/2;
		if(num<=mid) {
			insert(num,mini,index*2,start,mid);
		} else {
			insert(num,mini,index*2+1,mid+1,end);
		}
		arr[index][0] = Math.min(arr[index*2][0], arr[index*2+1][0]);
		return;
	}
}
