

/*Count number of query words in grid

*/


static char[] word={'S','N','A','K','E','S'};
 static char[][] grid= new char[4][5];
 static int count=0;

public static void countwords(char[][] grid, int i,int j,int index){
	
	if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1){
		return;		
	}
	
	if(index==word.length-1){
		count++;
                index=0;
                return;
	}
	
	if(grid[i][j]==word[index]){
		
		if(i>0 && grid[i-1][j]==word[index+1]){
			countwords(grid, i-1,j,index+1);
		}
		if( i<4-1 && grid[i+1][j]==word[index+1]){
			countwords(grid, i+1,j, index+1);
		}
		if(j>0 && grid[i][j-1]==word[index+1]){
			countwords(grid,i,j-1, index+1);
		}
		if(j<5-1 && grid[i][j+1]==word[index+1]){
			countwords(grid,i,j+1, index+1);
		}
		
	}
	
	
}

public static void main(String[] args){
	 grid[0][0] = 'S';
grid[0][1] = 'N';
grid[0][2]= 'B';
grid[0][3]='S';
grid[0][4]='N';

grid[1][0]='B';
grid[1][1]='A';
grid[1][2]='K';
grid[1][3]='E';
grid[1][4]='A';

grid[2][0]='B';
grid[2][1]='K';
grid[2][2]='B';
grid[2][3]='B';
grid[2][4]='K';

grid[3][0]='S';
grid[3][1]='E';
grid[3][2]='B';
grid[3][3]='S';
grid[3][4]='E';

for(int row=0;row<4;row++){
    for(int col=0;col<5;col++){
       countwords(grid, row,col,0); 
       
    }
}
System.out.println(count);


}