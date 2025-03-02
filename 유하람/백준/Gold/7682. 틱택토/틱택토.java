import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  1) x == y+1
 *  1-1) x is ok && o is not ok
 *  1-2) x+o == 9
 *  2) x == y
 *  2-1) o is ok && x is not ok
 */

public class Main {

    static char[] chars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();

        while(!"end".equals(line)) {
            chars = line.toCharArray();

            int x = 0;
            int o = 0;

            for(char c : chars) {
                if('X'==c){
                    x++;
                }else if('O'==c){
                    o++;
                }
            }

            if(x == o+1){
                if(x+o==9 && !check('O')){
                    sb.append("valid\n");
                }
                else if(!check('O') && check('X')){
                    sb.append("valid\n");
                }
                else{
                    sb.append("invalid\n");
                }
            }

            else if(x == o){
                if(!check('X') && check('O')){
                    sb.append("valid\n");
                }
                else{
                    sb.append("invalid\n");
                }
            }

            else{
                sb.append("invalid\n");
            }

            line = br.readLine();
        }

        System.out.println(sb);
    }

    public static boolean check(char c){
        for(int i=0  ; i<3 ; i++){
            if(chars[i] == c && chars[i+3] == c && chars[i+6] == c){
                return true;
            }

            if(chars[i*3]==c && chars[i*3+1]==c && chars[i*3+2]==c){
                return true;
            }

            if(chars[0] == c && chars[4] == c && chars[8] == c){
                return true;
            }

            if(chars[2] == c && chars[4] == c && chars[6] == c){
                return true;
            }

        }
        return false;
    }
}