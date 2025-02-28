import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    static int N;
    static int[] arr, idx;
    static long sm = 0;
    static List<Integer>[] arr2;
    static long[][] sumSeg;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        idx = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> tempArr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            tempArr.add(arr[i]);
        }


        // Compute LIS and index mapping
        List<Integer> lst = new ArrayList<>();
        lst.add(arr[0]);
        for (int i = 1; i < N; i++) {
            int t = arr[i];
            int start = 0;
            int end = lst.size()-1;
            if (lst.get(lst.size() - 1) < t) {
                lst.add(t);
                idx[i] = lst.size() - 1;
            } else if (lst.get(0)>=t){
                lst.set(0,t);
                idx[i] = 0;
            }else{
                while (end-start>1){
                    int mid = (start+end)/2;
                    if (lst.get(mid) <t){
                        start = mid;
                    } else {
                        end = mid;
                    }
                }
                lst.set(end,t);
                idx[i] = end;
            }
        }
        int l = lst.size();
        if (l==1){
            System.out.println(1+" "+N);
        } else{
        // Initialize arr2 and sumSeg
        arr2 = new ArrayList[l];
        sumSeg = new long[l - 1][];
        for (int i = 0; i < l; i++) {
            arr2[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            arr2[idx[i]].add(i);
        }
        for (int i = 0; i < l - 1; i++) {
            sumSeg[i] = new long[4 * arr2[i].size()];
        }

        long ans = 0;
        for (int i = 0; i < N; i++) {
            int tmp = idx[i];
            if (tmp > 0) {
                sm = 0;
                find(0, arr2[tmp - 1].size() - 1, i - 1, arr2[tmp - 1], sumSeg[tmp - 1], arr[i], 1);
                if (tmp == l - 1) {
                    ans = (ans + sm) % MOD;
                } else {
                    changeInfo(0, arr2[tmp].size() - 1, sumSeg[tmp], arr2[tmp], i, sm, 1);
                }
            } else {
                sm = 1;
                changeInfo(0, arr2[0].size() - 1, sumSeg[0], arr2[0], i, sm, 1);
            }
        }
        System.out.println(l + " " + ans);
        }
    }

    static void find(int left, int right, int fRight, List<Integer> ar2, long[] smSeg, int value, int index) {
        if (left > right || ar2.isEmpty() || index >= smSeg.length) return;
        if (ar2.get(left) > fRight) return;
        if (arr[ar2.get(right)] >= value) return;

        if (ar2.get(right) <= fRight && arr[ar2.get(left)] < value) {
            sm = (sm + smSeg[index]) % MOD;
            return;
        }

        if (left == right) {
            sm = (sm + smSeg[index]) % MOD;
            return;
        }

        int mid = (left + right) / 2;
        find(left, mid, fRight, ar2, smSeg, value, index * 2);
        find(mid + 1, right, fRight, ar2, smSeg, value, index * 2 + 1);
    }

    static void changeInfo(int left, int right, long[] smSeg, List<Integer> ar2, int target, long value, int index) {
        if (left > right || ar2.isEmpty() || index >= smSeg.length) return;
        if (ar2.get(left) > target || ar2.get(right) < target) return;

        if (left == right) {
            smSeg[index] = (smSeg[index] + value) % MOD;
            return;
        }

        smSeg[index] = (smSeg[index] + value) % MOD;
        int mid = (left + right) / 2;

        changeInfo(left, mid, smSeg, ar2, target, value, index * 2);
        changeInfo(mid + 1, right, smSeg, ar2, target, value, index * 2 + 1);
    }
}
