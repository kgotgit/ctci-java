package com.kgotgit.leetcode.problems;

public class SmallestIntegersInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {8,1,2,2,3};
		smallerNumbersThanCurrent(nums);
	}
	
	
	   public static int[] smallerNumbersThanCurrent(int[] nums) {
	        int[] count = new int[101];
	        int[] res = new int[nums.length];
	        
	        for (int i =0; i < nums.length; i++) { //n
	            count[nums[i]]++;
	        }
	        printArray(count);
	        
	        for (int i = 1 ; i <= 100; i++) {//n
	            count[i] += count[i-1];    
	        }
	        printArray(count);
	        for (int i = 0; i < nums.length; i++) {//n
	            if (nums[i] == 0)
	                res[i] = 0;
	            else 
	                res[i] = count[nums[i] - 1];
	        }
	        printArray(res);
	        
	        return res;        
	    }
	   
	   public static void printArray(int[] nums) {
		   System.out.println("");
		   for(int i:nums) {
			   System.out.print(i);
		   }
	   }

}
