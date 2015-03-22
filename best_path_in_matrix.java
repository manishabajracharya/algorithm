public class BestPathinMatrix{

public static int getmax(int i,int j)    {
if(i==m-1 && j==n-1){
    return matrix[i][j];
}
if(i==m-1){
    return (getmax(i,j+1)+matrix[i][j]);
}
if(j==n-1){
    return (getmax(i+1,j)+matrix[i][j]);
}

return Math.max(getmax(i+1,j), getmax(i,j+1))+matrix[i][j];

}
    
    
static int[][] matrix; 
static int m,n;
static int bestPath(String[] strMatrix) {

String[] temp = strMatrix[0].split(",");
m=strMatrix.length;
n=temp.length;
matrix = new int[m][n];

//put it in number matrix
for(int i=0;i<m;i++){
    temp = strMatrix[i].split(",");
    for(int j=0;j<n;j++){
        matrix[i][j] = Integer.parseInt(temp[j]);
    }    
}
    return getmax(0,0);
    }    

public static void main(String args[]){
    String[] str = {"1,2,3","4,5,6","7,8,9"};
    int ans = bestPath(str);
    System.out.println(ans);
             
}
}