import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int a = sc.nextInt();
    	int b = sc.nextInt();
    	int c = sc.nextInt();
    	
    	String str = Integer.toString(a * b * c);
    	char[] charArr = str.toCharArray();
    	
    	for (int i = 0; i <= 9; i++) {
    		int cnt = 0;
    		for (char ch : charArr)
    			if (ch - '0' == i) cnt++;
    		System.out.println(cnt);
    	}
    }
}