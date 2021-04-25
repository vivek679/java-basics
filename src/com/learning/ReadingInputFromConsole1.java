package com.learning;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class ReadingInputFromConsole1
{

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		InputStreamReader stream = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(stream);
		
		System.out.print("Enter your input : ");
		String str = bf.readLine();
		String[] stringArray = str.split(" ");
		System.out.println("Length :" + stringArray.length);
		//converting input stream to ArrayList
		List<Integer> list = 
				Arrays.stream(stringArray).map(x->{
					try {
						return Integer.parseInt(x);
					}
					catch(NumberFormatException nfe) {
						 return null;
					}
				})
		.filter(Objects::nonNull)
		.collect(Collectors.toList());
		System.out.print("\nOutput Array :"+list);
		
		System.out.print("\nOutput Array :");
		Collections.sort(list);
		Object[] arr1 = list.toArray();
		for(Object i: arr1)
		{
			System.out.print(i+" ");
		}
		
		// using helper method 		
		List<String> strList = Stream.of("1", "2", "illegal_3", "4", "illegal_5", "6").collect(Collectors.toList());
		list = strList.stream()
		            .flatMap(x -> parseIntStream(x))
		            .collect(Collectors.toList());
	}
	
	// helper method
	static Stream<Integer> parseIntStream(String s) {
	    try {
	        return Stream.of(Integer.parseInt(s));
	    } 
	    catch (NumberFormatException nfe) {
	    }
	    return Stream.empty();
	}
}
