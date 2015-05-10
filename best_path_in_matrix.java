

public static int setmatrix(String[] arr){

int[][] inp = new int[arr.length][arr[0].length];
String[] temp = new String[arr[0].length];

for(int i =0;i<arr.length;i++){

temp = arr[i].split(",");

for(int j=0;j<temp.length;j++){
inp[i][j] = Integer.parseInt(temp[j]);

}

}

return(max_sum(arr.length, arr[0].length));

}


public static int max_sum(row,col){

sum[row-1][col-1] = inp[row-1][col-1];

for(int j=col-2;j>=0;j--){
sum[row-1][j] = inp[row-1][j]+sum[row-1][j+1];
}

for(int i=row-2;i>=0;i--){
sum[i][col-1] = inp[i][col-1]+sum[i+1][col-1];
}

for(int i=row-2;i>=0;i--){
for(int j=col-2;j>=0;j--){
sum[i][j] = inp[i][j]+Math.max(sum[i][j+1], sum[i+1][j]);
}
}

return inp[0][0];
}

public static void main(String args[]){
    String[] str = {"1,2,3","4,5,6","7,8,9"};
    int ans = setmatrix(str);
    System.out.println(ans);
             
}











/*public class BestPathinMatrix{

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