import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    static int N;
    static int M;
    static int[] arr;
    static List<int[]> list = new ArrayList<>();
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        arr = new int[N];
        for(int i=0 ; i<N ; i++){
            arr[i] = i+1;
        }
        
        int[] datas = new int[M];
        
        NM(0,0,datas);
        
        for(int[] data : list){
            for(int i : data){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        
    }
    static void NM(int i, int idx, int[] data){
        if(idx==M){
            list.add(data.clone());
            return;
        }
        if(i==N){
            return;
        }
        data[idx] = arr[i];
        NM(i+1, idx+1, data);
        NM(i+1, idx, data);
        
        
    }
    
}