package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//With an input string, identify a longest substring with all distinct characters
//==============================================================================================================
//
//Input:  findlongestsubstring
//Output: The longest substring with all distinct characters is dlongest or ubstring
// 
//Input:  longestsubstr
//Output: The longest substring with all distinct characters is longest
// 
//Input:  abbcdafeegh
//Output: The longest substring with all distinct characters is bcdafe
// 
//Input:  aaaaaa
//Output: The longest substring with all distinct characters is a

public class LongestSubstring {
	public LongestSubstring() {
	}

	public static Set<String> substring(String string) {
		Map<Character, Integer> map = new HashMap<>();
		int left = -1;
		int bestLen = 0; // best length yet
		Set<String> substrings = new HashSet<>();

		for (int i = 0; i < string.length(); i++) {
			char ch = string.charAt(i);

			Integer prev = map.get(ch);
			if (prev != null && prev > left)
				left = prev;
			
			if (i - left == bestLen) {
				substrings.add(string.substring(left + 1, i + 1));
			} else if (i - left > bestLen) {
				bestLen = i - left;
				substrings.clear();
				substrings.add(string.substring(left + 1, i + 1));
			}
			
			map.put(ch, i);
		}
		return substrings;
	}

	public static void main(String[] args) {
		String string = "findlongestsubstring";
		System.out.println(substring(string));
	}

}
