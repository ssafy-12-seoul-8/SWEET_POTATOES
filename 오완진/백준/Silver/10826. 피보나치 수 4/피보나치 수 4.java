import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    
    static BigInteger N;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        N = sc.nextBigInteger();
        
        BigInteger[] result = fibo(N);
        System.out.println(result[0]);
    }
    
    static BigInteger[] fibo(BigInteger n) {
        if (n.equals(BigInteger.ZERO))
            return new BigInteger[] {BigInteger.ZERO, BigInteger.ONE};

        BigInteger[] newFibb = fibo(n.divide(BigInteger.valueOf(2)));
        
        BigInteger fbK = newFibb[0];
        BigInteger fbKplus1 = newFibb[1];
        
        BigInteger fb2K = fbK.multiply(BigInteger.valueOf(2).multiply(fbKplus1).subtract(fbK));
        BigInteger fb2Kplus1 = fbKplus1.multiply(fbKplus1).add(fbK.multiply(fbK));
        
        if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO))
            return new BigInteger[] {fb2K, fb2Kplus1};
        else
            return new BigInteger[] {fb2Kplus1, fb2K.add(fb2Kplus1)};
    }
}