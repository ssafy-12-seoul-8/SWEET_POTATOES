import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] count;
	static int max_result= -1000000001;
	static int min_result= 1000000001;
	static int N=0;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		count = new int[4];
 		st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			count[i]=Integer.parseInt(st.nextToken());
		}
		btk(0,arr[0]);
		System.out.println(max_result);
		System.out.println(min_result);
		
	}
	public static void btk(int cur,int result) {
		if (cur==N-1) {
			max_result=Math.max(max_result,result);
			min_result=Math.min(min_result,result);
			return;
		}
		for(int i=0;i<4;i++) {
			if(count[i]!=0) {
				count[i]-=1;
				switch (i) {
					case 0: 
						btk(cur+1,result+arr[cur+1]);
						break;
					case 1: 
						btk(cur+1,result-arr[cur+1]);
						break;
					case 2: 
						btk(cur+1,result*arr[cur+1]);
						break;
					case 3: 
						btk(cur+1,result/arr[cur+1]);
						break;
				}
				count[i]+=1;
			}
		}
		return;
	}
}
