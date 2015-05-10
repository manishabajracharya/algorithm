


//atoi
//input: String number
// output: integer number

public static int atoi(String st){
	int result =0;
	int sign = 1;
	
	if(st==null){
		throw new NullPointerException("Input is null");
		
	}
	
        for(int i=0;i<st.length();i++){
		if(st.charAt(i)=='-'){
			sign = -1;			
		}
		else{
		result = (result*10)+Character.getNumericValue(st.charAt(i));
		}
		
	}
	
	result = result*sign;
	return result;
}

    /**
     *
     * @param args
     */
    public static void main(String[] args){
	
	String st = "-1120";
	int a = atoi(st);
        System.out.println(a);
	
	
}