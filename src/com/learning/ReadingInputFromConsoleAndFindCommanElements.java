package com.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class ReadingInputFromConsoleAndFindCommanElements
{

	// Given three arrays sorted in non-decreasing order, print all common elements
	// in these arrays.
	//	Enter your input : 
	//		1 5 10 20 40 80
	//		6 7 20 80 100
	//		3 4 15 20 30 70 80 120
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		InputStreamReader stream = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(stream);

		System.out.println("Enter your input : ");
		int[] array1 = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] array2 = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] array3 = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int i = 0, j = 0, k = 0;
		while (i < array1.length && j < array2.length && k < array3.length)
		{
			if (array1[i] == array2[j] && array2[j] == array3[k])
			{
				System.out.println(array1[i] + " ");
				i++;
				j++;
				k++;
			} else if (array1[i] < array2[j])
			{
				i++;
			} else if (array2[j] < array3[k])
			{
				j++;
			} else
				k++;
		}
	}
}
