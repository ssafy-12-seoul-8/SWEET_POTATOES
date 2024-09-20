import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 참가자 수
		int N = sc.nextInt();
		
		// 티셔츠 사이즈 별 신청자의 수
		int[] size = new int[6];
		
		for(int i=0 ; i<6 ; i++) {
			size[i] = sc.nextInt();
		}
		
		// 티셔츠 한 묶음
		int T = sc.nextInt();
		
		// 펜 한 묶음
		int P = sc.nextInt();
		
		int cnt = 0;
		for(int i=0 ; i<6 ; i++) {
			if(size[i]%T==0) {
				cnt += size[i]/T;
			}else {
				cnt += size[i]/T + 1;
			}
		}
		
		System.out.println(cnt+"\n"+N/P+" "+N%P);
		
	}

}

