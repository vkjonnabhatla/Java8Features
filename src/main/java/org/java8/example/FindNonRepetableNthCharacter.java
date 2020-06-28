package org.java8.example;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindNonRepetableNthCharacter {

	public static void main(String[] args) {

		// Find non repeatable given Nth Character in the given string using Java 8 features.

		String str = "ebcccaaadff";
		char[] charArray = str.toCharArray();
		Stream<Character> streamOfCharacters = IntStream.range(0, charArray.length).mapToObj(i -> charArray[i]);
		System.out.println(streamOfCharacters);

		// Insertion order not preserving with below statement
		// Map<Character, Long> groupByChars = streamOfCharacters.collect(Collectors.groupingBy(Character::charValue, Collectors.counting()));

		Map<Character, Long> groupByChars = streamOfCharacters.collect(Collectors.groupingBy(Character::charValue, Collectors.counting()));
		System.out.println(groupByChars);
		//Map<Character, Long> groupByChars = streamOfCharacters.collect(Collectors.groupingBy(Character::charValue,
		//		LinkedHashMap::new, Collectors.mapping(Character::charValue, Collectors.counting())));

		List<Character> charList = groupByChars.entrySet().stream()
				                                          .filter(e -> e.getValue() == 1)
				                                          .map(e -> e.getKey())
				                                          .collect(Collectors.toList());

		System.out.println(groupByChars);
		System.out.println(charList);

	}

}
