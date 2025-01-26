import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static String S, T;
	static int result = 0;
	
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	S = br.readLine();
    	T = br.readLine();
    	
    	canMake(S, T, T.length() - 1);
    	
    	System.out.println(result);
    }
    
    static void canMake(String s, String t, int cnt) {
    	
    	if (s.length() == t.length()) {
    		
    		if (s.equals(t))
    			result = 1;
    		
    		return;
    	}
    	
    	if (t.charAt(cnt) == 'A')
    		canMake(s, t.substring(0, cnt), cnt - 1);
    	
    	StringBuilder tmp = new StringBuilder(t).reverse();
    	if (tmp.charAt(cnt) == 'B')
    		canMake(s, tmp.substring(0, cnt), cnt - 1);
    }
}