import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            String line = br.readLine();
            if (line.equals("end"))
                break;
            
            char[][] board = new char[3][3];
            int countX = 0, countO = 0;
            
            for (int i = 0; i < 9; i++) {
                char ch = line.charAt(i);
                board[i/3][i%3] = ch;
                if (ch == 'X') countX++;
                else if (ch == 'O') countO++;
            }
            
            boolean valid = (countX == countO || countX == countO + 1);
            
            boolean winX = false;
            boolean winO = false;
            
            // 가로
            for (int i = 0; i < 3; i++) {
                if (board[i][0] != '.' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                    if (board[i][0] == 'X') winX = true;
                    if (board[i][0] == 'O') winO = true;
                }
            }
            // 세로
            for (int j = 0; j < 3; j++) {
                if (board[0][j] != '.' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                    if (board[0][j] == 'X') winX = true;
                    if (board[0][j] == 'O') winO = true;
                }
            }
            // 대각선
            if (board[0][0] != '.' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                if (board[0][0] == 'X') winX = true;
                if (board[0][0] == 'O') winO = true;
            }
            if (board[0][2] != '.' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                if (board[0][2] == 'X') winX = true;
                if (board[0][2] == 'O') winO = true;
            }
            
            // 동시 Win : invalid
            if (winX && winO)
                valid = false;
            // X Win : X = O + 1
            else if (winX && countX != countO + 1)
                valid = false;
            // O Win : O = X
            else if (winO && countX != countO)
                valid = false;
            // Draw : full
            else if (!winX && !winO && countX + countO != 9)
                valid = false;
            
            sb.append(valid ? "valid" : "invalid").append("\n");
        }
        System.out.print(sb);
    }
}