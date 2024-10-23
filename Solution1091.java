class Solution {
    private final int[][]DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1},{1,1},{-1,-1},{1,-1},{-1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {    
        int n = grid.length-1;
        //finding the shortest clear path
        if (grid == null || grid[0][0] == 1 || grid[n][n] == 1) return -1;
        //0 is index, 1 is x, 2 is y
        if (n == 0) return 1;
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{1,0,0});
        grid[0][0] = 1;
        
        while (!queue.isEmpty()) {
            int [] cur = queue.poll();
            grid[cur[1]][cur[2]] = 1;
            int dist = cur[0], x = cur[1], y = cur[2];
            for (int[]dir : DIRECTIONS) {
                int newX = x+dir[0];
                int newY = y+dir[1];
                if (newX == n && newY == n) {
                    return dist+1;
                }
                if (newX >= 0 && newX <= n && newY >= 0 && newY <= n && grid[newX][newY] == 0) {
                    grid[newX][newY] = 1;
                    queue.add(new int[]{dist+1, newX, newY});
                }
            }
        }
        return -1;
    }
}
