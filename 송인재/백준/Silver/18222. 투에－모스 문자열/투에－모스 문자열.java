import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());
        
        System.out.println(thueMorse(k - 1));
    }
    
    static long thueMorse(long k) {
        if (k == 0) {
            return 0;
        }
        
        if (k == 1) {
            return 1;
        }
        
        if (k % 2 == 0) {
            return thueMorse(k / 2);
        }
        
        return 1 - thueMorse(k / 2);
    }
    
}