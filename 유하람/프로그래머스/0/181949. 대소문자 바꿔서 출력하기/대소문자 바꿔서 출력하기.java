import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        for(int i=0 ; i<a.length() ; i++){
            if(!Character.isUpperCase(a.charAt(i))){
                System.out.print(Character.toUpperCase(a.charAt(i)));
            } else {
                System.out.print(Character.toLowerCase(a.charAt(i)));
                
            }
        }
    }
}