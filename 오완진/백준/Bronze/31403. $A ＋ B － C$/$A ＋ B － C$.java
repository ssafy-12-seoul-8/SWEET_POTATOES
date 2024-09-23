import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int a = sc.nextInt();
    	int b = sc.nextInt();
    	int c = sc.nextInt();
    	
    	String str = "";
    	str += a;
    	str += b;
    	int intint = Integer.parseInt(str);
    	
    	System.out.println(a + b - c);
    	System.out.println(intint - c);
    	
    }
}