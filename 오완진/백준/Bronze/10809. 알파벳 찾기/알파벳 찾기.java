import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int[] alphabet = new int[26];
        for (int i = 0; i < 26; i++)
            alphabet[i] = -1;
    	
    	String str = sc.nextLine();
    	char[] charArr = str.toCharArray();
    	
    	for (int i = 0; i < charArr.length; i++) {
    		char ch = charArr[i];
    		
    		if (alphabet[ch - 'a'] == -1)
    			alphabet[ch - 'a'] = i;
    	}
    	
    	for (int a : alphabet)
    		System.out.print(a + " ");
    	
    }
}