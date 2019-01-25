package cipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) throws IOException
	{
		// Take user input String
		System.out.println("Enter the String : ");
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
        String encryptedString = reader.readLine(); 
        System.out.println("Your Encrypted String is = " + encryptedString);
        
        // Return the possible cipher text all list
        List<String> allStrings = Cipher.encrypt(encryptedString);
        List<String> allFormattedStrings = Cipher.formatString(allStrings);
        
        
        System.out.println("Output of your Encrypted String :");
        for(String eachStr : allFormattedStrings)
        {
        	System.out.println(eachStr);
        }

        // If Any sentence exists from your output then print it
        List<String> sentances = getSentances(allFormattedStrings);
        for(String eachStr : sentances)
        {
        	System.out.println(eachStr);
        }
        
        
        // Print All english word Exist from your output
        for(String eachStr : allFormattedStrings)
        {
        	System.out.println("Your String is ==> " + eachStr);
        	getWords(eachStr);
        }
	}
	
	/**
	 * @param str
	 * @throws IOException
	 */
	public static void getWords(String str) throws IOException
	{
		Dictionary dic = new Dictionary();
        	String[] splited = str.split("\\s+");
        	for(int i =0;i<splited.length;i++)
        	{
        		if(dic.contains(splited[i].toLowerCase()))
        		{
        			System.out.print("Word ==> ");
        			System.out.println(splited[i]);
        		}
        	}
	}
	
	
	/**
	 * @param allStrings
	 * @return
	 * @throws IOException
	 */
	public static List<String> getSentances(List<String> allStrings) throws IOException
	{
		List<String> results = new ArrayList<String>();
		Dictionary dic = new Dictionary();
        for(String eachStr : allStrings)
        {
        	String[] splited = eachStr.split("\\s+");
        	boolean flag=true;
        	// Print each word
        	for(int i =0;i<splited.length;i++)
        	{
        		if(!dic.contains(splited[i].toLowerCase()))
        		{
        			flag=false;
        			break;
        		}
        	}
        	if(flag) {
        		results.add(eachStr);
        	}
        }
        return results;
	}
	
	
}
