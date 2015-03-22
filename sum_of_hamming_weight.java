

/*Sum of Hamming Weight*/

static int printCountOfBitsSet(int[] intArr) {
int count=0;
for(int i=0;i<intArr.length;i++){
while(intArr[i]>0){
    if((intArr[i]&1)==1){
    count++;
    }
    intArr[i]>>=1;

}
}
return count;
    }
    
public static void main(String[] args){
int[] arr={31,51};

System.out.println(printCountOfBitsSet(arr));
}