import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for (int tc = 1; tc <= 10; tc++) {

        	LinkedList<Integer> amho = new LinkedList<>();
        	// 원본 암호문 입력
        	int N = sc.nextInt();
        	for (int n = 0; n < N; n++) {
        		amho.add(sc.nextInt());
        	}
        	// 명령어 입력
        	int M = sc.nextInt();
        	sc.nextLine();
        	for (int m = 0; m < M; m++) {
        		
        		sc.next();				// (구분용) I 입력
        		int X = sc.nextInt();	// 원본 암호문에 삽입할 인덱스
        		int Y = sc.nextInt();	// 원본 암호문에 삽입할 숫자 개수
        		ArrayList<Integer> newAmho = new ArrayList<>();	// 얘가 S
        		for (int y = 0; y < Y; y++) {
        			newAmho.add(sc.nextInt());
        		}
        		
        		int S = newAmho.size();
        		for (int s = 0; s < S; s++) {
        			amho.add(X+s, newAmho.get(s));
        		}
        		
        	}
        	
        	System.out.print("#" + tc + " ");
        	for (int n = 0; n < 10; n++) {
        		System.out.print(amho.get(n) + " ");
        	}
        	System.out.println();
        	
        }
        
    }
}