#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int R, C, K;
vector<vector<int>> arr;
vector<vector<vector<int>>> cnt;

// U R D L
tuple<int, int> moves[12] = {
    {-1, 0}, {0, 1}, {1, 0}, {0, -1},
    {-1, 0}, {0, 1}, {1, 0}, {0, -1},
    {-1, 0}, {0, 1}, {1, 0}, {0, -1}
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> R >> C >> K;
    arr.resize(R, vector<int>(C));
    cnt.resize(R, vector<vector<int>>(C, vector<int>(K + 1, K + 1)));

    for (int i = 0; i < R; i++) {
        string row;
        cin >> row;
        for (int j = 0; j < C; j++) {
            switch (row[j]) {
                case 'U': arr[i][j] = 4; break;
                case 'R': arr[i][j] = 5; break;
                case 'D': arr[i][j] = 6; break;
                case 'L': arr[i][j] = 7; break;
            }
        }
    }

    if (K >= (R + C - 1) * 2) {
        cout << "Yes" << endl;
        return 0;
    }

    priority_queue<tuple<int, int, int, int>, vector<tuple<int, int, int, int>>, greater<>> pq;
    cnt[0][0][0] = 0;
    pq.emplace(0, 0, 0, 0);

    bool flag = false;

    while (!pq.empty()) {
        auto [l_cnt, r_cnt, y, x] = pq.top();
        pq.pop();

        if (y == R - 1 && x == C - 1) {
            flag = true;
            break;
        }

        if (cnt[y][x][l_cnt] < r_cnt) continue;

        int cur = arr[y][x];
        for (int k = 0; k <= min(K - r_cnt, 3); k++) {
            int ny = y + get<0>(moves[cur + k]);
            int nx = x + get<1>(moves[cur + k]);
            if (ny >= 0 && ny < R && nx >= 0 && nx < C && cnt[ny][nx][l_cnt] > r_cnt + k) {
                cnt[ny][nx][l_cnt] = r_cnt + k;
                pq.emplace(l_cnt, r_cnt + k, ny, nx);
            }
        }

        for (int k = 1; k <= min(K - l_cnt, 3); k++) {
            int ny = y + get<0>(moves[cur - k]);
            int nx = x + get<1>(moves[cur - k]);
            if (ny >= 0 && ny < R && nx >= 0 && nx < C && cnt[ny][nx][l_cnt + k] > r_cnt) {
                cnt[ny][nx][l_cnt + k] = r_cnt;
                pq.emplace(l_cnt + k, r_cnt, ny, nx);
            }
        }
    }

    cout << (flag ? "Yes" : "No") << endl;
    return 0;
}
