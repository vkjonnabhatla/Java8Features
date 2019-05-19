package org.code.challenge;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    //O(n2) time complexity
	public static void main1(String[] args) {
		// "abcabcbd"
		String str = "abcabcdd";
		//String str = "bbbbbbbbbb";
		//String str = "sdfalsfjalskdfjacvbfgdff";
		//String str = "pwwkew";
		char[] charArray = str.toCharArray();
		int n = str.length();
		int ans = 0;
		int count = 1;
		HashSet<Character> set = new HashSet<Character>();
		for(int i = 0; i <= n-1; i++) {
			set.add(charArray[i]);
			for(int j = i+1; j < n; j++) {
				if(!set.contains(charArray[j])) {
					set.add(charArray[j]);
					ans = set.size();
				}else {
					break;
				}
			}
			if(count < ans){
				count = ans;
			}
			ans = 0;
			System.out.println(set);
			set.clear();
		}
		System.out.println(count);
	}
	//O(2n) = O(n)
	public static void main2(String[] args) {
		// "abcabcbd"
		//String str = "abcabcdd";
		//String str = "bbbbbbbbbb";
		//String str = "sdfalsfjalskdfjacvbfgdff";
		//String str = "dssfalsscmn";
		String str = "abcaf";
		//String str = "pwwkew";
		
		int n = str.length();
		int ans = 0, i = 0, j = 0;
		HashSet<Character> set = new HashSet<Character>();
		
		while(i < n && j < n) {
			if(!set.contains(str.charAt(j))) {
				set.add(str.charAt(j++));
				ans = Math.max(ans, j - i);
			}else{
				set.remove(str.charAt(i));
				i++;
			}
		}
		System.out.println(ans);
	}
	
	public static void main3(String[] args) {
		// "abcabcbd"
		//String str = "abcabcdd";
		//String str = "bbbbbbbbbb";
		//String str = "sdfalsfjalskdfjacvbfgdff";
		//String str = "dssfalsscmn";
		String str = "bcaaf";
		//String str = "pwwkew";
		
		int n = str.length();
		int ans = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int j = 0, i = 0; j < n; j++) {
			if(map.containsKey(str.charAt(j))) {
				i = Math.max(map.get(str.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(str.charAt(j), j + 1);
			System.out.println(map);
		}
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		// "abcabcbd"
		//String str = "abcabcdd";
		//String str = "bbbbbbbbbb";
		//String str = "sdfalsfjalskdfjacvbfgdff";
		//String str = "dssfalsscmn";
		String s = "fabcaf";
		//String str = "pwwkew";
		
		int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
		System.out.println(ans);
	}
}
