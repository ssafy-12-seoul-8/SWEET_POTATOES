import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	
    public static void main(String[] args) throws Exception{
    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringBuilder sb = new StringBuilder();
    	
    	String s = br.readLine();
    	int N = Integer.parseInt(s);
    	
    	
    	sb.append(factorial(N));
    	String ans = sb.toString();
    	bw.write(ans);
    	bw.flush();
    	bw.close();
    	br.close();
    	
    }

	static int factorial(int n) {
		
		if(n==0) {
			return 1;
		}
		
		return n*factorial(n-1);
		
		
		
	}
    
    
    
}