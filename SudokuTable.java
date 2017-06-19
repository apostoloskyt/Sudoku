
public class SudokuTable {
	static int[][] A = new int[9][9];
	static int row, column; 
	
	
	//we add the number n in A[i][j]
	//The array is initialized with 0's, thus the points not initialized
	//will be the points to be completed
	public static void add(int n, int i, int j){
		A[i][j]=n;
	}
	
	//printing in the requested format
	public static void printTable(){
		int i = 0;
		System.out.println("+-----+-----+-----+");
		for(int j = 0; j < 3; j++){
			for (int k = 0; k< 3; k++){
				System.out.println("|"+ A[i][0] +" "+ A[i][1] +" "+ A[i][2] + "|" + A[i][3] +" "+ A[i][4] +" "+ A[i][5]+ "|" +A[i][6] +" "+ A[i][7] +" "+ A[i][8] + "|");
				i++;
			}
			System.out.println("+-----+-----+-----+");
		}
	}
	
	public static boolean solve(){
		if (!point()){
			//we have reached the end of our table-we have found a solution
			return true;						
		}
		int r,c;
		r = row;
		c = column;
		for (int i = 1; i<10; i++){
			//if the number is good to use then add it
			if ((!exists(i,r,c)) && (!exists_box(i,r,c))){  		
				A[r][c] = i;	
				if (solve()){
					return true;
				}
				A[r][c] = 0;
			}
		}
		//Our last step was mistaken, we have to return to the previous part of our recursion
		return false;									
	}
	
	//we search for an empty point (==0) 
	public static boolean point(){
		for (row = 0; row < 9; row++){
			for (column = 0; column < 9; column++){
				if (A[row][column] == 0){ 
					return true;
				}
			}
		}
		return false;
	}
	
	//we check if the number exists in the current row or column
	public static boolean exists(int n, int r, int c){		
		for(int i = 0; i<9; i++){
			if(A[i][c] == n) return true;
		}
		for(int j = 0; j<9; j++){
			if(A[r][j] == n) return true;
		}
		return false;
	}
	
	//we check if the number exist in its 3x3 square
	public static boolean exists_box(int n, int r, int c){
		//integer division rounds towards zero
		int box_i = r/3;				
		int box_j = c/3;
		for (int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
				if (A[3*box_i+i][3*box_j+j] == n) return true;
			}
		}
		return false;
	}

}
