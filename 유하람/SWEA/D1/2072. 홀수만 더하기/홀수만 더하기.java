
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int t = 1; t <= T; t++)
		{
            int[] arr = new int[10];
            
            int sum = 0;
            
            for(int i=0 ; i<10 ; i++){
                arr[i] = sc.nextInt();
                if(arr[i]%2!=0){
                	sum += arr[i];
                }
            }
            
            
            System.out.print("#"+t+" ");
            System.out.println(sum);
                
		}
	}
}