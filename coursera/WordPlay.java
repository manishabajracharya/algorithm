
You will write a program to transform words from a file into another form, such as replacing vowels with an asterix.

Specifically, you should do the following.

    Create a new class called WordPlay.
    Write a method isVowel that has one Char parameter named ch. This method returns true if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) and false otherwise. You should write a tester method to see if this method works correctly. For example, isVowel(‘F’) should return false, and isVowel(‘a’) should return true.
	
	Write a method replaceVowels that has two parameters, a String named phrase and a Char named ch. This method should return a String that is the string phrase with all the vowels (uppercase or lowercase) replaced by ch. For example, the call replaceVowels(“Hello World”, ‘*’) returns the string “H*ll* W*rld”. Be sure to call the method isVowel that you wrote and also test this method.
	
	Write a method emphasize with two parameters, a String named phrase and a character named ch. This method should return a String that is the string phrase but with the Char ch (upper- or lowercase) replaced by

	‘*’ if it is in an odd number location in the string (first character has index 0, third character has index 2, etc.), or

	‘+’ if it is in an even number location in the string (second character has index 1, fourth character has index 3, etc.).

	For example, the call emphasize(“dna ctgaaactga”, ‘a’) would return the string “dn* ctg+*+ctg+”, and the call emphasize(“Mary Bella Abracadabra”, ‘a’) would return the string “M+ry Bell+ +br*c*d*br+”. Be sure to test this method.
	
package WordPlay;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WordPlay {
	
	public static Boolean isVowel(char ch){
		char temp = Character.toLowerCase(ch);
		if(temp=='a' || temp =='e' || temp=='i' || temp =='o' || temp=='u'){
			return true;
		}
		else 
			return false;
		
	}
	
	public static String replaceVowels(String phrase, char ch){
		StringBuilder edited_phrase = new StringBuilder(phrase);
		for(int i=0;i<edited_phrase.length();i++){
			if(isVowel(edited_phrase.charAt(i))){
				edited_phrase.setCharAt(i,ch);
			}
		}
		return edited_phrase.toString();
	}
	
	public static String emphasize(String phrase, char ch){
		StringBuilder edited_phrase = new StringBuilder(phrase);
		for(int i=0;i<edited_phrase.length();i++){
			if((i+1)%2!=0 && Character.toLowerCase(edited_phrase.charAt(i))==ch){
				edited_phrase.setCharAt(i,'*');
			}
			if((i+1)%2==0 && Character.toLowerCase(edited_phrase.charAt(i))==ch){
				edited_phrase.setCharAt(i,'+');
			}
		}
		return edited_phrase.toString();
	}
	
	public static void main(String[] args) throws IOException{
		
		String readfilename = "E:/NetBeans/Interview_Practice/src/Practice/inputtext.txt";
		String writefilename = "E:/NetBeans/Interview_Practice/src/Practice/outputtext.txt";
                StringBuilder st_replaceVowels = new StringBuilder();
		StringBuilder st_emphasize = new StringBuilder();
		try {
                    FileReader fileReader = new FileReader(readfilename);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String line = bufferedReader.readLine();
		
                    while(line!=null){
			st_replaceVowels.append(replaceVowels(line,'*'));
			st_replaceVowels.append('\n');
			st_emphasize.append(emphasize(line,'a'));
			st_emphasize.append('\n');
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
                    bufferedWriter.write(st_replaceVowels.toString());
                    bufferedWriter.newLine();
                    bufferedWriter.write(st_emphasize.toString());
                    bufferedWriter.close();
                }
                catch(IOException ex){
                System.out.println("Unable to write in file:"+writefilename);
                }
	}
}
