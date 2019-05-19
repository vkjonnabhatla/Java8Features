package org.code.challenge;
import java.util.*;

public class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    
	if(str == null || str.length() == 0 || str.length() < k) {
		throw new IllegalArgumentException();
	}
	int i = 0, n = 0;
	Map<Character, Integer> map = new HashMap();
	
	for(int j = 0; j < str.length(); j++) {
		char rightChar = str.charAt(j);
		map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
		
		while(map.size() > k) {
			char leftChar = str.charAt(i);
			map.put(leftChar, map.get(leftChar) - 1);
			if(map.get(leftChar) == 0) {
				map.remove(leftChar);
			}
			i++;
		}
		
		n = Math.max(n, j - i + 1);
	}
    return n;
  }

  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength1("araaci", 2));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength1("araaci", 1));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength1("cbbebi", 3));
  }
  
  
  
  
  
  public static int findLength1(String str, int k) {
	  
	  int i = 0, n = 0;
	  
	  Map<Character, Integer> map = new HashMap();
	  
	  for(int j = 0; j < str.length(); j++) {
		  char ch = str.charAt(j);
		  map.put(ch, map.getOrDefault(ch, 0) + 1);
		  
		  while(map.size() > k) {
			  char leftChar = str.charAt(i);
			  map.put(leftChar, map.get(leftChar) - 1);
			  if(map.get(leftChar) == 0) {
				  map.remove(leftChar);
			  }
			  i++;
		  }
		  n = Math.max(n, j - i + 1);
	  }
	  return n;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
