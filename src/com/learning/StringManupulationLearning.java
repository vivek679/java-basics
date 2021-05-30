package com.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StringManupulationLearning {

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(isr);
		
//		System.out.println("-----------1---------");
//		System.out.println(bf.readLine());
		
		
//		System.out.println("-----------2---------");
//		String[] stringArray = bf.readLine().split(" ");
//		for(String str: stringArray)
//		{
//			System.out.println(str);
//		}
		
//		System.out.println("-----------3----------");
//		// input : asdas assd asf asf asfasf asf
//		String yourString = sc.next();
//		System.out.println(yourString);
		
		
//		System.out.println("-----------4----------");
//		String yourString2 = sc.next();
//		char[] charArray1 = yourString2.toCharArray();
//		System.out.println();
//		for(int i = charArray1.length -1; i >=0 ; i--)
//		{
//			System.out.print(charArray1[i]);
//		}
		
//		System.out.println("-----------5----------");
//		String str3 = sc.nextLine();
//		char[] charArr3 = str3.toCharArray();
//		System.out.println();
//		for(int i = charArr3.length -1; i >=0 ; i--)
//		{
//			System.out.print(charArr3[i]);
//		}
		
		
//		System.out.println("-----------6----------");
//		String str6 = sc.nextLine();
//		char[] charArr3 = str6.toCharArray();
//		String replace = str6.replace("aa", "b");
//		System.out.println(str6);
//		System.out.println(replace);
////		for(int i = charArr3.length -1; i >=0 ; i--)
////		{
////			System.out.print(charArr3[i]);
////		}
		
		System.out.println("-----------7----------");
		String str = sc.nextLine();
		char[] charArr3 = str.toCharArray();
		String replace = str.replace("aa", "b");
		StringBuilder stringBuilder = new StringBuilder(str);
		stringBuilder.reverse();
		System.out.println(str);
		System.out.println(replace);
		System.out.println(stringBuilder);
//		for(int i = charArr3.length -1; i >=0 ; i--)
//		{
//			System.out.print(charArr3[i]);
//		}
		
		
		
	}
	
	/**
	 * Given a string str containing only lower case alphabets, the task is to sort it in lexicographically-descending order.
	 * Example 1:
	 * Input: str = "geeks"
	 * Output: "skgee"
	 * Explanation: It's the lexicographically-descending order.
	 * @param str
	 * @return
	 */
    String lexicographicallyReverseSort(String str) 
    { 
        StringBuilder sb = new StringBuilder();
        int[] charArray = new int[26];
        for(int i=0;i<str.length();i++)
            ++charArray[str.charAt(i) - 'a'];
            
        for(int i=0;i<26;i++)
        {
            if(charArray[i]>0)
            {
                while(charArray[i]>0)
                {
                    sb.append((char) (97 +i));
                    --charArray[i];
                }
            }
        }
        return sb.reverse().toString();
    }
	
	public void merge(int arr1[], int arr2[], int n, int m) {
        // code here
        int i=0,j=0;
	    while(i+j<=n+m)
	    {
	        if(arr1[i]==arr2[j])
	        {
	            System.out.print(arr1[i]+" ");
	            i++;
	        }
	        else if(arr1[i]<arr2[j])
	        {
	            System.out.print(arr1[i]+" ");
	            i++;
	        }
	        else if(arr1[i]>arr2[j])
	        {
	            System.out.print(arr2[j]+" ");
	            j++;
	        }
	    }
    }
}
