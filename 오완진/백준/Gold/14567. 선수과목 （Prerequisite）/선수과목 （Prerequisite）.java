import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] whenPassed = new int[N + 1];					// 이수학기
		boolean[] studied = new boolean[N + 1];				// 수강완료
		List<Integer>[] subject = new ArrayList[N + 1];
		for(int n = 1; n <= N; n++)
			subject[n] = new ArrayList<>();
		
		for (int m = 0; m < M; m++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			subject[b].add(a);
		}
		
		int semester = 1;
		while (true) {
			
			List<Integer> picked = new ArrayList<>();	// 수강과목
			
			for (int n = 1; n <= N; n++) {
				if (studied[n]) continue;
				
				if (subject[n].isEmpty()) {
					picked.add(n);
					whenPassed[n] = semester;
					studied[n] = true;
				}
			}
			
			if (picked.isEmpty()) break;
			
			for (int n = 1; n <= N; n++) {
				if (studied[n]) continue;
				
				subject[n].removeAll(picked);
			}
			
			semester++;
		}
		
        for (int n = 1; n <= N; n++) {
            System.out.print(whenPassed[n] + " ");
        }
	}
}