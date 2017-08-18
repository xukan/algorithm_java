package algorithm_java;
//Dropbox Google Two Sigma Snapchat
/*
 * 这道题的目的就是每一个cell都能记录下一状态，但是判断都是用的当前状态的值，
 * 举个例子就是在给定状态中board[1][1] = 0,在检查了邻接的值后，知道board[1][1]应该更新为1, 
 * 那么在看board[2][2]的时候,board[1][1]成为了board[2][2]的邻接值，它的值还是0,不是1，
 * 只有在board全部检查完毕后，统一更新所有的值
 * 编码来解决这个问题，高位存储下一状态，看一下编码表
 * count = 邻接1的个数(上下左右对角线共8个邻接值)
 * condition              original  update  encode      real           encode method   
 * count < 2  ||  count >3,  1   -> 0      | 01 =1   | 1->1, 0->0   |  &1
 * count ==2 || count ==3, 1   -> 1      | 11 =3   | 1->3, 0->0   |  &1
 * count = 3,                    0    ->1      | 10 =2   | 0->2, 1->3   |  &1
 * others                          0   -> 0      | 00 =0   |     
 * */
public class GameofLife {
	public static void gameOfLife(int[][] board) {
		int m = board.length;
        int n = board[0].length;
        int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count = 0;
                for(int[] dir: dirs){
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(x<0 || x>=m || y<0 || y>=n)
                        continue;
                    count += (board[x][y]&1);
                }
                if((board[i][j]&1) == 1 && (count == 2 || count ==3))
                    board[i][j] = 3;
                if((board[i][j]&1) ==1 && (count < 2 || count > 3))
                    board[i][j] = 1;
                if((board[i][j]&1) ==0 &&count == 3)
                    board[i][j] = 2;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j]>>=1;    
            }
        }
    }
	
	public static void main(String[] args) {
		int[][] board = {{1,0,1,1,0},
								{0,0,0,1,0},
								{1,0,1,1,0},
								{0,0,0,0,1},
								{1,0,0,1,0}};
//		[[0,0,1,1,0],
//		 [0,0,0,0,1],
//		 [0,0,1,1,1],
//		 [0,1,1,0,1],
//		 [0,0,0,0,0]]
		//[[1,1],[1,0]]
		int m = board.length, n = board[0].length;
		gameOfLife(board);
		for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(board[i][j]+  " ");
            }
            System.out.println();
        }
	}
}
