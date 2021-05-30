package com.learning;

public class CollectionFrameWork {

	public static void main(String[] args) {
		CollectionFrameWork c = new CollectionFrameWork();
		System.out.println("input : AABBCDAABB");
		System.out.println("output: "+c.processInputString("AABBCDAABB"));
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
}
