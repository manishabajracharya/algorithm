

/*
Using Dynamic Programming
*/
public class String_Interleave{
    
   
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
String[] tests= new String[]{"112243","123","123","0"};
 String T= tests[0];  int len=T.length();
 String s1= tests[1];  int len1 = s1.length();
 String s2=tests[2];   int len2 = s2.length();
 boolean mat[][] = new boolean[s1.length()+1][s2.length()+1];
 
if(len!=len1+len2){
System.out.println(false);
}
else{
mat[len1][len2] = true; //base case
//special case for last row
for(int i=0;i<len2;i++){
if(T.charAt(i+len1)==s2.charAt(i)){
    mat[len1][i]=true;
}
else{
    mat[len1][i]=false;
}
}

//special case for last column
for(int i=0;i<len1;i++){
if(T.charAt(i+len2)==s1.charAt(i)){
    mat[i][len2]=true;
}
else{
    mat[i][len2]=false;
}
}

//for all other cells
for(int i=len1-1;i>=0;i--){
    for(int j=len2-1;j>=0;j--){
        if((T.charAt(i+j)==s1.charAt(i) && mat[i+1][j]) || (T.charAt(i+j)==s2.charAt(j)&& mat[i][j+1])){
            mat[i][j]=true;
         }
        else{
            mat[i][j]=false;
        }
        
}

}

//if mat[0][0] = true then interleaves
System.out.println(mat[0][0]);
}        
    }
    }
    




/* Recursion formula involved
*/

public class StringInterleave{
static String[] tests= new String[]{"112233","123","123","0"};
static String T= tests[0]; static int len=T.length();
static String s1= tests[1]; static int len1 = s1.length();
static String s2=tests[2];  static int len2 = s2.length();
static boolean mat[][] = new boolean[s1.length()+1][s2.length()+1];
    
public static boolean interleave(int i, int j){
if(mat[i][j]==true){
return true;
}
return(T.charAt(i+j)==s1.charAt(i)&& interleave(i+1,j)) || (T.charAt(i+j)==s2.charAt(j)&& interleave(i,j+1));

}

public static void main(String[] args) throws java.lang.Exception {

if(len!=len1+len2){
System.out.println(false);
}
else{
mat[len1][len2] = true; //base case
//special case for last row
for(int i=0;i<len2;i++){
if(T.charAt(i+len1)==s2.charAt(i)){
    mat[len1][i]=true;
}
else{
    mat[len1][i]=false;
}
}

//special case for last column
for(int i=0;i<len1;i++){
if(T.charAt(i+len2)==s1.charAt(i)){
    mat[i][len2]=true;
}
else{
    mat[i][len2]=false;
}
}

//if mat[0][0] = true then interleaves
System.out.println(interleave(0,0));
}
        }
    }
    