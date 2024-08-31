import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int L = 1000000;
    static int[] arr = new int[L];
    static int[] temp = new int[L];

    public static void main(String[] args) throws IOException {
        // 백만개의 정수 정렬하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, L - 1);
        System.out.println(arr[L/2]);

    }

    // 병합정렬
    static void mergeSort(int left, int right) {

        // L >= R 이면 끝까지 도달한것.
        if (left >= right)
            return;

        int mid = (left + right) / 2;

        // 왼쪽에서 반으로 나누고
        mergeSort(left, mid);
        // 오른쪽에서 반으로 나누고
        mergeSort(mid + 1, right);

        // 그들을 다시 병합한다.
        merge(left, mid, right);

    }

    static void merge(int left, int mid, int right) {

        // 왼쪽 덩어리의 인덱스는 left
        int leftIndex = left;
        // 오른쪽 덩어리의 인덱스는 mid+1
        int rightIndex = mid + 1;

        // temp 배열의 인덱스는 left부터 시작하면 됨
        int index = left;


        // 덩어리 병합에 성공할때까지
        while (leftIndex <= mid && rightIndex <= right) {
            // 두 덩어리중에 작은 덩어리의 값을 가져옴
            temp[index++] = arr[leftIndex] <= arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }

        // 다 성공했으면, 반드시 한군데는 남음.
        // 왼쪽이 남으면 L <= mid, 오른쪽이남으면 rightIndex <= right

        if (leftIndex <= mid) {
            for (int i = leftIndex; i <= mid; i++) {
                temp[index++] = arr[i];
            }
        } else {
            for (int i = rightIndex; i <= right; i++) {
                temp[index++] = arr[i];
            }
        }
        
        // 원본 배열로 옮기기
        for (int i = left; i<=right; i++) {
            arr[i] = temp[i];
        }

    }
}
