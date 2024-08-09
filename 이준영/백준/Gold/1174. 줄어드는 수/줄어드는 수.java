import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int check=1;
	static long answer = -1;
	static int[] arr= {9,98,987,9876,98765,987654,9876543,98765432,987654321};
	static int[] arr2= {1,10,210,3210,43210,543210,6543210,76543210,876543210};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if (n==1) {
			System.out.println(0);
		}else if(n>=1024){
			System.out.println(-1);
		}else {
			btk(1,1,n);
			System.out.println(answer);
		}
	}

	static void btk(int num_len,int now_num,int last_num) {
		if (now_num==987654321) {
			check+=1;
			if (last_num==check) {
				answer = now_num;
				return;
			} else if(last_num==check+1) {
				answer = 9876543210L;
				return;
			} else {
				return;
			}
		}
		if (num_len==1) {
			check+=1;
			if (check==last_num) {
				check+=1;
				answer = now_num;
				return;
			} else if(check>last_num){
				return;
			} else if(now_num==9){
				for (int i=1;i<=9;i++) {
					btk(2,i,last_num);
				}
				return;
			} else {
				btk(num_len,now_num+1,last_num);
				return;
			}
		}
		if (arr2[num_len-1]<=now_num &&now_num<=arr[num_len-1]) {
			check+=1;
			if (check==last_num) {
				answer = now_num;
				return;
			} else if(check>last_num){
				return;
			} else if(now_num==arr[num_len-1]){
				for(int i=num_len;i<=9;i++) {
					btk(num_len+1,i,last_num);
				}
				return;
			}
		}
		for (int i=0;i<now_num%10;i++) {
			btk(num_len,now_num*10+i,last_num);
		}	
		return;
	}
}
