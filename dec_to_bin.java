

/*Decimal to binary  */

public static String add_one(int num)    {

    String st_add = new String();
    
    
    return st_add;


}
    
public static String dec_to_bin(int num){

StringBuilder st = new StringBuilder();
boolean flag = false;

if(num<0){
flag = true;
}

int n = Math.abs(num);

while(n>0){
st.append(n%2);
n=n/2;

}

st =st.reverse();

if(flag){
num = ~Integer.valueOf((st.toString()));                                                            
st.replace(0,st.length(),add_one(num));

}
return st.toString();
}
 public static void main(String[] args){
	int st = 10;

System.out.println(dec_to_bin(st));


}