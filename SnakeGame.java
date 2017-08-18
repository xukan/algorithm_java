package algorithm_java;

import java.util.LinkedList;

//Google

//http://www.programcreek.com/2014/08/leetcode-design-snake-game-java/
public class SnakeGame {
	/** Initialize your data structure here.
    @param width - screen width
    @param height - screen height 
    @param food - A list of food positions
    E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
	int row;
	int col;
	int x;
	int y;
	int len;
	int[][] foods;
	int foodIndex;
	LinkedList<int[]> queue;
	//coordinates of snake tail is at front of queue, coordinates of snake head is at end of queue
	public SnakeGame(int width, int height, int[][] food) {
	    row = height;
	    col = width;
	    x = 0;
	    y = 0;
	    len = 0;
	    foods = food;
	    foodIndex = 0;
	    queue = new LinkedList<int[]>();
	    queue.offer(new int[]{0,0});
	}
	
	/** Moves the snake.
	    @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
	    @return The game's score after the move. Return -1 if game over. 
	    Game over when snake crosses the screen boundary or bites its body. */
	public int move(String direction) {
	    switch(direction){
	        case "U":
	            x--;
	            break;
	        case "D":
	            x++;
	            break;
	        case "L":
	            y--;
	            break;
	        case "R":
	            y++;
	            break;
	    }
	    if(!isValid(x, y))
	        return -1;
	    return process(x, y);
	}
	
	public boolean isValid(int x, int y){
	    if(x<0 || x>=row || y<0 || y>=col)
	        return false;
	    return true;
	}
	
	public int process(int x, int y){
	    if(foodIndex < foods.length && foods[foodIndex][0] == x && foods[foodIndex][1] == y){
	        len++;
	        foodIndex++;
	    }else if(queue.size()>0){
	        queue.poll();
	    }
	    for(int[] pos : queue){
	        if(x == pos[0] && y == pos[1])
	            return -1;
	    }
	    queue.offer(new int[]{x, y});
	    return len;
	}
    
    public static void main(String[] args) {
    	int width = 3, height = 2;
    	int[][] food = {{1,2},{0,1}};
    	SnakeGame snake = new SnakeGame(width, height, food);
    	System.out.println(snake.move("R"));
    	System.out.println(snake.move("D"));
    	System.out.println(snake.move("R"));
    	System.out.println(snake.move("U"));
    	System.out.println(snake.move("L"));
    	System.out.println(snake.move("U"));
	}
}
