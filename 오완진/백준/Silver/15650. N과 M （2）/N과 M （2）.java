import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int start = 1;
        List<Integer> showN = new ArrayList<>();

        pickN(N, M, start, showN);				// 1
    }
    
    static void pickN(int N, int M, int start, List<Integer> showN) {
    	
    	if (showN.size() == M) {				// 2
    		for (int num : showN)
    			System.out.print(num + " ");
    		System.out.println();
    		return;
    	}
    	
    	for (int i = start; i <= N; i++) {		// 3
    		showN.add(start++);					// 4
    		pickN(N, M, start, showN);			// 5
    		showN.remove(showN.size() - 1); 	// 6
    	}
    	
    }
    
}

/*
 * 	이틀동안 캔 굉장한 고구마
 *  for문은 백트래킹(=체크포인트?) 역할
 * 	Ex. N = 3 / M = 2
 * 
 *  1	pickN(3, 2, 1, [])
 *  
 *  3	for i(start)=1 ~ 3
 *  4		showN.add(1)
 *  		start = 2
 *  5		pickN(3, 2, 2, [1])
 *  
 *  3		for i(start)=2 ~ 3
 *  4			showN.add(2)
 *  			start = 3
 *  5			pickN(3, 2, 3, [1,2])	-> 배열크기=M
 *  
 *  2				sysout [1,2]
 *  				return
 *  
 *  6			showN.remove(2)
 *  
 *  3		for i(start)=3 ~ 3
 *  4			showN.add(3)
 *  			start = 4
 *  5			pickN(3, 2, 4, [1,3])	-> 배열크기=M
 *  
 *  2				sysout [1,3]
 *  				return
 *  
 *  6			showN.remove(3)			-> for문 실행x = 이전단계로간다
 *  6			showN.remove(1)
 *  
 *  3	for i(start)=2 ~ 3
 *  4		showN.add(2)
 *  		start = 3
 *  5		pickN(3, 2, 3, [2])
 *  
 *  3		for i(start)=3 ~ 3
 *  4			showN.add(3)
 *  			start = 4
 *  5			pickN(3, 2, 4, [2,3])	-> 배열크기=M
 *  
 *  2				sysout [2,3]
 *  				return
 *  
 *  6			showN.remove(3)			-> for문 실행x = 이전단계로간다
 *  6			showN.remove(2)
 *  
 *  3	for i(start)=3 ~ 3
 *  4		showN.add(3)
 *  		start = 4
 *  4		pickN(3, 2, 4, [3])
 *  
 *  6	showN.remove(3)
 */