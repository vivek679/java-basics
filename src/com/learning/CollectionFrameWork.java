package com.learning;

import java.util.HashMap;
import java.util.Map;

public class CollectionFrameWork {

	public static void main(String[] args) {
		CollectionFrameWork c = new CollectionFrameWork();
		System.out.println("input : AABBCDAABB");
		System.out.println("output: "+c.processInputString("AABBCDAABB"));
		
		//group all -ve element at one side 
        int arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
        int n = arr.length;
        rearrange(arr, n);
        printArray(arr, n);
        
        // check if given strings are Rotations
        System.out.println();
        System.out.println("-------------------------------");
        c.getDuplicateCharactsCount("geeksforgeeks");
       
        //count duplicate elements
        System.out.println();
        System.out.println("-------------------------------");
        /**
         * Algorithm: areRotations(str1, str2)
         * 1. Create a temp string and store concatenation of str1 to str1 in temp.
                          temp = str1.str1
         * 2. If str2 is a substring of temp then str1 and str2 are rotations of each other.
         *     Example:                 
                     str1 = "ABACD"
                     str2 = "CDABA"
                     
     			temp = str1.str1 = "ABACDABACD" Since str2 is a substring of temp, str1 and str2 are rotations of each other.
         */
        c.stringRotation("geeksforgeeks","ksforgeeksgee");
        
        //count and say
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println(c.countAndSay(11));
		
        //longestPalindrome complexity : Time = O(n^2) and Space = O(1);
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println(c.longestPalindrome("ab"));
        System.out.println(c.longestPalindrome("abacabe"));
        System.out.println(c.longestPalindrome("abaccabe"));
        
	}

	private void stringRotation(String str1, String str2) {
		if(str1.length()==str2.length() &&  (str1+str2).indexOf(str2) != -1)
		{
			System.out.println("Strings are rotational");
		}
		else
		{
			System.out.println("Strings are not rotational");
		}
		
	}

	private void getDuplicateCharactsCount(String str) 
	{
		// TODO Auto-generated method stub
		Map<Character,Integer> characterCountMap = new HashMap<>();
		
		for(char ch : str.toCharArray())
		{
			if(!characterCountMap.containsKey(ch))
			{
				characterCountMap.put(ch,1);
			}
			else if(characterCountMap.containsKey(ch))
			{
				characterCountMap.replace(ch,characterCountMap.get(ch)+1);
			}
		}
		
		for(Map.Entry entryMap : characterCountMap.entrySet())
		{
			char ch  = (char) entryMap.getKey();
			int count= (int) entryMap.getValue();
			if(count>1)
			{
				System.out.println("["+ch+"] = " + count);
			}
		}
	}

	public String processInputString(String input)
	{
		StringBuilder strBuilder = new StringBuilder();
		for(int i=0;i <input.length();i++)   
		{
			int count = 1;
			L1 :
			for(int j=i+1;j<input.length();j++)
			{
				if(input.charAt(i)==input.charAt(j))
				{
					++count;
					i++;		
					continue L1;
				}
				break;
			}
			if(count>1)
				strBuilder.append(count);
			strBuilder.append(input.charAt(i));
		}
		return strBuilder.toString();
	}
	
    static void rearrange(int[] arr, int n)
    {
        int j =0, temp;
        for(int i=0;i<n;i++)
        {
            if(arr[i]<0)
            {
                if(i!=j)
                {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
    }
    
    static void printArray(int[] arr, int n)
    {
        for(int i : arr)
            System.out.print(i+" ");
    }
    
	/**
	 * 1. 1 
	 * 2. 11 
	 * 3. 21 
	 * 4. 1211 
	 * 5. 111221 
	 * 6. 312211 
	 * 7. 13112221
	 */
	public String countAndSay(int n) {

		if (n == 1)
			return "1";
		StringBuilder str = new StringBuilder("1");
		for (int i = 2; i <= n; i++) {
			str = countCharacterString(str, i);
		}
		return str.toString();

	}

	private StringBuilder countCharacterString(StringBuilder sequence, int order) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < sequence.length(); i++) {
				int count = 1;
				L1: for (int j = i + 1; j < sequence.length(); j++) {
					if (sequence.charAt(i) == sequence.charAt(j)) {
						++count;
						i++;
						continue L1;
					}
					break;
				}
				sb.append(count).append(sequence.charAt(i));
			}
			return sb;
	}
	
	/**
	 * For each character, consider center and expand on both side to
	 * find maximum length of palindrome.
	 * 
	 * Two possiblities of center,
	 * 	for odd length Palindrom, centre =i;
	 *  for even length Palindrom, centre =i or i+1;
	 *  Length = right - left - 1 ;
	 *  doing -1 since right and left will 
	 *  be shifted 1 step ahead of the actual staet and end.
	 *  
	 */
	// | a | b | a | c | c | a | b | e |
	// |   | * |   | i |i+1|   | * |   |
	// | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
	//Even len (6) -> ith position 2  start --> i-2 and end -->i+3
	
	// | a | b | a | c | c | a | b | e |
	// |   | * |   | i |i+1|   | * |   |
	// | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
	//Odd len (5) --> ith position 2  start --> i-2 and end -->i+2  
	
	private String longestPalindrome(String str) {
		int start = 0, end = 0;
		for (int i = 0; i < str.length(); i++) {
			int odd = expand(str, i, i);
			int even = expand(str, i, i + 1);
			int length = Math.max(odd, even);
			if (length > end - start) {
				start = i - (length - 1) / 2;
				end = i + length / 2;
			}
		}
//		if()
		return str.substring(start, end + 1); // doing '+1' to include last character too.
	}

	private int expand(String str, int left, int right) {
		//boundary condition
		while(left>=0 && right<str.length() && str.charAt(left)==str.charAt(right))
		{
			left--;
			right++;
		}
		return right-left-1;
	}
		
}
