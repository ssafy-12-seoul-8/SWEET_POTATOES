import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int valExt, String sortBy) {
                
        // 조건 충족 code idx 추출
        List<int[]> filteredIdxArr = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (ext.equals("code")      && data[i][0] < valExt)
                filteredIdxArr.add(data[i]);
            else if (ext.equals("date")      && data[i][1] < valExt)
                filteredIdxArr.add(data[i]);
            else if (ext.equals("maximum")   && data[i][2] < valExt)
                filteredIdxArr.add(data[i]);
            else if (ext.equals("remain")    && data[i][3] < valExt)
                filteredIdxArr.add(data[i]);
        }
        
        // 정렬 기준 idx
        int sortIdx = 0;
        if (sortBy.equals("code"))
            sortIdx = 0;
        else if (sortBy.equals("date"))
            sortIdx = 1;
        else if (sortBy.equals("maximum"))
            sortIdx = 2;
        else if (sortBy.equals("remain"))
            sortIdx = 3;
        
        // 조건 충족 code idx -> 조건 충족 data[][]
        int n = filteredIdxArr.size();
        int[][] filteredData = new int[n][4];
        for (int i = 0; i < n; i++){
            filteredData[i] = filteredIdxArr.get(i);
        }
        // for (int i = 0; i < n; i++){
        //     for (int j = 0; j < 4; j++){
        //         filteredData[i][j] = data[i][j];
        //     }
        // }
        
        // 정렬
        int[][] orderedData = new int[n][4];
        orderedData = Sort.selectionSort(filteredData, sortIdx);
        
        return orderedData;            
    }
}

class Sort {    // sortNum : 0 = code, 1 = date, 2 = maximum, 3 = remain
    public static int[][] selectionSort(int[][] data, int sortIdx){
        
        int n = data.length;
        // int[][] result = new int[n][4];
        for (int i = 0; i < n; i++){
            int minIdx = i;
			for (int j = i+1; j < n; j++) {
				if (data[minIdx][sortIdx] > data[j][sortIdx])
					minIdx = j;
            }
            // 추가
            int[] tmp = data[i];
            data[i] = data[minIdx];
            data[minIdx] = tmp;
            // for (int k = 0; k < 4; k++){
            // int tmp = data[i][k];
            // data[i][k] = data[minIdx][k];
            // data[minIdx][k] = tmp;
            // }
        }
        // for (int i = 0; i < n; i++){
        //     for (int j = 0; j < 4; j++){
        //         result[i][j] = data[i][j];
        //     }
        // }
        
        return data;
    }
}