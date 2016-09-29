
In this assignment, you will put together the CaesarCipher class from the lesson and add a decrypt method to decrypt with the same key. In addition you will create a second class, TestCaesarCipher to test examples that use the CaesarCipher class, including writing a method that will automatically decrypt an encrypted file by determining the key and then decrypting with that key.

Specifically, you should do the following.

Create the CaesarCipher class with the following parts:

    Private fields for the alphabet and shiftedAlphabet
	
	Write a constructor CaesarCipher that has one int parameter key. This method should initialize all the private fields of the class.
	
	Write an encrypt method that has one String parameter named input. This method returns a String that is the input encrypted using shiftedAlphabet.
	
	Write a decrypt method that has one String parameter named input. This method returns a String that is the encrypted String decrypted using the key associated with this CaesarCipher object. One way to do this is to create another private field mainKey, which is initialized to be the value of key. Then you can create a CaesarCipher object within decrypt: CaesarCipher cc = new CaesarCipher(26 - mainKey); and call cc.encrypt(input).
	
	package CeasarCipher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CeasarCipher {
	
        private String alphabet;
		private String shifted_alphabet;
		private int mainKey;
		public CeasarCipher(int key){
			mainKey = key;
			alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			shifted_alphabet = alphabet.substring(key)+alphabet.substring(0,key);
		}
		
		public String encrypt(String input){
			StringBuilder encrypted = new StringBuilder(input);
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
		
		public String decrypt(String input){
			CeasarCipher cc = new CeasarCipher(26 - mainKey);
			return cc.encrypt(input);
			
		}
		
		public static void main(String[] args){
			CeasarCipher cc = new CeasarCipher(23);
			System.out.println(cc.encrypt("FIRST LEGION ATTACK EAST FLANK!"));
			System.out.println(cc.decrypt(cc.encrypt("FIRST LEGION ATTACK EAST FLANK!")));
		}
}