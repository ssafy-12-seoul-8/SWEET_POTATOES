import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] inorder, postorder, indexs;
    static List<Integer> preorder;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        inorder = new int[N];
        postorder = new int[N];
        preorder = new ArrayList<>();
        indexs = new int[N + 1]; // 값에 대한 inorder 인덱스 저장

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            inorder[i] = num;
            indexs[num] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        findRoot(0, N - 1, 0, N - 1);

        for (int i : preorder) {
            System.out.print(i + " ");
        }
    }

    private static void findRoot(int iStart, int iEnd, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd) return;

        int root = postorder[pEnd]; // postorder의 마지막 값은 루트
        preorder.add(root);

        int rootIndex = indexs[root]; // inorder에서 루트의 인덱스
        int leftSize = rootIndex - iStart; // 왼쪽 서브트리 크기

        // 왼쪽 서브트리
        findRoot(iStart, rootIndex - 1, pStart, pStart + leftSize - 1);

        // 오른쪽 서브트리
        findRoot(rootIndex + 1, iEnd, pStart + leftSize, pEnd - 1);
    }
}
