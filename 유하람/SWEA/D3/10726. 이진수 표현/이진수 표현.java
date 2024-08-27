import java.util.Scanner;
import java.io.FileInputStream;
 
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
    Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for(int tc=1 ; tc<=T ; tc++) {
             
            System.out.print("#"+tc+" ");
             
            int N = sc.nextInt();
            int M = sc.nextInt();
             
            int num = (int) (M %(Math.pow(2, N)));
             
            if(num!=Math.pow(2, N)-1) {
                System.out.println("OFF");
            }else {
                System.out.println("ON");
            }
             
        }
    }
}