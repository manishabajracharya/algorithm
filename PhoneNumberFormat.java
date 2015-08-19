

Given:
assumption a large set of data
Phone numbers: xxx-yyy-zzzz or xxxyyyzzzz
Format phone numbers: yyy-xxx-zzzz

void reformat(String[] phonenumbers);

Be concious about space and time complexity



        public static void reformat(String[] phonenumbers){
	
	for(int i=0;i<phonenumbers.length;i++){
		
		int len = phonenumbers[i].length();
		if(len>10){
			phonenumbers[i]=reformat12(phonenumbers[i]);
		}
		else{
			phonenumbers[i]=reformat10(phonenumbers[i]);                        
		}
	}	
}

public static String reformat12(String phnum){
	char[] ch = phnum.toCharArray();
	char temp;
	for(int i=0;i<3;i++){
		temp = ch[i];
		ch[i] =ch[i+4];
		ch[i+4] = temp;
	}

	return(String.valueOf(ch));        
}

public static String reformat10(String phnum){

    char[] ch = new char[12];
    //phnum.toCharArray();
    
    ch[0] = phnum.charAt(3);
    ch[1] = phnum.charAt(4);
    ch[2] = phnum.charAt(5);
    ch[3] = '-';
    ch[4] = phnum.charAt(0);
    ch[5] = phnum.charAt(1);
    ch[6] = phnum.charAt(2);
    ch[7] = '-';
    ch[8] = phnum.charAt(6);
    ch[9] = phnum.charAt(7);
    ch[10] = phnum.charAt(8);
    ch[11] = phnum.charAt(9);
  
    return(String.valueOf(ch));
}


public static void main(String[] args){
	String[] st_ph={"126-456-7890","098-765-1234","1234567890"};
	reformat(st_ph);
        
System.out.println(st_ph[0]);
System.out.println(st_ph[1]);
System.out.println(st_ph[2]);
	
}

