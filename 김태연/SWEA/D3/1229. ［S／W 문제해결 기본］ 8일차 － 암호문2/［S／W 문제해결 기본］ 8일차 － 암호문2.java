import java.util.Scanner;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;
 
        for (int test_case = 1; test_case <= T; test_case++) {
 
            int N = sc.nextInt(); // 193
            int[] password = new int[N];
 
            // 원본 패스워드 받기
            for (int i = 0; i < N; i++) {
                password[i] = sc.nextInt();
            }
 
            int M = sc.nextInt(); // 초록색 숫자 (10~20)
 
            // 명령문 반복
            for (int i = 0; i < M; i++) {
                String command = sc.next(); // I 버림
                switch (command.charAt(0)) {
 
                case 'I': {
                    int idx = sc.nextInt(); // idx 번호 받음 // 19
                    int K = sc.nextInt(); // 길이 K 의 숫자 배열 생성 // 4
 
                    int[] insertedPassword = new int[password.length + K];
                    
                    for (int j = 0; j< idx; j++) {
                    	insertedPassword[j] = password[j];	// password[idx-1] 까지 복사했음
                    }
                    
                    for (int j = idx; j < idx+K; j++) {
                    	insertedPassword[j] = sc.nextInt();
                    }
 
                    for (int j = idx + K; j < password.length + K; j++) {
                        insertedPassword[j] = password[j - K];	// password[idx] 부터 복사해야함
                    }
                    
                    password = insertedPassword;
                }
                    break;
                case 'D': {
                    int idx = sc.nextInt();
                    int K = sc.nextInt();
                    
                    // 기존의 길이에서 K 만큼 빠짐
                    int[] deletedPassword = new int[password.length - K];
                    
                    // 삭제하는 구간 앞 부분 복사
//                    int minIdx = Math.min(test_case, password.length);	// 이 부분 손봐보자.
                    for (int j=0; j<idx; j++) {
                    	deletedPassword[j] = password[j];
                    }
                    
                    // 삭제하는 구간 뒷 부분 복사
                    for (int j = idx; j < password.length-K; j++) {
                    	deletedPassword[j] = password[j+K];
                    }
                    
                    password = deletedPassword;	// 짧아진 패스워드로 대체
                    
                }
                    break;
 
                }
            }
 
            System.out.print("#" + test_case);
            for (int i = 0; i < 10; i++) {
                System.out.print(" " + password[i]);
            }
            System.out.println();
        }
    }
}
