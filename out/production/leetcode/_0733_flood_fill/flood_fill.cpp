class Solution {
public:
    /* 深度优先搜索 */
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color)
    {
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    void dfs(vector<vector<int>>& image, int x, int y, int oldColor, int newColor)
    {
        if (x >= image.size() || x < 0 || y >= image[0].size() || y < 0) {
            return;
        }
        if (image[x][y] == newColor || image[x][y] != oldColor) {
            return;
        }
        image[x][y] = newColor;
        dfs(image, x - 1, y, oldColor, newColor);
        dfs(image, x + 1, y, oldColor, newColor);
        dfs(image, x, y - 1, oldColor, newColor);
        dfs(image, x, y + 1, oldColor, newColor);
    }
/*
    /* 广度优先搜索 */
    const int dx[4] = {1, 0, -1, 0};
    const int dy[4] = {0, 1, 0, -1};
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color)
    {
        int oldColor = image[sr][sc];
        if (oldColor == color)
            return image;
        queue<pair<int, int>> que;
        que.emplace(sr, sc);
        image[sr][sc] = color;
        while (!que.empty()) {
            int x = que.front().first, y = que.front().second;
            que.pop();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < image.size() && ny >= 0 && ny < image[0].size() && image[nx][ny] == oldColor) {
                    que.emplace(nx, ny);
                    image[nx][ny] = color;
                }
            }
        }
        return image;
    }
*/
};