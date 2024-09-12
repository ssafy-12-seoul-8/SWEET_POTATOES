import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 
        long k = sc.nextLong();
        
        // 1번 시행할 때 마다 길이가 2배씩 늘어난다.
        // K번째 문자를 구하려면, log 2 k 만큼 하면 된다
        
        int result = (int) reduce(k , 0);
        
        System.out.println(result);
        
    }
    
    
    static long reduce(long idx, int count) {
        if (idx == 1) {
            if (count % 2 == 0) return 0;
            else return 1;
        }
        else if (idx == 2) {
            if (count % 2 == 0) return 1;
            else return 0;
        }
        
        int power =  (int) Math.ceil((Math.log(idx) / Math.log(2)))  - 1;    // idx 가 11 일 때, power 는 3
        long newIdx = (idx - (long) Math.pow(2, power));
        count ++;
        return reduce(newIdx, count);
    }
}
