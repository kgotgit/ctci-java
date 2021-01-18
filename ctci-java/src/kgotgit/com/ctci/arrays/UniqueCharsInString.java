package kgotgit.com.ctci.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueCharsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("abc=>"+isUniqueString("abc"));
		
		System.out.println("abcabc=>"+isUniqueString("abcabc"));
		
		System.out.println("abca=>"+isUniqueString("abca"));
		
		System.out.println("**********");
		
		System.out.println("abc=>"+isUniqueStringInPlace("abc"));
		
		System.out.println("abcabc=>"+isUniqueStringInPlace("abcabc"));
		
		System.out.println("abca=>"+isUniqueStringInPlace("abca"));
		System.out.println("**********");
		
		
		System.out.println("abc=>"+isUniqueStringViaSorting("abc"));
		
		System.out.println("abcabc=>"+isUniqueStringViaSorting("abcabc"));
		
		System.out.println("abca=>"+isUniqueStringViaSorting("abca"));
		
		System.out.println("**********");
		
System.out.println("abc=>"+isUniqueStrinViaAscii("abc"));
		
		System.out.println("abcabc=>"+isUniqueStrinViaAscii("abcabc"));
		
		System.out.println("abca=>"+isUniqueStrinViaAscii("abca"));
		

		System.out.println("**********");
		
		System.out.println("abc=>"+isUniqueCharsViaBitVector("abc"));
		
		System.out.println("abcabc=>"+isUniqueCharsViaBitVector("abcabc"));
		
		System.out.println("abca=>"+isUniqueCharsViaBitVector("abca"));
		
		
	}
	
	
	/**
	 * Use Hashset -- > a hash set can only unique values.
	 * Time: O(N)
	 * Space: O(N)
	 * Is Unique String
	 * @param s
	 * @return
	 */
	public static boolean isUniqueString(String s) {
		if(s==null || s.length()==0) return false;
		
		Set<Character> set=new HashSet<Character>();
		
		for(int i=0;i<s.length();i++) {
			set.add(s.charAt(i));
		}		
		return set.size()==s.length();
	}

	/**
	 * Brute force, nested loops and return if the duplicate found. 
	 * ( ensure the nested loops don't compare same index values)
	 * Time: O(N*N)
	 * Space: O(1)
	 * @param s
	 * @return
	 */
	public static boolean isUniqueStringInPlace(String s) {
		
		if(s==null || s.length()==0) return false;
		
		int i=0;
		boolean isUnique=true;
		
		while(i<s.length() && isUnique) {
			for(int j=0;j<s.length();j++) {
				if(j!=i && s.charAt(i)==s.charAt(j)) {
					isUnique=false;
					break;
				}
			}
			i++;  
		}
		
		return isUnique;
		}
	
	/**
	 * If we are allowed to modify the input array
	 * Since we are using sorting algorithm then time complexity is O(nlogn)
	 * @param s
	 * @return
	 */
	
	public static boolean isUniqueStringViaSorting(String s) {
		
		if(s==null || s.length()==0) return false;
		
		
		char[] chars=s.toCharArray();
		Arrays.sort(chars);//O(nlongn)
		
		int i=1;
		
		while(i<chars.length) { //O(n)
			if(chars[i-1]==chars[i]) {
				return false;
			}
			i++;
		}
		
		return true;
	}
	
	
	/**
	 * If we assume the string is ASCII string instead of UNICODE string
	 * @param s
	 * @return
	 * Space: O(c)
	 * Time :O(c,n) or O(c) where c is the character set size;
	 */
	public static boolean isUniqueStrinViaAscii(String s) {
		//There are only max of 128 characters with ASCII string. If the string length 
		//is greater than 128 then we can safely assume that characters are repeated and string is not unique
		if(s==null || s.length()>128) return false;
		
		boolean[] char_set=new boolean[128];
		
		for(int i=0;i<s.length();i++) {
			int val=s.charAt(i);
			if(char_set[val]) {
				return false;
			}
			char_set[val]=true;
		}
		
		return true;
	}
	
	
	/**
	 * Use bit vector
	 * O(N) and O(1)
	 * @param s
	 * @return
	 */
	public static boolean isUniqueCharsViaBitVector(String s) {	
		
		int checker=0;
		
	
		for(int i=0;i<s.length();i++) {
			System.out.println("checker-->"+checker);
			int val=s.charAt(i);
			System.out.println("(checker & (1<< val)==>"+(checker & (1<< val)));
			if((checker & (1<< val))>0) {
				return false;
			}
			checker |=(1<<val);
		}
		return true;
	}
	
	
	
	
	
	
	

	
}
