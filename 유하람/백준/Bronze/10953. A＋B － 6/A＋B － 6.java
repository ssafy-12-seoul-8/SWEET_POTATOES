import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); 
        for (int t = 0; t < T; t++) {
            String input = br.readLine(); 
            String[] numbers = input.split(","); 
            int num1 = Integer.parseInt(numbers[0]); 
            int num2 = Integer.parseInt(numbers[1]); 
            System.out.println(num1 + num2); 
        }
    }
}
