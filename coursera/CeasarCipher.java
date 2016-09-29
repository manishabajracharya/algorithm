
You will start with the Caesar Cipher algorithm you learned about in the videos, and you will make some enhancements to it, so that it works with all letters (both uppercase and lowercase) and to make it a little bit harder to decrypt. Write these methods in a CaesarCipher class you can use in the next lesson.

Specifically, you should do the following:

    Create a new class called CaesarCipher.
    
	Write the method encrypt that has two parameters, a String named input and an int named key. This method returns a String that has been encrypted using the Caesar Cipher algorithm explained in the videos. Assume that all the alphabetic characters are uppercase letters. For example, the call

	encrypt(“FIRST LEGION ATTACK EAST FLANK!”, 23) should return the string 

	“CFOPQ IBDFLK XQQXZH BXPQ CIXKH!”	
	
	Modify the encrypt method to be able to handle both uppercase and lowercase letters. For example, encrypt(“First Legion”, 23) should return “Cfopq Ibdflk”, and encrypt(“First Legion”, 17) should return “Wzijk Cvxzfe”. Be sure to test the encrypt method. 
	
	Write the method encryptTwoKeys that has three parameters, a String named input, and two integers named key1 and key2. This method returns a String that has been encrypted using the following algorithm. Parameter key1 is used to encrypt every other character with the Caesar Cipher algorithm, starting with the first character, and key2 is used to encrypt every other character, starting with the second character. For example, the call encryptTwoKeys(“First Legion”, 23, 17) should return “Czojq Ivdzle”. Note the ‘F’ is encrypted with key 23, the first ‘i’ with 17, the ‘r’ with 23, and the ‘s’ with 17, etc. Be sure to test this method.
	
package CeasarCipher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

	public class CeasarCipher{
		
			public static String encrypt(String input, int key){
			StringBuilder encrypted = new StringBuilder(input);
			String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String shifted_alphabet = alphabet.substring(key)+alphabet.substring(0,key);
			for(int i=0;i<encrypted.length();i++){
				int index = alphabet.indexOf(encrypted.charAt(i));
                                char ch = Character.toUpperCase(encrypted.charAt(i));
				int index_lower = alphabet.indexOf(ch);
				if(index>=0){encrypted.setCharAt(i,shifted_alphabet.charAt(index));}
				else if(index_lower>=0){
                                    char ch_lower = shifted_alphabet.charAt(index_lower);
                                    encrypted.setCharAt(i,Character.toLowerCase(ch_lower));
                                }
			}
			return encrypted.toString();
			
		}
		
		public static String encryptTwoKeys(String input, int key1, int key2){
			StringBuilder encrypted = new StringBuilder(input);
			for(int i=0;i<encrypted.length();i++){
				int index = (int)(encrypted.charAt(i));
				if(index>=(int)('A') && index<=(int)('Z')){
					int index_ascii = (i%2!=0)?index+key2: index+key1;//odd or even index
					if(index_ascii>(int)('Z')){
						index_ascii=index_ascii-(int)('Z')-1; // -1 as to match the character, similar to alphabet starting at 1 not at 0
						index_ascii = index_ascii+(int)('A');
                                                System.out.println("encrypted.charAt(i):"+encrypted.charAt(i)+"="+index_ascii);
					}
					encrypted.setCharAt(i,(char)(index_ascii)); 
				}
				if(index>=(int)('a') && index<=(int)('z')){
					int index_ascii = (i%2!=0)?index+key2: index+key1;//odd or even index
					if(index_ascii>(int)('z')){
						index_ascii=index_ascii-(int)('z')-1;
						index_ascii = index_ascii+(int)('a');
					}
					encrypted.setCharAt(i,(char)(index_ascii)); 
				}
				
			}
			return encrypted.toString();
			
		}
		
		public static void main(String[] args) throws IOException{
		
		String readfilename = "E:/NetBeans/Interview_Practice/src/Practice/inputtext.txt";
		String writefilename = "E:/NetBeans/Interview_Practice/src/Practice/outputtext.txt";
        StringBuilder st_encrypt = new StringBuilder();
		StringBuilder st_encrypt_two_keys = new StringBuilder();
		try {
                    FileReader fileReader = new FileReader(readfilename);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String line = bufferedReader.readLine();
		
                    while(line!=null){
			st_encrypt.append(encrypt(line,23));
			st_encrypt.append('\n');
			st_encrypt_two_keys.append(encryptTwoKeys(line,23,17));
			st_encrypt_two_keys.append('\n');
			line = bufferedReader.readLine();
                    }
                    bufferedReader.close();
                }
                catch(FileNotFoundException ex){
                System.out.println("Unable to open file:"+readfilename);
                }
                try{
                    FileWriter fileWriter = new FileWriter(writefilename);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(st_encrypt.toString());
                    bufferedWriter.newLine();
                    bufferedWriter.write(st_encrypt_two_keys.toString());
                    bufferedWriter.close();
                }
                catch(IOException ex){
                System.out.println("Unable to write in file:"+writefilename);
                }
	}
}