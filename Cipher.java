package cipher;

import java.util.ArrayList;
import java.util.List;

//A Java Program to illustrate Caesar Cipher Technique 
class Cipher 
{ 

	/**
     * @param text
     * @return
     */
    public static List<String> encrypt(String text) 
    { 
    	List<String> results = new ArrayList<String>();
        for(int k=1;k<=25;k++) {
        	 StringBuffer result= new StringBuffer();
             for (int i=0; i<text.length(); i++) 
             { 
                 if (Character.isUpperCase(text.charAt(i))) 
                 { 
                     char ch = (char)(((int)text.charAt(i) + 
                                       k - 65) % 26 + 65); 
                     result.append(ch); 
                 } 
                 else
                 { 
                     char ch = (char)(((int)text.charAt(i) + 
                                       k - 97) % 26 + 97); 
                     result.append(ch); 
                 } 
             } 
             results.add(result.toString());
        }
        return results;
    } 
    
    /**
     * @param strings
     * @return
     */
    public static List<String> formatString(List<String> strings) 
    { 
    	List<String> results = new ArrayList<String>();
    	
        for(String eachStr : strings)
        {
        	StringBuilder result = new StringBuilder();
            for (int i = 0; i < eachStr.length(); i++) {
                result.append(eachStr.charAt(i));
                if (i != eachStr.length() -1 && (i==3 || i==5 || i==10 || i==13 || i==17)) {
                    result.append(" ");
                }
            }
            results.add(result.toString());
        }
        return results;
    } 
 
}