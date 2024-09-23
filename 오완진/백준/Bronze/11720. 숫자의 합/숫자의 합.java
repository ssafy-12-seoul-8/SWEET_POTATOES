import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	String str = sc.next();
    	
    	int sum = 0;
    	for (int n = 0; n < N; n++)
    		sum += str.charAt(n) - '0';
    	
    	System.out.println(sum);
    	
    }
}