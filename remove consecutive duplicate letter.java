




/* remove consecutive similar letters. Example: Google => Gogle */


public class practice {
    
public static String rem_corr_dup(String st){

if(st==null){
return null;
}
if(st.length()==1){
return st;
}

char[] ch_arr = st.toCharArray();
int start = 0, runner=1;
while(runner<ch_arr.length){

if(ch_arr[start]==ch_arr[runner]){
runner++;
}
else{
ch_arr[start+1] = ch_arr[runner];
start++; runner++;
}

}

return String.valueOf(ch_arr).substring(0,start+1);

}
 public static void main(String[] args){
	String st = "gogle";

System.out.println(rem_corr_dup(st));


}

}