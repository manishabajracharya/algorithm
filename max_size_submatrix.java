
/*
Given a binary matrix, find out the maximum size square sub-matrix with all 1s.

For example, consider the below binary matrix.

 
   0  1  1  0  1 
   1  1  0  1  0 
   0  1  1  1  0
   1  1  1  1  0
   1  1  1  1  1
   0  0  0  0  0
The maximum square sub-matrix with all set bits is

    1  1  1
    1  1  1
    1  1  1
Algorithm:
Let the given binary matrix be M[R][C]. The idea of the algorithm is to construct an auxiliary size matrix S[][] in which each entry S[i][j] represents size of the square sub-matrix with all 1s including M[i][j] where M[i][j] is the rightmost and bottommost entry in sub-matrix.

1) Construct a sum matrix S[R][C] for the given M[R][C].
     a)	Copy first row and first columns as it is from M[][] to S[][]
     b)	For other entries, use following expressions to construct S[][]
         If M[i][j] is 1 then
            S[i][j] = min(S[i][j-1], S[i-1][j], S[i-1][j-1]) + 1
         Else /*If M[i][j] is 0*/
            S[i][j] = 0
2) Find the maximum entry in S[R][C]
3) Using the value and coordinates of maximum entry in S[i], print 
   sub-matrix of M[][]
For the given M[R][C] in above example, constructed S[R][C] would be:

   0  1  1  0  1
   1  1  0  1  0
   0  1  1  1  0
   1  1  2  2  0
   1  2  2  3  1
   0  0  0  0  0


*/


public class Max_Size_Submatrix{
    

public static void main(String[] args) throws java.lang.Exception {

int [][] boolArr={{0,1,1,0,1},{1,1,0,1,0},{0,1,1,1,0},{1,1,1,1,0},{1,1,1,1,1},{0,0,0,0,0}};
int row = boolArr.length;
int col = boolArr[0].length;
int[][] sum_arr = new int[row][col];

for(int i=0;i<row;i++){
	sum_arr[i][0]=boolArr[i][0];	
}
for(int i=0;i<col;i++){
	sum_arr[0][i] = boolArr[0][i];	
}
int max_sum = sum_arr[0][0];
int x=0,y=0;
for(int i=1;i<row;i++){
	for(int j=1;j<col;j++){
            if(boolArr[i][j]==1){
		sum_arr[i][j]=Math.min(Math.min(sum_arr[i][j-1], sum_arr[i-1][j]), sum_arr[i-1][j-1])+1;
		if(max_sum<sum_arr[i][j]){
			max_sum = sum_arr[i][j];
			x=i; y=j;
		}
            }
            else{
                sum_arr[i][j]=0;
            }
	}
	
}

System.out.println("top left is:"+(x-max_sum+1) + ", "+ (y-max_sum+1));
System.out.println("bottom right is:"+x+", "+y);

        }
    }