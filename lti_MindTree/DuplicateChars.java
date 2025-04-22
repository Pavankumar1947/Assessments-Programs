package lti_MindTree;

import java.util.HashMap;
import java.util.Map;

public class DuplicateChars {
	public static void main(String[] args) {
		String str = "programming";
		Map<Character, Integer> map = new HashMap<>();
		for (char c : str.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);
		map.forEach((k, v) -> {
			if (v > 1)
				System.out.println(k + ": " + v);
		});
	}

}
