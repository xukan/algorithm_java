package algorithm_java;

public class BombEnemy {
	public static int maxKilledEnemies(char[][] grid) {
        if(grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count = 0;
                if(grid[i][j] == '0'){
                    for(int r=0;r<m;r++){
                        if(r == i)
                            continue;
                        if(grid[r][j] == 'W')
                            break;
                        if(grid[r][j] == 'E')
                            count++;
                    }
                    for(int c=0;c<n;c++){
                        if(c == j)
                            continue;
                        if(grid[i][c] == 'W')
                            break;
                        if(grid[i][c] == 'E')
                            count++;
                    }
                    max = Math.max(max, count);    
                }
            }
        }
        return max;
    }
	
	public static void main(String[] args) {
		char[][] grid= {{'W','E','W','0','E'}};
		int res = maxKilledEnemies(grid);
		System.out.println(res);
	}
}
