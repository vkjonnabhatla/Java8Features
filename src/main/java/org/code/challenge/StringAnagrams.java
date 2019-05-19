package org.code.challenge;
import java.util.*;

class StringAnagrams {
  public static List<Integer> findStringAnagrams(String str, String pattern) {
    List<Integer> resultIndices = new ArrayList<Integer>();
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    int i = 0, match = 0;
    //put pattern into map
    for(int k = 0; k < pattern.length(); k++){
      char ch = pattern.charAt(k);
      map.put(ch, map.getOrDefault(ch,0) + 1 );
    }

    for(int j = 0; j < str.length(); j++){
      char ch2 = str.charAt(j);
      if(map.containsKey(ch2)){
        map.put(ch2, map.get(ch2) - 1);
        if(map.get(ch2) == 0) 
          match++;
        
      }

      if(match == map.size()){
        resultIndices.add(i);
      }

      if(j >= pattern.length() - 1){
        char leftChar = str.charAt(i++);
        if(map.containsKey(leftChar)){
          if(map.get(leftChar) == 0)
            match--;
          map.put(leftChar, map.get(leftChar) + 1);
        }
      }

    }



    return resultIndices;
  }

  public static void main(String[] args) throws Exception {
	  
    String str = "ppqp";
    //System.out.println(indexOf(str.toCharArray(), 0, str.length(), "pq".toCharArray(), 0, 2, 0));
	System.out.println(indexOf(str,"pq"));
    //System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
    //System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    
    
    
  }
  
  
  
  public static int indexOf(String source, String target) throws Exception{
	  if(target.length() == 0) {
		  throw new IllegalArgumentException("target should not be a empty string");
	  }
	  
	  if(source.length() == 0) {
		  throw new IllegalArgumentException("Source should not be a empty string");
	  }
	  
	  char first = target.charAt(0);
	  int max = source.length() - target.length();
	  
	  for(int i = 0; i <= max; i++) {
		  if(source.charAt(i) != first) {
			  while(++i <= max && source.charAt(i) != first);
		  }
		  
		  if(i <= max) {
			  int j = i + 1;
			  int end = j + target.length() - 1;
			  
			  for(int k = 1; j < end && source.charAt(j) == target.charAt(k); j++, k++);
			  
			  if(j == end) {
				  return i;
			  }
		  }
	  }
	  return -1;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public static int indexOf(char[] source, int sourceOffset, int sourceCount,
          char[] target, int targetOffset, int targetCount,
          int fromIndex) {
      if (fromIndex >= sourceCount) {
          return (targetCount == 0 ? sourceCount : -1);
      }
      if (fromIndex < 0) {
          fromIndex = 0;
      }
      if (targetCount == 0) {
          return fromIndex;
      }

      char first = target[targetOffset];
      int max = sourceOffset + (sourceCount - targetCount);

      for (int i = sourceOffset + fromIndex; i <= max; i++) {
          /* Look for first character. */
          if (source[i] != first) {
              while (++i <= max && source[i] != first);
          }

          /* Found first character, now look at the rest of v2 */
          if (i <= max) {
              int j = i + 1;
              int end = j + targetCount - 1;
              for (int k = targetOffset + 1; j < end && source[j]
                      == target[k]; j++, k++);

              if (j == end) {
                  /* Found whole string. */
                  return i - sourceOffset;
              }
          }
      }
      return -1;
  }
  
}
