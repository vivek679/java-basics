package com.learning;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayQuestions {

	public static void main(String[] args) {
		ArrayQuestions obj = new ArrayQuestions();

		int arr1[] = { 1, 3, 5, 7 };
		int arr2[] = { 0, 2, 6, 8, 9 };
		obj.merge(arr1, arr2, arr1.length, arr2.length);
		int arr3[] = { -11,11,22,5,-3,0, 2, 6, 8, 9 };
		//max min element in array
		obj.getMaxMin(arr3, arr3.length);
		System.out.println("m1");
		//ascending order
		obj.sortMethod1(arr3,arr3.length);
		System.out.println("m2");
		//descending order
		obj.sortMethod2(arr3,arr3.length);
		
		
		int[] data = {1,2,3,4,5,6,7,8,9,10};

		// To boxed array
		Integer[] what = Arrays.stream( data ).boxed().toArray( Integer[]::new );
		Integer[] ever = IntStream.of( data ).boxed().toArray( Integer[]::new );

		// To boxed list
		List<Integer> you  = Arrays.stream( data ).boxed().collect( Collectors.toList() );
		List<Integer> like = IntStream.of( data ).boxed().collect( Collectors.toList() );
		int arr4[] = { -11,11,22,5,-3,0, 2, 6, 8, 9 };
		System.out.println();
		System.out.println("insertion");
		obj.insertionSort(arr4,arr4.length);
		// O(n^2) time
		/**
		 * Worst and Average Case Time Complexity:
		 * 		O(n*n). Worst case occurs when array is reverse sorted.
		 * Best Case Time Complexity: O(n).
		 * 		 Best case occurs when array is already sorted.
		 * Auxiliary Space: O(1)
		 * Boundary Cases: Bubble sort takes minimum time (Order of n) 
		 * when elements are already sorted.
		 * Sorting In Place: Yes
		 * Stable: Yes
		 */
		int arr5[] = { -11,11,22,5,-3,0, 2, 6, 8, 9 };
		System.out.println();
		System.out.println("bubble");
		obj.bubbleSort(arr5,arr5.length);
		
		
		System.out.println();
		System.out.println("dynamicProblem");
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println("number of jumps : "+minimumJumpToReachEnd(arr,arr.length));
	}

	private static Integer minimumJumpToReachEnd(int[] arr, int n) {
		// TODO Auto-generated method stub
		// 
		int[] minimumJumpArray = new int[n]; // store the actual jump count
		int[] jumpPathArray = new int[n]; // stores the index of previous element
		
		if(n==0|| arr[0] == 0)
			return Integer.MAX_VALUE;
		
		minimumJumpArray[0]=0;
		
		for(int i=1; i<n ; i++)
		{
			minimumJumpArray[i] = Integer.MAX_VALUE;
			for(int j=0; j<i; j++)
			{
				if( i <= (j+ arr[j]) &&  minimumJumpArray[j] != Integer.MAX_VALUE )
				{
					minimumJumpArray[i]=Math.min(minimumJumpArray[i], minimumJumpArray[j]+ j);
					jumpPathArray[i]=j;
					break;
				}
			}
			
		}
		System.out.println();
		System.out.println("jumpPathArray :"+jumpPathArray.toString());
		for(int i:jumpPathArray)
		{
			System.out.print(i +" ");
		}
		System.out.println();
		System.out.println("minimumJumpArray :"+minimumJumpArray.toString());
		for(int i:minimumJumpArray)
		{
			System.out.print(i +" ");
		}
		System.out.println();
		return minimumJumpArray[n-1];
		
	}

	private void bubbleSort(int[] arr, int length) {
		System.out.println("Sorted array : ");
		for(int i =0;i<length;i++)
		{
			for(int j=0;j<length-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for(int i:arr)
		{
			System.out.print(i +" ");
		}
		
	}

	private void insertionSort(int[] arr, int length) {
		System.out.println("Sorted array : ");
		
		for(int i=1; i<length; i++)
		{
			int key = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>key)
			{
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1]=key;
		}
		for(int i:arr)
		{
			System.out.print(i +" ");
		}
	}

	private void sortMethod1(int[] arr3, int length) {
		// TODO Auto-generated method stub
		System.out.println("Sorted array : ");
		Arrays.sort(arr3);
		for(int i:arr3)
		{
			System.out.print(i +" ");
		}
	}
	
	private void sortMethod2(int[] arr3, int length) {
		// TODO Auto-generated method stub
		Integer[] integerArray = Arrays.stream(arr3).boxed().toArray(Integer[] :: new);
		Arrays.sort(integerArray, Collections.reverseOrder());
		System.out.println("Sorted array : ");
		for(int i:integerArray)
		{
			System.out.print(i +" ");
		}
		
	}

	public void merge(int arr1[], int arr2[], int n, int m) {
		// code here
		int i = 0, j = 0;
		while (i < n && j < m) {
			if (arr1[i] < arr2[j]) {
				System.out.print(arr1[i++] + " ");
			} else {
				System.out.print(arr2[j++] + " ");
			}

		}
		while (i < n) {
			System.out.print(arr1[i++] + " ");
		}
		while (j < m) {
			System.out.print(arr2[j++] + " ");
		}
	}
	
	public void getMaxMin(int[] arr, int n)
	{
		int max=arr[0],min=arr[0];
		for(int i : arr)
		{
			if(min>i)
			{
				min=i;
			}
			if(max<i)
			{
				max=i;
			}
		}
		System.out.println("MAX : "+max+"MIN :"+min);
	}
}
