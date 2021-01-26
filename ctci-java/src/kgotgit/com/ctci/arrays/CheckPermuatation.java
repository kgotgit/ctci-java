package kgotgit.com.ctci.arrays;

import java.util.Arrays;

public class CheckPermuatation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(checkPermutationViaSortedArray("abc","bca"));
		System.out.println(checkPermutationViaSortedArray("abca","bcaa"));
		System.out.println(checkPermutationViaSortedArray("abcad","bcaaf"));
		
		
		System.out.println(checkPermutationViaAscii("abc","bca"));
		System.out.println(checkPermutationViaAscii("abca","bcaa"));
		System.out.println(checkPermutationViaAscii("abcad","bcaaf"));
	}
	
	
	
	/**
	 * Check permutation via sorted array approach
	 * @param s1
	 * @param s2
	 * O(nlogn) T
	 * O(len(s1)+len(s2))
	 */
	public static boolean checkPermutationViaSortedArray(String s1, String s2) {
		
		
		if(s1==null || s2==null || s1.length()!=s2.length()) return false;
		
		char[] s1Chars=s1.toCharArray();
		char[] s2Chars=s2.toCharArray();
		
		Arrays.sort(s1Chars);
		Arrays.sort(s2Chars);
		
		return new String(s1Chars).equals(new String(s2Chars));
		}
	
	/**
	 * O(N)T
	 * O(S1) S
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean checkPermutationViaAscii(String s1, String s2) {
		if(s1==null || s2==null || s1.length()!=s2.length()) return false;
		
		int[] letters=new int[128];//assumption is ASCII
		
		for(int i=0;i<s1.length();i++) {
			letters[s1.charAt(i)]++;
		}
		
		for(int i=0;i<s2.length();i++) {
			letters[s2.charAt(i)]--;
			if(letters[s2.charAt(i)]<0) {
				return false;
			}
		}
		
		
		return true;
	}

}
